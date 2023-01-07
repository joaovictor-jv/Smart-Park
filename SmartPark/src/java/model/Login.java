/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joao.vmgonso
 */
@Entity
@Table(name = "login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),
    @NamedQuery(name = "Login.findByUsuarioemail", query = "SELECT l FROM Login l WHERE l.usuarioemail = :usuarioemail"),
    @NamedQuery(name = "Login.findByEmailSenha", query = "SELECT l FROM Login l WHERE l.usuarioemail = :email AND l.senha = :senha"),
    @NamedQuery(name = "Login.findBySenha", query = "SELECT l FROM Login l WHERE l.senha = :senha")})
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Usuario_email")
    private String usuarioemail;
    @Column(name = "senha")
    private String senha;
    @JoinColumn(name = "Usuario_email", referencedColumnName = "emailUsuario", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;

    public Login() {
    }

    public Login(String usuarioemail) {
        this.usuarioemail = usuarioemail;
    }

    public String getUsuarioemail() {
        return usuarioemail;
    }

    public void setUsuarioemail(String usuarioemail) {
        this.usuarioemail = usuarioemail;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioemail != null ? usuarioemail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.usuarioemail == null && other.usuarioemail != null) || (this.usuarioemail != null && !this.usuarioemail.equals(other.usuarioemail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Login[ usuarioemail=" + usuarioemail + " ]";
    }
    
}
