package br.com.larimaia.dao;

import br.com.larimaia.entity.Cerimonial;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Kennedy on 02/12/2015.
 */
public class CerimonialDAO {
    private static EntityManager em;

    public CerimonialDAO() {
        em = JPAUtil.abreConexao();
    }

    public void salvar(Cerimonial c) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(c);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }




    public void excluir(int c) {
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(em.getReference(Cerimonial.class, c));
            tx.commit();
            //return "Removido com Sucesso !";

        }catch(Exception ex){
            //et.rollback(); // Desfaz o que foi feito em caso de erro
            //System.out.println(ex.getMessage());
            //return "Não foi possivel remover, pois há médicos cadastrados com essa especialidade";
        }
    }

    public List<Cerimonial> listar() {
        Session session = (Session) em.getDelegate();
        Criteria c = session.createCriteria(Cerimonial.class);
        return c.list();
    }

    public Cerimonial editar(int id) {
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Cerimonial.class);
        criteria.add(Restrictions.eq("id", id));
        return (Cerimonial)criteria.uniqueResult();
    }
}
