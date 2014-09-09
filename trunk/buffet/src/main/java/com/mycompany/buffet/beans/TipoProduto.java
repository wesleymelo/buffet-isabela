/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.buffet.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edilayne
 */
@Entity
@Table(name = "tipo_produto", catalog = "expresso_esperanca", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProduto.findAll", query = "SELECT t FROM TipoProduto t"),
    @NamedQuery(name = "TipoProduto.findByTipoProdCod", query = "SELECT t FROM TipoProduto t WHERE t.tipoProdCod = :tipoProdCod"),
    @NamedQuery(name = "TipoProduto.findByTipoProdNome", query = "SELECT t FROM TipoProduto t WHERE t.tipoProdNome = :tipoProdNome")})
public class TipoProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo_prod_cod")
    private Long tipoProdCod;
    @Size(max = 50)
    @Column(name = "tipo_prod_nome")
    private String tipoProdNome;
    @OneToMany(mappedBy = "prodTipo", fetch = FetchType.LAZY)
    private List<Produto> produtoList;

    public TipoProduto() {
    }

    public TipoProduto(Long tipoProdCod) {
        this.tipoProdCod = tipoProdCod;
    }

    public Long getTipoProdCod() {
        return tipoProdCod;
    }

    public void setTipoProdCod(Long tipoProdCod) {
        this.tipoProdCod = tipoProdCod;
    }

    public String getTipoProdNome() {
        return tipoProdNome;
    }

    public void setTipoProdNome(String tipoProdNome) {
        this.tipoProdNome = tipoProdNome;
    }

    @XmlTransient
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoProdCod != null ? tipoProdCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProduto)) {
            return false;
        }
        TipoProduto other = (TipoProduto) object;
        if ((this.tipoProdCod == null && other.tipoProdCod != null) || (this.tipoProdCod != null && !this.tipoProdCod.equals(other.tipoProdCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.buffet.beans.TipoProduto[ tipoProdCod=" + tipoProdCod + " ]";
    }
    
}
