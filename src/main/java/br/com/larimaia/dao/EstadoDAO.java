package br.com.larimaia.dao;

import br.com.larimaia.entity.Estado;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by Kennedy on 02/12/2015.
 */
public class EstadoDAO {
    private static EntityManager em;

    public EstadoDAO() {
        em = JPAUtil.abreConexao();
    }

    public void Salvar(Estado c) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(c);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }




    public void Excluir(int c) {
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(em.getReference(Estado.class, c));
            tx.commit();
            //return "Removido com Sucesso !";

        }catch(Exception ex){
            //et.rollback(); // Desfaz o que foi feito em caso de erro
            //System.out.println(ex.getMessage());
            //return "Não foi possivel remover, pois há médicos cadastrados com essa especialidade";
        }
    }

    public List<Estado> Listar() {
        Session session = (Session) em.getDelegate();
        Criteria c = session.createCriteria(Estado.class);
        return c.list();
    }

    public Estado Editar(int id) {
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Estado.class);
        criteria.add(Restrictions.eq("id", id));
        return (Estado)criteria.uniqueResult();
    }
}
