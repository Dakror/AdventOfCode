# A
with open("day2.txt", "r") as fh:
	two = 0
	three = 0
	for line in fh:
		list = [c for c in line.strip()]
		l = set([list.count(i) for i in list])
		if 2 in l:
			two += 1
		if 3 in l:
			three += 1
			
	print("A", two * three)
	# 7192

# B
with open("day2.txt", "r") as fh:
	list = []
	for line in fh:
		l = [c for c in line.strip()]
		list.append([c for c in l])

	for l in list:
		for j in list:
			if l == j:
				continue
			common = [c for ind, c in enumerate(l) if c == j[ind]]
			if len(common) == len(l) - 1:
				print("B", "".join(common))
				quit()
	# mbruvapghxlzycbhmfqjonsie