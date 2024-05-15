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
@Table(name = "dicas_padrao")
@NamedQueries({
    @NamedQuery(name = "Dicas_padrao.findAll", query = "SELECT c FROM Dicas_padrao c"),
    @NamedQuery(name = "Dicas_padrao.findByIdDicas_padrao", query = "SELECT c FROM Dicas_padrao c WHERE c.idDicas_padrao = :idDicas_padrao"),
    @NamedQuery(name = "Dicas_padrao.findByNomeDicas_padrao", query = "SELECT c FROM Dicas_padrao c WHERE c.nomeDicas_padrao = :nomeDicas_padrao")})
public class Dicas_padrao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_dicas_padrao")
    private Integer idDicas_padrao;
    @Basic(optional = false)
    @Column(name = "nome_dicas_padrao")
    private String nomeDicas_padrao;

    public Dicas_padrao() {
    }

    public Dicas_padrao(Integer idDicas_padrao) {
        this.idDicas_padrao = idDicas_padrao;
    }

    public Dicas_padrao(Integer idDicas_padrao, String nomeDicas_padrao) {
        this.idDicas_padrao = idDicas_padrao;
        this.nomeDicas_padrao = nomeDicas_padrao;
    }

    public Integer getIdDicas_padrao() {
        return idDicas_padrao;
    }

    public void setIdDicas_padrao(Integer idDicas_padrao) {
        this.idDicas_padrao = idDicas_padrao;
    }

    public String getNomeDicas_padrao() {
        return nomeDicas_padrao;
    }

    public void setNomeDicas_padrao(String nomeDicas_padrao) {
        this.nomeDicas_padrao = nomeDicas_padrao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDicas_padrao != null ? idDicas_padrao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dicas_padrao)) {
            return false;
        }
        Dicas_padrao other = (Dicas_padrao) object;
        if ((this.idDicas_padrao == null && other.idDicas_padrao != null) || (this.idDicas_padrao != null && !this.idDicas_padrao.equals(other.idDicas_padrao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idDicas_padrao + ";" + nomeDicas_padrao;
    }

}


