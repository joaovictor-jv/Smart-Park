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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author joao.vmgonso
 */
@Entity
@Table(name = "valor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valor.findAll", query = "SELECT v FROM Valor v"),
    @NamedQuery(name = "Valor.findByCategoriaValor", query = "SELECT v FROM Valor v WHERE v.categoriaValor = :categoriaValor"),
    @NamedQuery(name = "Valor.findByValorHora", query = "SELECT v FROM Valor v WHERE v.valorHora = :valorHora"),
    @NamedQuery(name = "Valor.findByValorAdicional", query = "SELECT v FROM Valor v WHERE v.valorAdicional = :valorAdicional")})
public class Valor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "categoriaValor")
    private String categoriaValor;
    @Basic(optional = false)
    @Column(name = "valorHora")
    private String valorHora;
    @Basic(optional = false)
    @Column(name = "valorAdicional")
    private String valorAdicional;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "valorcategoriaValor", fetch = FetchType.EAGER)
    private List<Cliente> clienteList;

    public Valor() {
    }

    public Valor(String categoriaValor) {
        this.categoriaValor = categoriaValor;
    }

    public Valor(String categoriaValor, String valorHora, String valorAdicional) {
        this.categoriaValor = categoriaValor;
        this.valorHora = valorHora;
        this.valorAdicional = valorAdicional;
    }

    public String getCategoriaValor() {
        return categoriaValor;
    }

    public void setCategoriaValor(String categoriaValor) {
        this.categoriaValor = categoriaValor;
    }

    public String getValorHora() {
        return valorHora;
    }

    public void setValorHora(String valorHora) {
        this.valorHora = valorHora;
    }

    public String getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(String valorAdicional) {
        this.valorAdicional = valorAdicional;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoriaValor != null ? categoriaValor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valor)) {
            return false;
        }
        Valor other = (Valor) object;
        if ((this.categoriaValor == null && other.categoriaValor != null) || (this.categoriaValor != null && !this.categoriaValor.equals(other.categoriaValor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Valor[ categoriaValor=" + categoriaValor + " ]";
    }
    
}
