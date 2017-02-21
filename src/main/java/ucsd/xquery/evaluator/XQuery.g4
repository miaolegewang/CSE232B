grammar XQuery;

/*
 * ==================
 *  Query
 * ==================
 */

query: xquery EOF;


/*
 * ==================
 *  XQuery
 * ==================
 */

xquery:
      var                             #variable
    | xquery ',' xquery               #pairXQ
    | lt '{' xquery '}' rt            #formatted
    | xquery slash tag                #descendant
    | xquery slash node               #leaf
    | forwherereturn                  #fwr
    | 'doc("' filename '")'           #root
    ;

cond:
      xquery eq xquery                #join
    | xquery eq const                 #filter
    | 'empty(' xquery ')'             #empty
    | cond AND cond                   #andCond
    | cond OR cond                    #orCond
    | NOT cond                        #negate
    ;

const:
      string                          #stringLiteral
    | integer                         #integerLiteral
    ;


/*
 * =================
 *  FWR clause
 * =================
 */

forwherereturn: forClause whereClause returnClause;
forClause: 'for' bindings;
whereClause: 'where' cond;
returnClause: 'return' xquery;
bindings: bind [',' bind]*;
bind: var 'in' xquery;


/*
 * ====================
 *  pattern definition
 * ====================
 */
var: VARIABLE;
eq: 'eq' | '=';
lt: '<' TAG '>';
rt: '</' TAG '>';
slash: SLASH;
string: '"' STR '"';
integer: INT;
filename: [a-zA-Z_0-9] '.xml';
node: text;

text: 'text()';

/*
 * ===================
 *  Constant
 * ===================
 */
TAG: [a-zA-Z]+;
VARIABLE: '$' [a-zA-Z]+;
SLASH: '/';
STR: [a-zA-Z0-9\s'"''\']+;
INT: [0-9]+;
AND: 'and';
OR: 'or';
NOT: 'not';

/*
 * ==================
 *  WhiteSpace skip
 * ==================
 */
Whitespaces: (\r | \n | \t | ' ') -> skip;
