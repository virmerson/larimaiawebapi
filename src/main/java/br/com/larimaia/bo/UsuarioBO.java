package br.com.larimaia.bo;

import br.com.larimaia.dao.UsuarioDAO;
import br.com.larimaia.entity.Usuario;

import javax.enterprise.context.Dependent;
import java.util.List;


@Dependent
public class UsuarioBO {

    private UsuarioDAO usuDao = new UsuarioDAO();


    public UsuarioBO() {
    }

    public void salvar(Usuario usuario) {
        try {
            usuDao.salvar(usuario);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Usuario> listar() {
        return usuDao.buscarTodos();
    }

    public void remover(int id) {
        usuDao.excluir(usuDao.buscarPorId(id));
    }

    public Usuario editar(int id) {
        return usuDao.buscarPorId(id);
    }

}

