/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.buffet.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edilayne
 */
@Entity
@Table(name = "produto", catalog = "expresso_esperanca", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByProdCod", query = "SELECT p FROM Produto p WHERE p.prodCod = :prodCod"),
    @NamedQuery(name = "Produto.findByProdNome", query = "SELECT p FROM Produto p WHERE p.prodNome = :prodNome"),
    @NamedQuery(name = "Produto.findByProdPreco", query = "SELECT p FROM Produto p WHERE p.prodPreco = :prodPreco")})
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prod_cod")
    private Long prodCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "prod_nome")
    private String prodNome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "prod_preco")
    private BigDecimal prodPreco;
    @ManyToMany(mappedBy = "produtoList", fetch = FetchType.LAZY)
    private List<Evento> eventoList;
    @JoinColumn(name = "prod_tipo", referencedColumnName = "tipo_prod_cod")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoProduto prodTipo;

    public Produto() {
    }

    public Produto(Long prodCod) {
        this.prodCod = prodCod;
    }

    public Produto(Long prodCod, String prodNome, BigDecimal prodPreco) {
        this.prodCod = prodCod;
        this.prodNome = prodNome;
        this.prodPreco = prodPreco;
    }

    public Long getProdCod() {
        return prodCod;
    }

    public void setProdCod(Long prodCod) {
        this.prodCod = prodCod;
    }

    public String getProdNome() {
        return prodNome;
    }

    public void setProdNome(String prodNome) {
        this.prodNome = prodNome;
    }

    public BigDecimal getProdPreco() {
        return prodPreco;
    }

    public void setProdPreco(BigDecimal prodPreco) {
        this.prodPreco = prodPreco;
    }

    @XmlTransient
    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
    }

    public TipoProduto getProdTipo() {
        return prodTipo;
    }

    public void setProdTipo(TipoProduto prodTipo) {
        this.prodTipo = prodTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodCod != null ? prodCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.prodCod == null && other.prodCod != null) || (this.prodCod != null && !this.prodCod.equals(other.prodCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.buffet.beans.Produto[ prodCod=" + prodCod + " ]";
    }
    
}
