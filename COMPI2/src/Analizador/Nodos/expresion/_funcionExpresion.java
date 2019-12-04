/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador.Nodos.expresion;

import Analizador.Nodo;
import Analizador.Nodos.Funcion.nodoFuncion;
import Analizador.Nodos.itemRetorno;
import Tablas.TablaSimbolos;
import Tablas.entorno;
import java.util.ArrayList;

/**
 *
 * @author Christian
 */
public class _funcionExpresion extends Nodo{

    public _funcionExpresion(String token, String lexema, int fila, int columna) {
        super(token, lexema, fila, columna);
    }
    public itemRetorno ejecutar(entorno nuevoEntorno, TablaSimbolos tabla) {
        itemRetorno retorno = new itemRetorno(0);
        try{
            String id = this.hijos.get(0).lexema;
            
            if(tabla.existeFuncion(id)){
                if(this.hijos.size() == 2){
                    itemRetorno valores = this.hijos.get(1).ejecutar(nuevoEntorno, tabla);
                    ArrayList<String> lista = (ArrayList<String>)valores.valor;
                    tabla.tmpIniciar(lista);
                }                    
                
                nodoFuncion funcion = tabla.getFuncion(id);
                itemRetorno valorRetorno = funcion.ejecutar(nuevoEntorno, tabla);
                tabla.tmpVaciar();
                
                retorno.valor = valorRetorno.valor;
            }else{
                retorno.valor = "null";
            }
                        
        }catch(Exception e){
            System.out.println("Error en funcion expresion - " + e);
        }
        return retorno;
    }
}
