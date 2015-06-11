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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author furqan
 */
@Entity
@Table(name="block")
public class Block implements Serializable {
   
    @Id
    @Column(name="block_id")
    private String blockId;
    
    @NotNull
    @Column(name="block_name")
    private String blockName ;
    
    
    public String getBlockId() {
        return blockId ;
    }
  
    public void setBlockId(String bId){
        this.blockId = bId ;
    }
    
    public String getBlockName() {
        return blockName ;
    }
  
    public void setBlockName(String bName){
        this.blockName = bName ;
    }
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (block_id != null ? block_id.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Block)) {
//            return false;
//        }
//        Block other = (Block) object;
//        if ((this.block_id == null && other.block_id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "com.lsms.entities.Block[ id=" + blockId + " ]";
    }
    
}
