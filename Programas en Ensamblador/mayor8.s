.text
main:	ldr r0,=0x95378951

	push {r0}
	bl nmayor8
	pop {r1}
	wfi

nmayor8:
	push {r0-r4}
	ldr r0,[sp,#20]
	ldr r1,=0xF
	mov r2,#8
	mov r4,#0

bucle:	cmp r2,#0
	beq fin
	sub r2,#1
	mov r3,r0
	and r3,r1
	sub r3,#8
	bpl mayor8
vuelve:	lsr r0,#4
	b bucle
mayor8:	add r4,#1
	b vuelve
fin:	str r4,[sp,#20]
	pop {r0-r4}
	mov pc,lr
