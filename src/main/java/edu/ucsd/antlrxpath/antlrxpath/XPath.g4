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
          TagName
        | '*'
        | '.'
        | '..'
        | 'text()'
        | '@' AttName
        | '(' relativePath ')'
        | relativePath ('/' | '//') relativePath
        | relativePath '[' pathFilter ']'
        | relativePath ',' relativePath
        ;

TagName: [a-zA-Z0-9]+;
AttName: [a-zA-Z0-9]+;


/*
 * ====================
 * Path filter
 * ====================
 */

pathFilter:
          relativePath
        | relativePath equal relativePath
        | '(' relativePath ')'
        | pathFilter condition pathFilter
        | 'not' pathFilter
        ;

equal: '=' | 'eq' | '==' | 'is';
condition: 'and' | 'or';