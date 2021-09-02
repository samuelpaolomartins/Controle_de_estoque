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
public class cor {
    
    private int idCor;
    private int corProduto;
    private String cor;

    public int getIdCor() {
        return idCor;
    }

    public void setIdCor(int idCor) {
        this.idCor = idCor;
    }

    public int getCorProduto() {
        return corProduto;
    }

    public void setCorProduto(int corProduto) {
        this.corProduto = corProduto;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
    @Override
    public String toString(){
        return getCor();
    }
}
