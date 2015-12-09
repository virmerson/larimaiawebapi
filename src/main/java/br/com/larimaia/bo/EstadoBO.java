package br.com.larimaia.bo;

import br.com.larimaia.dao.EstadoDAO;
import br.com.larimaia.entity.Estado;

import javax.enterprise.context.Dependent;
import java.util.List;


@Dependent
public class EstadoBO {

    EstadoDAO dao = new EstadoDAO();

    public EstadoBO() {
    }

    public void salvar(Estado c){
        dao.Salvar(c);
    }
    

    public List<Estado> listar(){
        return dao.Listar();
    }

    public void excluir (int c){
        dao.Excluir(c);
    }

    public Estado Editar(int id) {
        return dao.Editar(id);
    }
}
