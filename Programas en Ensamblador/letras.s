	.data
frase:	.ascii "jfgrkdhsirhgfGRD5Gerfdgh"
	
	.text
main:	ldr r4,=frase
	mov r5,#20
buc:	ldr r6,[r4,r5]
	push {r6}
	cmp r5,#0
	beq sube
	sub r5,#4
	b buc
sube:	bl letras
	pop {r0}
	wfi

letras:	push {r0-r3,r7}
	mov r0,sp
	mov r7,#6
	add r0,#40
nuevo:	ldr r1,=0xFF
	mov r2,#0	 
bucle:	ldr r3,[r0]
	lsr r3,r2
	and r3,r1
	cmp r3,#'A'
	bmi mal
	cmp r3,#'Z'
	bgt minus
	b bien
minus:	cmp r3,#'a'
	bmi mal
	cmp r3,#'z'
	bgt mal
bien:	cmp r2,#24
	beq actu
	add r2,#8
	b bucle
actu:	sub r0,#4
	sub r7,#1
	cmp r7,#0
	beq final
	
	b nuevo
mal:	mov r1,#0
	b alm	
final:	mov r1,#1
alm:	str r1,[sp,#40]
	pop {r0-r3,r7}	
	add sp,#20	
	mov pc,lr
