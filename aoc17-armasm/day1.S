.global day1_a
day1_a:
	@ r0 char* input
	@ r1 int position
	@ r2 char current_digit
	@ r4 char last_digit
	@ r3 sum
	@ r12 first digit
	push {r4, lr}
	
	mov r1, #1
	mov r2, #0
	mov r3, #0
	
	@ load first digit into r12 for circle check
	ldrb r12, [r0, #0]	
	@ make digit
	sub r12, r12, #48
		
	@ and in last digit
	mov r4, r12
	
	a_loop:
		@ load next char
		ldrb r2, [r0, r1]
		
		@ end on null terminator
		cmp r2, #0
		beq a_end
		
		@ make digit
		sub r2, r2, #48
		
		@ compare with last
		cmp r2, r4
		
		@ add to sum if same
		addeq r3, r3, r2
		
		add r1, r1, #1
		mov r4, r2
		b a_loop
	
	a_end:
		@ circle check
		cmp r4, r12
		addeq r3, r3, r4
		
		@ return
		mov r0, r3
		
		pop {r4, pc}
		
		
.global day1_b
day1_b:
	@ r0 char* input
	@ r1 int length
	@ r2 char a
	@ r3 char b
	@ r4 position
	@ r5 position with offset
	@ r12 sum
	push {r4-r5, lr}
	
	mov r1, #0
	mov r4, #0
	mov r5, #0
	find_length:
		ldrh r12, [r0, r1]
		cmp r12, #0
		beq main
		
		add r1, r1, #2
		b find_length
	main: 
		@ find mid offset
		lsr r1, r1, #1
		
		mov r12, #0
		add r5, r4, r1
		
		b_loop: 
			cmp r4, r1
			beq b_end
		
			ldrb r2, [r0, r4]
			sub r2, r2, #48
			ldrb r3, [r0, r5]
			sub r3, r3, #48
			
			cmp r2, r3
			addeq r12, r12, r2, lsl #1

			add r4, r4, #1
			add r5, r5, #1
			
			b b_loop

		b_end:
			@ return
			mov r0, r12
			pop {r4-r5, pc}