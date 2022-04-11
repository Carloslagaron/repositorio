	.data
numero:	.word 0x123456AB
cadena:	.space 9
	
	.text
main:	ldr r0,=numero
	ldr r1,[r0]
	ldr r2,=cadena
	push {r1,r2}
	bl bintohex
	pop {r1,r2}
	wfi

bintohex:push {r0-r4}
	mov r2,sp
	ldr r3,=0xF
	mov r4,#0
bucle:	ldr r1,[r0]
	lsl r1,r4
	and r1,r3
	cmp r1,#10
	bge letra
	add r1,#'0'
	b sigue
letra:	add r1,#'A'
sigue:	orr r5,r1
	add r4,#4
	
	
	