/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import Analizador.Nodos.Funcion.nodoFuncion;
import Analizador.TError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Christian
 */
public class TablaSimbolos {
    // Esta es una tabla donde se manejan las funciones y los errores globales
    
    private HashMap<String, nodoFuncion> tablaFunciones = new HashMap<String, nodoFuncion>();
    private LinkedList<TError> tablaErrores = new LinkedList<TError>();
    private ArrayList<String> tmp = null;
    
    public void tmpIniciar(ArrayList<String> nueva){
        this.tmp = nueva;
    }
    
    public String tmpGet(){
        String temporal = tmp.get(0);
        tmp.remove(0);
        return temporal;
    }
    
    public void tmpVaciar(){
        tmp = null;
    }
    
    public void agregarError(String le, int li, int co, String t, String de){
        TError nuevo = new TError(le,li,co,t,de);
        tablaErrores.add(nuevo);
    }
    
    public boolean existeFuncion(String nombre){
        if (tablaFunciones.containsKey(nombre)) {
            return true;
        }
        return false;
    }
    
    public void agregarFuncion(String nombre, nodoFuncion funcion){
        if(existeFuncion(nombre)){
            agregarError(nombre,0,0,"Sintactico", "Funcion ya existe");
        }else{
            tablaFunciones.put(nombre, funcion);
        }        
    }
    
    public nodoFuncion getFuncion(String nombre) {
        return tablaFunciones.get(nombre);
    }    
    
    public void verFunciones(){
        System.out.println("---------------------------------------------------------->");
        tablaFunciones.forEach((k,v) -> funcion(k,v));
        System.out.println("---------------------------------------------------------->");
    }
    public void funcion(String nombre, Object nodo){
        /*
        Object actual = nodo;
        if( actual instanceof nodoVariable){
            nodoVariable actualVar = (nodoVariable)this.getValor(clave);
            cadenaVariables += ("--------------------------------------------> (" + clave+")\n");
            cadenaVariables += actualVar.nombre + " = "+actualVar.valor + "    ("+actualVar.tipo+")\n";
            cadenaVariables += "-------------------------------------------->\n";
            numeroVariables++;
        }
        */
    }
    
    public void cantidadFunciones(){
        System.out.println("Hay " + this.tablaFunciones.size() + " funciones");
    }
}
