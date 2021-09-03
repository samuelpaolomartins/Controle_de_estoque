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
public class marca {
    
    private int idMarca;
    private int marcaProduto;
    private String marca;

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public int getMarcaProduto() {
        return marcaProduto;
    }

    public void setMarcaProduto(int marcaProduto) {
        this.marcaProduto = marcaProduto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    @Override
    public String toString(){
        return getMarca();
    }
    
}
