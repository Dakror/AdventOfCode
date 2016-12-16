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
import java.io.File;
import java.io.FileReader;
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
		Day16_ab();
	}
	
	/////////////////////////////////////////////
	
	public static void Day() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day.txt")));
		String line = "";
		
		while ((line = br.readLine()) != null) {}
		
		br.close();
	}
	
	/////////////////////////////////////////////
	
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
	
	public static void Day15_a_and_b() {
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
	
	public static void Day13_a_or_b() throws Exception {
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
	
	public static void Day12_a_and_b() throws Exception {
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
	
	public static void Day11_a_and_b() throws Exception {
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
	
	public static void Day10_a_and_b() throws Exception {
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
	
	public static void Day8_a_and_b() throws Exception {
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
