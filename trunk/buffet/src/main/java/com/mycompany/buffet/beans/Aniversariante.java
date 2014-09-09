/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.buffet.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edilayne
 */
@Entity
@Table(name = "aniversariante", catalog = "expresso_esperanca", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aniversariante.findAll", query = "SELECT a FROM Aniversariante a"),
    @NamedQuery(name = "Aniversariante.findByAnivCod", query = "SELECT a FROM Aniversariante a WHERE a.anivCod = :anivCod"),
    @NamedQuery(name = "Aniversariante.findByAnivNome", query = "SELECT a FROM Aniversariante a WHERE a.anivNome = :anivNome"),
    @NamedQuery(name = "Aniversariante.findByAnivSexo", query = "SELECT a FROM Aniversariante a WHERE a.anivSexo = :anivSexo"),
    @NamedQuery(name = "Aniversariante.findByAnivDataNasc", query = "SELECT a FROM Aniversariante a WHERE a.anivDataNasc = :anivDataNasc"),
    @NamedQuery(name = "Aniversariante.findByAnivPai", query = "SELECT a FROM Aniversariante a WHERE a.anivPai = :anivPai"),
    @NamedQuery(name = "Aniversariante.findByAnivMae", query = "SELECT a FROM Aniversariante a WHERE a.anivMae = :anivMae")})
public class Aniversariante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aniv_cod")
    private Long anivCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "aniv_nome")
    private String anivNome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aniv_sexo")
    private Character anivSexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aniv_data_nasc")
    @Temporal(TemporalType.DATE)
    private Date anivDataNasc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "aniv_pai")
    private String anivPai;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "aniv_mae")
    private String anivMae;
    @OneToMany(mappedBy = "eveAniversariante", fetch = FetchType.LAZY)
    private List<Evento> eventoList;
    @JoinColumn(name = "aniv_cliente", referencedColumnName = "cli_cod")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente anivCliente;

    public Aniversariante() {
    }

    public Aniversariante(Long anivCod) {
        this.anivCod = anivCod;
    }

    public Aniversariante(Long anivCod, String anivNome, Character anivSexo, Date anivDataNasc, String anivPai, String anivMae) {
        this.anivCod = anivCod;
        this.anivNome = anivNome;
        this.anivSexo = anivSexo;
        this.anivDataNasc = anivDataNasc;
        this.anivPai = anivPai;
        this.anivMae = anivMae;
    }

    public Long getAnivCod() {
        return anivCod;
    }

    public void setAnivCod(Long anivCod) {
        this.anivCod = anivCod;
    }

    public String getAnivNome() {
        return anivNome;
    }

    public void setAnivNome(String anivNome) {
        this.anivNome = anivNome;
    }

    public Character getAnivSexo() {
        return anivSexo;
    }

    public void setAnivSexo(Character anivSexo) {
        this.anivSexo = anivSexo;
    }

    public Date getAnivDataNasc() {
        return anivDataNasc;
    }

    public void setAnivDataNasc(Date anivDataNasc) {
        this.anivDataNasc = anivDataNasc;
    }

    public String getAnivPai() {
        return anivPai;
    }

    public void setAnivPai(String anivPai) {
        this.anivPai = anivPai;
    }

    public String getAnivMae() {
        return anivMae;
    }

    public void setAnivMae(String anivMae) {
        this.anivMae = anivMae;
    }

    @XmlTransient
    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
    }

    public Cliente getAnivCliente() {
        return anivCliente;
    }

    public void setAnivCliente(Cliente anivCliente) {
        this.anivCliente = anivCliente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.anivCod);
        hash = 17 * hash + Objects.hashCode(this.anivNome);
        hash = 17 * hash + Objects.hashCode(this.anivDataNasc);
        hash = 17 * hash + Objects.hashCode(this.anivMae);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aniversariante)) {
            return false;
        }
        Aniversariante other = (Aniversariante) object;
        if ((this.anivCod == null && other.anivCod != null) || (this.anivCod != null && !this.anivCod.equals(other.anivCod))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "com.mycompany.buffet.beans.Aniversariante[ anivCod=" + anivCod + " ]";
    }
    
}
