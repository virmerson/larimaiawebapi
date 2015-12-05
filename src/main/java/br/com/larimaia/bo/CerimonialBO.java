package br.com.larimaia.bo;

import br.com.larimaia.dao.CerimonialDAO;
import br.com.larimaia.entity.Cerimonial;

import javax.enterprise.context.Dependent;
import java.util.List;

/**
 * Created by Usuario on 02/12/2015.
 */
@Dependent
public class CerimonialBO {
    private CerimonialDAO cerimonialDAO = new CerimonialDAO();

    public CerimonialBO(){}

    public void salvar(Cerimonial cerimonial){
        try {
            cerimonialDAO.salvar(cerimonial);
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public List<Cerimonial> listar(){
        return cerimonialDAO.buscarTodos();
    }

    public void remover(int  id){
        cerimonialDAO.excluir(cerimonialDAO.buscarPorId(id));
    }
    public Cerimonial editar(int id){
        return cerimonialDAO.buscarPorId(id);
    }

}
