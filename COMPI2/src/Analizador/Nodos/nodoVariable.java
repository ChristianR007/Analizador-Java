/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador.Nodos;

/**
 *
 * @author Christian
 */
public class nodoVariable {
    public String tipo = "";
    public String id = "";
    public Object valor = null;
    
    public nodoVariable(String tipo, String id, String val){
        this.tipo = tipo;
        this.id = id;
        this.valor = val;
    }
}
