	.data
numero:	.ascii "88888888"
	.text
main:	ldr r4,=numero
	ldr r5,[r4,#0]
	ldr r6,[r4,#4]
	push {r5-r6}
	bl altdec
	pop {r0}
	wfi
altdec:	push {r0-r6}
	cmp r5,r6
	bne no_alt
	mov r3,#4
	ldr r4,=0xFF
iguales:mov r0,r5
	and r0,r4
	mov r1,r0
	mov r0,r5
	lsr r0,#8
	and r0,r4
	mov r2,r0
	cmp r1,r2
	beq no_alt
bucle1:	mov r0,r5
	and r0,r4
	mov r1,r0
	mov r0,r5
	lsr r0,#16
	and r0,r4
	mov r2,r0
	cmp r1,r2
	beq bucle2
	b no_alt
bucle2:	mov r0,r5
	lsr r0,#8
	and r0,r4
	mov r1,r0
	mov r0,r5
	lsr r0,#8
	and r0,r4
	mov r2,r0
	cmp r1,r2
	beq es_alt
no_alt:	mov r0,#0
	b fin
es_alt:	mov r0,#1
fin:	str r0,[sp,#32]
	pop {r0-r6}
	pop {r5}
	mov pc,lr
	