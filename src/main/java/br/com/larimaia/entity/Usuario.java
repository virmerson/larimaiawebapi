package br.com.larimaia.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Davi on 23/09/2015.
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
        @NamedQuery(name = "Usuario.findAll", query = "SELECT c FROM Usuario c"),
        @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT c FROM Usuario c WHERE c.idUsuario = :idUsuario"),
        @NamedQuery(name = "Usuario.findByNome", query = "SELECT c FROM Usuario c WHERE c.nome = :nome"),
        @NamedQuery(name = "Usuario.findBySenha", query = "SELECT c FROM Usuario c WHERE c.senha = :senha"),
        @NamedQuery(name = "Usuario.findByEmail", query = "SELECT c FROM Usuario c WHERE c.email = :email")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;


    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String nome, String senha, String email) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        return !((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario)));
    }

    @Override
    public String toString() {
        return this.getNome();
    }

}