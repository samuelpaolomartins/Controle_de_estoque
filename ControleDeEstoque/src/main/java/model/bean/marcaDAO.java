/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import connection.ConnectionFactory;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class marcaDAO {

    public void create(marca m){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            
            stmt = con.prepareStatement("INSERT INTO marca (marcaProduto, marca) VALUES (?,?)");
            stmt.setInt(1,m.getMarcaProduto());
            stmt.setString(2,m.getMarca());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
            
        }catch(SQLException ex){
            
            System.out.println(ex);
            
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
    }
    
    public List<marca> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<marca> marcas = new ArrayList<>();
        
        try{
            
            stmt = con.prepareStatement("SELECT * FROM marca");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                marca Marca = new marca();
                
                Marca.setIdMarca(rs.getInt("idMarca"));
                Marca.setMarcaProduto(rs.getInt("marcaProduto"));
                Marca.setMarca(rs.getString("marca"));
                
                marcas.add(Marca);
            }
        }catch(SQLException ex){
            Logger.getLogger(marcaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return marcas;
    }
    
   public static int idmarca(String marca){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            
            stmt = con.prepareStatement("SELECT idMarca FROM marca WHERE marca = ?");
            stmt.setString(1, marca);
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