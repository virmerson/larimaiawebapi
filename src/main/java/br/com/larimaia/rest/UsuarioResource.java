package br.com.larimaia.rest;

import br.com.larimaia.bo.UsuarioBO;
import br.com.larimaia.entity.Usuario;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by Davi on 05/10/2015.
 */
public class UsuarioResource {
    @Inject
    UsuarioBO usuarioBO;

    private int id;


    @POST
    @Path("/salvar")
    @Consumes("application/json")
    @Produces("application/json")
    public Response salvar(Usuario usuario) {
        usuarioBO.salvar(usuario);
        return Response.status(200).entity(usuario).build();
    }

    @GET
    @Path("/editar/{id}")
    public Response editar(@PathParam("id") int id) {
        return Response.status(200).entity(usuarioBO.editar(id)).build();
    }

    @GET
    @Path("/lista")
    @Produces("application/json")
    public Response lista(){

        return Response.status(200).entity(usuarioBO.listar()).build();
    }

    @DELETE
    @Path("/excluir/{id}")
    public void excluir(@PathParam("id") int id) {
        usuarioBO.remover(id);
    }
}
