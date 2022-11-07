package interfaces;

import main.Funcionarios;
import java.util.List;

public interface DAOFuncionarios {

    public void registrar (Funcionarios func) throws Exception;
    public void actualizar(Funcionarios func) throws Exception;
    public void eliminar  (Funcionarios func) throws Exception;
    public List<Funcionarios> listar()        throws Exception;
}
