/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.buffet.dao;

import com.mycompany.buffet.beans.Produto;
import com.mycompany.buffet.util.GenericDAO;
import javax.persistence.EntityManager;

/**
 *
 * @author Edilayne
 */
public class ProdutoDAO extends GenericDAO<Produto>{

    public ProdutoDAO(EntityManager em) {
        super(em);
    }
}
