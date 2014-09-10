/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.buffet.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "evento", catalog = "expresso_esperanca", schema = "")
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e"),
    @NamedQuery(name = "Evento.findByEveCod", query = "SELECT e FROM Evento e WHERE e.eveCod = :eveCod"),
    @NamedQuery(name = "Evento.findByEveData", query = "SELECT e FROM Evento e WHERE e.eveData = :eveData"),
    @NamedQuery(name = "Evento.findByEveHora", query = "SELECT e FROM Evento e WHERE e.eveHora = :eveHora"),
    @NamedQuery(name = "Evento.findByEveQntPessoas", query = "SELECT e FROM Evento e WHERE e.eveQntPessoas = :eveQntPessoas"),
    @NamedQuery(name = "Evento.findByEveDecoracao", query = "SELECT e FROM Evento e WHERE e.eveDecoracao = :eveDecoracao"),
    @NamedQuery(name = "Evento.findByEveSnBebidaAlcool", query = "SELECT e FROM Evento e WHERE e.eveSnBebidaAlcool = :eveSnBebidaAlcool"),
    @NamedQuery(name = "Evento.findByEveSnPratoQuente", query = "SELECT e FROM Evento e WHERE e.eveSnPratoQuente = :eveSnPratoQuente"),
    @NamedQuery(name = "Evento.findByEveSnCerveja", query = "SELECT e FROM Evento e WHERE e.eveSnCerveja = :eveSnCerveja"),
    @NamedQuery(name = "Evento.findByEveSnGarcon", query = "SELECT e FROM Evento e WHERE e.eveSnGarcon = :eveSnGarcon"),
    @NamedQuery(name = "Evento.findByEveSnMesaGuloseima", query = "SELECT e FROM Evento e WHERE e.eveSnMesaGuloseima = :eveSnMesaGuloseima"),
    @NamedQuery(name = "Evento.findByEveSnNomeFachada", query = "SELECT e FROM Evento e WHERE e.eveSnNomeFachada = :eveSnNomeFachada")})
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "eve_cod")
    private Long eveCod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eve_data")
    @Temporal(TemporalType.DATE)
    private Date eveData;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eve_hora")
    @Temporal(TemporalType.TIME)
    private Date eveHora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eve_qnt_pessoas")
    private int eveQntPessoas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "eve_decoracao")
    private String eveDecoracao;
    @Column(name = "eve_sn_bebida_alcool_")
    private Character eveSnBebidaAlcool;
    @Column(name = "eve_sn_prato_quente")
    private Character eveSnPratoQuente;
    @Column(name = "eve_sn_cerveja")
    private Character eveSnCerveja;
    @Column(name = "eve_sn_garcon")
    private Character eveSnGarcon;
    @Column(name = "eve_sn_mesa_guloseima")
    private Character eveSnMesaGuloseima;
    @Column(name = "eve_sn_nome_fachada")
    private Character eveSnNomeFachada;
    
    @JoinTable(name = "evento_has_produto", joinColumns = {
        @JoinColumn(name = "evento_eve_cod", referencedColumnName = "eve_cod")}, inverseJoinColumns = {
        @JoinColumn(name = "produto_prod_cod", referencedColumnName = "prod_cod")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Produto> produtoList;
    @JoinColumn(name = "eve_aniversariante", referencedColumnName = "aniv_cod")
    @ManyToOne(fetch = FetchType.LAZY)
    private Aniversariante eveAniversariante;

    public Evento() {
    }

    public Evento(Long eveCod) {
        this.eveCod = eveCod;
    }

    public Evento(Long eveCod, Date eveData, Date eveHora, int eveQntPessoas, String eveDecoracao) {
        this.eveCod = eveCod;
        this.eveData = eveData;
        this.eveHora = eveHora;
        this.eveQntPessoas = eveQntPessoas;
        this.eveDecoracao = eveDecoracao;
    }

    public Long getEveCod() {
        return eveCod;
    }

    public void setEveCod(Long eveCod) {
        this.eveCod = eveCod;
    }

    public Date getEveData() {
        return eveData;
    }

    public void setEveData(Date eveData) {
        this.eveData = eveData;
    }

    public Date getEveHora() {
        return eveHora;
    }

    public void setEveHora(Date eveHora) {
        this.eveHora = eveHora;
    }

    public int getEveQntPessoas() {
        return eveQntPessoas;
    }

    public void setEveQntPessoas(int eveQntPessoas) {
        this.eveQntPessoas = eveQntPessoas;
    }

    public String getEveDecoracao() {
        return eveDecoracao;
    }

    public void setEveDecoracao(String eveDecoracao) {
        this.eveDecoracao = eveDecoracao;
    }

    public Character getEveSnBebidaAlcool() {
        return eveSnBebidaAlcool;
    }

    public void setEveSnBebidaAlcool(Character eveSnBebidaAlcool) {
        this.eveSnBebidaAlcool = eveSnBebidaAlcool;
    }

    public Character getEveSnPratoQuente() {
        return eveSnPratoQuente;
    }

    public void setEveSnPratoQuente(Character eveSnPratoQuente) {
        this.eveSnPratoQuente = eveSnPratoQuente;
    }

    public Character getEveSnCerveja() {
        return eveSnCerveja;
    }

    public void setEveSnCerveja(Character eveSnCerveja) {
        this.eveSnCerveja = eveSnCerveja;
    }

    public Character getEveSnGarcon() {
        return eveSnGarcon;
    }

    public void setEveSnGarcon(Character eveSnGarcon) {
        this.eveSnGarcon = eveSnGarcon;
    }

    public Character getEveSnMesaGuloseima() {
        return eveSnMesaGuloseima;
    }

    public void setEveSnMesaGuloseima(Character eveSnMesaGuloseima) {
        this.eveSnMesaGuloseima = eveSnMesaGuloseima;
    }

    public Character getEveSnNomeFachada() {
        return eveSnNomeFachada;
    }

    public void setEveSnNomeFachada(Character eveSnNomeFachada) {
        this.eveSnNomeFachada = eveSnNomeFachada;
    }

    @XmlTransient
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    public Aniversariante getEveAniversariante() {
        return eveAniversariante;
    }

    public void setEveAniversariante(Aniversariante eveAniversariante) {
        this.eveAniversariante = eveAniversariante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eveCod != null ? eveCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.eveCod == null && other.eveCod != null) || (this.eveCod != null && !this.eveCod.equals(other.eveCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.buffet.beans.Evento[ eveCod=" + eveCod + " ]";
    }
    
}
