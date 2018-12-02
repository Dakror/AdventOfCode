# A
with open("day1.txt", "r") as fh:
	print("A", reduce(lambda x,y:x+y, [int(i) for i in fh]))
	# 556
	
# B
with open("day1.txt", "r") as fh:
	sum = 0
	list = set([])
	lines = []
	for line in fh:
		lines.append(line)
		
	found = False
	while not found:
		for line in lines:
			sum+= int(line)
			if sum in list:
				print("B", sum)
				found = True
				break
			list.add(sum)
	#448
