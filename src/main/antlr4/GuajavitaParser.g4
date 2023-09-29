grammar GuajavitaParser;

options {
	tokenVocab = GuajavitaLexer;
}

@header {
package org.guajavita.parser;
}

program:
               	packageClause eos (importDecl eos)* (
               		(function ) eos
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


block:
                L_CURLY statement? R_CURLY;


statement:      RETURN expression? ;

expression:     SEMI;

eos:
                SEMI
                | EOF
                | EOS
                ;