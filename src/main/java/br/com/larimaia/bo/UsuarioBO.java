package br.com.larimaia.bo;

/**
 * Created by Davi on 05/10/2015.
 */

import br.com.larimaia.dao.UsuarioDAO;
import br.com.larimaia.entity.Usuario;

import java.util.List;

/**
 * @author Davi
 */
public class UsuarioBO {
    private UsuarioDAO usuarioDAO;

    public UsuarioBO() {
        usuarioDAO = new UsuarioDAO();
    }

    public void salvar(Usuario usuario) {
        usuarioDAO.salvar(usuario);
    }

    public void remover(int id) {
        usuarioDAO.excluir(usuarioDAO.buscarPorId(id));
    }

    public Usuario editar(int id) {
        return usuarioDAO.buscarPorId(id);
    }

    public Usuario buscarPorId(Integer id) {
        return usuarioDAO.buscarPorId(id);
    }

    public List<Usuario> listar() {
        return usuarioDAO.buscarTodos();
    }
}
