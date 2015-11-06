/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lsms.beans.summary;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author furqan
 */
@Named
@Stateless
public class UnservedEnergyBean {

    @PersistenceContext
    private EntityManager em ;
    
    private Query q ;
    
    private java.util.Date date ;
    private Date selectedDate ;
    private long totalLoad = 0;
    private List<UnservedHelper> eventsList = new ArrayList<UnservedHelper>();

    public void usEnergyCalculator(){
//        selectedDate = new Date(getDate().getYear(), getDate().getMonth(), getDate().getDate());
        System.out.println("running usEnergyCalculator()" + getSelectedDate());
        regularUnservedEnergyFinder();
        deviationUnServedEnergy();
        unscheduledUnServedEnergy();
        specialGroupUnServedEnergy();
        for (UnservedHelper unservedHelper : eventsList) {
            setTotalLoad(getTotalLoad() + unservedHelper.getMwh()) ;
        }
    }
    
    private void regularUnservedEnergyFinder(){
        try {
            UnservedHelper regularUsEnergy = new UnservedHelper();
            regularUsEnergy.setType("Regular Ls");
            q = em.createQuery("SELECT MIN(sc.cycleTimes.offTime) FROM ShededCategory sc WHERE sc.entryDate = :d")
                    .setParameter("d", getSelectedDate());
            System.out.println("date" + getSelectedDate());
            System.out.println("regular start time" + (Time)q.getSingleResult());
            regularUsEnergy.setStartTime((Time)q.getSingleResult());
            q = em.createQuery("SELECT MAX(sc.cycleTimes.onTime) FROM ShededCategory sc WHERE sc.entryDate = :d")
                    .setParameter("d", getSelectedDate());
            System.out.println("regular end time" + (Time)q.getSingleResult());
            regularUsEnergy.setEndTime((Time)q.getSingleResult());
            q = em.createQuery("SELECT SUM(sc.toalLoad) FROM ShededCategory sc WHERE sc.entryDate = :d")
                    .setParameter("d", getSelectedDate());
            System.out.println("regular load sum" + (Long)q.getSingleResult());
            regularUsEnergy.setMwh((Long)q.getSingleResult());
            eventsList.add(regularUsEnergy);
        } catch (Exception e) {
            System.out.println("Exception in regularUnservedEnergyFinder()" + e);
        }
    }
    
    private void deviationUnServedEnergy(){
        try {
            UnservedHelper deviationUsEnergy = new UnservedHelper();
            deviationUsEnergy.setType("Deviated Ls");
            q = em.createQuery("SELECT MIN(d.stTime) FROM LsDeviation d WHERE d.eventDate = :d")
                    .setParameter("d", getSelectedDate());
            deviationUsEnergy.setStartTime((Time)q.getSingleResult());
            q = em.createQuery("SELECT MAX(d.stTime) FROM LsDeviation d WHERE d.eventDate = :d")
                    .setParameter("d", getSelectedDate());
            deviationUsEnergy.setEndTime((Time)q.getSingleResult());
            q = em.createQuery("SELECT SUM(c.load) FROM DeviationCategory c WHERE c.devEvent.eventDate = :d")
                    .setParameter("d", getSelectedDate());
            deviationUsEnergy.setMwh((Integer)q.getSingleResult());
            eventsList.add(deviationUsEnergy);
        } catch (Exception e) {
            System.out.println("Exception in deviationUnServedEnergy()" + e);
        }
    }
    
    private void unscheduledUnServedEnergy(){
        try {
            UnservedHelper unsUsEnergy = new UnservedHelper();
            unsUsEnergy.setType("Unscheduled Ls");
            q = em.createQuery("SELECT MIN(u.st_Time) FROM UnscheduledLs u WHERE u.et_Date = :d")
                    .setParameter("d", getSelectedDate());
            unsUsEnergy.setStartTime((Time)q.getSingleResult());
            q = em.createQuery("SELECT MAX(u.en_Time) FROM UnscheduledLs u WHERE u.et_Date = :d")
                    .setParameter("d", getSelectedDate());
            unsUsEnergy.setEndTime((Time)q.getSingleResult());
            q = em.createQuery("SELECT SUM(g.gridLoad) FROM UnscheduledLsGrids g WHERE g.uslEventId.et_Date = :d")
                    .setParameter("d", getSelectedDate());
            unsUsEnergy.setMwh((Integer)q.getSingleResult());
            eventsList.add(unsUsEnergy);
        } catch (Exception e) {
            System.out.println("Exception in deviationUnServedEnergy() " + e);
        }
    }
    
    private void specialGroupUnServedEnergy(){
        try {
            UnservedHelper spgUsEnergy = new UnservedHelper();
            spgUsEnergy.setType("Special Group");
            q = em.createQuery("SELECT MIN(s.cycle.stTime) FROM SpecialCycleLoad s WHERE s.date = :d")
                    .setParameter("d", getSelectedDate());
            spgUsEnergy.setStartTime((Time)q.getSingleResult());
            q = em.createQuery("SELECT MAX(s.cycle.endTime) FROM SpecialCycleLoad s WHERE s.date = :d")
                    .setParameter("d", getSelectedDate());
            spgUsEnergy.setEndTime((Time)q.getSingleResult());
            q = em.createQuery("SELECT SUM(s.load) FROM SpecialCycleLoad s WHERE s.date = :d")
                    .setParameter("d", getSelectedDate());
            spgUsEnergy.setMwh((Integer)q.getSingleResult());
            eventsList.add(spgUsEnergy);
        } catch (Exception e) {
            System.out.println("Exception in specialGroupUnServedEnergy() " + e);
        }
    }
    
    /**
     * @return the selectedDate
     */
    public Date getSelectedDate() {
        return selectedDate;
    }

    /**
     * @param selectedDate the selectedDate to set
     */
    public void setSelectedDate(Date selectedDate) {
        this.selectedDate = selectedDate;
    }

    /**
     * @return the eventsList
     */
    public List<UnservedHelper> getEventsList() {
        usEnergyCalculator();
        return eventsList;
    }

    /**
     * @param eventsList the eventsList to set
     */
    public void setEventsList(List<UnservedHelper> eventsList) {
        this.eventsList = eventsList;
    }

    /**
     * @return the totalLoad
     */
    public long getTotalLoad() {
        return totalLoad;
    }

    /**
     * @param totalLoad the totalLoad to set
     */
    public void setTotalLoad(long totalLoad) {
        this.totalLoad = totalLoad;
    }

    /**
     * @return the date
     */
    public java.util.Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(java.util.Date date) {
        this.date = date;
    }
    
    
    
}
