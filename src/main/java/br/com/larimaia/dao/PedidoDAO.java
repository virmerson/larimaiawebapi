package br.com.larimaia.dao;

import br.com.larimaia.entity.Pedido;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Davi on 23/09/2015.
 */

public class PedidoDAO {
    EntityManager em;

    public PedidoDAO() {
        em = JPAUtil.abreConexao();
    }

    public void salvar(Pedido pedido) {
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.merge(pedido);
        em.flush();
        tx.commit();

    }

    public Pedido buscarPorId(Integer id) {

        return em.find(Pedido.class, id);
    }

    public List<Pedido> buscarTodos() {
        //JPQL
        Query consulta = em.createQuery("select c from Pedido c");
        return consulta.getResultList();
    }

    public void excluir(Pedido pedido) {
        //

        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(pedido);
            tx.commit();
        } catch (Exception e) {

            tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Pedido> findByDataPedido(String dataInicio, String dataFinal){
        List<Pedido> resultList = em.createNamedQuery("Pedido.findByDataPedido")
                .setParameter("dataInicio", dataInicio).setParameter("dataFinal", dataFinal).getResultList();
        return resultList;
    }

}
