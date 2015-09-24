package br.com.larimaia.bo;

import br.com.larimaia.dao.PedidoDAO;
import br.com.larimaia.entity.Pedido;
import br.com.larimaia.entity.TipoEvento;

import java.util.List;

/**
 * Created by Davi on 23/09/2015.
 */
public class PedidoBO {

    private PedidoDAO pedidoDAO = new PedidoDAO();


    public PedidoBO(){
    }

    public void salvar(Pedido pedido){
        try {
            pedidoDAO.salvar(pedido);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public List<Pedido> listar(){
        return pedidoDAO.buscarTodos();
    }

    public void remover(int  id){
        pedidoDAO.excluir(pedidoDAO.buscarPorId(id));
    }
    public Pedido editar(int id){
        return pedidoDAO.buscarPorId(id);
    }
}


