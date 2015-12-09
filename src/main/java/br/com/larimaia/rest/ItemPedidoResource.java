package br.com.larimaia.rest;

import br.com.larimaia.bo.ItemPedidoBO;
import br.com.larimaia.entity.ItemPedido;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;


/**
 * Created by Kennedy on 30/11/2015.
 */
@Path("/itempedido")
public class ItemPedidoResource {

    @Inject
    ItemPedidoBO itemPedidoBO;

    private int id;


    @POST
    @Path("/salvar")
    @Consumes("application/json")
    @Produces("application/json")
    public Response salvar(ItemPedido itemPedido) {
        itemPedidoBO.salvar(itemPedido);
        return Response.status(200).entity(itemPedido).build();
    }

    @GET
    @Path("/editar/{id}")
    public Response editar(@PathParam("id") int id) {
        return Response.status(200).entity(itemPedidoBO.editar(id)).build();
    }

    @GET
    @Path("/lista")
    @Produces("application/json")
    public Response lista(){

        return Response.status(200).entity(itemPedidoBO.listar()).build();
    }

    @DELETE
    @Path("/excluir/{id}")
    public void excluir(@PathParam("id") int id) {
        itemPedidoBO.remover(id);
    }

}
