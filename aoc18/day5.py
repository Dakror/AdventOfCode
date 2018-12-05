# A
with open("day5.txt", "r") as fh:
	l = fh.readline().strip()
	
	index = 0
	any_change = True
	while any_change:
		any_change = False
		d = ''
		for i, c in enumerate(l[index:]):
			if (c.islower() and d == c.upper()) or (d.upper() == c and d.islower()):
				l = l[:i + index - 1] + l[i + index +1:]
				any_change = True
				index = max(0, i + index - 5)
				break
			d = c
	print("A", len(l))
	#11590
	
# B
with open("day5.txt", "r") as fh:
	l = fh.readline().strip()
	
	units = 'qwertzuiopasdfghjklyxcvbnm'
	
	min_length = float('inf')
	
	for f in units:
		stri = l.replace(f,'').replace(f.upper(),'')
		index = 0
		any_change = True
		while any_change:
			any_change = False
			d = ''
			for i, c in enumerate(stri[index:]):
				if (c.islower() and d == c.upper()) or (d.upper() == c and d.islower()):
					stri = stri[:i + index - 1] + stri[i + index +1:]
					any_change = True
					index = max(0, i + index - 5)
					break
				d = c
		if len(stri) < min_length:
			min_length = len(stri)
		
	print("B", min_length)
	#4504
	