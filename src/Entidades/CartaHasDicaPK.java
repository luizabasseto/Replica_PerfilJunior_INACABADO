/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author luiza
 */
@Embeddable
public class CartaHasDicaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "carta_id_carta")
    private int cartaIdCarta;
    @Basic(optional = false)
    @Column(name = "dica_id_dica")
    private int dicaIdDica;

    public CartaHasDicaPK() {
    }

    public CartaHasDicaPK(int cartaIdCarta, int dicaIdDica) {
        this.cartaIdCarta = cartaIdCarta;
        this.dicaIdDica = dicaIdDica;
    }

    public int getCartaIdCarta() {
        return cartaIdCarta;
    }

    public void setCartaIdCarta(int cartaIdCarta) {
        this.cartaIdCarta = cartaIdCarta;
    }

    public int getDicaIdDica() {
        return dicaIdDica;
    }

    public void setDicaIdDica(int dicaIdDica) {
        this.dicaIdDica = dicaIdDica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cartaIdCarta;
        hash += (int) dicaIdDica;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartaHasDicaPK)) {
            return false;
        }
        CartaHasDicaPK other = (CartaHasDicaPK) object;
        if (this.cartaIdCarta != other.cartaIdCarta) {
            return false;
        }
        if (this.dicaIdDica != other.dicaIdDica) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidade.CartaHasDicaPK[ cartaIdCarta=" + cartaIdCarta + ", dicaIdDica=" + dicaIdDica + " ]";
    }
    
}
