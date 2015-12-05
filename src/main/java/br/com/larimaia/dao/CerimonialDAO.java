package br.com.larimaia.dao;

import br.com.larimaia.entity.Cerimonial;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Usuario on 02/12/2015.
 */
public class CerimonialDAO {

    EntityManager em;

    public CerimonialDAO() {
        em = JPAUtil.abreConexao();
    }

    public void salvar(Cerimonial cerimonial) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(cerimonial);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }

    public Cerimonial buscarPorId(Integer id) {

        return em.find(Cerimonial.class, id);
    }

    public List<Cerimonial> buscarTodos() {
        //JPQL
        Query consulta = em.createQuery("select c from Cerimonial c ORDER BY c.idCerimonial");
        return consulta.getResultList();
    }

    public void excluir(Cerimonial cerimonial) {
        //

        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(cerimonial);
            tx.commit();
        } catch (Exception e) {

            tx.rollback();
            e.printStackTrace();
        }
    }
}
