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
@Table(name = "tipo_fornecedor", catalog = "expresso_esperanca", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoFornecedor.findAll", query = "SELECT t FROM TipoFornecedor t"),
    @NamedQuery(name = "TipoFornecedor.findByTipoFornCod", query = "SELECT t FROM TipoFornecedor t WHERE t.tipoFornCod = :tipoFornCod"),
    @NamedQuery(name = "TipoFornecedor.findByTipoFornNome", query = "SELECT t FROM TipoFornecedor t WHERE t.tipoFornNome = :tipoFornNome")})
public class TipoFornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo_forn_cod")
    private Long tipoFornCod;
    @Size(max = 50)
    @Column(name = "tipo_forn_nome")
    private String tipoFornNome;
    @OneToMany(mappedBy = "fornTipo", fetch = FetchType.LAZY)
    private List<Fornecedor> fornecedorList;

    public TipoFornecedor() {
    }

    public TipoFornecedor(Long tipoFornCod) {
        this.tipoFornCod = tipoFornCod;
    }

    public Long getTipoFornCod() {
        return tipoFornCod;
    }

    public void setTipoFornCod(Long tipoFornCod) {
        this.tipoFornCod = tipoFornCod;
    }

    public String getTipoFornNome() {
        return tipoFornNome;
    }

    public void setTipoFornNome(String tipoFornNome) {
        this.tipoFornNome = tipoFornNome;
    }

    @XmlTransient
    public List<Fornecedor> getFornecedorList() {
        return fornecedorList;
    }

    public void setFornecedorList(List<Fornecedor> fornecedorList) {
        this.fornecedorList = fornecedorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoFornCod != null ? tipoFornCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoFornecedor)) {
            return false;
        }
        TipoFornecedor other = (TipoFornecedor) object;
        if ((this.tipoFornCod == null && other.tipoFornCod != null) || (this.tipoFornCod != null && !this.tipoFornCod.equals(other.tipoFornCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.buffet.beans.TipoFornecedor[ tipoFornCod=" + tipoFornCod + " ]";
    }
    
}
