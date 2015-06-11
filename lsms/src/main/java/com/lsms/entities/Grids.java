/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lsms.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "grids")
public class Grids implements Serializable {
    
    
    @Id
    @NotNull
    @Column(name = "grid_id")
    private String gridId ;
    
    @NotNull
    @Column(name = "grid_name")
    private String gridName;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "block_id")
    private Block block;
    
       
    public String getGridId(){
        return gridId ;
    }
    
    public String getGridName(){
        return gridName ;
    }
   
    public Block getBlockId(){
        return block ;
    }
    
    public void setGridId(String gId){
        this.gridId = gId ;
    }
    
    public void setGridName(String gName){
        this.gridName = gName ;
    }
    public void setBlockId(Block b){
        this.block = b ;
    }
 
    @Override
    public String toString() {
        return "com.lsms.Grids[ id=" + gridId + " ]";
    }
    
}
