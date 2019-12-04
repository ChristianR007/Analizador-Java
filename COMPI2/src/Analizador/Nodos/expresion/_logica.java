/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador.Nodos.expresion;

import Analizador.Nodo;
import Analizador.Nodos.itemRetorno;
import Tablas.TablaSimbolos;
import Tablas.entorno;

/**
 *
 * @author Christian
 */
public class _logica extends Nodo{
    
    public _logica(String token, String lexema, int fila, int columna) {
        super(token, lexema, fila, columna);
    }
    
    public itemRetorno ejecutar(entorno nuevoEntorno, TablaSimbolos tabla) {
        itemRetorno retorno = new itemRetorno(0);
        try{
            Object val1 = this.hijos.get(0).ejecutar(nuevoEntorno, tabla).valor;
            String signo = this.hijos.get(1).lexema;
            Object val2 = this.hijos.get(2).ejecutar(nuevoEntorno, tabla).valor;
            boolean resultado = false;
            
            String bool1 = (String) (val1+"");
            String bool2 = (String) (val2+"");
            if(signo.equals("&&")){
                if(bool1.equals("true") && bool2.equals("true")){
                    resultado = true;
                }
            }else if(signo.equals("||")){
                if(bool1.equals("true") || bool2.equals("true")){
                    resultado = true;
                }
            }
            retorno.valor = resultado+"";
        }catch(Exception e){
            System.out.println("Error en logica - " + e);
        }
        return retorno;
    }
}
