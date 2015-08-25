package tallerN1_compiladores;
import static tallerN1_compiladores.Token.*;
%%
%class Lexer
%type Token
%line
%column
LETRA = [a-zA-Z]
DIGITO = [0-9]
NUMERO = 0 | [1-9][0-9]*
IF = ("i"|"I")("f"|"F")
ELSE = ([eE])([lL])([sS])([eE])
RETURN = ([rR])([eE])([tT])([uU])([rR])([nN])
INT = ([iI])([nN])([tT])
VOID = ([vV])([oO])([iI])([dD])
WHILE = ([wW])([hH])([iI])([lL])([eE])
DO = ([dD])([oO])
SALTO=\n|\r|\r\n /*saltos, que no nos interesa*/
InputCharacter = [^\r\n] /*cualquier cosa excepto /r/n*/
ESPACIOS     = {SALTO} | [ \t\f]
Comment = {TraditionalComment} | {EndOfLineComment}
TraditionalComment   = "/*" ~"*/"
EndOfLineComment     = "//" {InputCharacter}* {SALTO}?
%{
public String lexeme;
public int fila;
public int columna;
%}
%%
{SALTO} {/*Ignore*/}
{ESPACIOS} {/*Ignore*/}
{Comment} {lexeme=yytext(); fila=yyline; columna=yycolumn; return COMENTARIO;}
{IF} {lexeme=yytext(); fila=yyline; columna=yycolumn; return IF;}
{INT} {lexeme=yytext(); fila=yyline; columna=yycolumn; return INT;}
{ELSE} {lexeme=yytext(); fila=yyline; columna=yycolumn; return ELSE;}
{RETURN} {lexeme=yytext(); fila=yyline; columna=yycolumn; return RETURN;}
{VOID} {lexeme=yytext(); return VOID;}
{WHILE} {lexeme=yytext(); return WHILE;}
{DO} {lexeme=yytext(); fila=yyline; columna=yycolumn; return DO;}
"=" {lexeme=yytext(); fila=yyline; columna=yycolumn; return ASSIGN;}
"+" {lexeme=yytext(); fila=yyline; columna=yycolumn; return SUMA;}
"*" {lexeme=yytext(); fila=yyline; columna=yycolumn; return MULT;}
"-" {lexeme=yytext(); fila=yyline; columna=yycolumn; return RESTA;}
"/" {lexeme=yytext(); fila=yyline; columna=yycolumn; return DIV;}
"<" {lexeme=yytext(); fila=yyline; columna=yycolumn; return MENOR;}
"<=" {lexeme=yytext(); fila=yyline; columna=yycolumn; return MENIGUAL;}
">" {lexeme=yytext(); fila=yyline; columna=yycolumn; return MAYOR;}
">=" {lexeme=yytext(); fila=yyline; columna=yycolumn; return MAYIGUAL;}
"==" {lexeme=yytext(); fila=yyline; columna=yycolumn; return IGUALIGUAL;}
"<>" {lexeme=yytext(); fila=yyline; columna=yycolumn; return DISTINTO;}
";" {lexeme=yytext(); fila=yyline; columna=yycolumn; return PUNTOCOMA;}
"," {lexeme=yytext(); fila=yyline; columna=yycolumn; return COMA;}
"(" {lexeme=yytext(); fila=yyline; columna=yycolumn; return PARENTHLEFT;}
")" {lexeme=yytext(); fila=yyline; columna=yycolumn; return PARENTHRIGHT;}
"[" {lexeme=yytext(); fila=yyline; columna=yycolumn; return BRACKETLEFT;}
"]" {lexeme=yytext(); fila=yyline; columna=yycolumn; return BRACKETRIGHT;}
"{" {lexeme=yytext(); fila=yyline; columna=yycolumn; return BRACELEFT;}
"}" {lexeme=yytext(); fila=yyline; columna=yycolumn; return BRACERIGHT;}
([A-Z]){LETRA}* {lexeme=yytext(); fila=yyline; columna=yycolumn; return ERROR;}
([a-z]){LETRA}*{DIGITO}* {lexeme=yytext();  fila=yyline; columna=yycolumn; return ID;}
("_"){LETRA}+ {lexeme=yytext(); fila=yyline; columna=yycolumn; return ID;}
("_"){LETRA}+{DIGITO} {lexeme=yytext(); fila=yyline; columna=yycolumn; return ID;}
{NUMERO} {lexeme=yytext(); fila=yyline; columna=yycolumn; return NUM;}
"[^]" {lexeme=yytext(); fila=yyline; columna=yycolumn; return ERROR;}
. {lexeme=yytext(); fila=yyline; columna=yycolumn; return ERROR;}
