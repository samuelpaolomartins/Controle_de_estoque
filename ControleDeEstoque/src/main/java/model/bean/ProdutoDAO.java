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
 * @author Samuel Paolo Martins
 */
public class ProdutoDAO {

    public void create(Produto p) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

    }

    public List<Produto> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM cadastro");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();
                produto.setIdCadastro(rs.getInt("idCadastro"));
                produto.setDescricaoProduto(rs.getString("descricaoProduto"));
                produto.setPrecoProduto(rs.getInt("precoProduto"));
                produto.setCodigoProduto(rs.getInt("codigoProduto"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }
}