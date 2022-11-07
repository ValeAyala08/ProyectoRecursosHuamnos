package main;

import dao.DAOFuncionariosImpl;
import interfaces.DAOFuncionarios;


public class Index {

    public static void main(String[] args) {

        Funcionarios func = new Funcionarios();
        int opc = 0;
        do {
            DAOFuncionarios dao = new DAOFuncionariosImpl();
            opc = DAOFuncionariosImpl.leerEntero("Bienvenido al CRUD de la tabla Funcionarios" +
                    "\nElija operación a realizar"+
                    "\n1. Consultar Funcionarios" +
                    "\n2. Registrar Funcionario"  +
                    "\n3. Actualizar Funcionario" +
                    "\n4. Eliminar Funcionario"   +
                    "\n0. Salir"                  );

            if (opc == 1){
                try {
                    for (Funcionarios f : dao.listar()){

                        DAOFuncionariosImpl.Mensaje("ID " + f.getId_funcionario() + " | " + f.getTipo_id() + " #" + f.getNumero_id() + "\n" +
                                f.getPrimer_nombre() + "\n" +
                                ((f.getSegundo_nombre() == null) ? "N/A" : f.getSegundo_nombre()) + "\n" +
                                f.getPrimer_apellido() + "\n" +
                                f.getSegundo_apellido() + "\n" +
                                f.getSexo() + "\n" +
                                f.getEdad() + "\n" +
                                f.getTelefono() + "\n" +
                                f.getDireccion() + "\n" +
                                f.getEstado_civil() + "\n"
                        );
                    }
                    continue;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            } else if (opc == 2) {
                try {
                    dao.registrar(func);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            } else if (opc == 3) {
                try {
                    dao.actualizar(func);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            } else if (opc == 4) {
                try {
                    dao.eliminar(func);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }


        } while (opc > 0);

        DAOFuncionariosImpl.Mensaje("Gracias por usar el sistema");
    }

}


