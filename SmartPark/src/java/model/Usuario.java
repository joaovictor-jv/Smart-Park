/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author joao.vmgonso
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByNomeUsuario", query = "SELECT u FROM Usuario u WHERE u.nomeUsuario = :nomeUsuario"),
    @NamedQuery(name = "Usuario.findByEmailUsuario", query = "SELECT u FROM Usuario u WHERE u.emailUsuario = :emailUsuario"),
    @NamedQuery(name = "Usuario.findByCelularUsuario", query = "SELECT u FROM Usuario u WHERE u.celularUsuario = :celularUsuario")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "nomeUsuario")
    private String nomeUsuario;
    @Id
    @Basic(optional = false)
    @Column(name = "emailUsuario")
    private String emailUsuario;
    @Column(name = "celularUsuario")
    private String celularUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioemail", fetch = FetchType.EAGER)
    private List<Cliente> clienteList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.EAGER)
    private Login login;

    public Usuario() {
    }

    public Usuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public Usuario(String emailUsuario, String nomeUsuario) {
        this.emailUsuario = emailUsuario;
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getCelularUsuario() {
        return celularUsuario;
    }

    public void setCelularUsuario(String celularUsuario) {
        this.celularUsuario = celularUsuario;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailUsuario != null ? emailUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.emailUsuario == null && other.emailUsuario != null) || (this.emailUsuario != null && !this.emailUsuario.equals(other.emailUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Usuario[ emailUsuario=" + emailUsuario + " ]";
    }
    
}
