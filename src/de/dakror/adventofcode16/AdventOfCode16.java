/*******************************************************************************
 * Copyright 2016 Maximilian Stark | Dakror <mail@dakror.de>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package de.dakror.adventofcode16;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Maximilian Stark | Dakror
 *
 */
public class AdventOfCode16 {
	static String path = "src\\de\\dakror\\adventofcode16\\";
	
	public static void main(String[] args) throws Exception {
		Day25_a();
	}
	
	/////////////////////////////////////////////
	
	public static void Day() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day.txt")));
		String line = "";
		
		while ((line = br.readLine()) != null) {
			
		}
		
		br.close();
	}
	
	/////////////////////////////////////////////
	
	public static void Day25_a() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day25.txt")));
		String line = "";
		
		long a = 0, b = 0, c = 0, d = 0;
		
		ArrayList<String> code = new ArrayList<>();
		while ((line = br.readLine()) != null) {
			code.add(line);
		}
		
		
		br.close();
		
		String output = "";
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("data.txt")));
		
		for (int ind = 0;; ind++) {
			if (output.equals("010101010101")) {
				System.out.println(ind);
				return;
			} else if (output.length() > 0/* && ind % 50 == 0*/) {
				//				int inv = ~Integer.parseInt(output, 2) & 0x1FFF;
				//				String s1 = Integer.toBinaryString(inv);
				//				while (s1.length() < 12)
				//					s1 = "0" + s1;
				//				bw.write(Integer.parseInt(output, 2) + "\n");
				//				bw.flush();
				
				System.out.println(ind + ":	" + output + ":	" + Integer.parseInt(output, 2) + ":	" + Integer.parseInt(new StringBuilder(output).reverse().toString(), 2));
				//				System.out.println(/*ind + ":		" + output + ":	" +/ Integer.parseInt(output, 2)/* + ",	" + inv + "	" + s1/);
			}
			int i = 0;
			a = ind;
			output = "";
			
			Thread.sleep(50);
			
			
			// i noticed the pattern, the output is the reversed binary representation of the number 2541 + ind
			// needed is 010101010101, so reversed 101010101010 = 2730. 2730 - 2541 = 189,
			// answer was 189, rank 799
			
			
			loop: while (i < code.size()) {
				//			Thread.sleep(1000);
				//			
				//			for (int j = 0; j < code.size(); j++) {
				//				String s = (i == j ? "> " : "  ") + code.get(j);
				//				if (i == j) {
				//					while (s.length() < 30)
				//						s += " ";
				//				}
				//				System.out.println(s + (i == j ? "a: " + a + "	b: " + b + "	c: " + c + "	d: " + d : ""));
				//			}
				//			
				//			System.out.println();
				
				String[] parts = code.get(i).split(" ");
				switch (parts[0]) {
					case "break": {
						throw new RuntimeException();
					}
					case "cpy": {
						long val = 0;
						switch (parts[1]) {
							case "a":
								val = a;
								break;
							case "b":
								val = b;
								break;
							case "c":
								val = c;
								break;
							case "d":
								val = d;
								break;
							default:
								val = Integer.parseInt(parts[1]);
						}
						switch (parts[2]) {
							case "a":
								a = val;
								break;
							case "b":
								b = val;
								break;
							case "c":
								c = val;
								break;
							case "d":
								d = val;
								break;
						}
						i++;
						break;
					}
					case "mov": {
						long val = 0;
						switch (parts[1]) {
							case "a":
								val = a;
								a = 0;
								break;
							case "b":
								val = b;
								b = 0;
								break;
							case "c":
								val = c;
								c = 0;
								break;
							case "d":
								val = d;
								d = 0;
								break;
							default:
								val = Integer.parseInt(parts[1]);
								
						}
						switch (parts[2]) {
							case "a":
								a += val;
								break;
							case "b":
								b += val;
								break;
							case "c":
								c += val;
								break;
							case "d":
								d += val;
								break;
						}
						i++;
						break;
					}
					case "inc": {
						if (parts.length != 2) {
							i++;
							break;
						}
						switch (parts[1]) {
							case "a":
								a++;
								break;
							case "b":
								b++;
								break;
							case "c":
								c++;
								break;
							case "d":
								d++;
								break;
						}
						i++;
						break;
					}
					case "dec": {
						switch (parts[1]) {
							case "a":
								a--;
								break;
							case "b":
								b--;
								break;
							case "c":
								c--;
								break;
							case "d":
								d--;
								break;
						}
						i++;
						break;
					}
					case "jnz": {
						long val = 0;
						switch (parts[1]) {
							case "a":
								val = a;
								break;
							case "b":
								val = b;
								break;
							case "c":
								val = c;
								break;
							case "d":
								val = d;
								break;
							default:
								val = Integer.parseInt(parts[1]);
						}
						
						if (val != 0) {
							long steps = 0;
							switch (parts[2]) {
								case "a":
									steps = a;
									break;
								case "b":
									steps = b;
									break;
								case "c":
									steps = c;
									break;
								case "d":
									steps = d;
									break;
								default:
									steps = Integer.parseInt(parts[2]);
							}
							i += steps;
						} else {
							i++;
						}
						break;
					}
					case "out":
						long val = 0;
						switch (parts[1]) {
							case "a":
								val = a;
								break;
							case "b":
								val = b;
								break;
							case "c":
								val = c;
								break;
							case "d":
								val = d;
								break;
							default:
								val = Integer.parseInt(parts[1]);
						}
						output += val;
						if (output.length() >= 12) break loop;
						//					System.out.print(val);
						i++;
						break;
					default:
						i++;
				}
			}
		}
	}
	
	static class Day24_State {
		ArrayList<Point> targets;
		
		int x, y, num;
		
		Day24_State prev;
		
		public Day24_State(int x, int y, Day24_State prev) {
			this.x = x;
			this.y = y;
			this.prev = prev;
			if (prev != null) {
				num = prev.num + 1;
				targets = new ArrayList<>();
				for (Point p : prev.targets) {
					if (p.x != x || p.y != y) targets.add(p);
				}
			}
		}
		
		@Override
		public String toString() {
			return x + ":" + y + ":" + targets.toString();
		}
	}
	
	public static void Day24_ab() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day24.txt")));
		String line = "";
		
		ArrayList<Point> targets = new ArrayList<>();
		// y x
		boolean[][] map = new boolean[39][185];
		
		Point start = null;
		
		int ind = 0;
		while ((line = br.readLine()) != null) {
			for (int i = 0; i < 185; i++) {
				char c = line.charAt(i);
				if (c != '#') {
					map[ind][i] = true;
					if (c == '0') start = new Point(i, ind);
					else if (c != '.') targets.add(new Point(i, ind));
				}
			}
			ind++;
		}
		br.close();
		
		LinkedList<Day24_State> queue = new LinkedList<>();
		HashSet<String> visited = new HashSet<>();
		
		Day24_State st = new Day24_State(start.x, start.y, null);
		st.targets = targets;
		queue.add(st);
		visited.add(st.toString());
		
		while (queue.size() > 0) {
			Day24_State s = queue.pop();
			
			if (s.targets.size() == 0 && s.x == start.x && s.y == start.y /* b */) {
				System.out.println("a) " + s.num + " steps");
				// a) answer was 448, rank 338
				// b) answer was 672, rank 327
				break;
			}
			
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if (i * i + j * j != 1) continue;
					
					int x = s.x + i;
					int y = s.y + j;
					if (x < 0 || y < 0 || x >= 185 || y >= 39) continue;
					if (!map[y][x]) continue;
					
					Day24_State q = new Day24_State(x, y, s);
					if (!visited.contains(q.toString())) {
						queue.add(q);
						visited.add(q.toString());
					}
				}
			}
		}
	}
	
	public static void Day23_ab() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day23.txt")));
		String line = "";
		
		long a = 12, b = 0, c = 0, d = 0;
		
		ArrayList<String> code = new ArrayList<>();
		while ((line = br.readLine()) != null) {
			code.add(line);
		}
		
		br.close();
		int i = 0;
		
		while (i < code.size()) {
			//			Thread.sleep(100);
			//			System.out.println("a: " + a + "	b: " + b + "	c: " + c + "	d: " + d);
			//			
			//			for (int j = 0; j < code.size(); j++) {
			//				System.out.println((i == j ? "> " : "  ") + code.get(j));
			//			}
			//			
			//			System.out.println();
			
			
			String[] parts = code.get(i).split(" ");
			sw: switch (parts[0]) {
				case "cpy": {
					if (parts.length != 3) {
						i++;
						break;
					}
					long val = 0;
					switch (parts[1]) {
						case "a":
							val = a;
							break;
						case "b":
							val = b;
							break;
						case "c":
							val = c;
							break;
						case "d":
							val = d;
							break;
						default:
							val = Integer.parseInt(parts[1]);
					}
					switch (parts[2]) {
						case "a":
							a = val;
							break;
						case "b":
							b = val;
							break;
						case "c":
							c = val;
							break;
						case "d":
							d = val;
							break;
					}
					i++;
					break;
				}
				case "inc": {
					if (parts.length != 2) {
						i++;
						break;
					}
					switch (parts[1]) {
						case "a":
							a++;
							break;
						case "b":
							b++;
							break;
						case "c":
							c++;
							break;
						case "d":
							d++;
							break;
					}
					i++;
					break;
				}
				case "dec": {
					if (parts.length != 2) {
						i++;
						break;
					}
					
					switch (parts[1]) {
						case "a":
							a--;
							break;
						case "b":
							b--;
							break;
						case "c":
							c--;
							break;
						case "d":
							d--;
							break;
					}
					i++;
					break;
				}
				case "jnz": {
					if (parts.length != 3) {
						i++;
						break;
					}
					
					long val = 0;
					switch (parts[1]) {
						case "a":
							val = a;
							break;
						case "b":
							val = b;
							break;
						case "c":
							val = c;
							break;
						case "d":
							val = d;
							break;
						default:
							val = Integer.parseInt(parts[1]);
					}
					
					if (val != 0) {
						long steps = 0;
						switch (parts[2]) {
							case "a":
								steps = a;
								break;
							case "b":
								steps = b;
								break;
							case "c":
								steps = c;
								break;
							case "d":
								steps = d;
								break;
							default:
								steps = Integer.parseInt(parts[2]);
						}
						i += steps;
					} else {
						i++;
					}
					break;
				}
				case "tgl": {
					long val = 0;
					switch (parts[1]) {
						case "a":
							val = a;
							break;
						case "b":
							val = b;
							break;
						case "c":
							val = c;
							break;
						case "d":
							val = d;
							break;
						default:
							val = Integer.parseInt(parts[1]);
					}
					
					if (i + val < 0 || i + val >= code.size()) {
						i++;
						break;
					}
					
					String l = code.get((int) (i + val));
					
					String m = l;
					if (l.split(" ").length == 2) {
						if (l.startsWith("inc")) l = l.replace("inc", "dec");
						else l = "inc" + l.substring(l.indexOf(" "));
					} else {
						if (l.startsWith("jnz")) l = l.replace("jnz", "cpy");
						else l = "jnz" + l.substring(l.indexOf(" "));
					}
					
					code.set((int) (i + val), l);
					i++;
					break;
				}
				case "mul": {
					if (parts.length != 4) {
						i++;
						break;
					}
					
					long val = 0;
					switch (parts[2]) {
						case "a":
							val = a;
							break;
						case "b":
							val = b;
							break;
						case "c":
							val = c;
							break;
						case "d":
							val = d;
							break;
						default:
							val = Integer.parseInt(parts[2]);
					}
					
					switch (parts[3]) {
						case "a":
							val *= a;
							break;
						case "b":
							val *= b;
							break;
						case "c":
							val *= c;
							break;
						case "d":
							val *= d;
							break;
						default:
							val *= Integer.parseInt(parts[1]);
					}
					
					switch (parts[1]) {
						case "a":
							a = val;
							break;
						case "b":
							b = val;
							break;
						case "c":
							c = val;
							break;
						case "d":
							d = val;
							break;
					}
					
					i++;
					break;
				}
				default:
					i++;
			}
		}
		
		System.out.println(a);
		// a) answer was 12000
		// b) answer was 479008560, rank 990
	}
	
	static class Day22_Node {
		int x, y, size, used, avail, usage;
		
		public Day22_Node(int x, int y, int size, int used, int avail, int usage) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.used = used;
			this.avail = avail;
			this.usage = usage;
		}
		
		@Override
		public String toString() {
			return "/dev/grid/node-x" + x + "-y" + y + "	" + size + "T	" + used + "T	" + avail + "T	" + usage + "%";
		}
	}
	
	static class Day22_State {
		int i, x, y, gx, gy, num;
		
		Day22_State prev;
		
		public Day22_State(int i, int x, int y, int gx, int gy, int num) {
			this.i = i;
			this.x = x;
			this.y = y;
			this.gx = gx;
			this.gy = gy;
			this.num = num;
		}
		
		@Override
		public String toString() {
			return x + ":" + y + ":" + gx + ":" + gy;
		}
	}
	
	public static void Day22_ab() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day22.txt")));
		String line = "";
		
		Pattern p = Pattern.compile("/dev/grid/node-x([0-9]+)-y([0-9]+) +([0-9]+)T +([0-9]+)T +([0-9]+)T +([0-9]+)%");
		
		int w = 35, h = 29;
		
		Day22_Node[] grid = new Day22_Node[w * h];
		
		while ((line = br.readLine()) != null) {
			Matcher m = p.matcher(line);
			if (m.matches()) {
				int x = Integer.parseInt(m.group(1)), y = Integer.parseInt(m.group(2));
				grid[y * w + x] = new Day22_Node(x, y, Integer.parseInt(m.group(3)), Integer.parseInt(m.group(4)), Integer.parseInt(m.group(5)), Integer.parseInt(m.group(6)));
			}
		}
		br.close();
		
		int pairs = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (i == j) continue;
				if (grid[i].used == 0) continue;
				
				if (grid[i].used <= grid[j].avail) pairs++;
			}
		}
		
		System.out.println("a) " + pairs);
		System.out.println();
		// a) answer was 981
		
		//// b part ////
		
		
		// 269 is too high
		// (thought it was 74 + 39 * 5) 
		
		
		LinkedList<Day22_State> queue = new LinkedList<>();
		HashSet<String> visited = new HashSet<>();
		
		for (int i = 0; i < grid.length; i++) {
			Day22_State s = new Day22_State(i, i % w, i / w, w - 1, 0, 0);
			if (grid[i].used == 0) {
				visited.add(s.toString());
				queue.add(s);
			}
		}
		
		
		Day22_State finish = null;
		while (queue.size() > 0) {
			Day22_State s = queue.pop();
			
			
			if (s.x == s.gx - 1 && s.y == 0) {
				//				System.out.println("WOHOOOO: " + s.num + " steps");
				//				break;
				//				s.gx--;
				//				s.x++;
				//				s.i++;
				//				s.num++;
				Day22_State q = new Day22_State(s.i + 1, s.x + 1, s.y, s.gx - 1, s.gy, s.num + 1);
				q.prev = s;
				if (!visited.contains(q.toString())) {
					queue.add(q);
					visited.add(q.toString());
					continue;
				}
			}
			
			if (s.gx == 0) {
				System.out.println("WOHOOOO: " + s.num + " steps");
				// b) answer was 233 steps
				finish = s;
				break;
			}
			
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if (i * i + j * j != 1) continue;
					
					int x = s.x + i;
					if (x < 0 || x >= w) continue;
					int y = s.y + j;
					if (y < 0 || y >= h) continue;
					
					if (x == s.gx && y == s.gy) continue;
					
					Day22_Node n = grid[y * w + x];
					if (n.size > 200) continue;
					
					Day22_State q = new Day22_State(y * w + x, x, y, s.gx, s.gy, s.num + 1);
					q.prev = s;
					if (!visited.contains(q.toString())) {
						queue.add(q);
						visited.add(q.toString());
					}
				}
			}
		}
		
		String s = "";
		
		while (finish != null) {
			String q = "";
			for (int i = 0; i < grid.length; i++) {
				q += ((i == 0 ? "(" : (i == finish.gy * w + finish.gx ? "[" : " ")) + (i == finish.i ? "_" : (grid[i].size > 200 ? "#" : ".")) + //
						(i == 0 ? ")" : (i == finish.gy * w + finish.gx ? "]" : " ")) + (i % w == w - 1 ? "\n" : ""));
			}
			s = q + "\n" + s;
			
			finish = finish.prev;
		}
		//		System.out.println(s);
		
	}
	
	public static void Day21_b() throws Exception {
		Day21_rec("", "abcdefgh");
		
		// brute force recursion with 8! , answer was bacdefgh
	}
	
	// all permutations of abcdefgh
	static void Day21_rec(String prefix, String str) throws Exception {
		int n = str.length();
		if (n == 0) {
			if (Day21_a(prefix).equals("fbgdceah")) {
				System.out.println(prefix);
				System.exit(0);
			}
		} else {
			for (int i = 0; i < n; i++)
				Day21_rec(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
		}
	}
	
	public static String Day21_a(String s) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day21.txt")));
		String line = "";
		
		s = s == null ? "abcdefgh" : s;
		
		while ((line = br.readLine()) != null) {
			String[] parts = line.split(" ");
			
			switch (parts[0]) {
				case "swap": {
					switch (parts[1]) {
						case "position": {
							char[] c = s.toCharArray();
							int i = Integer.parseInt(parts[2]), j = Integer.parseInt(parts[5]);
							char t = c[i];
							c[i] = c[j];
							c[j] = t;
							s = new String(c);
							break;
						}
						case "letter": {
							s = s.replace(parts[2], "%").replace(parts[5], parts[2]).replace("%", parts[5]);
							break;
						}
					}
					
					break;
				}
				case "rotate": {
					switch (parts[1]) {
						case "based": {
							int i = s.indexOf(parts[6]);
							if (i > -1) {
								if (i >= 4) i++;
								i++;
								
								i %= s.length();
								s = s.substring(s.length() - i) + s.substring(0, s.length() - i);
							}
							break;
						}
						case "left": {
							int i = Integer.parseInt(parts[2]) % s.length();
							if (i > 0) {
								s = s.substring(i) + s.substring(0, i);
							}
							break;
						}
						case "right": {
							int i = Integer.parseInt(parts[2]) % s.length();
							if (i > 0) {
								s = s.substring(s.length() - i) + s.substring(0, s.length() - i);
							}
							break;
						}
					}
					break;
				}
				case "reverse": {
					char[] c = s.toCharArray();
					int x = Integer.parseInt(parts[2]), y = Integer.parseInt(parts[4]);
					for (int i = x; i <= (y + x) / 2; i++) {
						int j = y - i + x;
						if (i == j) continue;
						char t = c[i];
						c[i] = c[j];
						c[j] = t;
					}
					s = new String(c);
					break;
				}
				case "move": {
					ArrayList<Character> c = new ArrayList<>();
					for (char c1 : s.toCharArray())
						c.add(c1);
					
					int i = Integer.parseInt(parts[2]), j = Integer.parseInt(parts[5]);
					
					c.add(j, c.remove(i));
					
					char[] d = new char[c.size()];
					for (int x = 0; x < c.size(); x++)
						d[x] = c.get(x);
					s = new String(d);
					
					break;
				}
			}
		}
		
		//		System.out.println("result: " + s);
		// a) answer was cbeghdaf
		
		br.close();
		return s;
	}
	
	static class Day20_Range {
		long len;
		long start;
		
		public Day20_Range(long start, long len) {
			this.start = start;
			this.len = len;
		}
		
		@Override
		public String toString() {
			return start + "-" + end();
		}
		
		public long end() {
			return start + len;
		}
	}
	
	public static void Day20_ab() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day20.txt")));
		String line = "";
		
		ArrayList<Day20_Range> list = new ArrayList<>();
		
		while ((line = br.readLine()) != null) {
			String[] parts = line.split("-");
			long s = Long.parseLong(parts[0]);
			list.add(new Day20_Range(s, Long.parseLong(parts[1]) - s));
			//			map.put(Long.parseLong(parts[0]), Long.parseLong(parts[1]));
		}
		
		Collections.sort(list, new Comparator<Day20_Range>() {
			
			@Override
			public int compare(Day20_Range o1, Day20_Range o2) {
				int c = Long.compare(o1.start, o2.start);
				if (c == 0) return Long.compare(o1.len, o2.len);
				return c;
			}
		});
		
		int number = 0;
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			Day20_Range r = list.get(i);
			//			System.out.println(r + ",	" + number);
			if (r.start <= number && r.end() > number) {
				number += (r.len - (number - r.start - 1));
				index = i;
			}
		}
		
		// a) answer was 23923783
		System.out.println(number);
		
		int sum = 0;
		long l = number;
		while (l <= 4294967295l) {
			boolean found = false;
			for (int i = index; i < list.size(); i++) {
				Day20_Range r = list.get(i);
				if (l >= r.start && l <= r.end()) {
					l = r.end() + 1;
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println(l + "valid");
				sum++;
				l++;
			}
		}
		System.out.println(sum);
		// b) answer was 125, rank 880
		
		br.close();
	}
	
	static class Day19_Elf {
		Day19_Elf next;
		Day19_Elf prev;
		int num;
	}
	
	public static void Day19_b() throws InterruptedException {
		int l = 5;
		
		System.out.println(l - Math.pow(3, Math.floor(Math.log(l) / Math.log(3))));
		// rank 988, answer was 1423634, filthy copy
		
		// hold everything in memory
		Day19_Elf[] nodes = new Day19_Elf[l];
		// smart loop inits
		// this guy https://www.reddit.com/r/adventofcode/comments/5j4lp1/2016_day_19_solutions/dbdfasl/
		for (int i = 1; i <= l; i++) {
			nodes[i - 1] = new Day19_Elf();
			nodes[i - 1].num = i;
			
			// past inits
			if (i > 1) {
				nodes[i - 1].prev = nodes[i - 2];
				nodes[i - 2].next = nodes[i - 1];
			}
		}
		
		// loop
		nodes[0].prev = nodes[l - 1];
		nodes[l - 1].next = nodes[0];
		
		int length = l;
		Day19_Elf cur = nodes[0];
		Day19_Elf removal = nodes[0];
		int dist = 0;
		
		while (dist < length / 2) {
			removal = removal.next;
			++dist;
		}
		
		while (length > 1) {
			while (dist < length / 2) {
				removal = removal.next;
				++dist;
			}
			
			Day19_Elf n = removal.next;
			removal.prev.next = removal.next;
			removal.next.prev = removal.prev;
			
			removal = n;
			
			length -= 1;
			cur = cur.next;
			dist -= 1;
		}
		
		System.out.println(cur.num);
		
	}
	
	public static void Day19_a() throws InterruptedException {
		int l = 3017957;
		
		System.out.println(2 * (l - Math.pow(2, Math.floor(Math.log(l) / Math.log(2)))) + 1);
		// answer was 1841611
	}
	
	public static void Day18_ab() {
		String row0 = ".^^^.^.^^^^^..^^^..^..^..^^..^.^.^.^^.^^....^.^...^.^^.^^.^^..^^..^.^..^^^.^^...^...^^....^^.^^^^^^^";
		
		int safe = 0;
		boolean[][] map = new boolean[400000][100];
		for (int i = 0; i < 100; i++) {
			map[0][i] = row0.charAt(i) == '^';
			if (!map[0][i]) safe++;
		}
		
		for (int i = 1; i < map.length; i++) {
			for (int j = 0; j < 100; j++) {
				boolean m = j == 0 ? map[i - 1][1] : (j == 99 ? map[i - 1][j - 1] : map[i - 1][j - 1] ^ map[i - 1][j + 1]);
				if (!m) safe++;
				map[i][j] = m;
			}
			if (i == 39) {
				System.out.println("a): " + safe);
				// answer was 1939, rank 963
			}
		}
		
		System.out.println("b): " + safe);
		// b answer was 19999535, rank 945
	}
	
	static class Day17_State {
		int x, y;
		String path = "";
		
		Day17_State prev;
		
		public Day17_State(int x, int y, String dir, Day17_State prev) {
			this.x = x;
			this.y = y;
			if (prev != null) {
				this.prev = prev;
				path = prev.path + dir;
			}
		}
	}
	
	public static void Day17_ab() throws Exception {
		String input = "lpvhkcbi";
		MessageDigest md = MessageDigest.getInstance("MD5");
		
		ArrayList<Day17_State> queue = new ArrayList<>();
		queue.add(new Day17_State(0, 0, null, null));
		
		HashSet<String> visited = new HashSet<>();
		
		HashSet<String> paths = new HashSet<>();
		
		boolean shortest = false;
		
		while (queue.size() > 0) {
			Day17_State s = queue.remove(0);
			
			if (s.x == 3 && s.y == 3) {
				if (!shortest) {
					System.out.println("Shortest Path: " + s.path); //				answer was DUDRLRRDDR, rank 618
					shortest = true;
				}
				paths.add(s.path);
				continue;
			}
			
			BigInteger bigInt = new BigInteger(1, md.digest((input + s.path).getBytes()));
			String hashtext = bigInt.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			
			for (int i = 0; i < 4; i++) {
				if (hashtext.charAt(i) > 'a') {
					switch (i) {
						case 0: {
							if (s.y > 0 && !visited.contains(s.path + "U")) {
								Day17_State p = new Day17_State(s.x, s.y - 1, "U", s);
								visited.add(p.path);
								queue.add(p);
							}
							break;
						}
						case 1: {
							if (s.y < 3 && !visited.contains(s.path + "D")) {
								Day17_State p = new Day17_State(s.x, s.y + 1, "D", s);
								visited.add(p.path);
								queue.add(p);
							}
							break;
						}
						case 2: {
							if (s.x > 0 && !visited.contains(s.path + "L")) {
								Day17_State p = new Day17_State(s.x - 1, s.y, "L", s);
								visited.add(p.path);
								queue.add(p);
							}
							break;
						}
						case 3: {
							if (s.x < 3 && !visited.contains(s.path + "R")) {
								Day17_State p = new Day17_State(s.x + 1, s.y, "R", s);
								visited.add(p.path);
								queue.add(p);
							}
							break;
						}
					}
				}
			}
		}
		
		int l = 0;
		for (String s : paths)
			if (s.length() > l) l = s.length();
		
		System.out.println("Longest Path: " + l);
		// b answer was 788, rank 565
	}
	
	public static void Day16_ab() {
		StringBuilder input = new StringBuilder("10111100110001111");
		int num = 35651584; // a 272
		StringBuilder sb = new StringBuilder();
		long t = System.currentTimeMillis();
		while (input.length() < num) {
			sb.setLength(0);
			
			String q = sb.append(input).reverse().toString().replace("0", "-").replace("1", "0").replace("-", "1");
			input.append("0" + q);
		}
		
		System.out.println("done");
		
		input.setLength(num);
		do {
			StringBuilder q = new StringBuilder();
			for (int i = 0; i < input.length(); i += 2) {
				q.append(input.charAt(i) == input.charAt(i + 1) ? 1 : 0);
			}
			input.setLength(0);
			input.append(q);
		} while (input.length() % 2 == 0);
		
		System.out.println(input);
		
		System.out.println(System.currentTimeMillis() - t);
		// a) answer was 11100110111101110
		// b answer was 10001101010000101
	}
	
	public static void Day15_ab() {
		int[] pos = new int[] { 1, 10, 2, 1, 3, 5, 0 };
		int[] max = new int[] { 13, 19, 3, 7, 5, 17, 11 };
		
		int num = 0;
		while (true) {
			boolean done = true;
			for (int i = 0; i < pos.length; i++) {
				if ((pos[i] + num + i + 1) % max[i] != 0) {
					done = false;
					break;
				}
			}
			
			if (done) {
				System.out.println(num); // a) answer was 376777, rank 637
				// b) answer was 3903937 rank 623
				return;
			}
			
			num++;
		}
	}
	
	static class Day14_Hash {
		char c;
		int index;
		
		public Day14_Hash(char c, int index) {
			this.c = c;
			this.index = index;
		}
		
		@Override
		public int hashCode() {
			return index;
		}
		
		@Override
		public boolean equals(Object obj) {
			return obj.hashCode() == hashCode();
		}
	}
	
	public static void Day14_a() throws Exception {
		String salt = "zpqevtbw"; // zpqevtbw
		
		// a) answer was 16106 BURN IN HELL
		
		ArrayList<Day14_Hash> list = new ArrayList<>();
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		Pattern p = Pattern.compile("(.)\\1{2}");
		Pattern p1 = Pattern.compile("(.)\\1{4}");
		
		ArrayList<Integer> keys = new ArrayList<>();
		
		int i = 0;
		while (true) {
			String hashtext = salt + i;
			
			for (int j = 0; j < 2017; j++) {
				BigInteger bigInt = new BigInteger(1, md.digest(hashtext.getBytes()));
				hashtext = bigInt.toString(16);
				while (hashtext.length() < 32) {
					hashtext = "0" + hashtext;
				}
			}
			
			// b) answer was 22423
			
			Matcher m1 = p1.matcher(hashtext);
			if (m1.find()) {
				char c = m1.group(1).charAt(0);
				for (Iterator<Day14_Hash> iter = list.iterator(); iter.hasNext();) {
					Day14_Hash h = iter.next();
					if (h.c == c && i - h.index <= 1000) {
						keys.add(h.index);
						System.out.println("I:::" + i + ": " + h.index + ":" + h.c + ", " + keys.size() + ", " + list.size());
						if (keys.size() == 74) {
							Collections.sort(keys);
							System.out.println(keys.get(63));
							System.exit(0);
						}
					}
				}
			}
			
			Matcher m = p.matcher(hashtext);
			if (m.find()) {
				char c = m.group(1).charAt(0);
				list.add(new Day14_Hash(c, i));
			}
			
			i++;
		}
		
	}
	
	static int Day13_NumberOfSetBits(int i) {
		i = i - ((i >>> 1) & 0x55555555);
		i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
		return (((i + (i >>> 4)) & 0x0F0F0F0F) * 0x01010101) >>> 24;
	}
	
	static class Day13_Node {
		float g, h;
		int x, y;
		Day13_Node parent;
		
		public Day13_Node(float g, int x, int y, Day13_Node parent) {
			this.g = g;
			h = (float) Point.distance(x, y, 31, 39);
			this.x = x;
			this.y = y;
			this.parent = parent;
		}
		
		float f() {
			return g + h;
		}
		
		@Override
		public int hashCode() {
			return x * 50 + y;
		}
		
		@Override
		public boolean equals(Object obj) {
			return obj.hashCode() == hashCode();
		}
	}
	
	public static void Day13_ab() throws Exception {
		boolean[][] map = new boolean[50][50];
		for (int i = 0; i < 50; i++) { // y
			for (int j = 0; j < 50; j++) { //x
				map[j][i] = Day13_NumberOfSetBits(j * j + 3 * j + 2 * j * i + i + i * i + 1358) % 2 == 0;
				System.out.print(map[j][i] ? "." : "#");
			}
			System.out.println();
		}
		
		HashSet<Day13_Node> closed = new HashSet<>();
		LinkedList<Day13_Node> queue = new LinkedList<>();
		queue.add(new Day13_Node(0, 1, 1, null));
		
		int count50s = 0;
		
		do {
			Day13_Node n = queue.pop();
			closed.add(n);
			
			if (n.g <= 50) count50s++;
			
			if (n.g == 50) continue;
			
			// part a
			/*if (n.x == 31 && n.y == 39) {
				System.out.println("heureka");
				System.out.println(n.g);
				// answer was 96, rank 754
				return;
			}*/
			
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if (i == j) continue;
					if ((i == -1 && j == 1) || (i == 1 && j == -1)) continue;
					
					int x = n.x + i;
					int y = n.y + j;
					if (x < 0 || y < 0 || x > 49 || y > 49) continue;
					
					if (!map[x][y]) continue;
					
					Day13_Node node = new Day13_Node(n.g + 1, x, y, n);
					if (closed.contains(node)) continue;
					int index = -1;
					if ((index = queue.indexOf(node)) > -1) {
						Day13_Node q = queue.get(index);
						if (node.g < q.g) q.parent = n;
					} else {
						queue.add(node);
					}
				}
			}
		} while (queue.size() > 0);
		
		System.out.println(count50s); // part b  answer was 141, rank 672
	}
	
	public static void Day12_ab() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day12.txt")));
		String line = "";
		
		long a = 0, b = 0, c = 1 /* 0 for a) */, d = 0;
		
		// a) answer was 318077
		// b) was 9227731
		
		ArrayList<String> code = new ArrayList<>();
		while ((line = br.readLine()) != null) {
			code.add(line);
		}
		
		br.close();
		int i = 0;
		
		//@off
		while (i < code.size()) {
//			System.out.println(i+"	"+code.get(i));

//			Thread.sleep(500);
			String[] parts = code.get(i).split(" ");
			switch (parts[0]) {
				case "cpy": {
					long val = 0;
					switch(parts[1]) {
						case "a": val = a;break;
						case "b": val = b;break;
						case "c": val = c;break;
						case "d": val = d;break;
						default: val = Integer.parseInt(parts[1]);
					}
					switch(parts[2]) {
						case "a": a = val;break;
						case "b": b = val;break;
						case "c": c = val;break;
						case "d": d = val;break;
					}
					i++;
					break;
				}
				case "inc": {
					switch(parts[1]) {
						case "a": a++;break;
						case "b": b++;break;
						case "c": c++;break;
						case "d": d++;break;
					}
					i++;
					break;
				}
				case "dec": {
					switch(parts[1]) {
						case "a": a--;break;
						case "b": b--;break;
						case "c": c--;break;
						case "d": d--;break;
					}
					i++;
					break;
				}				
				case "jnz": {
					long val = 0;
					switch(parts[1]) {
						case "a": val=a;break;
						case "b": val=b;break;
						case "c": val=c;break;
						case "d": val=d;break;
						default: val=Integer.parseInt(parts[1]);
					}
					if(val != 0) {
						i+= Integer.parseInt(parts[2]);
					} else {
						i++;
					}
					break;
				}
			}
		}
		//@on
		
		
		System.out.println(a);
	}
	
	static class Day11_State {
		static String[] elems = { "Pr", "Co", "Cu", "Ru", "Pl", "El", "Di" };
		
		Day11_State prev;
		
		int step, elev;
		byte[][] slots;
		
		String keyCache;
		
		public Day11_State(Day11_State prev, int elev, byte[][] slots) {
			this.prev = prev;
			step = prev == null ? 0 : prev.step + 1;
			this.elev = elev;
			this.slots = slots;
		}
		
		String visitKey() {
			if (keyCache != null) return keyCache;
			
			String s = elev + ".";
			
			for (int i = 0; i < 4; i++) {
				int gens = 0, chp = 0;
				for (int j = 0; j < slots[i].length; j++) {
					if (slots[i][j] != 0) {
						if (j % 2 == 0) gens++;
						else chp++;
					}
				}
				s += i + "[" + gens + ":" + chp + "]";
			}
			
			keyCache = s;
			return s;
		}
		
		@Override
		public String toString() {
			String s = step + "";
			while (s.length() < 3)
				s += " ";
			
			for (int i = 3; i > -1; i--) {
				s += (i < 3 ? "   " : "") + "F" + (i + 1) + " ";
				s += elev == i ? "E  " : ".  ";
				
				for (int j = 0; j < slots[i].length; j++) {
					if (slots[i][j] == 0) s += ".  ";
					else {
						String q = elems[(int) Math.floor(j / 2f)] + (j % 2 == 0 ? "G" : "M");
						while (q.length() < 3)
							q += " ";
						s += q;
					}
				}
				s += "\n";
			}
			return s;
		}
	}
	
	static byte[][] Day11_copySlots(byte[][] in) {
		byte[][] c = new byte[in.length][];
		
		for (int i = 0; i < in.length; i++) {
			c[i] = new byte[in[i].length];
			System.arraycopy(in[i], 0, c[i], 0, in[i].length);
		}
		return c;
	}
	
	static boolean Day11_isValid(Day11_State st) {
		for (int i = 0; i < 4; i++) {
			int gens = 0;
			for (int j = 0; j < st.slots[i].length; j += 2) {
				if (st.slots[i][j] != 0) gens++;
			}
			for (int j = 1; j < st.slots[i].length; j += 2) {
				if (st.slots[i][j] != 0 && gens >= 1 && st.slots[i][j - 1] == 0) return false;
			}
			
		}
		
		return true;
	}
	
	public static void Day11_ab() throws Exception {
		HashSet<String> visited = new HashSet<>();
		
		ArrayList<Day11_State> queue = new ArrayList<>();
		//		queue.add(new Day11_State(null, 0, new byte[][] { { 0, 1, 0, 1 }, { 1, 0, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } }));
		
		queue.add(new Day11_State(null, 0, new byte[][] { { 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 1, 0, 1, 0, 1, 0 }, { 0, 0, 0, 1, 0, 1, 0, 1, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } }));
		// a (answer was 33)
		
		queue.add(new Day11_State(null, 0, new byte[][] { { 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 }, { 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } }));
		// b (answer was 57)
		
		// rank 998
		
		do {
			Day11_State st = queue.remove(0);
			
			System.out.println(st);
			
			boolean done = true;
			for (int i = 0; i < st.slots[3].length; i++) {
				if (st.slots[3][i] == 0) {
					done = false;
					break;
				}
			}
			
			if (done) {
				System.out.println("DONE!");
				return;
			}
			
			for (int i = Math.max(0, st.elev - 1); i <= Math.min(3, st.elev + 1); i++) { // new level
				if (i == st.elev) continue;
				
				for (int j = 0; j < st.slots[st.elev].length; j++) { // current slot
					if (st.slots[st.elev][j] != 0) {
						byte[][] c = Day11_copySlots(st.slots);
						c[st.elev][j] = 0;
						c[i][j] = 1;
						Day11_State s = new Day11_State(st, i, c);
						if (Day11_isValid(s) && !visited.contains(s.visitKey())) {
							queue.add(s);
							visited.add(s.visitKey());
						}
						
						
						for (int k = j + 1; k < st.slots[st.elev].length; k++) { // for potential second items
							if (st.slots[st.elev][k] != 0/* && (Math.floor(j / 2f) == Math.floor(k / 2f))*/) {
								byte[][] c1 = Day11_copySlots(st.slots);
								c1[st.elev][j] = 0;
								c1[i][j] = 1;
								c1[st.elev][k] = 0;
								c1[i][k] = 1;
								Day11_State s1 = new Day11_State(st, i, c1);
								if (Day11_isValid(s1) && !visited.contains(s1.visitKey())) {
									queue.add(s1);
									visited.add(s1.visitKey());
								}
							}
						}
					}
				}
			}
		} while (queue.size() > 0);
		System.out.println("lol rip");
	}
	
	static class Day10_Bot {
		int v0, v1;
		int hi, lo;
		int num;
		
		@Override
		public String toString() {
			return "(" + lo + ") < [" + num + "] < (" + hi + "): " + v0 + ", " + v1 + "\n";
		}
		
		public void put(int i) {
			if (v0 == 0) v0 = i;
			else {
				if (i > v0) {
					v1 = i;
				} else if (v1 > 0) {
					System.out.println("NO");
				} else {
					v1 = v0;
					v0 = i;
				}
			}
		}
	}
	
	public static void Day10_ab() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day10.txt")));
		String line = "";
		
		Map<Integer, Day10_Bot> map = Collections.synchronizedMap(new HashMap<>());
		Map<Integer, Integer> out = Collections.synchronizedMap(new HashMap<>());
		
		Day10_Bot start = null;
		
		while ((line = br.readLine()) != null) {
			String[] parts = line.split(" ");
			switch (parts[0]) {
				case "bot": {
					int num = Integer.parseInt(parts[1]);
					Day10_Bot bot = map.getOrDefault(num, new Day10_Bot());
					bot.num = num;
					bot.lo = Integer.parseInt(parts[6]);
					if (parts[5].equals("output")) bot.lo = -bot.lo - 1;
					bot.hi = Integer.parseInt(parts[11]);
					if (parts[10].equals("output")) bot.hi = -bot.hi - 1;
					
					map.put(num, bot);
					break;
				}
				case "value": {
					int num = Integer.parseInt(parts[5]);
					Day10_Bot bot = map.getOrDefault(num, new Day10_Bot());
					bot.num = num;
					bot.put(Integer.parseInt(parts[1]));
					
					if (bot.v0 > 0 && bot.v1 > 0) start = bot;
					
					map.put(num, bot);
					break;
				}
			}
		}
		br.close();
		
		ArrayList<Day10_Bot> queue = new ArrayList<>();
		queue.add(start);
		
		while (queue.size() > 0) {
			Day10_Bot bot = queue.remove(0);
			
			if (bot.v0 == 17 && bot.v1 == 61) System.out.println(bot.num); // answer was 98, got rank 898
			
			Day10_Bot l = null;
			if (bot.lo >= 0) {
				l = map.get(bot.lo);
				l.put(bot.v0);
			} else out.put(bot.lo, bot.v0);
			
			Day10_Bot h = null;
			if (bot.hi >= 0) {
				h = map.get(bot.hi);
				h.put(bot.v1);
			} else out.put(bot.hi, bot.v1);
			
			if (l != null && l.v1 > 0) queue.add(l);
			if (h != null && h.v1 > 0) queue.add(h);
		}
		
		
		System.out.println(out.get(-1) * out.get(-2) * out.get(-3)); // answer for b) was 4042, rank 861
	}
	
	public static void Day9_b() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day9.txt")));
		String line = br.readLine();
		br.close();
		
		long output = Day9_b_recursion(line);
		System.out.println(line.length() + "->" + output);
		//answer was 11317278863
	}
	
	static long Day9_b_recursion(String input) {
		int i = input.indexOf("(");
		if (i == -1) {
			return input.length();
		}
		input = input.substring(i + 1);
		int j = input.indexOf(")");
		int x = input.indexOf("x");
		int chars = Integer.parseInt(input.substring(0, x));
		int loop = Integer.parseInt(input.substring(x + 1, j));
		int end = j + 1 + chars;
		return i + Day9_b_recursion(input.substring(j + 1, end)) * loop + Day9_b_recursion(input.substring(end));
	}
	
	public static void Day9_a() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day9.txt")));
		String line = br.readLine();
		br.close();
		
		String input = line;
		String output = "";
		
		while (input.length() > 0) {
			int i = input.indexOf("(");
			if (i == -1) {
				output += input;
				break;
			}
			
			output += input.substring(0, i);
			input = input.substring(i + 1);
			
			int j = input.indexOf(")");
			
			int x = input.indexOf("x");
			
			int chars = Integer.parseInt(input.substring(0, x));
			int loop = Integer.parseInt(input.substring(x + 1, j));
			
			int end = j + 1 + chars;
			
			for (int k = 0; k < loop; k++) {
				output += input.substring(j + 1, end);
			}
			
			input = input.substring(end);
		}
		
		System.out.println(line.length() + "->" + output.length());
		// answer was 183269
	}
	
	public static void Day8_ab() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day8.txt")));
		String line = "";
		
		boolean[][] lcd = new boolean[50][6];
		
		while ((line = br.readLine()) != null) {
			String[] parts = line.split(" ");
			switch (parts[0]) {
				case "rect": {
					for (int i = 0; i < Integer.parseInt(parts[1].substring(0, parts[1].indexOf("x"))); i++)
						for (int j = 0; j < Integer.parseInt(parts[1].substring(parts[1].indexOf("x") + 1)); j++)
							lcd[i][j] = true;
					break;
				}
				case "rotate": {
					int j = Integer.parseInt(parts[2].substring(2));
					int k = Integer.parseInt(parts[4]);
					switch (parts[1]) {
						case "row": {
							boolean[] u = new boolean[50];
							for (int i = 0; i < 50; i++) {
								u[(i + k) % 50] = lcd[i][j];
							}
							for (int i = 0; i < 50; i++)
								lcd[i][j] = u[i];
							break;
						}
						case "column": {
							boolean[] u = new boolean[6];
							for (int i = 0; i < 6; i++) {
								u[(i + k) % 6] = lcd[j][i];
							}
							for (int i = 0; i < 6; i++)
								lcd[j][i] = u[i];
							break;
						}
					}
					break;
				}
			}
			
			int on = 0;
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 50; j++) {
					System.out.print(lcd[j][i] ? "#" : " ");
					if (lcd[j][i]) on++;
				}
				System.out.println();
			}
			System.out.println("-----------------------" + on + "---------------------------");
		}
		
		// answer was 116 & UPOJFLBCEZ
		
		br.close();
	}
	
	public static void Day7_b() throws Exception {
		Pattern p = Pattern.compile("([a-z])([a-z])\\1");
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day7.txt")));
		String line = "";
		
		int valids = 0;
		@SuppressWarnings("unchecked")
		HashSet<String>[] lists = new HashSet[] { new HashSet<>(), new HashSet<>() };
		while ((line = br.readLine()) != null) {
			boolean st = line.startsWith("[");
			String[] parts = line.split("\\[|\\]");
			lists[0].clear();
			lists[1].clear();
			
			int index = st ? 1 : 0;
			for (String s : parts) {
				Matcher m = p.matcher(s);
				for (int i = 0; i < s.length() - 2; i++) {
					if (m.find(i)) {
						if (m.group().charAt(0) != m.group().charAt(1)) lists[index].add(m.group());
					}
				}
				index = (index + 1) % 2;
			}
			
			o: for (String s : lists[0]) {
				String q = s.charAt(1) + "" + s.charAt(0) + "" + s.charAt(1);
				if (lists[1].contains(q)) {
					valids++;
					break o;
				}
			}
		}
		System.out.println(valids);
		// answer was 242
		br.close();
	}
	
	public static void Day7_a() throws Exception {
		Pattern p = Pattern.compile("(\\[[^\\[\\]]*?)?(([a-z])([a-z])\\4\\3)");
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day7.txt")));
		String line = "";
		
		int valids = 0;
		while ((line = br.readLine()) != null) {
			Matcher m = p.matcher(line.trim());
			boolean valid = false;
			
			while (m.find()) {
				if (m.group(1) == null) {
					if (m.group(2).charAt(0) != m.group(2).charAt(1)) valid = true;
				} else if (m.group(1).startsWith("[")) {
					valid = false;
					break;
				}
			}
			
			if (valid) valids++;
		}
		System.out.println(valids);
		//answer was 110
		br.close();
	}
	
	public static void Day6_b() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day6.txt")));
		String line = "";
		
		@SuppressWarnings("unchecked")
		HashMap<Character, Integer>[] maps = new HashMap[8];
		for (int i = 0; i < 8; i++)
			maps[i] = new HashMap<Character, Integer>();
		
		while ((line = br.readLine()) != null) {
			for (int i = 0; i < 8; i++) {
				char c = line.charAt(i);
				maps[i].put(c, maps[i].getOrDefault(c, 0) + 1);
			}
		}
		
		for (int i = 0; i < 8; i++) {
			ArrayList<Entry<Character, Integer>> l = new ArrayList<>(maps[i].entrySet());
			
			Collections.sort(l, new Comparator<Entry<Character, Integer>>() {
				@Override
				public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
					int c = o1.getValue().compareTo(o2.getValue());
					if (c == 0) return o1.getKey().compareTo(o2.getKey());
					return c;
				}
			});
			
			//			System.out.println(l);
			System.out.print(l.get(0).getKey()); // answer was pdesmnoz
		}
		
		br.close();
	}
	
	public static void Day6_a() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day6.txt")));
		String line = "";
		
		@SuppressWarnings("unchecked")
		HashMap<Character, Integer>[] maps = new HashMap[8];
		for (int i = 0; i < 8; i++)
			maps[i] = new HashMap<Character, Integer>();
		
		while ((line = br.readLine()) != null) {
			for (int i = 0; i < 8; i++) {
				char c = line.charAt(i);
				maps[i].put(c, maps[i].getOrDefault(c, 0) + 1);
			}
		}
		
		for (int i = 0; i < 8; i++) {
			ArrayList<Entry<Character, Integer>> l = new ArrayList<>(maps[i].entrySet());
			
			Collections.sort(l, new Comparator<Entry<Character, Integer>>() {
				@Override
				public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
					int c = o2.getValue().compareTo(o1.getValue());
					if (c == 0) return o1.getKey().compareTo(o2.getKey());
					return c;
				}
			});
			
			//			System.out.println(l);
			System.out.print(l.get(0).getKey()); // answer was ygjzvzib
		}
		
		br.close();
	}
	
	public static void Day5_b() throws Exception {
		String input = "wtnhxymk";
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		int index = -1;
		
		Pattern p = Pattern.compile("^00000([0-7])(.).+$");
		
		char[] c = new char[8];
		Arrays.fill(c, '_');
		int i = 0;
		while (i < 8) {
			index++;
			BigInteger bigInt = new BigInteger(1, md.digest((input + index).getBytes()));
			String hashtext = bigInt.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			
			if (hashtext.startsWith("00000")) {
				Matcher m = p.matcher(hashtext);
				if (m.matches()) {
					
					int inde = Integer.parseInt(m.group(1));
					
					if (c[inde] == '_') {
						System.out.println(index);
						c[inde] = m.group(2).charAt(0);
						i++;
					}
				}
			}
		}
		
		System.out.println(new String(c));
	}
	
	public static void Day5_a() throws Exception {
		String input = "wtnhxymk";
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		int index = -1;
		
		String pwd = "";
		while (pwd.length() < 8) {
			index++;
			BigInteger bigInt = new BigInteger(1, md.digest((input + index).getBytes()));
			String hashtext = bigInt.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			
			if (hashtext.startsWith("00000")) {
				System.out.println(index);
				pwd += hashtext.substring(5, 6);
			}
		}
		
		System.out.println(pwd);
		// answer was 2414bc77
	}
	
	public static void Day4_b() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day4.txt")));
		String line = "";
		
		while ((line = br.readLine()) != null) {
			String s = line.substring(0, line.lastIndexOf("-"));
			String v = s.replace("-", "");
			
			int num = Integer.parseInt(line.substring(line.lastIndexOf("-") + 1, line.indexOf("[")));
			
			HashMap<Character, Integer> m = new HashMap<>();
			
			for (int i = 0; i < v.length(); i++) {
				m.put(v.charAt(i), m.getOrDefault(v.charAt(i), 0) + 1);
			}
			
			ArrayList<Entry<Character, Integer>> l = new ArrayList<>(m.entrySet());
			
			Collections.sort(l, new Comparator<Entry<Character, Integer>>() {
				@Override
				public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
					int c = o2.getValue().compareTo(o1.getValue());
					if (c == 0) return o1.getKey().compareTo(o2.getKey());
					return c;
				}
			});
			
			String r = "";
			for (int i = 0; i < 5; i++) {
				r += l.get(i).getKey();
			}
			
			String q = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
			if (q.equals(r)) {
				String re = "";
				for (int i = 0; i < s.length(); i++) {
					char c = s.charAt(i);
					
					if (c != ' ' && c != '-') {
						int d = c - 'a';
						d = (d + num) % 26;
						re += Character.toString((char) (d + 'a'));
					} else {
						if (num % 2 == 0) {
							re += c;
						} else {
							re += Character.toString(c == ' ' ? '-' : ' ');
						}
					}
				}
				
				if (re.contains("north")) System.out.println(re + ": " + num); // answer was 501
			}
		}
		
		br.close();
	}
	
	public static void Day4_a() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day4.txt")));
		String line = "";
		
		int c = 0;
		
		while ((line = br.readLine()) != null) {
			String s = line.substring(0, line.lastIndexOf("-")).replace("-", "");
			
			int num = Integer.parseInt(line.substring(line.lastIndexOf("-") + 1, line.indexOf("[")));
			
			HashMap<Character, Integer> m = new HashMap<>();
			
			for (int i = 0; i < s.length(); i++) {
				m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
			}
			
			ArrayList<Entry<Character, Integer>> l = new ArrayList<>(m.entrySet());
			
			Collections.sort(l, new Comparator<Entry<Character, Integer>>() {
				@Override
				public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
					int c = o2.getValue().compareTo(o1.getValue());
					if (c == 0) return o1.getKey().compareTo(o2.getKey());
					return c;
				}
			});
			
			String r = "";
			for (int i = 0; i < 5; i++) {
				r += l.get(i).getKey();
			}
			
			String q = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
			System.out.println(q);
			if (q.equals(r)) c += num;
		}
		
		System.out.println(c);
		// answer was 137896
		br.close();
	}
	
	public static void Day3_b() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day3.txt")));
		String line = "";
		
		int count = 0;
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] ints = new ArrayList[] { new ArrayList<>(), new ArrayList<>(), new ArrayList<>() };
		while ((line = br.readLine()) != null) {
			try {
				String[] parts = line.trim().split("\\s+");
				for (int i = 0; i < 3; i++) {
					ints[i].add(Integer.parseInt(parts[i]));
					
					if (ints[i].size() == 3) {
						Collections.sort(ints[i]);
						if (ints[i].get(0) + ints[i].get(1) > ints[i].get(2)) count++;
						System.out.print(ints[i] + " ");
						ints[i].clear();
					} else System.out.print(ints[i] + " ");
				}
				System.out.println();
			} catch (Exception e) {
				System.out.println(line);
			}
		}
		
		System.out.println(count);
		// answer was 1836
		br.close();
	}
	
	public static void Day3_a() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day3.txt")));
		String line = "";
		
		int count = 0;
		
		while ((line = br.readLine()) != null) {
			try {
				String[] parts = line.trim().split("\\s+");
				ArrayList<Integer> ints = new ArrayList<>();
				for (String s : parts)
					ints.add(Integer.parseInt(s));
				Collections.sort(ints);
				
				if (ints.get(0) + ints.get(1) > ints.get(2)) count++;
			} catch (Exception e) {
				System.out.println(line);
			}
		}
		
		System.out.println(count);
		// answer was 983
		br.close();
	}
	
	public static void Day2_b() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day2.txt")));
		String line = "RRR";
		
		char[][] pad = { { 0, 0, '1', 0, 0 }, { 0, '2', '3', '4', 0 }, { '5', '6', '7', '8', '9' }, { 0, 'A', 'B', 'C', 0 }, { 0, 0, 'D', 0, 0 } };
		
		int x = 0, y = 2;
		while ((line = br.readLine()) != null) {
			for (int i = 0; i < line.length(); i++) {
				switch (line.charAt(i)) {
					case 'U':
						y = pad[Math.max(0, y - 1)][x] != 0 ? Math.max(0, y - 1) : y;
						break;
					case 'L':
						x = pad[y][Math.max(0, x - 1)] != 0 ? Math.max(0, x - 1) : x;
						break;
					case 'R':
						x = pad[y][Math.min(4, x + 1)] > 0 ? Math.min(4, x + 1) : x;
						break;
					case 'D':
						y = pad[Math.min(4, y + 1)][x] != 0 ? Math.min(4, y + 1) : y;
						break;
				}
			}
			System.out.print(pad[y][x]);
		}
		
		br.close();
	}
	
	public static void Day2_a() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day.txt")));
		String line = "";
		
		while ((line = br.readLine()) != null) {
			int x = 0, y = 0;
			for (int i = 0; i < line.length(); i++) {
				switch (line.charAt(i)) {
					case 'U':
						y = Math.max(-1, y - 1);
						break;
					case 'L':
						x = Math.max(-1, x - 1);
						break;
					case 'R':
						x = Math.min(1, x + 1);
						break;
					case 'D':
						y = Math.min(1, y + 1);
						break;
				}
			}
			System.out.println(x + ":" + y);
		}
		
		br.close();
	}
	
	public static final String day1 = "L5, R1, L5, L1, R5, R1, R1, L4, L1, L3, R2, R4, L4, L1, L1, R2, R4, R3, L1, R4, L4, L5, L4, R4, L5, R1, R5, L2, R1, R3, L2, L4, L4, R1, L192, R5, R1, R4, L5, L4, R5, L1, L1, R48, R5, R5, L2, R4, R4, R1, R3, L1, L4, L5, R1, L4, L2, L5, R5, L2, R74, R4, L1, R188, R5, L4, L2, R5, R2, L4, R4, R3, R3, R2, R1, L3, L2, L5, L5, L2, L1, R1, R5, R4, L3, R5, L1, L3, R4, L1, L3, L2, R1, R3, R2, R5, L3, L1, L1, R5, L4, L5, R5, R2, L5, R2, L1, L5, L3, L5, L5, L1, R1, L4, L3, L1, R2, R5, L1, L3, R4, R5, L4, L1, R5, L1, R5, R5, R5, R2, R1, R2, L5, L5, L5, R4, L5, L4, L4, R5, L2, R1, R5, L1, L5, R4, L3, R4, L2, R3, R3, R3, L2, L2, L2, L1, L4, R3, L4, L2, R2, R5, L1, R2";
	
	public static void Day1_b() {
		int x = 0, y = 0, dx = 0, dy = 1;
		ArrayList<Point> points = new ArrayList<>();
		String[] ins = day1.split(", ");
		for (String s : ins) {
			if (s.startsWith("L")) {
				int dxx = dx;
				dx = -dy;
				dy = dxx;
			} else {
				int dxx = dx;
				dx = dy;
				dy = -dxx;
			}
			
			int num = Integer.parseInt(s.substring(1));
			
			boolean isX = dx != 0;
			
			for (int i = 0; i < (isX ? dx : dy) * num; i++) {
				int x1 = x + (isX ? i : 0);
				int y1 = y + (!isX ? i : 0);
				Point p = new Point(x1, y1);
				if (points.contains(p)) {
					System.out.println(Math.abs(x1) + Math.abs(y1)); // Answer 79
					return;
				} else points.add(p);
			}
			
			x += dx * num;
			y += dy * num;
			
			System.out.println(x + ":" + y);
			
			
		}
		
		System.out.println(points);
		
		System.out.println("404");
	}
	
	public static void Day1_a() {
		int x = 0, y = 0, dx = 0, dy = -1;
		String[] ins = day1.split(", ");
		for (String s : ins) {
			if (s.startsWith("L")) {
				int dxx = dx;
				dx = -dy;
				dy = dxx;
			} else {
				int dxx = dx;
				dx = dy;
				dy = -dxx;
			}
			
			int num = Integer.parseInt(s.substring(1));
			x += dx * num;
			y += dy * num;
		}
		
		System.out.println(Math.abs(x) + Math.abs(y));
		// answer is 226
	}
}
