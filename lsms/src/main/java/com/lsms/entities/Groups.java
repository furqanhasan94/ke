/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lsms.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import jdk.nashorn.internal.ir.annotations.Reference;

/**
 *
 * @author furqan
 */
@Entity
@Table(name = "groups")
public class Groups implements Serializable {
   
    
    
    @Id
    @NotNull
    private String group_id ;

    @NotNull
    private String group_name; 
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "block_id")
    private Block block ;
    
    public String getId(){
        return group_id ;
    }
    
    public void setId(String id){
        group_id = id ;
    }
    
    public String getGroup_name(){
        return group_name ;
    }
    
    public void setGroup_name(String group_name){
        this.group_name = group_name ;
    }

    public Block getBlock(){
        return block;
    }
    
    public void setBlock(Block b){
        this.block = b ;
    }
    
    
    @Override
    public String toString() {
        return "com.lsms.Groups[ id=" + group_id + " ]";
    }
    
}
