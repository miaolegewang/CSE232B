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
    | query sl relativePath										#child
    | query dsl relativePath                             		#descendant
    | '<' tag '>' '{' query '}' '</' tag '>'                    #format
    | forClause (letClause)? (whereClause)? returnClause        #flwr
    | letClause query                                           #let
    | query ',' query                                           #pairQuery
    | JOIN '(' query ',' query ',' attrs ',' attrs ')'			#join
    ;

ap: ('doc(' | 'document(') FILENAME ')';
attr: NAME;
attrs: '[' attr (',' attr)* ']';
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

JOIN: J O I N;
NOT: N O T;
AND: A N D;
OR: O R;
TEXTFUNCTION: 'text()';
FNAME: [a-zA-Z0-9_'.''/']+ '.xml';
SLASH: '/';
DSLASH: '//';
CONCAT: ',';
ValueEq: '=' | (E Q);
IDEq: '==' | (I S);
ASTERISK: '*';
DOT: '.';
UPPER: '..';
RETURN: R E T U R N;
FOR: F O R;
IN: I N;
LET: L E T;
ASSIGN: ':=';
WHERE: W H E R E;
SOME: S O M E;
EMPTY: E M P T Y;
SATISFIES: S A T I S F I E S;
FILENAME: '"' [a-zA-Z0-9_]+ '.xml"';
STR: '"' (~'"')* '"';
NAME: [a-zA-Z0-9_]+;
WHITESPACES: [ \n\t\r]+ -> skip;

/*
 * =====================
 * Character
 * =====================
 */
A: 'a' | 'A';
B: 'b' | 'B';
C: 'c' | 'C';
D: 'd' | 'D';
E: 'e' | 'E';
F: 'f' | 'F';
G: 'g' | 'G';
H: 'h' | 'H';
I: 'i' | 'I';
J: 'j' | 'J';
K: 'k' | 'K';
L: 'l' | 'L';
M: 'm' | 'M';
N: 'n' | 'N';
O: 'o' | 'O';
P: 'p' | 'P';
Q: 'q' | 'Q';
R: 'r' | 'R';
S: 's' | 'S';
T: 't' | 'T';
U: 'u' | 'U';
V: 'v' | 'V';
W: 'w' | 'W';
X: 'x' | 'X';
Y: 'y' | 'Y';
Z: 'z' | 'Z';