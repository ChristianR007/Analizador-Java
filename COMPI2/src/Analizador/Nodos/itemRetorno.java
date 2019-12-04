/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador.Nodos;

/**
 *
 * @author Christian
 */
public class itemRetorno {
    /*
    |--------------------------------------------------------------------------
    | itemRetorno
    |--------------------------------------------------------------------------
    | 0= normal
    | 1 = return;
    | 2 = break
    | 3 = continue
    | 4 = errores
    */
    
    public int tipoRetorno = 0;
    public Object valor = new Object();

    public itemRetorno(int tipoRetorno)
    {
        this.tipoRetorno = tipoRetorno;
    }
    
    public Boolean isRetorno()
    {
        if (tipoRetorno == 1)
            return true;
        else
            return false;
    }

    public Boolean isRomper()
    {
        if (tipoRetorno == 2)
            return true;
        else
            return false;
    }

    public Boolean isContinuar()
    {
        if (tipoRetorno == 3)
            return true;
        else
            return false;
    }

    public void setValueRetorno(Object item)
    {
        tipoRetorno = 1;
        this.valor = item;
    }
}
