/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lsms.beans;

import com.lsms.entities.Block;
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
public class BlockBean {

    @PersistenceContext
    EntityManager em ;
    
    private String blockName;
    private List<Block> blockList ;

    /**
     * @return the blockName
     */
    public String getBlockName() {
        return blockName;
    }

    /**
     * @param blockname the blockName to set
     */
    public void setBlockName(String blockname) {
        this.blockName = blockname;
    }
    
    /**
     * @return the blockList
     */
    public List<Block> getBlockList() {
        listOfBlocks();
        return blockList;
    }

    /**
     * @param bockList the blockList to set
     */
    public void setBlockList(List<Block> bockList) {
        this.blockList = bockList;
    }
    
    public void beanCreator(){
        
        Block b = new Block();
        b.setBlockName(getBlockName());
        em.persist(b);
        
    }

    public void listOfBlocks(){
        try {
            Query q = em.createQuery("select b from Block b");
            setBlockList(q.getResultList());
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
