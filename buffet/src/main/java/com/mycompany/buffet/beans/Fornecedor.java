/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.buffet.beans;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Edilayne
 */
@Entity
@Table(name = "fornecedor", catalog = "expresso_esperanca", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f"),
    @NamedQuery(name = "Fornecedor.findByFornCod", query = "SELECT f FROM Fornecedor f WHERE f.fornCod = :fornCod"),
    @NamedQuery(name = "Fornecedor.findByFornNome", query = "SELECT f FROM Fornecedor f WHERE f.fornNome = :fornNome"),
    @NamedQuery(name = "Fornecedor.findByFornCnpj", query = "SELECT f FROM Fornecedor f WHERE f.fornCnpj = :fornCnpj"),
    @NamedQuery(name = "Fornecedor.findByFornCont", query = "SELECT f FROM Fornecedor f WHERE f.fornCont = :fornCont")})
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "forn_cod")
    private Long fornCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "forn_nome")
    private String fornNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "forn_cnpj")
    private String fornCnpj;
    @Column(name = "forn_cont")
    private BigInteger fornCont;
    @JoinColumn(name = "forn_end", referencedColumnName = "end_cod")
    @ManyToOne(fetch = FetchType.LAZY)
    private Endereco fornEnd;
    @JoinColumn(name = "forn_tipo", referencedColumnName = "tipo_forn_cod")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoFornecedor fornTipo;

    public Fornecedor() {
    }

    public Fornecedor(Long fornCod) {
        this.fornCod = fornCod;
    }

    public Fornecedor(Long fornCod, String fornNome, String fornCnpj) {
        this.fornCod = fornCod;
        this.fornNome = fornNome;
        this.fornCnpj = fornCnpj;
    }

    public Long getFornCod() {
        return fornCod;
    }

    public void setFornCod(Long fornCod) {
        this.fornCod = fornCod;
    }

    public String getFornNome() {
        return fornNome;
    }

    public void setFornNome(String fornNome) {
        this.fornNome = fornNome;
    }

    public String getFornCnpj() {
        return fornCnpj;
    }

    public void setFornCnpj(String fornCnpj) {
        this.fornCnpj = fornCnpj;
    }

    public BigInteger getFornCont() {
        return fornCont;
    }

    public void setFornCont(BigInteger fornCont) {
        this.fornCont = fornCont;
    }

    public Endereco getFornEnd() {
        return fornEnd;
    }

    public void setFornEnd(Endereco fornEnd) {
        this.fornEnd = fornEnd;
    }

    public TipoFornecedor getFornTipo() {
        return fornTipo;
    }

    public void setFornTipo(TipoFornecedor fornTipo) {
        this.fornTipo = fornTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fornCod != null ? fornCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.fornCod == null && other.fornCod != null) || (this.fornCod != null && !this.fornCod.equals(other.fornCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.buffet.beans.Fornecedor[ fornCod=" + fornCod + " ]";
    }
    
}
