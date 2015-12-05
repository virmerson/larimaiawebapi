package br.com.larimaia.rest;

import br.com.larimaia.bo.PedidoBO;
import br.com.larimaia.entity.Pedido;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by Lucas on 25/09/2015.
 */

@Path("/pedido")
public class PedidoResources {
    @Inject
    PedidoBO pedidoBO;

    @POST
    @Path("/salvar")
    @Consumes("application/json")
    public void salvar(Pedido pedido){pedidoBO.salvar(pedido);}

    @GET
    @Path("/editar/{id}")
    @Produces("application/json")
    public Response editar(@PathParam("id") int id){return Response.status(200).entity(pedidoBO.editar(id)).build();}

    @DELETE
    @Path("/excluir/{id}")
    public void excluir(@PathParam("id") int id){pedidoBO.remover(id); }

    @GET
    @Path("/buscarporid/{id}")
    @Produces("application/json")
    public Response buscarPorId(@PathParam("id") int id){return Response.status(200).entity(pedidoBO.editar(id)).build(); }

    @GET
    @Path("/pordatapedido/{dataInicio}/{dataFim}")
    @Produces("application/json")
    public Response porDataPedido(@PathParam("dataInicio") String dataInicio,@PathParam("dataFim") String dataFim){
        return Response.status(200).entity(pedidoBO.porDataPedido(dataInicio, dataFim)).build();
    }

    @GET
    @Path("/porcliente/{id}")
    @Produces("application/json")
    public Response porCliente(@PathParam("id") Integer id){
        return Response.status(200).entity(pedidoBO.porCliente(id)).build();
    }


    @GET
    @Path("/pordataevento/{dataInicio}/{dataFim}")
    @Produces("application/json")
    public Response porDataEvento(@PathParam("dataInicio") String dataInicio,@PathParam("dataFim") String dataFim){
        return Response.status(200).entity(pedidoBO.porDataPedido(dataInicio, dataFim)).build();
    }
    
}
