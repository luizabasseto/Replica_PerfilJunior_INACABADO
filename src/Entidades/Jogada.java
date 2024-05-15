package Entidades;

/**
 *
 * @author luiza
 */

import Entidades.JogadaHasDica;
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


@Entity
@Table(name = "jogada")
@NamedQueries({
    @NamedQuery(name = "Jogada.findAll", query = "SELECT m FROM Jogada m"),
    @NamedQuery(name = "Jogada.findByDicaEscolhida", query = "SELECT m FROM Jogada m WHERE m.dicaEscolhida = :dicaEscolhida"),
    @NamedQuery(name = "Jogada.findByIdPartida", query = "SELECT m FROM Jogada m WHERE m.idPartida = :idPartida")})
public class Jogada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "resposta")
    private String resposta;
    @JoinColumn(name = "partida_id_partida", referencedColumnName = "id_partida")
    @ManyToOne(optional = false)
    @JoinColumn(name = "jogador_id_jogador", referencedColumnName = "id_jogador")
    @ManyToOne(optional = false)
    @JoinColumn(name = "carta_id_carta", referencedColumnName = "id_carta")
    @ManyToOne(optional = false)
    private Carta cartaIdCarta;
    

    public Jogada() {
    }


    public Jogada(String nomeJogada) {
        this.resposta = nomeJogada;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Categoria getCategoriaIdCategoria() {
        return categoriaIdCategoria;
    }

    public void setCategoriaIdCategoria(Categoria categoriaIdCategoria) {
        this.categoriaIdCategoria = categoriaIdCategoria;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jogada)) {
            return false;
        }
        Jogada other = (Jogada) object;
        if ((this.idJogada == null && other.idJogada != null) || (this.idJogada != null && !this.idJogada.equals(other.idJogada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idJogada + ";" + resposta + ";" + categoriaIdCategoria;
    }

}
