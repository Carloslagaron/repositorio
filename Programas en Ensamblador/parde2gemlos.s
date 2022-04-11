	.data
CADENA:	.asciz	"hOlA mUndo CRUEL: vaya PAR de2gEMELOS"
	.balign 4

CONV:	.space 1

	.text
	ldr r0,=CADENA
	ldr r5,=CONV
	mov r1,#0
	ldrb r2,[r0,r1]
	add r2,#32
	add r1,#1
	b otro
bucle:	ldrb r2,[r0,r1]
sigue:	cmp r2,#' '
	beq espacio
	cmp r2,#'A'
	blt otro
	cmp r2,#'Z'
	bgt otro
	add r2,#32
	b otro
espacio:add r1,#1
	ldrb r2,[r0,r1]
	sub r2,#32
otro:	add r1,#1
	
	lsl r7,#8
	b bucle
	