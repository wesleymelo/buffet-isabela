/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.buffet.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Edilayne
 */
public class PersistenceUtil {
    private static final EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("expressoPU");
    
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
