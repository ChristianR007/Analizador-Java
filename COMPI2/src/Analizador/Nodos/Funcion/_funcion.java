/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador.Nodos.Funcion;

import Analizador.Nodo;
import Analizador.Nodos.itemRetorno;
import Tablas.TablaSimbolos;
import Tablas.entorno;

/**
 *
 * @author Christian
 */
public class _funcion extends Nodo{
    
    public _funcion(String token, String lexema, int fila, int columna) {
        super(token, lexema, fila, columna);
    }
    
    public itemRetorno ejecutar(entorno nuevoEntorno, TablaSimbolos tabla) {
        itemRetorno retorno = new itemRetorno(0);
        try{
            String tipo = this.hijos.get(0).lexema;
            String id = this.hijos.get(1).lexema;
            if(this.hijos.size() == 4){
                Nodo para = this.hijos.get(2);  // Parametros
                Nodo cuer = this.hijos.get(3);  // Cuerpo Local
                nodoFuncion nueva = new nodoFuncion(tipo,id,para,cuer);
                tabla.agregarFuncion(id, nueva);
            }else if(this.hijos.size() == 3){
                Nodo cuer = this.hijos.get(2);  // Cuerpo Local
                nodoFuncion nueva = new nodoFuncion(tipo,id,null,cuer);
                tabla.agregarFuncion(id, nueva);
            }
        }catch(Exception e){
            System.out.println("Error en retorno - " + e);
        }
        return retorno;
    }
}
