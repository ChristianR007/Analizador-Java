/*---------------- 1ra Area: Codigo de Usuario --------------*/
//---------> Paquetes, importaciones
package Analizador;
import java.util.LinkedList;
import java_cup.runtime.*;

/*---------------- 2ra Area: Opciones y Declaraciones  --------------*/
%%
%{
    //----> Codigo de usuario en sintaxis java
    String cadena= "";
    public LinkedList<TError> TablaEL = new LinkedList<TError>();  
%}

//------> Directivas
%public
%class Analizador_Lexico
%cupsym Simboloss
%cup
%char
%column
%full
%state CADENA
%state METODO
%ignorecase
%line
%unicode

//Simbolos
igual           = "="
mas             = "+"
menos           = "-"
por             = "*"
div             = "/"
and             = "&&"
or              = "||"
igualigual      = "=="
menor           = "<"
mayor           = ">"
punc            = ";"
coma            = ","
llava           = "{"
llavc           = "}"
para            = "("
parc            = ")"

_int            = "int"
_double         = "double"
_string         = "string"
_bool           = "bool"
_void           = "void"
_retorno        = "return"
_if             = "if"
_else           = "else"

//---------> Expresiones Regulares
ID              = [_A-Za-z][_0-9A-Za-zñÑ]*          //\"á"\"é"\"í"\"ó"\"ú"
numero          = [0-9]+(\.[0-9]+)?
IDS             = \"([^\"]+|[\r\n])*\"

SPACE   = [\ \r\t\f\t]
ENTER   = [\ \n]

comentMultilinea = \#\$([^\$])*\$\#
comentarioLinea = \/\/(.)*

%%

/*---------------- 3ra Area: Reglas Lexicas --------------*/

//-----> Simbolos
<YYINITIAL> {_int}                  {return new Symbol(Simboloss._int, yyline, yycolumn, yytext());}
<YYINITIAL> {_double}               {return new Symbol(Simboloss._double, yyline, yycolumn, yytext());}
<YYINITIAL> {_string}               {return new Symbol(Simboloss._string, yyline, yycolumn, yytext());}
<YYINITIAL> {_bool}                 {return new Symbol(Simboloss._bool, yyline, yycolumn, yytext());}
<YYINITIAL> {_void}                 {return new Symbol(Simboloss._void, yyline, yycolumn, yytext());}
<YYINITIAL> {_retorno}              {return new Symbol(Simboloss._retorno, yyline, yycolumn, yytext());}
<YYINITIAL> {_if}                   {return new Symbol(Simboloss._if, yyline, yycolumn, yytext());}
<YYINITIAL> {_else}                 {return new Symbol(Simboloss._else, yyline, yycolumn, yytext());}

<YYINITIAL> {igual}                 {return new Symbol(Simboloss.igual, yyline, yycolumn, yytext());}
<YYINITIAL> {mas}                   {return new Symbol(Simboloss.mas, yyline, yycolumn, yytext());}
<YYINITIAL> {menos}                 {return new Symbol(Simboloss.menos, yyline, yycolumn, yytext());}
<YYINITIAL> {por}                   {return new Symbol(Simboloss.por, yyline, yycolumn, yytext());}
<YYINITIAL> {div}                   {return new Symbol(Simboloss.div, yyline, yycolumn, yytext());}
<YYINITIAL> {and}                   {return new Symbol(Simboloss.and, yyline, yycolumn, yytext());}
<YYINITIAL> {or}                    {return new Symbol(Simboloss.or, yyline, yycolumn, yytext());}
<YYINITIAL> {igualigual}            {return new Symbol(Simboloss.igualigual, yyline, yycolumn, yytext());}
<YYINITIAL> {menor}                 {return new Symbol(Simboloss.menor, yyline, yycolumn, yytext());}
<YYINITIAL> {mayor}                 {return new Symbol(Simboloss.mayor, yyline, yycolumn, yytext());}
<YYINITIAL> {punc}                  {return new Symbol(Simboloss.punc, yyline, yycolumn, yytext());}
<YYINITIAL> {coma}                  {return new Symbol(Simboloss.coma, yyline, yycolumn, yytext());}
<YYINITIAL> {para}                  {return new Symbol(Simboloss.para, yyline, yycolumn, yytext());}
<YYINITIAL> {parc}                  {return new Symbol(Simboloss.parc, yyline, yycolumn, yytext());}
<YYINITIAL> {llava}                 {return new Symbol(Simboloss.llava, yyline, yycolumn, yytext());}
<YYINITIAL> {llavc}                 {return new Symbol(Simboloss.llavc, yyline, yycolumn, yytext());}

//-------> Simbolos ER
<YYINITIAL> {numero}                {return new Symbol(Simboloss.numero, yyline, yycolumn,yytext());}
<YYINITIAL> {ID}                    {return new Symbol(Simboloss.ID, yyline, yycolumn,yytext());}
<YYINITIAL> {IDS}                   {return new Symbol(Simboloss.IDS, yyline, yycolumn,yytext().toLowerCase());}

<YYINITIAL> {SPACE}                 { /*Espacios en blanco, ignorados*/ }
<YYINITIAL> {ENTER}                 { /*Saltos de linea, ignorados*/}

<YYINITIAL> {comentarioLinea}       {/*System.out.println(">> COMENTARIO DE UNA LINEA");*/}
<YYINITIAL> {comentMultilinea}      {/*System.out.println(">> COMENTARIO MULTILINEA");*/}

//-------> Espacios
//[ \t\r\n\f]             {/* Espacios en blanco, se ignoran */}

//-------> Errores Lexicos
.    { System.out.println("Error Lexico " + yytext() + " Linea " + yyline+1 + " Columna " + yycolumn); 
        TError datos = new TError(yytext(), yyline+1, yycolumn, "Error Lexico ", "Simbolo no existe en el lenguaje");
        TablaEL.add(datos);
     }

<CADENA> {
    [^\<]+ { 
                yybegin(YYINITIAL);
                //return new Symbol(Simboloss.texto, yyline, yycolumn, yytext());
              }        
}

<METODO>{
    [^\}]+ { 
                yybegin(YYINITIAL);
                //return new Symbol(Simboloss.metodo, yyline, yycolumn, yytext().toLowerCase());
              } 
}