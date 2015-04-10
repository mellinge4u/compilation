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
opMult = \*
opDiff = !=
opEgal = ==
opSup = \>
opInf = \<
parO = \(
parF = \)
%%

";"                	{ return symbol(CodeLexicaux.POINTVIRGULE); }

"nombre"  { return symbol(CodeLexicaux.NOMBRE, yytext());}
"opPlus"  { return symbol(CodeLexicaux.OPPLUS);}
"opMoins"  { return symbol(CodeLexicaux.OPMOINS);}
"opMult"  { return symbol(CodeLexicaux.OPMULT);}
"opDiff"  { return symbol(CodeLexicaux.OPDIFF);}
"opEgal"  { return symbol(CodeLexicaux.OPEGAL);}
"opSup"  { return symbol(CodeLexicaux.OPSUP);}
"opInf"  { return symbol(CodeLexicaux.OPINF);}
"parO"  { return symbol(CodeLexicaux.PARO);}
"parF"  { return symbol(CodeLexicaux.PARF);}


.                       {}
\n                      {}
