	.data
num1:	.word 0x11111141
num2:	.word 0x11111151
res:	.space 4

	.text
main:	ldr r0,=num1
	ldr r1,=num2
	ldr r2,=res
	bl igualdec
	ldr r0,[r0]
	ldr r1,[r1]
	ldr r2,[r2]
	wfi

igualdec:push {r0-r4}
	ldr r0,[r0]
	ldr r1,[r1]
	ldr r2,=0xF0
	mov r4,sp
	add r4,#8
	and r0,r2
	and r1,r2
	cmp r0,r1
	beq bien
	ldr r3,=-1
	b fin
bien:	mov r3,#1
fin:	str r3,[r4]
	pop {r0-r4}
	mov pc,lr