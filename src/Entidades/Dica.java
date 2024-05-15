/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author luiza
 */
@Entity
@Table(name = "dica")
@NamedQueries({
    @NamedQuery(name = "Dica.findAll", query = "SELECT c FROM Dica c"),
    @NamedQuery(name = "Dica.findByIdDica", query = "SELECT c FROM Dica c WHERE c.idDica = :idDica"),
    @NamedQuery(name = "Dica.findByMaxDica", query = "SELECT c FROM Dica c WHERE c.maxDica = :maxDica")})

public class Dica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_dica")
    private Integer idDica;
    @Basic(optional = false)
    @Column(name = "max_dica")
    private String maxDica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dica")
    private List<CartaHasDica> cartaHasDicaList;

    public Dica() {
    }

    public Dica(Integer idDica) {
        this.idDica = idDica;
    }

    public Dica(Integer idDica, String maxDica) {
        this.idDica = idDica;
        this.maxDica = maxDica;
    }

    public Integer getIdDica() {
        return idDica;
    }

    public void setIdDica(Integer idDica) {
        this.idDica = idDica;
    }

    public String getMaxDica() {
        return maxDica;
    }

    public void setMaxDica(String maxDica) {
        this.maxDica = maxDica;
    }
    
    public List<CartaHasDica> getCartaHasDicaList() {
        return cartaHasDicaList;
    }

    public void setCartaHasDicaList(List<CartaHasDica> CartaHasDicaList) {
        this.cartaHasDicaList = CartaHasDicaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDica != null ? idDica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dica)) {
            return false;
        }
        Dica other = (Dica) object;
        if ((this.idDica == null && other.idDica != null) || (this.idDica != null && !this.idDica.equals(other.idDica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idDica + ";" + maxDica;
    }

}
