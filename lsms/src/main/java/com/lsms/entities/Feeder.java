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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author furqan
 */
@Entity
@Table(name = "feeders")
public class Feeder implements Serializable {
    
    @Id
    @Column(name = "feeder_id")
    private String feedId ;
    
    @NotNull
    @Column(name = "feeder_name")
    private String feedName ;
    
    @NotNull
    @Column(name = "cycle1_time")
    private Time cycoff1 ;
    
    @NotNull
    @Column(name = "cycle2_time")
    private Time cycoff2 ;
    
    @NotNull
    @Column(name = "cycle3_time")
    private Time cycoff3 ;
    
    @NotNull
    @Column(name = "cycle1_ontime")
    private Time cycOn1 ;
    
    @NotNull
    @Column(name = "cycle2_ontime")
    private Time cycOn2 ;
    
    @NotNull
    @Column(name = "cycle3_ontime")
    private Time cycOn3 ;
    
    @Column(name = "exempt")
    private boolean exemption;
    
    @Column(name = "reason")
    private String reason ;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "trafo_id")
    private Transformer trafoId;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Categories categoryId;
    
    public String getfeedId(){
        return feedId ;
    }
    
    public String getFeedName(){
        return feedName ;
    }
    
    public Time getCyc1OffTime(){
        return cycoff1;
    }
  
    public Time getCyc2OffTime(){
        return cycoff2;
    }
    
    public Time getCyc3OffTime(){
        return cycoff3;
    }
    
    public Time getCyc1OnTime(){
        return cycOn1;
    }
  
    public Time getCyc2OnTime(){
        return cycOn2;
    }
    
    public Time getCyc3OnTime(){
        return cycOn3;
    }
    
    public boolean getExStat(){
        return exemption ;
    }
    
    public String getReasonOfExemption(){
        return reason ;
    }
    
    public Transformer getTrafoId(){
        return trafoId ;
    }
    
    public Categories getCatId(){
        return categoryId ;
    }
    
    public void setFeedId(String fedId){
        this.feedId = fedId ;
    }
    
    public void setFeedName(String fedName){
        this.feedName = fedName ;
    }
    
    public void setCyc1OffTime(Time cyc1OffTime){
        this.cycoff1 = cyc1OffTime ;
    }
    
    public void setCyc2OffTime(Time cyc2OffTime){
        this.cycoff2 = cyc2OffTime ;
    }
    
    public void setCyc3OffTime(Time cyc3OffTime){
        this.cycoff3 = cyc3OffTime ;
    }
   
    public void setCyc1OnTime(Time cyc1OnTime){
        this.cycOn1 = cyc1OnTime ;
    }
    
    public void setCyc2OnTime(Time cyc2OnTime){
        this.cycOn2 = cyc2OnTime ;
    }
    
    public void setCyc3OnTime(Time cyc3OnTime){
        this.cycOn3 = cyc3OnTime ;
    }
    
    public void setExStat(boolean exStat){
        this.exemption = exStat ;
    }
    
    public void setReasonOfExemption(String reason){
        this.reason = reason ;
    }
    
    public void setTrafoId(Transformer tr){
        this.trafoId = tr ;
    }
    
    public void setCatId(Categories cat){
        this.categoryId = cat ;
    }
    
    @Override
    public String toString() {
        return "com.lsms.entities.Feeder[ id=" + feedId + " ]";
    }
    
}
