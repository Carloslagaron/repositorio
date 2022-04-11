	.data
matriz:	.hword 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16

	.text
main:	ldr r4,=matriz
	sub sp,#32
	mov r5,sp
	mov r6,#30
buc:	ldrh r7,[r4,r6]
	strh r7, [r5, r6]
	cmp r6,#0
	beq csp
	sub r6,#2
	b buc
csp:	bl sumarray4
	pop {r0-r3}
	wfi

sumarray4:push {r0-r7}
	ldr r1,=0xFF	@máscara
	mov r7,#4
	mov r6,#0	@contador total
p0:	mov r2,#0	@contador fila (2)
	mov r3,#0	@suma
p1:	ldr r0,[r5]
	and r0,r1
	add r3,r0
	ldr r0,[r5]
	lsr r0,#16
	and r0,r1
	add r3,r0
	add r2,#1
	cmp r2,#2
	beq nuevo
sube:	add r5,#4
	b p1
	
	
nuevo:	sub r5,r7
	str r3,[r5]
	add r7,#4
	add r5,r7
	add r6,#1
	cmp r6,#4
	beq fin
	b p0
	
fin:	pop {r0-r7}
	mov pc,lr