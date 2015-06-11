/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lsms.entities;

import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author furqan
 */
@Entity
@Table(name = "lsdeviation")
public class LsDeviation implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private int id ;
    
    @NotNull
    @Column(name = "start_time")
    private Time stTime ;
    
    @Column(name = "end_time")
    private Time enTime ;
    
    @NotNull
    @OneToOne
    @JoinColumn(name = "group_id")
    private Groups gp_id  ;
    
    @NotNull
    @OneToOne
    @JoinColumn(name = "grid_id")
    private Grids grId ;
    
    @NotNull
    @Column(name = "mlload")
    private String mlLoad ;
    
    @NotNull
    @Column(name = "hlload")
    private String hlLoad ;
    
    @NotNull
    @Column(name = "vhlload")
    private String vhlLoad ;

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
     * @return the gp_id
     */
    public Groups getGp_id() {
        return gp_id;
    }

    /**
     * @param gp_id the gp_id to set
     */
    public void setGp_id(Groups gp_id) {
        this.gp_id = gp_id;
    }

    /**
     * @return the grId
     */
    public Grids getGrId() {
        return grId;
    }

    /**
     * @param grId the grId to set
     */
    public void setGrId(Grids grId) {
        this.grId = grId;
    }

    /**
     * @return the mlLoad
     */
    public String getMlLoad() {
        return mlLoad;
    }

    /**
     * @param mlLoad the mlLoad to set
     */
    public void setMlLoad(String mlLoad) {
        this.mlLoad = mlLoad;
    }

    /**
     * @return the hlLoad
     */
    public String getHlLoad() {
        return hlLoad;
    }

    /**
     * @param hlLoad the hlLoad to set
     */
    public void setHlLoad(String hlLoad) {
        this.hlLoad = hlLoad;
    }

    /**
     * @return the vhlLoad
     */
    public String getVhlLoad() {
        return vhlLoad;
    }

    /**
     * @param vhlLoad the vhlLoad to set
     */
    public void setVhlLoad(String vhlLoad) {
        this.vhlLoad = vhlLoad;
    }
    
    
    
    
}
