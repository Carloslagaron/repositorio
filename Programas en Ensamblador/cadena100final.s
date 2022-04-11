	.text
main:	ldr r0,=0x12345100
	push {r0}
	bl cien
	pop {r1}
	wfi

cien:	push {r0-r3}
	ldr r0,[sp,#16]
	ldr r1,=0xFFF
	and r1,r0
	ldr r2,=0x100
	cmp r1,r2
	beq lo_es
	mov r0,#0
	str r0,[sp,#16]
	pop {r0-r3}
	mov pc,lr
lo_es:	mov r0,#1
	str r0,[sp,#16]
	pop {r0-r3}
	mov pc, lr
	