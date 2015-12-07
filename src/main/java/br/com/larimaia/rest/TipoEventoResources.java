package br.com.larimaia.rest;

import br.com.larimaia.bo.TipoEventoBO;
import br.com.larimaia.entity.TipoEvento;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Lucas on 25/09/2015.
 */
@Path("/tipoevento")
public class TipoEventoResources {
    @Inject
    TipoEventoBO tipoEventoBO;

    @POST
    @Path("/salvar")
    @Consumes("application/json")
    @Produces("application/json")
    public void salvar(TipoEvento tipoEvento){
        tipoEventoBO.salvar(tipoEvento);

    }

    @GET
    @Path("/editar/{id}")
    public Response editar(@PathParam("id") int id){return Response.status(200).entity(tipoEventoBO.editar(id)).build();}

    @DELETE
    @Path("/excluir/{id}")
    public void excluir(@PathParam("id") int id){tipoEventoBO.remover(id); }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar(){
        return Response.status(200).entity(tipoEventoBO.listar()).build();
    }

}
