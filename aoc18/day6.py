import png 
import operator
from functools import *
# A	
def a():	
	def draw_image():
		col = 150 / len(points)
		img = []
		img.append([0]*w)

		for y in range(0, h):
			s = []
			for x in range(0, w):
				g = grid[x*h+y]
				
				el = (x+x1,y+y1)
				
				if el in points:
					s.append(255)
				elif g[0] == -1 and g[1] == inf:
					s.append(0)
				elif g[0] == -1:
					s.append(50)
				else:
					s.append(int(80 + col * g[0]))
			img.append(s)
					
		with open('day6/img_'+("%03d" % (radius+1))+'.png', 'wb') as f:
			wr = png.Writer(w, h+1, greyscale=True)
			wr.write(f, img)

	with open("day6.txt", "r") as fh:
		points = [(int(i[0]),int(i[1])) for i in [line.strip().split(', ') for line in fh]]
		
		x1 = min(points, key=lambda t: t[0])[0]
		y1 = min(points, key=lambda t: t[1])[1]
		x2 = max(points, key=lambda t: t[0])[0]
		y2 = max(points, key=lambda t: t[1])[1]
		
		abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
		
		w = x2-x1 + 1
		h = y2-y1 + 1
		
		inf = float('inf')
		
		grid = [(-1,inf)]*(w*h)
		
		scores = {}
		
		change = True
		
		radius = 0
		
		while change:
			change = False
			radius += 1
			
			for i,p in enumerate(points):
				if radius == 1:
					change = True
					grid[(p[0] - x1)*h + (p[1] - y1)] = (i, 0)
					scores[i] = 1
					
				for x in range(-radius, radius+1):
					for y in range(-radius, radius+1):
						if abs(x) < radius and abs(y) < radius:
							continue
						_x = p[0] - x1 + x
						_y = p[1] - y1 + y
						
						if _x >= 0 and _x < w and _y >= 0 and _y < h:
							ind = _x * h + _y
							md = abs(x)+abs(y)
							g = grid[ind]
							if g[0] == -1 and g[1] == inf:
								grid[ind] = (i, md)
								scores[i]+=1
								change = True
							elif g[1] > md:
								if g[0] > -1:
									scores[g[0]]-=1
						
								grid[ind] = (i, md)
								scores[i]+=1
								change = True
							elif g[0] != i and g[1] == md:
								if g[0] > -1:
									scores[g[0]]-=1
								grid[ind] = (-1, md)
								change = True

			#draw_image()
			
		infinites = set([])
			
		for y in range(0, h):
			g = grid[y]
			if g[0] != -1:
				infinites.add(g[0])
				grid = [(a,b) if a != g[0] else (-1,b) for a,b in grid]
			g = grid[(w-1)*h+y]
			if g[0] != -1:
				infinites.add(g[0])
				grid = [(a,b) if a != g[0] else (-1,b) for a,b in grid]		
		for x in range(0, w):
			g = grid[x*h]
			if g[0] != -1:
				infinites.add(g[0])
				grid = [(a,b) if a != g[0] else (-1,b) for a,b in grid]
			g = grid[x*h+h-1]
			if g[0] != -1:
				infinites.add(g[0])
				grid = [(a,b) if a != g[0] else (-1,b) for a,b in grid]
				

		#draw_image()
			
	valid_scores = {i:e for i,e in scores.items() if i not in infinites}
	m = max(valid_scores.items(), key=operator.itemgetter(1))[0]
	print("A", abc[m], valid_scores[m])
	#3420

	
#B
def b():
	with open("day6.txt", "r") as fh:
		points = [(int(i[0]),int(i[1])) for i in [line.strip().split(', ') for line in fh]]
		
		middle_x = int(reduce((lambda x,y: x+y), map((lambda x: x[0]), points)) / len(points))
		middle_y = int(reduce((lambda x,y: x+y), map((lambda x: x[1]), points)) / len(points))
		
		
		dist = reduce((lambda a,b:a+b), map((lambda a: abs(a[0]-middle_x) + abs(a[1]-middle_y)), points))
		
		print("middle", dist)
		
		change = True
		radius = 0
		
		count = 0
		
		if dist < 10000:
			count+=1
		
		while change:
			change = False
			radius+=1
		
			for x in range(-radius, radius+1):
				for y in range(-radius, radius+1):
					if abs(x) < radius and abs(y) < radius:
						continue
					_x = x + middle_x
					_y = y + middle_y
					
					dist = reduce((lambda a,b:a+b), map((lambda a: abs(a[0]-_x) + abs(a[1]-_y)), points))
					if dist < 10000:
						change = True
						count+=1
						
		print("B", count)
		#4667

a()		
b()		
		
		
		
		
		
		
		
		
		