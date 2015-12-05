package br.com.larimaia.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Usuario on 02/12/2015.
 */

@Entity
@Table(name = "cerimonial")
public class Cerimonial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCerimonial;
    @Column(name = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String descricao) {
        this.nome = descricao;
    }

    public Integer getIdCerimonial() {
        return idCerimonial;
    }

    public void setIdCerimonial(Integer idCerimonial) {
        this.idCerimonial = idCerimonial;
    }

    @Override
    public String toString() {
        return nome;
    }
}
