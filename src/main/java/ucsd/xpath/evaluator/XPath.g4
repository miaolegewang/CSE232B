grammar XPath;

/*
 * ==================
 * XQuery
 * ==================
 */

xquery:	xpath EOF;

xpath: absolutePath (descendant | descendantOrSelf) relativePath;
descendant: SLASH;
descendantOrSelf: DSLASH;


/*
 * ====================
 * Absolute path
 * ====================
 */

absolutePath: 'doc("' filename '")';

filename: FNAME;

/*
 * ====================
 * Relative path
 * ====================
 */

relativePath:
          NAME  		#tagName
        | ASTERISK  	#all
        | DOT			#self
        | UPPER			#parent
        | TEXTFUNCTION	#text			
        | '@' attName	#attTest
        | '(' relativePath ')'	#firstPath
        | relativePath (descendant | descendantOrSelf) relativePath  #descendantPath
        | relativePath '[' pathFilter ']'	#pathWithFilter
        | relativePath ',' relativePath 	#pathSequence
        ;

attName: NAME;

/*
attTest: '@' attName;
tagName: NAME;
all: ASTERISK;
self: DOT;
attName: NAME;
parent: UPPER;
text: TEXTFUNCTION;
concatPath: ',' relativePath;
*/

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
NAME: [a-zA-Z0-9]+;