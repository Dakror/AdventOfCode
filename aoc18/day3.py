import re
from functools import *

#A
with open("day3.txt", "r") as fh:
	_map = {}
	p = re.compile("^#(\d+) @ (\d+),(\d+): (\d+)x(\d+)$")
	for line in fh:
		m = p.match(line)
		if m:
			for x in range(int(m.group(2)), int(m.group(2)) + int(m.group(4))):
				for y in range(int(m.group(3)), int(m.group(3)) + int(m.group(5))):
					k = x*1000+y
					if k in _map:
						_map[k] = _map[k]+1
					else:
						_map[k] = 1

	print("A", reduce(lambda x,y:x+y, map(lambda x:1, filter(lambda x: x > 1, _map.values()))))
	#115348
	
	
#B
with open("day3.txt", "r") as fh:
	_map = {}
	_ids = {}
	p = re.compile("^#(\d+) @ (\d+),(\d+): (\d+)x(\d+)$")
	for line in fh:
		m = p.match(line)
		if m:
			id = int(m.group(1))
			_ids[id] = (int(m.group(2)), int(m.group(3)),  int(m.group(4)), int(m.group(5)))
			for x in range(int(m.group(2)), int(m.group(2)) + int(m.group(4))):
				for y in range(int(m.group(3)), int(m.group(3)) + int(m.group(5))):
					k = x*1000+y
					if k in _map:
						_map[k] = 0
					else:
						_map[k] = id
				
	for id,t in _ids.items():
		all = True
		for x in range(t[0], t[0]+t[2]):
			if not all:
				break
			for y in range(t[1], t[1]+t[3]):

				if _map[x*1000+y] != id:
					all = False
					break
			
		if all:
			print("B", id)
			break
			
	#188