/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
    
public class ConnectionFactory {
    
    public Connection conecta(){
        try{
    
        return DriverManager.getConnection("jdbc:mysql//localhost/bookcheck","root","admin");
    
        }catch(SQLException e){
    
            throw new RuntimeException(e);
            
        }
    }
    
}
