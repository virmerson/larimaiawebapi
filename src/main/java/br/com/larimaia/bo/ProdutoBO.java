package br.com.larimaia.bo;

import br.com.larimaia.dao.ProdutoDAO;
import br.com.larimaia.entity.Produto;

import java.util.List;

public class ProdutoBO {

    private ProdutoDAO produtoDAO = new ProdutoDAO();

    public ProdutoBO() {
    }

    public void salvar(Produto produto){
        try {
            produtoDAO.salvar(produto);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public List<Produto> listar(){
        return produtoDAO.buscarTodos();
    }

    public void remover(int id){
      produtoDAO.excluir(produtoDAO.buscarPorId(id));
    }

    public Produto editar(int id){
        return produtoDAO.buscarPorId(id);
    }

}
