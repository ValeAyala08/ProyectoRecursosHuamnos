package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    protected Connection conexion;
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost/recursos_humanos";
    private final String DB_USER = "root";
    private final String DB_PASS = "";

    public void conectar() throws Exception {
        try {
            conexion = DriverManager.getConnection(DB_URL,DB_USER, DB_PASS);

            System.out.println("Base de datos conectada");
            Class.forName(JDBC_DRIVER);

        } catch (Exception e){
            e.getMessage();
            throw e;
        }
    }

    public void cerrarConexion() throws SQLException {
        if (conexion != null)
            if (!conexion.isClosed())
                conexion.close();
    }


}