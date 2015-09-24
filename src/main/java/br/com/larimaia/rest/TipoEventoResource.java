package br.com.larimaia.rest;

import br.com.larimaia.bo.TipoEventoBO;
import br.com.larimaia.entity.TipoEvento;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
/**
 * Created by Usuario on 23/09/2015.
 */
public class TipoEventoResource {
    @Inject
    TipoEventoBO tipoEventoBO;
    private int id;

    @POST
    @Path("/salvar")
    @Consumes("apllication/jason")
    @Produces("application/json")
    public void salvar(TipoEvento tipoEvento){
        tipoEventoBO.salvar(tipoEvento);

    }

    @GET
    @Path("/editar/{id}")
    public TipoEvento editar(@PathParam("id") int id){
        return tipoEventoBO.editar(id);
    }



    @DELETE
    @Path("/excluir/{id}")
    public void excluir(@PathParam("id") int id){
        tipoEventoBO.remover(id);
    }



}
