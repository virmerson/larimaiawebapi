import br.com.larimaia.dao.ClienteDAO;
import br.com.larimaia.entity.Cliente;

/**
 * Created by Davi on 30/09/2015.
 */
public class TestConexao {
    public static void main(String[] args) {

        ClienteDAO clidao = new ClienteDAO();

        Cliente cli = new Cliente();

        cli.setNome("Jao");
        cli.setEmail("jao@gmail.com");
        cli.setTelefone("9999999");

        clidao.salvar(cli);

    }
}
