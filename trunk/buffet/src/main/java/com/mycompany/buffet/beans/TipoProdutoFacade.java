/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.buffet.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Wesley
 */
@Stateless
public class TipoProdutoFacade extends AbstractFacade<TipoProduto> {
    @PersistenceContext(unitName = "expressoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoProdutoFacade() {
        super(TipoProduto.class);
    }
    
}
