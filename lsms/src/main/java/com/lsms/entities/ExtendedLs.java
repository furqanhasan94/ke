/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lsms.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.websocket.OnError;

/**
 *
 * @author furqan
 */
@Entity
@Table(name = "exetndedls")
public class ExtendedLs implements Serializable {
  
    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "ex_ll_time")
    private Time lowLossEt;
    
    @Column(name = "ex_ml_time")
    private Time medLossEt ;
    
    @Column(name = "ex_hl_time")
    private Time highLossEt ;

    @Column(name = "ex_vhl_time")
    private Time vHighLossEt ;
    
    @NotNull
    @Column(name = "ll_ext")
    private Boolean lowLossExtStat ;
    
    @NotNull
    @Column(name = "ml_ext")
    private Boolean medLossExtStat ;
    
    @NotNull
    @Column(name = "hl_ext")
    private Boolean highLossExtStat ;
    
    @NotNull
    @Column(name = "vhl_ext")
    private Boolean vHighLossExtStat ;
    
    @NotNull
    @Column(name = "start_time")
    private Time stTime ;
    
    @NotNull
    @Column(name = "end_time")
    private Time enTime ;
    
    @NotNull
    @Column(name = "ent_date")
    private Date entryDate ;
    
    @Column(name = "reason")
    private String reason ;
    
    @NotNull
    @OneToMany
    @JoinColumn(name = "grid_id")
    private Grids gr ;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the lowLossEt
     */
    public Time getLowLossEt() {
        return lowLossEt;
    }

    /**
     * @param lowLossEt the lowLossEt to set
     */
    public void setLowLossEt(Time lowLossEt) {
        this.lowLossEt = lowLossEt;
    }

    /**
     * @return the medLossEt
     */
    public Time getMedLossEt() {
        return medLossEt;
    }

    /**
     * @param medLossEt the medLossEt to set
     */
    public void setMedLossEt(Time medLossEt) {
        this.medLossEt = medLossEt;
    }

    /**
     * @return the highLossEt
     */
    public Time getHighLossEt() {
        return highLossEt;
    }

    /**
     * @param highLossEt the highLossEt to set
     */
    public void setHighLossEt(Time highLossEt) {
        this.highLossEt = highLossEt;
    }

    /**
     * @return the vHighLossEt
     */
    public Time getvHighLossEt() {
        return vHighLossEt;
    }

    /**
     * @param vHighLossEt the vHighLossEt to set
     */
    public void setvHighLossEt(Time vHighLossEt) {
        this.vHighLossEt = vHighLossEt;
    }

    /**
     * @return the lowLossExtStat
     */
    public Boolean getLowLossExtStat() {
        return lowLossExtStat;
    }

    /**
     * @param lowLossExtStat the lowLossExtStat to set
     */
    public void setLowLossExtStat(Boolean lowLossExtStat) {
        this.lowLossExtStat = lowLossExtStat;
    }

    /**
     * @return the medLossExtStat
     */
    public Boolean getMedLossExtStat() {
        return medLossExtStat;
    }

    /**
     * @param medLossExtStat the medLossExtStat to set
     */
    public void setMedLossExtStat(Boolean medLossExtStat) {
        this.medLossExtStat = medLossExtStat;
    }

    /**
     * @return the highLossExtStat
     */
    public Boolean getHighLossExtStat() {
        return highLossExtStat;
    }

    /**
     * @param highLossExtStat the highLossExtStat to set
     */
    public void setHighLossExtStat(Boolean highLossExtStat) {
        this.highLossExtStat = highLossExtStat;
    }

    /**
     * @return the vHighLossExtStat
     */
    public Boolean getvHighLossExtStat() {
        return vHighLossExtStat;
    }

    /**
     * @param vHighLossExtStat the vHighLossExtStat to set
     */
    public void setvHighLossExtStat(Boolean vHighLossExtStat) {
        this.vHighLossExtStat = vHighLossExtStat;
    }

    /**
     * @return the stTime
     */
    public Time getStTime() {
        return stTime;
    }

    /**
     * @param stTime the stTime to set
     */
    public void setStTime(Time stTime) {
        this.stTime = stTime;
    }

    /**
     * @return the enTime
     */
    public Time getEnTime() {
        return enTime;
    }

    /**
     * @param enTime the enTime to set
     */
    public void setEnTime(Time enTime) {
        this.enTime = enTime;
    }

    /**
     * @return the entryDate
     */
    public Date getEntryDate() {
        return entryDate;
    }

    /**
     * @param entryDate the entryDate to set
     */
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return the gr
     */
    public Grids getGrId() {
        return gr;
    }

    /**
     * @param gr the gr to set
     */
    public void setGrId(Grids gr) {
        this.gr = gr;
    }
}
    
