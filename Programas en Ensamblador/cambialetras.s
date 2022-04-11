	.data
frase:	.ascii "Piensa antes de hablar!!"

	.text
main:	ldr r4,=frase
	mov r5,#20
buc:	ldr r6,[r4,r5]
	push {r6}
	cmp r5,#0
	beq sube
	sub r5,#4
	b buc
sube:	bl cambia
	pop {r0-r5}
	wfi

cambia:	push {r0-r7}
	mov r0,sp
	add r0,#32
	mov r2,#0
	ldr r3,=0xFF
	mov r5,#0
	mov r6,#0
bucle:	ldr r1,[r0]
	lsr r1,r6
	and r1,r3
	cmp r1,#' '
	beq sigue
	cmp r1,#'A'
	blt sigue
	cmp r1,#'Z'
	bgt minus
	add r1,#32
	b sigue
minus:	cmp r1,#'a'
	blt sigue
	cmp r1,#'z'
	bgt sigue
	sub r1,#32
sigue:	add r2,#1
	lsl r1,r6
	add r6,#8
	orr r7,r1
	cmp r2,#4
	beq nuevo
	b bucle
nuevo:	mov r2,#0
	add r5,#1
	mov r6,#0
	str r7,[r0]
	mov r7,#0
	add r0,#4
	cmp r5,#6
	beq fin
	b bucle
fin:	pop {r0-r7}
	mov pc,lr