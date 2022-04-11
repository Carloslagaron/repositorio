	.data
NUM:	.word 0xABABABAB

NZERO:	.space 4

	.text
	ldr r0,=NUM
	ldr r1,[r0]
	mov r2,#0b1
	mov r3,#0
	mov r4,#0
buc:	cmp r3,#32
	beq fin
	mov r5,r1
	and r5,r2
	cmp r5,#1
	beq sig
	add r4,#1
sig:	lsr r1,#1
	add r3,#1
	b buc
fin:	ldr r7,=NZERO
	str r4,[r7]
	wfi
	.end
	 