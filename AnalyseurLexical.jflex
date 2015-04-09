package analyse ;

import java_cup.runtime.*;
      
%%
   
%class AnalyseurLexical
%public

%line
%column
    
%type Symbol
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}

%cup
   
%{
  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }
%}

chiffre = [0-9]
nombre = {chiffre}+
opPlus = \+
opMoins = -
opFois = \*
opDiff = !=
opEgal = ==
opSup = \>
opInf = \<
parO = \(
parF = \)
%%

";"                	{ return symbol(CodesLexicaux.POINTVIRGULE); }

"chiffre"  { return symbol(CodesLexicaux.chiffre);}
"nombre"  { return symbol(CodesLexicaux.nombre);}
"opPlus"  { return symbol(CodesLexicaux.opPlus);}
"opMoins"  { return symbol(CodesLexicaux.opMoins);}
"opFois"  { return symbol(CodesLexicaux.opFois);}
"opDiff"  { return symbol(CodesLexicaux.opDiff);}
"opEgal"  { return symbol(CodesLexicaux.opEgal);}
"opSup"  { return symbol(CodesLexicaux.opSup);}
"opInf"  { return symbol(CodesLexicaux.opInf);}
"parO"  { return symbol(CodesLexicaux.parO);}
"parF"  { return symbol(CodesLexicaux.parF);}


.                       {}
\n                      {}
