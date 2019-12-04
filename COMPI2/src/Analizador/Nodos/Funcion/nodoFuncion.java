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
import java.util.ArrayList;

/**
 *
 * @author Christian
 */
public class nodoFuncion {
    public String tipo = "";
    public String id = "";
    public Nodo parametro = null;
    public Nodo cuerpoLocal = null;
    
    public nodoFuncion(String tipo, String id, Nodo parametro, Nodo cuerpo){
        this.tipo = tipo;
        this.id = id;
        this.parametro = parametro;
        this.cuerpoLocal = cuerpo;
    }
    
    public itemRetorno ejecutar(entorno nuevoEntorno, TablaSimbolos tabla){
        entorno nuevoLocal = new entorno("local",nuevoEntorno);
        if(this.parametro != null){
            parametro.ejecutar(nuevoLocal, tabla);
        }
        itemRetorno retorno = cuerpoLocal.ejecutar(nuevoLocal, tabla);
        return retorno;
    }
}
