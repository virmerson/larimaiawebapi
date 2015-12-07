package br.com.larimaia.rest;

import br.com.larimaia.bo.ProdutoBO;
import br.com.larimaia.entity.Produto;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Lucas 23/09/2015.
 */

@Path("/produto")
public class ProdutoResources {
    @Inject
    ProdutoBO produtoBO;

    @POST
    @Path("/salvar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(Produto produto){

        produtoBO.salvar(produto);
        System.out.println("Salvar produto --> " + produto.getDescricao());
        System.out.println("Salvar produto --> "+produto.getValor());

        return Response.status(200).entity(produto).build();
    }

    @GET
    @Path("/editar/{id}")
    public Response editar(@PathParam("id") int id){
        return Response.status(200).entity(produtoBO.editar(id)).build();
    }


    @DELETE
    @Path("/excluir/{id}")
    public void excluir(@PathParam("id") int id){
          produtoBO.remover(id);
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar(){
        return Response.status(200).entity(produtoBO.listar()).build();
    }

}
