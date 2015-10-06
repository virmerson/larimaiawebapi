package br.com.larimaia.dao;

/**
 * Created by Davi on 05/10/2015.
 */
import br.com.larimaia.entity.Usuario;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Davi
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
        try {
            tx.begin();
            em.merge(usuario);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }

    public Usuario buscarPorId(Integer id) {

        return em.find(Usuario.class, id);
    }

    public List<Usuario> buscarTodos() {
        //JPQL
        Query consulta = em.createQuery("select c from Usuario c");
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
