import re
import time
from datetime import datetime
import operator

#A and B
with open("day4.txt", "r") as fh:
	lines = [line.strip() for line in fh]
	lines.sort()
	
	p = re.compile("^\[(\d{4})-(\d{2})-(\d{2}) (\d{2}):(\d{2})\] (.+)$");
	q = re.compile("^Guard #(\d+) begins shift$");
	
	times = {}
	
	minutes = {}
	
	time = 0
	fell_asleep_at = 0
	guard = 0
	sleeping = False
	for l in lines:
		m = p.match(l);
		if m:
			dt = datetime(int(m.group(1))+500, int(m.group(2)), int(m.group(3)), int(m.group(4)), int(m.group(5)))
			now = int(dt.timestamp() / 60)
			if m.group(6).startswith("Guard"):
				m1 = q.match(m.group(6))
				guard = m1.group(1)
				if guard not in times:
					times[guard] = 0
					minutes[guard] = {}
			elif m.group(6).startswith("wake"):
				for i in range(fell_asleep_at, now):
					if i%60 in minutes[guard]:
						minutes[guard][i%60] += 1
					else:
						minutes[guard][i%60] = 1
				times[guard] += now - fell_asleep_at
				sleeping = False
			elif m.group(6).startswith("fall"):
				fell_asleep_at = now
				sleeping = True
			time = now

	gu = max(times.items(), key=operator.itemgetter(1))[0]		
	mi = max(minutes[gu].items(), key=operator.itemgetter(1))[0]
	print("A", gu, mi, int(gu)*int(mi))
	# 3212
	
	mv = 0
	mvv = 0
	gv = 0
	for gi in minutes:
		if len(minutes[gi]) == 0:
			continue
		mm = max(minutes[gi].items(), key=operator.itemgetter(1))[0]
		mmv = minutes[gi][mm]
		if mmv > mvv:
			mv = mm
			mvv = mmv
			gv = gi
	
	print("B", gv, mv, int(gv)*int(mv))
	# 4966