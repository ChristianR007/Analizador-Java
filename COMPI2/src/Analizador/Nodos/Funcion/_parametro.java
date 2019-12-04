/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador.Nodos.Funcion;

import Analizador.Nodo;
import Analizador.Nodos.itemRetorno;
import Analizador.Nodos.nodoVariable;
import Tablas.TablaSimbolos;
import Tablas.entorno;

/**
 *
 * @author Christian
 */
public class _parametro extends Nodo{
    
    public _parametro(String token, String lexema, int fila, int columna) {
        super(token, lexema, fila, columna);
    }
    
    public itemRetorno ejecutar(entorno nuevoEntorno, TablaSimbolos tabla) {
        itemRetorno retorno = new itemRetorno(0);
        try{
            if(this.hijos.size() == 3){
                itemRetorno listaParametros = this.hijos.get(0).ejecutar(nuevoEntorno, tabla);
                String tipo = this.hijos.get(1).lexema;
                String id = this.hijos.get(2).lexema;
                String valor = tabla.tmpGet();
                
                nodoVariable nueva = new nodoVariable(tipo,id,valor);
                nuevoEntorno.insertarElemento(id, nueva);
            }else if(this.hijos.size() == 2){
                String tipo = this.hijos.get(0).lexema;
                String id = this.hijos.get(1).lexema;
                String valor = tabla.tmpGet();
                        
                nodoVariable nueva = new nodoVariable(tipo,id,valor);
                nuevoEntorno.insertarElemento(id, nueva);
            }
        }catch(Exception e){
            System.out.println("Error en parametros - " + e);
        }
        return retorno;
    }
}
