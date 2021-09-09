/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class saidaDAO {
    
   public void create(saida s){
       
       try{
           
           Connection con = ConnectionFactory.getConnection();
           PreparedStatement stmt = null;
           
           stmt = con.prepareStatement("INSERT INTO historico (operacao,codigoProduto, quantidade) VALUES (?,?,?)");
           stmt.setString(1,s.getOperacao());
           stmt.setInt(2,s.getCodigoproduto());
           stmt.setInt(3,s.getQuantidade());
           
           stmt.execute();
           
       }catch(SQLException ex){
           
           Logger.getLogger(saidaDAO.class.getName()).log(Level.SEVERE, null, ex);
           
       }finally{
           
           //ConnectionFactory.closeConnection(con, stmt);
       
       }
   }
}
