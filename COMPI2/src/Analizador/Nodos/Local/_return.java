/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador.Nodos.Local;

import Analizador.Nodo;
import Analizador.Nodos.itemRetorno;
import Tablas.TablaSimbolos;
import Tablas.entorno;

/**
 *
 * @author Christian
 */
public class _return extends Nodo{
    
    public _return(String token, String lexema, int fila, int columna) {
        super(token, lexema, fila, columna);
    }
    
    public itemRetorno ejecutar(entorno nuevoEntorno, TablaSimbolos tabla) {
        itemRetorno retorno = new itemRetorno(1);
        try{
            retorno.valor = this.hijos.get(0).ejecutar(nuevoEntorno, tabla).valor;
        }catch(Exception e){
            System.out.println("Error en retorno - " + e);
        }
        return retorno;
    }
}
