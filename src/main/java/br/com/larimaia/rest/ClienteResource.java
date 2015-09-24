package br.com.larimaia.rest;

import br.com.larimaia.bo.ClienteBO;
import br.com.larimaia.entity.Cliente;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;


/**
 * Created by Usuario on 23/09/2015.
 */
public class ClienteResource {
    @Inject
    ClienteBO clienteBO;
    private int id;


    @POST
    @Path("/salvar")
    @Consumes("apllication/jason")
    @Produces("application/json")
    public void salvar(Cliente cliente){
        clienteBO.salvar(cliente);

    }

   @GET
   @Path("/editar/{id}")
   public Cliente editar(@PathParam("id") int id){
       return clienteBO.editar(id);
   }



    @DELETE
    @Path("/excluir/{id}")
    public void excluir(@PathParam("id") int id){
        clienteBO.remover(id);
    }




}
