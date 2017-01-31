grammar XPath;

/*
 * ==================
 * XQuery
 * ==================
 */

xquery:	xpath EOF;

xpath: absolutePath (selfNode | descendantOrSelf) relativePath;
selfNode: SLASH;
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
          tagName
        | all
        | self
        | parent
        | text
        | attTest
        | '(' relativePath ')'
        | relativePath (selfNode | descendantOrSelf) relativePath
        | relativePath '[' pathFilter ']'
        | relativePath concatPath
        ;

attTest: '@' attName;
tagName: NAME;
all: ASTERISK;
self: DOT;
attName: NAME;
parent: UPPER;
text: TEXTFUNCTION;
concatPath: ',' relativePath;


/*
 * =====================
 * Path filter
 * =====================
 */

pathFilter:
          relativePath
        | relativePath (ValueEq | IDEq) relativePath
        | '(' pathFilter ')'
        | nagatePathFilter
        | pathFilter (AND | OR) pathFilter
        ;
        
nagatePathFilter: NOT pathFilter;

/*
 * =====================
 * Constant and String
 * =====================
 */
 
FNAME: [a-zA-Z0-9_'.''/']+ '.xml';
SLASH: '/';
DSLASH: '//';
CONCAT: ',';
ValueEq: '=' | 'eq';
IDEq: '==' | 'is';
AND: 'and';
OR: 'or';
ASTERISK: '*';
DOT: '.';
UPPER: '..';
NAME: [a-zA-Z0-9]+;
TEXTFUNCTION: 'text()';
NOT: 'not';