package br.com.larimaia.bo;

import br.com.larimaia.dao.PedidoDAO;
import br.com.larimaia.entity.ItemPedido;
import br.com.larimaia.entity.Pedido;
import br.com.larimaia.entity.TipoEvento;

import javax.enterprise.context.Dependent;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by Davi on 23/09/2015.
 */
@Dependent
public class PedidoBO {

    private PedidoDAO pedidoDAO = new PedidoDAO();


    public PedidoBO(){
    }

    public void salvar(Pedido pedido){
        try {

            for(ItemPedido ip:pedido.getItemPedidoCollection())
                ip.setId(pedido);

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

    public List<Pedido> porDataPedido(String dataInicio, String dataFim){return pedidoDAO.findByDataPedido(dataInicio, dataFim);}

    public List<Pedido> porCliente(Integer id){
        return pedidoDAO.findByCliente(id);
    }

    public List<Pedido> porDataEvento(String dataInicio, String dataFim){

        return pedidoDAO.findByDataEvento(dataInicio, dataFim);
    }
}


