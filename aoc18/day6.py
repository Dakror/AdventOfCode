import png 
import operator

# A
with open("day6.txt", "r") as fh:
	points = [(int(i[0]),int(i[1])) for i in [line.strip().split(', ') for line in fh]]
	
	x1 = min(points, key=lambda t: t[0])[0]
	y1 = min(points, key=lambda t: t[1])[1]
	x2 = max(points, key=lambda t: t[0])[0]
	y2 = max(points, key=lambda t: t[1])[1]
	
	possible_points = [p for p in points if p[0] > x1 and p[0] < x2 and p[1] > y1 and p[1] < y2]
	
	x1 -= 100
	y1 -= 100
	x2 += 100
	y2 += 100
	
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

		
		'''
		for y in range(0, h):
			s = ''
			for x in range(0, w):
				g = grid[x*h+y]
				
				el = (x+x1,y+y1)
				
				if el in points:
					s+=abc[points.index(el)]
				elif g[0] == -1 and g[1] == inf:
					s+='-'
				elif g[0] == -1:
					s+='.'
				else:
					s+=abc[g[0]]
			print(s)
		'''
		
		col = 150 / len(points)
		img = []
		img.append([0]*w)
		
		valid_scores = {i:e for i,e in scores.items() if points[i] in possible_points}
		m = max(valid_scores.items(), key=operator.itemgetter(1))[0]
		
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
				elif g[0] == m:
					s.append(240)
				else:
					s.append(int(80 + col * g[0]))
			img.append(s)
					
		with open('day6/img_'+("%03d" % radius)+'.png', 'wb') as f:
			wr = png.Writer(w, h+1, greyscale=True)
			wr.write(f, img)
		
		

valid_scores = {i:e for i,e in scores.items() if points[i] in possible_points}
m = max(valid_scores.items(), key=operator.itemgetter(1))[0]
print("A", valid_scores[m])

# 641 too low
# 3998 too high