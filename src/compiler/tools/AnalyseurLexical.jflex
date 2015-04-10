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

";"                	{ return symbol(CodesLexicaux.POINTVIRGULE); }

{nombre}  { return symbol(CodesLexicaux.NOMBRE, yytext());}
{opPlus}  { return symbol(CodesLexicaux.OPPLUS);}
{opMoins}  { return symbol(CodesLexicaux.OPMOINS);}
{opMult}  { return symbol(CodesLexicaux.OPMULT);}
{opDiff}  { return symbol(CodesLexicaux.OPDIFF);}
{opEgal}  { return symbol(CodesLexicaux.OPEGAL);}
{opSup}  { return symbol(CodesLexicaux.OPSUP);}
{opInf}  { return symbol(CodesLexicaux.OPINF);}
{parO}  { return symbol(CodesLexicaux.PARO);}
{parF}  { return symbol(CodesLexicaux.PARF);}


.                       {}
\n                      {}
