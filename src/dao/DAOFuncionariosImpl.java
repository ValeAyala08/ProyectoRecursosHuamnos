package dao;

import main.Funcionarios;
import interfaces.DAOFuncionarios;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOFuncionariosImpl extends Conexion implements DAOFuncionarios {

    @Override
    public void registrar(Funcionarios func) throws Exception {
        try {
            this.conectar();

            Mensaje("-- REGISTRO FUNCIONARIO --\n Ingrese los datos de cada campo a continuación");
            func.setTipo_id(leerTexto("Digite Tipo Documento"));
            func.setNumero_id(leerEntero("Digite Numero Documento"));
            func.setPrimer_nombre(leerTexto("Digite Primer Nombre"));
            func.setSegundo_nombre(leerTexto("Digite Segundo Nombre (Si no tiene escriba N/A)"));
            func.setPrimer_apellido(leerTexto("Digite Primer Apellido"));
            func.setSegundo_apellido(leerTexto("Digite Segundo Apellido"));
            func.setSexo(leerTexto("Digite Sexo de la persona"));
            func.setEdad(leerEntero("Digite Edad persona"));
            func.setTelefono(leerTexto("Digite Telefono persona"));
            func.setDireccion(leerTexto("Digite Direccion persona"));
            func.setEstado_civil(leerTexto("Digite Estado Civil persona"));

            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO funcionarios (tipo_id,numero_id,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,sexo,edad,telefono,direccion,estado_civil) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, func.getTipo_id());
            st.setInt   (2, func.getNumero_id());
            st.setString(3, func.getPrimer_nombre());
            st.setString(4, func.getSegundo_nombre());
            st.setString(5, func.getPrimer_apellido());
            st.setString(6, func.getSegundo_apellido());
            st.setString(7, func.getSexo());
            st.setInt   (8, func.getEdad());
            st.setString(9, func.getTelefono());
            st.setString(10,func.getDireccion());
            st.setString(11,func.getEstado_civil());

            st.executeUpdate();
            Mensaje("Insercion efectuada");

        } catch (Exception e){
            throw e;
        } finally {

            this.cerrarConexion();
        }
    }

    @Override
    public void actualizar(Funcionarios func) throws Exception {
        try {

            int id_func = leerEntero("Ingrese el ID del funcionario a actualizar");
            int opc = 0;

            do {
                opc = leerEntero("Actualización de Funcionario\n" +
                        "1.TipoDoc\n2.NumeroDoc\n3.PrimerNombre\n4.SegundoNombre\n5.PrimerApellido\n6.SegundoApellido" +
                        "\n7.Sexo\n8.Edad\n9.Telefono\n10.Direccion\n11.EstadoCivil \nIngrese 0 para terminar" +
                        "\nEscriba el número del campo a actualizar");

                switch (opc){
                    case 1:
                        this.conectar();
                        func.setTipo_id(leerTexto("Digite Tipo Documento"));
                        PreparedStatement st = this.conexion.prepareStatement("UPDATE funcionarios SET tipo_id=? WHERE id_funcionario = ?");
                        st.setString(1, func.getTipo_id());
                        st.setInt(2, id_func);
                        st.executeUpdate();
                        this.cerrarConexion();
                        break;

                    case 2:
                        this.conectar();
                        func.setNumero_id(leerEntero("Digite Numero Documento"));
                        PreparedStatement st2 = this.conexion.prepareStatement("UPDATE funcionarios SET numero_id=? WHERE id_funcionario = ?");
                        st2.setInt(1, func.getNumero_id());
                        st2.setInt(2, id_func);
                        st2.executeUpdate();
                        this.cerrarConexion();
                        break;

                    case 3:
                        this.conectar();
                        func.setPrimer_nombre(leerTexto("Digite Primer Nombre"));
                        PreparedStatement st3 = this.conexion.prepareStatement("UPDATE funcionarios SET primer_nombre=? WHERE id_funcionario = ?");
                        st3.setString(1, func.getPrimer_nombre());
                        st3.setInt   (2, id_func);
                        st3.executeUpdate();
                        this.cerrarConexion();
                        break;

                    case 4:
                        this.conectar();
                        func.setSegundo_nombre(leerTexto("Digite Segundo Nombre (Si no tiene escriba N/A)"));
                        PreparedStatement st4 = this.conexion.prepareStatement("UPDATE funcionarios SET segundo_nombre=? WHERE id_funcionario = ?");
                        st4.setString(1, func.getSegundo_nombre());
                        st4.setInt   (2, id_func);
                        st4.executeUpdate();
                        this.cerrarConexion();
                        break;

                    case 5:
                        this.conectar();
                        func.setPrimer_apellido(leerTexto("Digite Primer Apellido"));
                        PreparedStatement st5 = this.conexion.prepareStatement("UPDATE funcionarios SET primer_apellido=? WHERE id_funcionario = ?");
                        st5.setString(1, func.getPrimer_apellido());
                        st5.setInt   (2, id_func);
                        st5.executeUpdate();
                        this.cerrarConexion();
                        break;

                    case 6:
                        this.conectar();
                        func.setSegundo_apellido(leerTexto("Digite Segundo Apellido"));
                        PreparedStatement st6 = this.conexion.prepareStatement("UPDATE funcionarios SET segundo_apellido=? WHERE id_funcionario = ?");
                        st6.setString(1, func.getSegundo_apellido());
                        st6.setInt   (2, id_func);
                        st6.executeUpdate();
                        this.cerrarConexion();
                        break;

                    case 7:
                        this.conectar();
                        func.setSexo(leerTexto("Digite Sexo de la persona"));
                        PreparedStatement st7 = this.conexion.prepareStatement("UPDATE funcionarios SET sexo=? WHERE id_funcionario = ?");
                        st7.setString(1, func.getSexo());
                        st7.setInt   (2, id_func);
                        st7.executeUpdate();
                        this.cerrarConexion();
                        break;

                    case 8:
                        this.conectar();
                        func.setEdad(leerEntero("Digite Edad persona"));
                        PreparedStatement st8 = this.conexion.prepareStatement("UPDATE funcionarios SET edad=? WHERE id_funcionario = ?");
                        st8.setInt(1, func.getEdad());
                        st8.setInt(2, id_func);
                        st8.executeUpdate();
                        this.cerrarConexion();
                        break;

                    case 9:
                        this.conectar();
                        func.setTelefono(leerTexto("Digite Telefono persona"));
                        PreparedStatement st9 = this.conexion.prepareStatement("UPDATE funcionarios SET telefono=? WHERE id_funcionario = ?");
                        st9.setString(1, func.getTelefono());
                        st9.setInt   (2, id_func);
                        st9.executeUpdate();
                        this.cerrarConexion();
                        break;

                    case 10:
                        this.conectar();
                        func.setDireccion(leerTexto("Digite Direccion persona"));
                        PreparedStatement st10 = this.conexion.prepareStatement("UPDATE funcionarios SET direccion=? WHERE id_funcionario = ?");
                        st10.setString(1, func.getDireccion());
                        st10.setInt   (2, id_func);
                        st10.executeUpdate();
                        this.cerrarConexion();
                        break;

                    case 11:
                        this.conectar();
                        func.setEstado_civil(leerTexto("Digite Estado Civil persona"));
                        PreparedStatement st11 = this.conexion.prepareStatement("UPDATE funcionarios SET estado_civil=? WHERE id_funcionario = ?");
                        st11.setString(1, func.getEstado_civil());
                        st11.setInt   (2, id_func);
                        st11.executeUpdate();
                        this.cerrarConexion();
                        break;

                    default:
                        Mensaje("Ingrese una de las opciones validas");
                        break;
                }

            } while (opc > 0);


            Mensaje("Funcionario actualizado");


        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void eliminar(Funcionarios func) throws Exception {
        try {
            this.conectar();

            int id_func = leerEntero("Digite ID del funcionario a eliminar");
            func.setId_funcionario(id_func);

            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM funcionarios WHERE id_funcionario = ?");
            st.setInt(1, func.getId_funcionario());
            st.executeUpdate();

            Mensaje("Funcionario eliminado");

        } catch (Exception e){
            throw e;
        } finally {
            this.cerrarConexion();
        }
    }

    @Override
    public List<Funcionarios> listar() {
        List<Funcionarios> lista = null;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM funcionarios");
            st.executeQuery();

            lista = new ArrayList<>();
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                Funcionarios func = new Funcionarios();
                func.setId_funcionario(rs.getInt("id_funcionario"));
                func.setTipo_id(rs.getString("tipo_id"));
                func.setNumero_id(rs.getInt("numero_id"));
                func.setPrimer_nombre(rs.getString("primer_nombre"));
                func.setSegundo_nombre(rs.getString("segundo_nombre"));
                func.setPrimer_apellido(rs.getString("primer_apellido"));
                func.setSegundo_apellido(rs.getString("segundo_apellido"));
                func.setSexo(rs.getString("sexo"));
                func.setEdad(rs.getInt("edad"));
                func.setTelefono(rs.getString("telefono"));
                func.setDireccion(rs.getString("direccion"));
                func.setEstado_civil(rs.getString("estado_civil"));

                lista.add(func);
            }
            rs.close();
            st.close();

        } catch (Exception e){
            try {
                throw e;
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return lista;
    }


    public static void Mensaje (String Texto) { JOptionPane.showMessageDialog ( null, Texto ); }

    public static int leerEntero(String Texto)
    {  int vr;
        try
        {  vr = Integer.parseInt ( JOptionPane.showInputDialog( null, Texto ) );
            return vr;
        } catch( Exception ex )
        {  Mensaje( "Error, Tipo de dato no valido");
            return 0;
        }
    }

    public static String leerTexto(String Texto)
    {
        String Dato = JOptionPane.showInputDialog( null, Texto ).trim();
        if ( Dato.isEmpty())
        { Mensaje ("Valor no valido, debe ser diferente de vacio, reintente por favor");
            return leerTexto ( Texto );
        }
        else
            return Dato;
    }
}