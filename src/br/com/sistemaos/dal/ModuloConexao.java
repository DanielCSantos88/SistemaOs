 
package br.com.sistemaos.dal;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModuloConexao {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://192.168.0.2:3306/assistencia_tecnica?characterEncoding=utf-8";
    private static final String USER = "dba";
    private static final String PASS = "Dba@123456";

   
    public static Connection conector() {
        Connection conexao = null;

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USER, PASS);
            return conexao;
        } catch (ClassNotFoundException | SQLException ex) {

            throw new RuntimeException("Erro na conexão: ", ex);
        }
    }

    public static void closeConexao(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModuloConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConexao(Connection con, PreparedStatement ps) {
        closeConexao(con);
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModuloConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConexao(Connection con, PreparedStatement ps, ResultSet rs) {
        closeConexao(con, ps);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModuloConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
