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
egal			= =
virgule			= ,
csteChaine		= ".*"
commentaire		= //.*\\n
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

{classe}		{ return symbol(CodesLexicaux.SYMCLASSE);}
{fin}			{ return symbol(CodesLexicaux.FIN);}
{status}		{ return symbol(CodesLexicaux.STATUS, yytext());}
{type}			{ return symbol(CodesLexicaux.TYPE, yytext());}
{lire}			{ return symbol(CodesLexicaux.SYMLIRE);}
{ecrire}		{ return symbol(CodesLexicaux.SYMECRIRE);}
{egal}			{ return symbol(CodesLexicaux.EGAL);}
{virgule}		{ return symbol(CodesLexicaux.VIRGULE);}
{idf}			{ return symbol(CodesLexicaux.IDF, yytext());}
{csteChaine}	{ return symbol(CodesLexicaux.CSTECHAINE, yytext());}

{commentaire}	{}
. 				{}
\n				{}
