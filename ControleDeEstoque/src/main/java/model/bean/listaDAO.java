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
public class listaDAO {
    
       public void create(lista l){
       
   }

    public List<lista> readForDesc(String codProd) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<lista> listaP = new ArrayList<>();
        
        try {

            stmt = con.prepareStatement("SELECT codigoProduto, quantidade FROM historico WHERE codigoProduto LIKE ?");
            stmt.setString(1, "%"+codProd+"%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                lista saldoT = new lista();
                
                saldoT.setCodigoProduto(rs.getInt("codigoProduto"));
                saldoT.setQuantidade(rs.getInt("quantidade"));
                listaP.add(saldoT);
            }

        } catch (SQLException ex) {

            Logger.getLogger(listaDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);

        }
        return listaP;
    }

}
