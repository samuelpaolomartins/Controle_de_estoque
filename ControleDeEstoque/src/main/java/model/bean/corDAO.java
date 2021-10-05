/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class corDAO {
    
    public void create(cor a){
        
       Connection con = ConnectionFactory.getConnection();
       PreparedStatement stmt = null;
       
       try{
           
           stmt = con.prepareStatement("INSERT INTO cor (corProduto, cor) VALUES (?,?)");
           stmt.setInt(1,a.getCorProduto());
           stmt.setString(2,a.getCor());
           
           stmt.executeUpdate();
           
           JOptionPane.showMessageDialog(null, "Salvo com sucesso");
           
       }catch(SQLException ex){
           
           System.out.println(ex);
       
       }finally{
       
           ConnectionFactory.closeConnection(con, stmt);
       
       }
       
    }    
    
    public List<cor> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<cor> cores = new ArrayList<>();
        
        try{
            
            stmt = con.prepareStatement("SELECT * FROM cor");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                cor Cor = new cor();
                
                Cor.setIdCor(rs.getInt("idCor"));
                Cor.setCorProduto(rs.getInt("corProduto"));
                Cor.setCor(rs.getString("cor"));
                
                cores.add(Cor);
            }
        }catch(SQLException ex){
            
            Logger.getLogger(corDAO.class.getName()).log(Level.SEVERE,null, ex);
            
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
        
        return cores;
    }
    
    public static int idcor (String cor){
       
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            
            stmt = con.prepareStatement("SELECT idCor FROM cor WHERE cor = ?");
            stmt.setString(1, cor);
            rs = stmt.executeQuery();
            
            rs.next();
            return rs.getInt(1);
            
        }catch(SQLException ex){
            
            Logger.getLogger(corDAO.class.getName()).log(Level.SEVERE,null, ex);
            return 0;
            
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }    
    }
}
