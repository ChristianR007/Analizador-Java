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
public class _aritmetica extends Nodo{
    
    public _aritmetica(String token, String lexema, int fila, int columna) {
        super(token, lexema, fila, columna);
    }
    
    public itemRetorno ejecutar(entorno nuevoEntorno, TablaSimbolos tabla) {
        itemRetorno retorno = new itemRetorno(0);
        try{
            Object val1 = this.hijos.get(0).ejecutar(nuevoEntorno, tabla).valor;
            String signo = this.hijos.get(1).lexema;
            Object val2 = this.hijos.get(2).ejecutar(nuevoEntorno, tabla).valor;
            int resultado = 0;
            
            if(signo.equals("+")){
                int num1 = Integer.parseInt((String) (val1+""));
                int num2 = Integer.parseInt((String) (val2+""));
                resultado = num1 + num2;
            }else if(signo.equals("-")){
                int num1 = Integer.parseInt((String) (val1+""));
                int num2 = Integer.parseInt((String) (val2+""));
                resultado = num1 - num2;            
            }else if(signo.equals("*")){
                int num1 = Integer.parseInt((String) (val1+""));
                int num2 = Integer.parseInt((String) (val2+""));
                resultado = num1 * num2;            
            }else if(signo.equals("/")){
                int num1 = Integer.parseInt((String) (val1+""));
                int num2 = Integer.parseInt((String) (val2+""));
                resultado = num1 / num2;            
            }
            retorno.valor = resultado;
        }catch(Exception e){
            System.out.println("Error en aritmetica - " + e);
        }
        return retorno;
    }
    
}
