grammar XPath;

/*
 * ==================
 * XQuery
 * ==================
 */

xquery:	xpath EOF;

xpath: absolutePath ('/' | '//') relativePath;

/*
 * ====================
 * Absolute path
 * ====================
 */

absolutePath: 'doc("' Filename '")';

Filename: [a-zA-Z0-9_'.''/']+ '.xml';

/*
 * ====================
 * Relative path
 * ====================
 */

relativePath:
          tagName
        | '*'
        | '.'
        | '..'
        | 'text()'
        | '@' attName
        | '(' relativePath ')'
        | relativePath ('/' | '//') relativePath
        | relativePath '[' pathFilter ']'
        | relativePath ',' relativePath
        ;

tagName: NAME;
attName: NAME;

NAME: [a-zA-Z0-9]+;


/*
 * ====================
 * Path filter
 * ====================
 */

pathFilter:
          relativePath
        | relativePath (ValueEq | IDEq) relativePath
        | '(' pathFilter ')'
        | pathFilter (AND | OR) pathFilter
        | 'not' pathFilter
        ;

ValueEq: '=' | 'eq';
IDEq: '==' | 'is';
AND: 'and';
OR: 'or';