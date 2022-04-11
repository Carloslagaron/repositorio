	.data
nums:	.word 160,-16
res:	.space 4

	.text
main:	ldr r0,=nums
	add r1,r0,#4
	ldr r2,=res
	bl nmult8
	ldr r0,[r0]
	ldr r1,[r1]
	ldr r2,[r2]
	wfi

nmult8:	push {r0-r4}
	ldr r0,[r0]
	ldr r1,[r1]
	mov r2,#0b111
	mov r3,#0
	and r0,r2
	cmp r0,#0
	bne sigue
	add r4,#1
sigue:	and r1,r2
	cmp r0,#0
	bne fin
	add r4,#1
fin:	mov r2,sp
	add r2,#8
	str r4,[r2]
	pop {r0-r4}
	mov pc,lr
	