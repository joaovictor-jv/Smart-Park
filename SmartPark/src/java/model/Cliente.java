/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joao.vmgonso
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByPlacaCliente", query = "SELECT c FROM Cliente c WHERE c.placaCliente = :placaCliente"),
    @NamedQuery(name = "Cliente.findByEntradaCliente", query = "SELECT c FROM Cliente c WHERE c.entradaCliente = :entradaCliente"),
    @NamedQuery(name = "Cliente.findBySaidaCliente", query = "SELECT c FROM Cliente c WHERE c.saidaCliente = :saidaCliente"),
    @NamedQuery(name = "Cliente.findByPermanenciaCliente", query = "SELECT c FROM Cliente c WHERE c.permanenciaCliente = :permanenciaCliente")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "placaCliente")
    private String placaCliente;
    @Column(name = "entradaCliente")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entradaCliente;
    @Column(name = "saidaCliente")
    @Temporal(TemporalType.TIMESTAMP)
    private Date saidaCliente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "permanenciaCliente")
    private Double permanenciaCliente;
    @JoinColumn(name = "Usuario_email", referencedColumnName = "emailUsuario")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuarioemail;
    @JoinColumn(name = "Valor_categoriaValor", referencedColumnName = "categoriaValor")
    @ManyToOne(fetch = FetchType.EAGER)
    private Valor valorcategoriaValor;

    public Cliente() {
    }

    public Cliente(String placaCliente) {
        this.placaCliente = placaCliente;
    }

    public String getPlacaCliente() {
        return placaCliente;
    }

    public void setPlacaCliente(String placaCliente) {
        this.placaCliente = placaCliente;
    }

    public Date getEntradaCliente() {
        return entradaCliente;
    }

    public void setEntradaCliente(Date entradaCliente) {
        this.entradaCliente = entradaCliente;
    }

    public Date getSaidaCliente() {
        return saidaCliente;
    }

    public void setSaidaCliente(Date saidaCliente) {
        this.saidaCliente = saidaCliente;
    }

    public Double getPermanenciaCliente() {
        return permanenciaCliente;
    }

    public void setPermanenciaCliente(Double permanenciaCliente) {
        this.permanenciaCliente = permanenciaCliente;
    }

    public Usuario getUsuarioemail() {
        return usuarioemail;
    }

    public void setUsuarioemail(Usuario usuarioemail) {
        this.usuarioemail = usuarioemail;
    }

    public Valor getValorcategoriaValor() {
        return valorcategoriaValor;
    }

    public void setValorcategoriaValor(Valor valorcategoriaValor) {
        this.valorcategoriaValor = valorcategoriaValor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placaCliente != null ? placaCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.placaCliente == null && other.placaCliente != null) || (this.placaCliente != null && !this.placaCliente.equals(other.placaCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cliente[ placaCliente=" + placaCliente + " ]";
    }
    
}
