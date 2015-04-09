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

idf = <-- à compléter
typePrimitif = <-- à compléter

%%

";"                	{ return symbol(CodesLexicaux.POINTVIRGULE); }

{typePrimitif}		{ return symbol(CodesLexicaux.TYPEPRIMITIF, yytext()); }

{idf}			{ return symbol(CodesLexicaux.IDF, yytext()) ; }

.                       {}
\n                      {}
