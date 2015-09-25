package br.com.larimaia.rest;

import br.com.larimaia.bo.ProdutoBO;
import br.com.larimaia.entity.Produto;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by Lucas 23/09/2015.
 */

@Path("/produto")
public class ProdutoResources {
    @Inject
    ProdutoBO produtoBO;

    @Path("/salvar")
    @Consumes("application/json")
    public void salvar(Produto produto){
      produtoBO.salvar(produto);
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

}
