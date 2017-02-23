grammar XQuery;

/*
 * ==================
 * XQuery
 * ==================
 */

xquery:	query EOF;

query:
      var                                                       #variable
    | xpath						                                #absolutePath
    | stringConst                                               #string
    | '(' query ')'                                             #priority
    | query ',' query                                           #pairQuery
    | query sl relativePath										#child
    | query dsl relativePath                             		#descendant
    | '<' tag '>' '{' query '}' '</' tag '>'                    #format
    | forClause (letClause)? (whereClause)? returnClause        #flwr
    | letClause query                                           #let
    ;

ap: ('doc(' | 'document(') FILENAME ')';
stringConst: STR;

var: '$' varName ;
varName: NAME;
tag: NAME;

/*
 * ==================
 * forClause
 * ==================
 */

forClause: FOR bindings;

/*
 * ==================
 * letClause
 * ==================
 */

letClause: LET assignments;

assignments: ass (',' ass)*;
ass: var ASSIGN query;

/*
 * ==================
 * whereClause
 * ==================
 */

whereClause: WHERE cond;

/*
 * ==================
 * retrunClause
 * ==================
 */

returnClause: RETURN query;

/*
 * ==================
 * cond
 * ==================
 */

cond:
      query ValueEq query                   #queryValueEq
    | query IDEq query                      #queryIDEq
    | EMPTY '(' query ')'                   #emptyQuery
    | SOME bindings SATISFIES cond          #someClause
    | '(' cond ')'                          #priorityCond
    | cond AND cond                         #andCond
    | cond OR cond                          #orCond
    | NOT cond                              #notCond
    ;

bindings: bind (',' bind)*;
bind: var IN query;

/*
 * ====================
 * Relative path
 * ====================
 */

sl: SLASH;
dsl: DSLASH;

xpath: ap (sl | dsl) relativePath;

relativePath:
          NAME  		#tagName
        | ASTERISK  	#all
        | DOT			#self
        | UPPER			#parent
        | TEXTFUNCTION	#text
        | '@' attName	#attTest
        | '(' relativePath ')'	#firstPath
        | relativePath (sl | dsl) relativePath  #descendantPath
        | relativePath '[' pathFilter ']'	#pathWithFilter
        | relativePath ',' relativePath 	#pathSequence
        ;

attName: NAME;


/*
 * =====================
 * Path filter
 * =====================
 */

pathFilter:
          relativePath							#descendantExistence
        | relativePath ValueEq relativePath		#pathValueEq
        | relativePath IDEq relativePath		#pathIdEq
        | '(' pathFilter ')'					#firstFunc
        | pathFilter OR pathFilter				#orFilter
        | pathFilter AND pathFilter				#andFilter
        | NOT pathFilter						#negatvePathFilter
        ;

/*
 * =====================
 * Constant and String
 * =====================
 */

NOT: 'not';
AND: 'and';
OR: 'or';
TEXTFUNCTION: 'text()';
FNAME: [a-zA-Z0-9_'.''/']+ '.xml';
SLASH: '/';
DSLASH: '//';
CONCAT: ',';
ValueEq: '=' | 'eq';
IDEq: '==' | 'is';
ASTERISK: '*';
DOT: '.';
UPPER: '..';
RETURN: 'return';
FOR: 'for';
IN: 'in';
LET: 'let';
ASSIGN: ':=';
WHERE: 'where';
SOME: 'some';
EMPTY: 'empty';
SATISFIES: 'satisfies';
FILENAME: '"' [a-zA-Z0-9_]+ '.xml"';
STR: '"' (~'"')* '"';
NAME: [a-zA-Z0-9_]+;
WHITESPACES: [ \n\t\r]+ -> skip;
