grammar GuajavitaParser;

options {
	tokenVocab = GuajavitaLexer;
}

@header {
package org.guajavita.parser;
}

program:
               	packageClause eos (importDecl eos)* (
               		(defDeclaration | function ) eos
               	)* EOF;


packageClause:
                PACKAGE packageName = IDENTIFIER;

importDecl:
                IMPORT importName = IDENTIFIER;

function:
                types IDENTIFIER funcParams block
                ;
funcParams:
	            L_PAREN types IDENTIFIER (COMMA types IDENTIFIER)* R_PAREN;

types:
                primitives
                | typedefName
                ;

primitives:     'void'
                | 'int'
                | 'double'
                | 'long'
                | 'float'
                | 'byte'
                | 'bool'
                ;

typedefName:
                IDENTIFIER ;

defDeclaration: DEF IDENTIFIER ASSIGN expression;

block:
                L_CURLY statement? R_CURLY;


statement:      RETURN expression? ;

expression:     SEMI
                | DECIMALS
                | DECIMAL_FLOAT_LIT;

eos:
                SEMI
                | EOF
                | EOS
                ;