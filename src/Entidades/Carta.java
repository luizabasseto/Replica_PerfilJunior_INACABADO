/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Entidades.CartaHasDica;
import Entidades.Categoria;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author luiza
 */
@Entity
@Table(name = "carta")
@NamedQueries({
    @NamedQuery(name = "Carta.findAll", query = "SELECT m FROM Carta m"),
    @NamedQuery(name = "Carta.findByIdCarta", query = "SELECT m FROM Carta m WHERE m.idCarta = :idCarta"),
    @NamedQuery(name = "Carta.findByNomeCarta", query = "SELECT m FROM Carta m WHERE m.nomeCarta = :nomeCarta")})
public class Carta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_carta")
    private Integer idCarta;
    @Basic(optional = false)
    @Column(name = "nome_carta")
    private String nomeCarta;
    @JoinColumn(name = "categoria_id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private Categoria categoriaIdCategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dica")
    private List<CartaHasDica> cartaHasDicaList;

    public Carta() {
    }

    public Carta(Integer idCarta) {
        this.idCarta = idCarta;
    }

    public Carta(Integer idCarta, String nomeCarta) {
        this.idCarta = idCarta;
        this.nomeCarta = nomeCarta;
    }

    public Integer getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(Integer idCarta) {
        this.idCarta = idCarta;
    }

    public String getNomeCarta() {
        return nomeCarta;
    }

    public void setNomeCarta(String nomeCarta) {
        this.nomeCarta = nomeCarta;
    }

    public Categoria getCategoriaIdCategoria() {
        return categoriaIdCategoria;
    }

    public void setCategoriaIdCategoria(Categoria categoriaIdCategoria) {
        this.categoriaIdCategoria = categoriaIdCategoria;
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
        hash += (idCarta != null ? idCarta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carta)) {
            return false;
        }
        Carta other = (Carta) object;
        if ((this.idCarta == null && other.idCarta != null) || (this.idCarta != null && !this.idCarta.equals(other.idCarta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idCarta + ";" + nomeCarta + ";" + categoriaIdCategoria;
    }

}
