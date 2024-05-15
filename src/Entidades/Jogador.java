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
@Table(name = "jogador")
@NamedQueries({
    @NamedQuery(name = "Jogador.findAll", query = "SELECT c FROM Jogador c"),
    @NamedQuery(name = "Jogador.findByIdJogador", query = "SELECT c FROM Jogador c WHERE c.idJogador = :idJogador"),
    @NamedQuery(name = "Jogador.findByNomeJogador", query = "SELECT c FROM Jogador c WHERE c.nomeJogador = :nomeJogador")})
public class Jogador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_jogador")
    private Integer idJogador;
    @Basic(optional = false)
    @Column(name = "nome_jogador")
    private String nomeJogador;

    public Jogador() {
    }

    public Jogador(Integer idJogador) {
        this.idJogador = idJogador;
    }

    public Jogador(Integer idJogador, String nomeJogador) {
        this.idJogador = idJogador;
        this.nomeJogador = nomeJogador;
    }

    public Integer getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(Integer idJogador) {
        this.idJogador = idJogador;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJogador != null ? idJogador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jogador)) {
            return false;
        }
        Jogador other = (Jogador) object;
        if ((this.idJogador == null && other.idJogador != null) || (this.idJogador != null && !this.idJogador.equals(other.idJogador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idJogador + ";" + nomeJogador;
    }

}


