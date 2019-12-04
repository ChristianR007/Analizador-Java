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
import java.util.ArrayList;

/**
 *
 * @author Christian
 */
public class _listaprimitivos extends Nodo{
    
    public _listaprimitivos(String token, String lexema, int fila, int columna) {
        super(token, lexema, fila, columna);
    }
    
    public itemRetorno ejecutar(entorno nuevoEntorno, TablaSimbolos tabla) {
        itemRetorno retorno = new itemRetorno(0);
        try{
            if(this.hijos.size() == 2){
                itemRetorno val = this.hijos.get(0).ejecutar(nuevoEntorno, tabla);
                Object val2 = this.hijos.get(1).ejecutar(nuevoEntorno, tabla).valor;
                String valor = val2+"";
                
                ArrayList<String> list = (ArrayList<String>)val.valor;
                list.add(valor);
                retorno.valor = list;
            }else if(this.hijos.size() == 1){
                ArrayList<String> list = new ArrayList<String>();
                Object val = this.hijos.get(0).ejecutar(nuevoEntorno, tabla).valor;
                String valor = val+"";
                
                list.add(valor);
                retorno.valor = list;
            }
        }catch(Exception e){
            System.out.println("Error en lista primitivos - " + e);
        }
        return retorno;
    }
}
