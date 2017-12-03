.data 
.balign 4
	string: .asciz "%d\n"
	string2: .asciz "%d	%d\n"
.text
.extern printf

.global day3_a
day3_a:
	@ r0 the number
	@ r1 x
	@ r2 y 
	@ r3 num
	@ r4 radius
	push {r4, lr}
	mov r1, #0
	mov r2, #0
	mov r3, #1
	mov r4, #1
	mov r5, #0
	
	cmp r2, r0
	beq a_end
	
	a_loop:
		@ to the right
		add r1, r1, #1
		add r3, r3, #1
		cmp r3, r0
		beq a_end
		
		@ move all the way up
		add r2, r2, r4, lsl #1
		sub r2, r2, #1
		add r3, r3, r4, lsl #1
		sub r3, r3, #1
		cmp r0, r3
		beq a_end
		bgt go_left

		@ step a bit back and return
		sub r12, r3, r0
		add r2, r2, r12
		b a_end
				
		go_left:
			sub r1, r1, r4, lsl #1
			add r3, r3, r4, lsl #1
			cmp r0, r3
			beq a_end
			bgt go_down
			
			@ step a bit back and return
			sub r12, r3, r0
			add r1, r1, r12
			b a_end
			
		go_down: 
			sub r2, r2, r4, lsl #1
			add r3, r3, r4, lsl #1
			cmp r0, r3
			beq a_end
			bgt go_right
					
			@ step a bit back and return
			sub r12, r3, r0
			add r2, r2, r12
			b a_end
			
		go_right:
			add r1, r1, r4, lsl #1
			add r3, r3, r4, lsl #1
			cmp r0, r3
			beq a_end
			
			addgt r4, r4, #1
			bgt a_loop
			
			@ step a bit back and return
			sub r12, r3, r0
			sub r1, r1, r12
			b a_end
	a_end:
		push {r0-r3,r12}
		ldr r0, =string2
		mov r1, r1
		mov r2, r2
		bl printf
		pop {r0-r3,r12}

				mov r0, #0
		cmp r1, #0
		sublt r0, r0, r1
		addgt r0, r0, r1
		cmp r2, #0
		sublt r0, r0, r2
		addgt r0, r0, r2
		pop {r4, pc}
	