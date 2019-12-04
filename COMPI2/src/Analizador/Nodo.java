/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador;

import Analizador.Nodos.itemRetorno;
import Tablas.TablaSimbolos;
import Tablas.entorno;
import java.util.ArrayList;

/**
 *
 * @author Christian
 */
public class Nodo {
    public String token;
    public String lexema;
    public int fila;
    public int columna;
    public ArrayList<Nodo> hijos;
    //public TablaSimbolos tabla;
    //public entorno Entorno;
    
    public Nodo(String token, String lexema, int fila, int columna) {
        this.token = token;
        //this.tabla = tabla;
        this.lexema = lexema;
        this.fila = fila;
        this.columna = columna;
        this.hijos = new ArrayList<Nodo>();
    }

    public void AddHijo(Nodo nuevo) {
        this.hijos.add(nuevo);
    }
    
    public itemRetorno ejecutarHijos(entorno Entorno, TablaSimbolos tabla) {
        itemRetorno subir = new itemRetorno(0);
        for (Nodo hijo : hijos) {
            itemRetorno actual = hijo.ejecutar(Entorno, tabla);
            if(actual.isRetorno()){
                return actual;
            }   
        }
        return subir;
    }

    public itemRetorno ejecutar(entorno Entorno, TablaSimbolos tabla) {
        return ejecutarHijos(Entorno, tabla);
    }
    
/*   public nodoResultado getValor(entorno nuevoEntorno){
        return null;
    }
*/
}
