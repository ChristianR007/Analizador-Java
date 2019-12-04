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
public class _sentenciaIf extends Nodo{
    
    public _sentenciaIf(String token, String lexema, int fila, int columna) {
        super(token, lexema, fila, columna);
    }
    
    public itemRetorno ejecutar(entorno nuevoEntorno, TablaSimbolos tabla) {
        itemRetorno retorno = new itemRetorno(0);
        try{
            //System.out.println("----- Sentencia if -----");
            String expresion = this.hijos.get(0).ejecutar(nuevoEntorno, tabla).valor+"";
            if(expresion.equals("true")){
                itemRetorno cuerpo = this.hijos.get(1).ejecutar(nuevoEntorno, tabla);
                retorno = cuerpo;
            }else if(this.hijos.size()==3){
                itemRetorno cuerpo = this.hijos.get(2).ejecutar(nuevoEntorno, tabla);
                retorno = cuerpo;
            }
            //System.out.println("---------------------------");
        }catch(Exception e){
            System.out.println("Error en sentencia If - " + e);
        }
        return retorno;
    }
}
