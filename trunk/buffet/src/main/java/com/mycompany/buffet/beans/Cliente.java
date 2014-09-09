/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.buffet.beans;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "cliente", catalog = "expresso_esperanca", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByCliCod", query = "SELECT c FROM Cliente c WHERE c.cliCod = :cliCod"),
    @NamedQuery(name = "Cliente.findByCliNome", query = "SELECT c FROM Cliente c WHERE c.cliNome = :cliNome"),
    @NamedQuery(name = "Cliente.findByCliRg", query = "SELECT c FROM Cliente c WHERE c.cliRg = :cliRg"),
    @NamedQuery(name = "Cliente.findByCliCpf", query = "SELECT c FROM Cliente c WHERE c.cliCpf = :cliCpf"),
    @NamedQuery(name = "Cliente.findByCliSexo", query = "SELECT c FROM Cliente c WHERE c.cliSexo = :cliSexo"),
    @NamedQuery(name = "Cliente.findByCliEnd", query = "SELECT c FROM Cliente c WHERE c.cliEnd = :cliEnd"),
    @NamedQuery(name = "Cliente.findByCliCont", query = "SELECT c FROM Cliente c WHERE c.cliCont = :cliCont")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cli_cod")
    private Long cliCod;
    @Size(max = 45)
    @Column(name = "cli_nome")
    private String cliNome;
    @Size(max = 12)
    @Column(name = "cli_rg")
    private String cliRg;
    @Size(max = 14)
    @Column(name = "cli_cpf")
    private String cliCpf;
    @Size(max = 1)
    @Column(name = "cli_sexo")
    private String cliSexo;
    @Column(name = "cli_end")
    private BigInteger cliEnd;
    @Column(name = "cli_cont")
    private BigInteger cliCont;
    @OneToMany(mappedBy = "anivCliente", fetch = FetchType.LAZY)
    private List<Aniversariante> aniversarianteList;

    public Cliente() {
    }

    public Cliente(Long cliCod) {
        this.cliCod = cliCod;
    }

    public Long getCliCod() {
        return cliCod;
    }

    public void setCliCod(Long cliCod) {
        this.cliCod = cliCod;
    }

    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }

    public String getCliRg() {
        return cliRg;
    }

    public void setCliRg(String cliRg) {
        this.cliRg = cliRg;
    }

    public String getCliCpf() {
        return cliCpf;
    }

    public void setCliCpf(String cliCpf) {
        this.cliCpf = cliCpf;
    }

    public String getCliSexo() {
        return cliSexo;
    }

    public void setCliSexo(String cliSexo) {
        this.cliSexo = cliSexo;
    }

    public BigInteger getCliEnd() {
        return cliEnd;
    }

    public void setCliEnd(BigInteger cliEnd) {
        this.cliEnd = cliEnd;
    }

    public BigInteger getCliCont() {
        return cliCont;
    }

    public void setCliCont(BigInteger cliCont) {
        this.cliCont = cliCont;
    }

    @XmlTransient
    public List<Aniversariante> getAniversarianteList() {
        return aniversarianteList;
    }

    public void setAniversarianteList(List<Aniversariante> aniversarianteList) {
        this.aniversarianteList = aniversarianteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliCod != null ? cliCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.cliCod == null && other.cliCod != null) || (this.cliCod != null && !this.cliCod.equals(other.cliCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.buffet.beans.Cliente[ cliCod=" + cliCod + " ]";
    }
    
}
