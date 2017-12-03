.data 
.balign 4
	string: .asciz "%d\n"
	string2: .asciz "%d	%d\n"
.text
.extern printf

.global day2_a
day2_a:
	@ r0 short[][] input
	@ r1 y size
	@ r2 x size
	@ r3 sum
	@ r4 pointer
	@ r5 min
	@ r6 max
	@ r7 col counter
	@ r12 temp
	push {r4-r7, lr}	
	mov r3, #0
	mov r4, #0	
	a_loop: 
		subs r1, r1, #1
		blt a_end
		mov r5, #0xffff
		mov r6, #0
		mov r7, #0
		a_inner:
			ldrh r12, [r0, r4]
			cmp r12, r5
			movle r5, r12
			cmp r12, r6
			movge r6, r12
			a_advance:
				add r4, r4, #2
				add r7, r7, #1
				cmp r7, r2
				blt a_inner
				sub r12, r6, r5
				add r3, r3, r12
				b a_loop
	a_end:
		mov r0, r3
		pop {r4-r7, pc}
		
		
.global day2_b
day2_b:
	@ r0 short[][] input
	@ r1 y size
	@ r2 x size
	@ r3 sum
	@ r4 pointer in row
	@ r5 current value
	@ r6 second pointer in row
	@ r7 row start pointer
	@ r8 tmp for calc
	@ r12 temp
	push {r4-r8, lr}
	
	lsl r2, r2, #1
	mov r3, #0
	mov r7, #0
	
	b_loop:
		subs r1, r1, #1
		blt b_end
		mov r4, #0
		b_inner:
			add r8, r7, r4
			ldrh r5, [r0, r8]
			add r6, r4, #2
			b_row_loop:
				add r8, r7, r6
				ldrh r12, [r0, r8]

				cmp r12, r5
				addeq r3, r3, #1
				beq b_loop
				
				push {r0-r3}
				movlt r0, r5
				movlt r1, r12
				movgt r0, r12
				movgt r1, r5
											
				bl __aeabi_uidivmod
				cmp r1, #0
				mov r8, r0
				pop {r0-r3}
				bne b_advance
	
				add r3, r3, r8
				add r7, r7, r2
				b b_loop
				
				b_advance:
					add r6, r6, #2
					cmp r6, r2
					blt b_row_loop

					add r4, r4, #4
					cmp r4, r2
					sub r4, r4, #2
					blt b_inner

					add r7, r7, r2
					b b_loop
			
	b_end:
		mov r0, r3
		pop {r4-r8, pc}
