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
public class cadastroDAO {
    
    public void create(cadastro c){
        
        try{
            
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            stmt = con.prepareStatement("INSERT INTO cadastro (descricaoProduto, precoProduto, codigoProduto) VALUES (?,?,?)");
            
            stmt.setString(1,c.getDescricaoProduto());
            stmt.setDouble(2,c.getPrecoProduto());
            stmt.setInt(3,c.getCodigoProduto());
            
            stmt.execute();
            
        }catch(SQLException ex){
            Logger.getLogger(cadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            //ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
