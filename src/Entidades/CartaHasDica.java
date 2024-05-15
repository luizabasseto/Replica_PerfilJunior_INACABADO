/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Entidades.Carta;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author luiza
 */
@Entity
@Table(name = "carta_has_dica")
@NamedQueries({
    @NamedQuery(name = "CartaHasDica.findAll", query = "SELECT m FROM CartaHasDica m"),
    @NamedQuery(name = "CartaHasDica.findByCartaIdCarta", query = "SELECT m FROM CartaHasDica m WHERE m.cartaHasDicaPK.cartaIdCarta = :cartaIdCarta"),
    @NamedQuery(name = "CartaHasDica.findByDicaIdDica", query = "SELECT m FROM CartaHasDica m WHERE m.cartaHasDicaPK.dicaIdDica = :dicaIdDica"),
    @NamedQuery(name = "CartaHasDica.findByTexto_dica", query = "SELECT m FROM CartaHasDica m WHERE m.texto_dica = :texto_dica")})
public class CartaHasDica implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CartaHasDicaPK cartaHasDicaPK;
    @Column(name = "texto_dica")
    private String texto_dica;
    @JoinColumn(name = "dica_id_dica", referencedColumnName = "id_dica", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dica dica;
    @JoinColumn(name = "carta_id_carta", referencedColumnName = "id_carta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Carta carta;

    public CartaHasDica() {
    }

    public CartaHasDica(CartaHasDicaPK cartaHasDicaPK) {
        this.cartaHasDicaPK = cartaHasDicaPK;
    }

    public CartaHasDica(int cartaIdCarta, int dicaIdDica) {
        this.cartaHasDicaPK = new CartaHasDicaPK(cartaIdCarta, dicaIdDica);
    }

    public CartaHasDicaPK getCartaHasDicaPK() {
        return cartaHasDicaPK;
    }

    public void setCartaHasDicaPK(CartaHasDicaPK cartaHasDicaPK) {
        this.cartaHasDicaPK = cartaHasDicaPK;
    }

    public String getTexto_dica() {
        return texto_dica;
    }

    public void setTexto_dica(String texto_dica) {
        this.texto_dica = texto_dica;
    }

    public Dica getDica() {
        return dica;
    }

    public void setDica(Dica dica) {
        this.dica = dica;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartaHasDicaPK != null ? cartaHasDicaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartaHasDica)) {
            return false;
        }
        CartaHasDica other = (CartaHasDica) object;
        if ((this.cartaHasDicaPK == null && other.cartaHasDicaPK != null) || (this.cartaHasDicaPK != null && !this.cartaHasDicaPK.equals(other.cartaHasDicaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "-->"+cartaHasDicaPK;
    }
    
}
