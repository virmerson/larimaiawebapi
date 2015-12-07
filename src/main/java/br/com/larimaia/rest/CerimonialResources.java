package br.com.larimaia.rest;

import br.com.larimaia.bo.CerimonialBO;
import br.com.larimaia.entity.Cerimonial;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Kennedy on 02/12/2015.
 */
@Path("/cerimonial")
public class CerimonialResources {

    @Inject
    CerimonialBO cerimonialBO;

    @POST
    @Path("/salvar")
    @Consumes("application/json")
    @Produces("application/json")
    public Response salvar(Cerimonial c){
        cerimonialBO.salvar(c);
        return Response.status(200).entity(c).build();

    }

    @GET
    @Path("/editar/{id}")
    public Response editar(@PathParam("id") int id){return Response.status(200).entity(cerimonialBO.editar(id)).build();}

    @DELETE
    @Path("/excluir/{id}")
    public void excluir(@PathParam("id") int id){cerimonialBO.excluir(id); }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar(){
        return Response.status(200).entity(cerimonialBO.listar()).build();
    }
}
