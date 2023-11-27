/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JDBC;

import java.sql.*;


public class ConnectionFactory {
     //Metodo para Estabelecer conexão
    public static Connection Conector(){
        java.sql.Connection conexao = null;
        //Chamar Driver
        String driver = "com.mysql.cj.jdbc.Driver";
        //Armazenar informações do Banco
        String url= "jdbc:mysql://localhost:3306/bookcheck";
        String user="root";
        String password="admin";
        //Estabelecendo a conexão com o banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,user,password);
            return conexao;
        } catch (Exception e) {
            return null;
        }
    }
}
