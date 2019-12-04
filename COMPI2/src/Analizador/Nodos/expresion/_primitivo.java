/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador.Nodos.expresion;

import Analizador.Nodo;
import Analizador.Nodos.itemRetorno;
import Analizador.Nodos.nodoVariable;
import Tablas.TablaSimbolos;
import Tablas.entorno;

/**
 *
 * @author Christian
 */
public class _primitivo extends Nodo{
    
    public _primitivo(String token, String lexema, int fila, int columna) {
        super(token, lexema, fila, columna);
    }
    
    public itemRetorno ejecutar(entorno nuevoEntorno, TablaSimbolos tabla) {
        itemRetorno valor = new itemRetorno(0);
        try{
            if(this.hijos.get(0).token.equals("id")){
                nodoVariable var = (nodoVariable) nuevoEntorno.getValor(this.hijos.get(0).lexema);
                valor.valor = var.valor;
            }else{
                valor.valor = this.hijos.get(0).lexema+"";
            }
        }catch(Exception e){
            System.out.println("Error en primitivo - " + e);
        }
        return valor;
    }
}
