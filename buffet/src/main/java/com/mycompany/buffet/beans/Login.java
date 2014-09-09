/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.buffet.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Edilayne
 */
@Entity
@Table(name = "login", catalog = "expresso_esperanca", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),
    @NamedQuery(name = "Login.findByLogCod", query = "SELECT l FROM Login l WHERE l.logCod = :logCod"),
    @NamedQuery(name = "Login.findByLogUsuario", query = "SELECT l FROM Login l WHERE l.logUsuario = :logUsuario"),
    @NamedQuery(name = "Login.findByLogSenha", query = "SELECT l FROM Login l WHERE l.logSenha = :logSenha")})
public class Login implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "log_cod")
    private Long logCod;
    @Size(max = 20)
    @Column(name = "log_usuario")
    private String logUsuario;
    @Size(max = 8)
    @Column(name = "log_senha")
    private String logSenha;

    public Login() {
    }

    public Login(Long logCod) {
        this.logCod = logCod;
    }

    public Long getLogCod() {
        return logCod;
    }

    public void setLogCod(Long logCod) {
        this.logCod = logCod;
    }

    public String getLogUsuario() {
        return logUsuario;
    }

    public void setLogUsuario(String logUsuario) {
        this.logUsuario = logUsuario;
    }

    public String getLogSenha() {
        return logSenha;
    }

    public void setLogSenha(String logSenha) {
        this.logSenha = logSenha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logCod != null ? logCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.logCod == null && other.logCod != null) || (this.logCod != null && !this.logCod.equals(other.logCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.buffet.beans.Login[ logCod=" + logCod + " ]";
    }
    
}
