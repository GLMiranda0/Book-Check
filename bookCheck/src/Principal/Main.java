/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import JDBC.ConnectionFactory;
import javax.swing.JOptionPane;
import java.sql.Connection;

public class Main {
    
    public static void main(String[]args){
        try {
            //Testando Conecção
            JOptionPane.showMessageDialog(null,"Testando Conexão");
            Connection con = new ConnectionFactory().conecta();
            JOptionPane.showMessageDialog(null,"Tudo ok");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro" + e);
        }
        
        
    }
    
}
