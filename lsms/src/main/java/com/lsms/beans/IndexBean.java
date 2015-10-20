/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lsms.beans;

import com.lsms.entities.ExtendedLs;
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
public class IndexBean {

   @PersistenceContext
   private EntityManager em ;
   
   private Query q ;
   
   private List<ExtendedLsEvent> extendedLsEventList = new ArrayList<ExtendedLsEvent>() ;

   /**
    * Fuctions for ending
    * the created events
     * @param event
    */
   
   
   
    public void stopExtEvent(ExtendedLsEvent event){
        em.find(ExtendedLs.class, event.getExtEvent().getId());
    }
       
   
   //*******************************************
   
    /**
     * @return the extendedLsEventList
     */
    public List<ExtendedLsEvent> getExtendedLsEventList() {
        try {
            q = em.createQuery("SELECT e FROM ExtendedLs e WHERE e.extStatus = TRUE");
            List<ExtendedLs> els = q.getResultList();

            for (ExtendedLs extendedLs : els) {
                ExtendedLsEvent eve =  new ExtendedLsEvent();
                eve.initializerFunction(extendedLs);
                extendedLsEventList.add(eve);
            }
        } catch (Exception e) {
            System.out.println("Exception in getExtendedLsEventList()" + e);
        }
        return extendedLsEventList;
    }

    /**
     * @param extendedLsList the extendedLsEventList to set
     */
    public void setExtendedLsEventList(List<ExtendedLsEvent> extendedLsList) {
        this.extendedLsEventList = extendedLsList;
    }
   
   
}
