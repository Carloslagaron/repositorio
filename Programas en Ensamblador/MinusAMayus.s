	.data
carA:	.ascii "z"
carB:	.space 1

	.text
main:	ldr r0,=carA
	ldr r1,=carB
	bl mayus
	ldrb r0,[r0]
	ldrb r1,[r1]
	wfi

mayus:	push {r0-r2}
	ldr r1,[r0]
	ldr r2,[r0]
	cmp r1,#'a'
	blt fin
	cmp r1,#'z'
	bgt fin
	sub r1,#32
fin:	mov r0,sp
	str r2,[r0]
	add r0,#4
	str r1,[r0]
	pop {r0-r2}
	mov pc,lr