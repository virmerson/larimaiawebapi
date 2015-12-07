package br.com.larimaia.dao;

import br.com.larimaia.entity.Usuario;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Davi on 23/09/2015.
 */
public class UsuarioDAO {
    EntityManagerFactory emf;
    EntityManager em;

    public UsuarioDAO() {
        //Ler o persistence.xml
        emf = Persistence.createEntityManagerFactory("lm_bemcasadoPU");
        //Criano EntityManager
        em = emf.createEntityManager();
    }

    public void salvar(Usuario usuario) {
        EntityTransaction tx = em.getTransaction();
        System.out.println(usuario.getIdUsuario());
        tx.begin();
        em.merge(usuario);
        tx.commit();

    }

    public Usuario buscarPorId(Integer id) {

        return em.find(Usuario.class, id);
    }

    public List<Usuario> buscarTodos() {
        //JPQL
        Query consulta = em.createQuery("select c from Usuario c ORDER BY c.idUsuario");
        return consulta.getResultList();
    }

    public void excluir(Usuario usuario) {
        //

        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(usuario);
            tx.commit();
        } catch (Exception e) {

            tx.rollback();
            e.printStackTrace();
        }
    }

}

