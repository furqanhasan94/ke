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
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author furqan
 */
@Entity
@Table(name = "Overloading")
public class Overloading implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)          
    @Column(name = "id")
    private int id ;
    
    @NotNull
    @Column(name = "start_time")
    private Time st_time ;
    
    @Column(name = "end_time")
    private Time en_time ;
    
    @NotNull
    @Column(name = "OLload")
    private String load ;
    
    @NotNull
    @OneToOne
    @JoinColumn(name = "grid_id")
    private Grids grId ;
    
    @NotNull
    @OneToOne
    @JoinColumn(name = "trafo_id")
    private Transformer trId ;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "feeder_id")
    private Feeder fId ;

    /**
     * @return the olId
     */
    public int getOlId() {
        return id;
    }

    /**
     * @param overLId the olId to set
     */
    public void setOlId(int overLId) {
        this.id = overLId;
    }

    /**
     * @return the st_time
     */
    public Time getSt_time() {
        return st_time;
    }

    /**
     * @param st_time the st_time to set
     */
    public void setSt_time(Time st_time) {
        this.st_time = st_time;
    }

    /**
     * @return the en_time
     */
    public Time getEn_time() {
        return en_time;
    }

    /**
     * @param en_time the en_time to set
     */
    public void setEn_time(Time en_time) {
        this.en_time = en_time;
    }

    /**
     * @return the load
     */
    public String getLoad() {
        return load;
    }

    /**
     * @param ld the load to set
     */
    public void setLoad(String ld) {
        this.load = ld;
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
     * @return the trId
     */
    public Transformer getTrId() {
        return trId;
    }

    /**
     * @param trId the trId to set
     */
    public void setTrId(Transformer trId) {
        this.trId = trId;
    }

    /**
     * @return the fId
     */
    public Feeder getfId() {
        return fId;
    }

    /**
     * @param feedId the fId to set
     */
    public void setfId(Feeder feedId) {
        this.fId = feedId;
    }
    
    
    
    @Override
    public String toString() {
        return "com.lsms.entities.Overloading[ id=" + id + " ]";
    }
    
}
