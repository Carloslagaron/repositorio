	.data
cadena:	.asciz "352400"
	.asciz	"222"
	.asciz	"6510"
	.asciz	"71710"
	.asciz	"123"
	.ascii	"."
	
	.text
main:	ldr r0,=cadena
	bl maxmin
	pop {r1,r2}
	wfi
maxmin:	push {r0-r4}
	ldr r1,[r0]
	mov r2,r1
	mov r3,r1
	mov r4,#4
buc:	ldr r1,[r0,r4]
	cmp r1,#'.'
	beq fin
	cmp r1,r2
	bgt mayor
	cmp r1,r3
	blt menor
vuelve:	add r4,#4
	b buc
mayor:	mov r2,r1
	b vuelve
menor: 	mov r3,r1
	b vuelve
fin:	pop {r0,r3-r4}
	