	.data
num:	.word 0x11111141
res:	.space

.text
main:	ldr r0,=num
	ldr r1,=res
	bl  iguales
	ldr r0,[r0]
	ldr r1,[r1]
	wfi

iguales:push {r2-r5}
	ldr r2,=0xF
	ldr r4,[r0]
	and r4,r2
	mov r3,r4
	ldr r4,[r0]
	lsr r4,#28
	cmp r4,r3
	beq correcto
	mov r5,#0
	b fin
correcto:mov r5,#1
fin:	str r5,[r1]
	pop {r2-r5}
	mov pc,lr		