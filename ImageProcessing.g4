grammar ImageProcessing;

program : statement+ ;

statement
	: loadImage
	| saveImage
	| applyFilter
	| transform
	;

// Cargar imagen
loadImage : 'load' STRING 'as' ID ';' ;

// Guardar imagen
saveImage : 'save' ID 'to' STRING ';' ;

// Aplicar filtros
applyFilter : ID '.' 'filter' '(' filterType ')' ';' ;

filterType
	: 'blur'
	| 'sharpen'
	| 'grayscale'
	| 'edgeDetection'
	;

// Transformaciones
transform : ID '.' transformation '(' transformationValue ')' ';' ;

transformation
	: 'rotate'
	| 'resize'
	| 'crop'
	;

transformationValue
	: NUMBER // Para valores de rotación, tamaño, etc.
	;

// Tokens
STRING : '"' .*? '"' ; // Para nombres de archivo
ID : [a-zA-Z]+ ; // Identificadores
NUMBER : [0-9]+ ;
WS : [ \t\r\n]+ -> skip ; // Ignorar espacios en blanco