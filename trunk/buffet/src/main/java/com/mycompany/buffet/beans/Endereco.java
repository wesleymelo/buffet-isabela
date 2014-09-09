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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "endereco", catalog = "expresso_esperanca", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e"),
    @NamedQuery(name = "Endereco.findByEndCod", query = "SELECT e FROM Endereco e WHERE e.endCod = :endCod"),
    @NamedQuery(name = "Endereco.findByEndLogradouro", query = "SELECT e FROM Endereco e WHERE e.endLogradouro = :endLogradouro"),
    @NamedQuery(name = "Endereco.findByEndNumero", query = "SELECT e FROM Endereco e WHERE e.endNumero = :endNumero"),
    @NamedQuery(name = "Endereco.findByEndComplemento", query = "SELECT e FROM Endereco e WHERE e.endComplemento = :endComplemento"),
    @NamedQuery(name = "Endereco.findByEndCep", query = "SELECT e FROM Endereco e WHERE e.endCep = :endCep"),
    @NamedQuery(name = "Endereco.findByEndBairro", query = "SELECT e FROM Endereco e WHERE e.endBairro = :endBairro"),
    @NamedQuery(name = "Endereco.findByEndCidade", query = "SELECT e FROM Endereco e WHERE e.endCidade = :endCidade"),
    @NamedQuery(name = "Endereco.findByEndEstado", query = "SELECT e FROM Endereco e WHERE e.endEstado = :endEstado")})
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_cod")
    private Long endCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "end_logradouro")
    private String endLogradouro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "end_numero")
    private String endNumero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "end_complemento")
    private String endComplemento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "end_cep")
    private String endCep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "end_bairro")
    private String endBairro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "end_cidade")
    private String endCidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "end_estado")
    private String endEstado;
    @OneToMany(mappedBy = "fornEnd", fetch = FetchType.LAZY)
    private List<Fornecedor> fornecedorList;

    public Endereco() {
    }

    public Endereco(Long endCod) {
        this.endCod = endCod;
    }

    public Endereco(Long endCod, String endLogradouro, String endNumero, String endComplemento, String endCep, String endBairro, String endCidade, String endEstado) {
        this.endCod = endCod;
        this.endLogradouro = endLogradouro;
        this.endNumero = endNumero;
        this.endComplemento = endComplemento;
        this.endCep = endCep;
        this.endBairro = endBairro;
        this.endCidade = endCidade;
        this.endEstado = endEstado;
    }

    public Long getEndCod() {
        return endCod;
    }

    public void setEndCod(Long endCod) {
        this.endCod = endCod;
    }

    public String getEndLogradouro() {
        return endLogradouro;
    }

    public void setEndLogradouro(String endLogradouro) {
        this.endLogradouro = endLogradouro;
    }

    public String getEndNumero() {
        return endNumero;
    }

    public void setEndNumero(String endNumero) {
        this.endNumero = endNumero;
    }

    public String getEndComplemento() {
        return endComplemento;
    }

    public void setEndComplemento(String endComplemento) {
        this.endComplemento = endComplemento;
    }

    public String getEndCep() {
        return endCep;
    }

    public void setEndCep(String endCep) {
        this.endCep = endCep;
    }

    public String getEndBairro() {
        return endBairro;
    }

    public void setEndBairro(String endBairro) {
        this.endBairro = endBairro;
    }

    public String getEndCidade() {
        return endCidade;
    }

    public void setEndCidade(String endCidade) {
        this.endCidade = endCidade;
    }

    public String getEndEstado() {
        return endEstado;
    }

    public void setEndEstado(String endEstado) {
        this.endEstado = endEstado;
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
        hash += (endCod != null ? endCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.endCod == null && other.endCod != null) || (this.endCod != null && !this.endCod.equals(other.endCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.buffet.beans.Endereco[ endCod=" + endCod + " ]";
    }
    
}
