package compiler.tools ;

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

classe			= classe
fin 			= fin
status			= publique|privee
type			= entier
lire			= lire
ecrire			= ecrire

lettre			= [a-zA-Z]
chiffre 		= [0-9]
charAlphaNum	= {lettre}|{chiffre}
nombre 			= {chiffre}+
idf				= {lettre}{charAlphaNum}*

opPlus 			= \+
opMoins 		= -
opMult 			= \*
opDiff 			= \!=
opEgal 			= ==
opSup 			= \>
opInf 			= \<
parO 			= \(
parF 			= \)
egal				= =
%%

";"				{ return symbol(CodesLexicaux.POINTVIRGULE); }

{opEgal}  		{ return symbol(CodesLexicaux.OPEGAL);}
{opDiff}  		{ return symbol(CodesLexicaux.OPDIFF);}
{opSup}  		{ return symbol(CodesLexicaux.OPSUP);}
{opInf}  		{ return symbol(CodesLexicaux.OPINF);}
{parO}  		{ return symbol(CodesLexicaux.PARO);}
{parF}  		{ return symbol(CodesLexicaux.PARF);}
{opPlus}  		{ return symbol(CodesLexicaux.OPPLUS);}
{opMoins}  		{ return symbol(CodesLexicaux.OPMOINS);}
{opMult}  		{ return symbol(CodesLexicaux.OPMULT);}
{nombre}  		{ return symbol(CodesLexicaux.NOMBRE, yytext());}

{classe}		{ return symbol(CodesLexicaux.CLASSE);}
{fin}			{ return symbol(CodesLexicaux.FIN);}
{status}		{ return symbol(CodesLexicaux.STATUS, yytext());}
{type}			{ return symbol(CodesLexicaux.TYPE, yytext());}
{lire}			{ return symbol(CodesLexicaux.LIRE);}
{ecrire}		{ return symbol(CodesLexicaux.ECRIRE);}
{egal}			{ return symbol(CodesLexicaux.EGAL);}
{idf}			{ return symbol(CodesLexicaux.IDF, yytext());}

. 				{}
\n				{}
