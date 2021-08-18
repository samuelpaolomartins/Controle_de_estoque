/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Aluno
 */
public class cadastro {
    //pra chamar é alt + insert
    private int idCadastro;
    private String descricaoProduto;
    private int marcaProduto;
    private int corProduto;
    private double precoProduto;
    private int codigoProduto;

    public int getMarcaProduto() {
        return marcaProduto;
    }

    public void setMarcaProduto(int marcaProduto) {
        this.marcaProduto = marcaProduto;
    }

    public int getCorProduto() {
        return corProduto;
    }

    public void setCorProduto(int corProduto) {
        this.corProduto = corProduto;
    }

    public int getIdCadastro() {
        return idCadastro;
    }

    public void setIdCadastro(int idCadastro) {
        this.idCadastro = idCadastro;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
    
        
}
