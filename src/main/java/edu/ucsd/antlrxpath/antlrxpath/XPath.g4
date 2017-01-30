grammar XPath;

/*
 * ==================
 * XQuery
 * ==================
 *
 */

xquery:	xpath EOF;

xpath: absolutePath slashes relativePath;

slashes: '//' | '/';

absolutePath: 'doc(' filename ')';

/*filename: [a-zA-Z0-9_]+\.xml$;*/