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

/**
 *
 * @author Aluno
 */
public class entradaDAO {
    
    public void create(entrada e){
        
        try{
            
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            stmt = con.prepareStatement("INSERT INTO historico (operacao,codigoProduto,quantidade) VALUES (?,?,?)");
            stmt.setString(1,e.getOperacao());
            stmt.setInt(2,e.getCodigoProduto());
            stmt.setInt(3,e.getQuantidade());
            
            stmt.execute();
            
        }catch(SQLException ex){
            
            Logger.getLogger(entradaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            
            //ConnectionFactory.closeConnection(con, stmt);
            
        }
    }
    
    public List<entrada> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<entrada> Codigo = new ArrayList<>();
        
        try{
            
            stmt = con.prepareStatement("SELECT \n" +
            "A.codigoProduto AS codigoProduto, \n" +
            "A.descricaoProduto AS descricaoProduto, \n" +
            "(SELECT SUM(quantidade) FROM historico WHERE codigoProduto = A.codigoProduto AND operacao = \"Entrada\") - \n" +
            "(SELECT SUM(quantidade) FROM historico WHERE codigoProduto = A.codigoProduto AND operacao = \"Saída\") AS saldo\n" +
            "\n" +
            "FROM cadastro A");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                entrada codigo = new entrada();
                codigo.setCodigoProduto(rs.getInt("codigoProduto"));
                codigo.setSaldo(rs.getInt("saldo"));
                Codigo.add(codigo);
            }
            
        }catch(SQLException ex){
           
           Logger.getLogger(entradaDAO.class.getName()).log(Level.SEVERE, null, ex);
           
       }finally{
           
           ConnectionFactory.closeConnection(con, stmt, rs);
       
       }
        return Codigo;
    }
}
