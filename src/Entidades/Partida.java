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
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author luiza
 */
@Entity
@Table(name = "partida")
@NamedQueries({
    @NamedQuery(name = "Partida.findAll", query = "SELECT c FROM Partida c"),
    @NamedQuery(name = "Partida.findByIdPartida", query = "SELECT c FROM Partida c WHERE c.idPartida = :idPartida"),
    @NamedQuery(name = "Partida.findByDataPartida", query = "SELECT c FROM Partida c WHERE c.dataPartida = :dataPartida")})
public class Partida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_partida")
    private Integer idPartida;
    @Basic(optional = false)
    @Column(name = "data_partida")
    private DateTime dataPartida;

    public Partida() {
    }

    public Partida(Integer idPartida) {
        this.idPartida = idPartida;
    }

    public Partida(Integer idPartida, DateTime dataPartida) {
        this.idPartida = idPartida;
        this.dataPartida = dataPartida;
    }

    public Integer getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Integer idPartida) {
        this.idPartida = idPartida;
    }

    public DateTime getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(DateTime dataPartida) {
        this.dataPartida = dataPartida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPartida != null ? idPartida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partida)) {
            return false;
        }
        Partida other = (Partida) object;
        if ((this.idPartida == null && other.idPartida != null) || (this.idPartida != null && !this.idPartida.equals(other.idPartida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idPartida + ";" + dataPartida;
    }

}


