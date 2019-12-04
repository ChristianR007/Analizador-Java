/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import java.util.HashMap;

/**
 *
 * @author Christian
 */
public class entorno {

    public String nombre;   // Si es global o local
    private entorno anterior;       // Mantiene puntero hacia el entorno anterior
    private HashMap<String, Object> tablaSimbolos = new HashMap<String, Object>();
    
    public entorno(String nombre, entorno anterior) {
        this.nombre = nombre;
        this.anterior = anterior;
    }

    //--------------------------------------------------------------------------------------- EXISTE NODO
    public boolean existeValor(String nombre) {
        if (tablaSimbolos.containsKey(nombre)) {
            return true;
        } else {
            if(anterior!=null){
                return anterior.existeValor(nombre);
            }
        }
        return false;
    }
    public boolean existeElemento(String nombre) {
        if (tablaSimbolos.containsKey(nombre)) {
            return true;
        } else {
            return false;
        }
    }
    //---------------------------------------------------------------------------------------INSERTAR
    public void insertarElemento(String nombre, Object nodo) {
        // Validar que exista elemento para marcar error
        tablaSimbolos.put(nombre, nodo);
    }
    //---------------------------------------------------------------------------------------ASIGNAR
    public void asignarElemento(String nombre, Object nuevo) {
        // Validar que exista elemento para marcar error
        if (tablaSimbolos.containsKey(nombre)) {
            tablaSimbolos.replace(nombre, nuevo);
        } else {
            anterior.asignarElemento(nombre, nuevo);
        }
    }
    //---------------------------------------------------------------------------------------RETORNO NODO VALOR
    public Object getValor(String nombre) {
        // Validar que exista antes de pedir valor, para marcar errores
        if (tablaSimbolos.containsKey(nombre)) {
            return tablaSimbolos.get(nombre);
        } else {
            return anterior.getValor(nombre);
        }
    }
    //-------------------------------------------------------------------------------------------------- FIN
    public entorno getEntornoGlobal() {
        if (nombre.equals("global")) {
            return this;
        } else {
            if (anterior != null) {
                return anterior.getEntornoGlobal();
            }
        }
        return null;
    }
    
    public String valorDefecto(String tipo){
        if(tipo.equals("int")){
            return "0";
        }else if(tipo.equals("double")){
            return "0.0";
        }else if(tipo.equals("bool")){
            return "true";
        }else{
            // String
            return "null";
        }
    }
            
    public String is(String cadena, entorno en){
        try{
            int numero = Integer.parseInt(cadena);
            return "int";
        }catch(Exception e){
            try{
                double numeroDecimal = Double.parseDouble(cadena);
                return "double";
            }catch(Exception ex){
                try{
                    if(cadena.charAt(0) == '"'){
                        return "string";
                    }else{
                        if(cadena.equals("true") || cadena.equals("false")){
                            return "bool";
                        }
                        return "error1";
                    }
                }catch(Exception ec){
                    return "error2";
                }                    
            }
        }
    }
    
    public void verElementos(){
        System.out.println("---------------------------------------------------------->");
        tablaSimbolos.forEach((k,v) -> elemento(k,v));
        System.out.println("---------------------------------------------------------->");
    }
            
    public void elemento(String nombre, Object nodo){
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

    public void infoEntornoLLevaActual(){
        System.out.println("ENTORNO: " + this.nombre +"-"+ this.tablaSimbolos.size());
        if(this.anterior != null){
            this.anterior.infoEntornoLLevaActual();
        }
    }
}
