	.data
cadena:	.asciz "3502570"
	
	.text
main:	ldr r0,=cadena
	bl octobin
	wfi

octobin:push {r0-r4}
	mov r3,#0
buc:	ldrb r2,[r0,r3]
	cmp r2,#0
	beq sigue
	sub r2,#48
	orr r1,r2
	lsl r1,#4
	add r3,#1
	b buc
	mov pc,lr
sigue:	
fin:	pop {r0,r2-r4}
	mov pc,lr