package br.com.larimaia.bo;

import br.com.larimaia.dao.ItemPedidoDAO;
import br.com.larimaia.dao.PedidoDAO;
import br.com.larimaia.entity.ItemPedido;
import br.com.larimaia.entity.Pedido;
import br.com.larimaia.entity.TipoEvento;

import javax.enterprise.context.Dependent;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Davi on 23/09/2015.
 */
@Dependent
public class PedidoBO {

    private PedidoDAO pedidoDAO = new PedidoDAO();


    public PedidoBO(){
    }

    public Pedido salvar(Pedido pedido){
        try {
            Collection<ItemPedido> itensAux = pedido.getItemPedidoCollection();
            Collection<ItemPedido> itens = new ArrayList<ItemPedido>();
            pedido.setItemPedidoCollection(null);
            pedido = pedidoDAO.salvar(pedido);
            ItemPedidoDAO itemDAO = new ItemPedidoDAO();

            for (ItemPedido ip : itensAux){
              ip.setId(pedido.getId());
                itens.add(ip);
            }

            pedido.setItemPedidoCollection(itens);
            pedido = pedidoDAO.salvar(pedido);
            return pedido;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
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


