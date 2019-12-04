/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador.Nodos;

import Analizador.Nodo;
import Tablas.TablaSimbolos;
import Tablas.entorno;

/**
 *
 * @author Christian
 */
public class _variable extends Nodo{
    
    public _variable(String token, String lexema, int fila, int columna) {
        super(token, lexema, fila, columna);
    }
    
    public itemRetorno ejecutar(entorno ent, TablaSimbolos tabla) {
        itemRetorno retorno = new itemRetorno(0);
        try{
            //System.out.println("----- Variable "+ent.nombre+" -----");
            String tipo = this.hijos.get(0).lexema;
            String id = this.hijos.get(1).lexema;
            String valor = (String)(this.hijos.get(2).ejecutar(ent, tabla).valor+"");
            
            System.out.println(tipo + " " + id + " = " + valor );
            //System.out.println("---------------------------");
            
            nodoVariable nueva = new nodoVariable(tipo,id,valor);
            ent.insertarElemento(id, nueva);
        }catch(Exception e){
            System.out.println("Problema en variables - " +e);
        }
        
        return retorno;
    }
    
}
