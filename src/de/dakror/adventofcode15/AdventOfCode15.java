/*******************************************************************************
 * Copyright 2015 Maximilian Stark | Dakror <mail@dakror.de>
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

package de.dakror.adventofcode15;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.bind.DatatypeConverter;

/**
 * @author Maximilian Stark | Dakror
 *
 */
public class AdventOfCode15 {
	static String path = "src\\de\\dakror\\adventofcode15\\";
	
	public static void main(String[] args) throws Exception {
		Day19_2();
	}
	
	// ---------------- template ---------------- //
	public static void Day() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day.txt")));
		String line = "";
		while ((line = br.readLine()) != null) {
			String[] s = line.split(" ");
		}
		
		br.close();
	}
	
	public static void Day19_2() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day19.txt")));
		String line = "";
		
		String mo = "CRnCaSiRnBSiRnFArTiBPTiTiBFArPBCaSiThSiRnTiBPBPMgArCaSiRnTiMgArCaSiThCaSiRnFArRnSiRnFArTiTiBFArCaCaSiRnSiThCaCaSiRnMgArFYSiRnFYCaFArSiThCaSiThPBPTiMgArCaPRnSiAlArPBCaCaSiRnFYSiThCaRnFArArCaCaSiRnPBSiRnFArMgYCaCaCaCaSiThCaCaSiAlArCaCaSiRnPBSiAlArBCaCaCaCaSiThCaPBSiThPBPBCaSiRnFYFArSiThCaSiRnFArBCaCaSiRnFYFArSiThCaPBSiThCaSiRnPMgArRnFArPTiBCaPRnFArCaCaCaCaSiRnCaCaSiRnFYFArFArBCaSiThFArThSiThSiRnTiRnPMgArFArCaSiThCaPBCaSiRnBFArCaCaPRnCaCaPMgArSiRnFYFArCaSiThRnPBPMgAr";
		
		HashSet<String> repl = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			String[] s = line.split(" ");
			String[] p = mo.split(s[0]);
			if (p.length == 1) continue;
			System.out.println(line);
			System.out.println(mo);
			for (int i = 0; i < p.length; i++) {
				sb.setLength(0);
				for (int j = 0; j < i; j++) {
					sb.append(p[j] + (j == i - 1 ? "" : s[0]));
				}
				if (sb.length() == 0) continue;
				
				
				sb.append(s[2]);
				for (int j = i; j < p.length; j++) {
					sb.append(p[j] + (j == p.length - 1 ? "" : s[0]));
				}
				System.out.println(sb.toString());
				repl.add(sb.toString());
			}
			
		}
		
		System.out.println(repl.size());
		
		br.close();
	}
	
	public static void Day19_1() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day19.txt")));
		String line = "";
		
		String mo = "CRnCaSiRnBSiRnFArTiBPTiTiBFArPBCaSiThSiRnTiBPBPMgArCaSiRnTiMgArCaSiThCaSiRnFArRnSiRnFArTiTiBFArCaCaSiRnSiThCaCaSiRnMgArFYSiRnFYCaFArSiThCaSiThPBPTiMgArCaPRnSiAlArPBCaCaSiRnFYSiThCaRnFArArCaCaSiRnPBSiRnFArMgYCaCaCaCaSiThCaCaSiAlArCaCaSiRnPBSiAlArBCaCaCaCaSiThCaPBSiThPBPBCaSiRnFYFArSiThCaSiRnFArBCaCaSiRnFYFArSiThCaPBSiThCaSiRnPMgArRnFArPTiBCaPRnFArCaCaCaCaSiRnCaCaSiRnFYFArFArBCaSiThFArThSiThSiRnTiRnPMgArFArCaSiThCaPBCaSiRnBFArCaCaPRnCaCaPMgArSiRnFYFArCaSiThRnPBPMgAr";
		
		HashSet<String> repl = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			String[] s = line.split(" ");
			String[] p = mo.split(s[0]);
			if (p.length == 1) continue;
			System.out.println(line);
			System.out.println(mo);
			for (int i = 0; i < p.length; i++) {
				sb.setLength(0);
				for (int j = 0; j < i; j++) {
					sb.append(p[j] + (j == i - 1 ? "" : s[0]));
				}
				if (sb.length() == 0) continue;
				
				
				sb.append(s[2]);
				for (int j = i; j < p.length; j++) {
					sb.append(p[j] + (j == p.length - 1 ? "" : s[0]));
				}
				System.out.println(sb.toString());
				repl.add(sb.toString());
			}
			
		}
		
		System.out.println(repl.size());
		
		br.close();
	}
	
	public static void Day18_2() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day18.txt")));
		String line = "";
		boolean[] buf = new boolean[100 * 100];
		boolean[] start = new boolean[100 * 100];
		int i = 0;
		while ((line = br.readLine()) != null) {
			for (int j = 0; j < line.length(); j++)
				buf[i * 100 + j] = line.charAt(j) == '#';
			i++;
		}
		System.arraycopy(buf, 0, start, 0, buf.length);
		
		JFrame f = new JFrame();
		f.setSize(1000, 1000);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new JPanel() {
			private static final long serialVersionUID = 1L;
			
			final Color[] colors = { Color.green, Color.blue, Color.red, Color.yellow };
			
			@Override
			protected void paintComponent(Graphics g) {
				((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g.setColor(Color.black);
				g.fillRect(0, 0, getWidth(), getHeight());
				float w = getWidth() / 100f;
				float h = getHeight() / 100f;
				for (int i = 0; i < 100; i++) {
					for (int j = 0; j < 100; j++) {
						g.setColor(colors[((i + j) % 4 + j % 4) % 4]);
						if (buf[i * 100 + j]) g.fillOval(Math.round(i * w), Math.round(j * h), Math.round(w), Math.round(h));
					}
				}
			}
		});
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		Thread t = new Thread() {
			@Override
			public void run() {
				sim();
			}
			
			
			public void sim() {
				System.arraycopy(start, 0, buf, 0, buf.length);
				buf[0] = true;
				buf[99] = true;
				buf[99 * 100] = true;
				buf[99 * 100 + 99] = true;
				boolean[] buf2 = new boolean[100 * 100];
				for (int i = 0; i < 100; i++) {
					Arrays.fill(buf2, false);
					int on = 0;
					for (int j = 0; j < 100; j++) {
						for (int k = 0; k < 100; k++) {
							
							int n = getNeigh(j, k);
							if (buf[j * 100 + k]) buf2[j * 100 + k] = n == 2 || n == 3;
							else buf2[j * 100 + k] = n == 3;
							buf2[0] = true;
							buf2[99] = true;
							buf2[99 * 100] = true;
							buf2[99 * 100 + 99] = true;
							
							if (buf2[j * 100 + k]) on++;
						}
					}
					
					System.arraycopy(buf2, 0, buf, 0, buf.length);
					f.repaint();
					f.setTitle(on + "");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			boolean get(int x, int y) {
				return x >= 0 && y >= 0 && x < 100 && y < 100 ? buf[x * 100 + y] : false;
			}
			
			int getNeigh(int x, int y) {
				int n = 0;
				for (int i = -1; i < 2; i++) {
					for (int j = -1; j < 2; j++) {
						if (i == j && i == 0) continue;
						if (get(x + i, y + j)) n++;
					}
				}
				
				return n;
			}
		};
		
		f.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					t.start();
				}
			}
		});
		
		br.close();
	}
	
	public static void Day18_1() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day18.txt")));
		String line = "";
		boolean[] buf = new boolean[100 * 100];
		boolean[] start = new boolean[100 * 100];
		int i = 0;
		while ((line = br.readLine()) != null) {
			for (int j = 0; j < line.length(); j++)
				buf[i * 100 + j] = line.charAt(j) == '#';
			i++;
		}
		System.arraycopy(buf, 0, start, 0, buf.length);
		
		JFrame f = new JFrame();
		f.setSize(1000, 1000);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new JPanel() {
			private static final long serialVersionUID = 1L;
			
			final Color[] colors = { Color.green, Color.blue, Color.red, Color.yellow };
			
			@Override
			protected void paintComponent(Graphics g) {
				((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g.setColor(Color.black);
				g.fillRect(0, 0, getWidth(), getHeight());
				float w = getWidth() / 100f;
				float h = getHeight() / 100f;
				for (int i = 0; i < 100; i++) {
					for (int j = 0; j < 100; j++) {
						g.setColor(colors[((i + j) % 4 + j % 4) % 4]);
						if (buf[i * 100 + j]) g.fillOval(Math.round(i * w), Math.round(j * h), Math.round(w), Math.round(h));
					}
				}
			}
		});
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		Thread t = new Thread() {
			@Override
			public void run() {
				sim();
			}
			
			
			public void sim() {
				System.arraycopy(start, 0, buf, 0, buf.length);
				
				boolean[] buf2 = new boolean[100 * 100];
				for (int i = 0; i < 100; i++) {
					Arrays.fill(buf2, false);
					int on = 0;
					for (int j = 0; j < 100; j++) {
						for (int k = 0; k < 100; k++) {
							int n = getNeigh(j, k);
							if (buf[j * 100 + k]) buf2[j * 100 + k] = n == 2 || n == 3;
							else buf2[j * 100 + k] = n == 3;
							
							if (buf2[j * 100 + k]) on++;
						}
					}
					
					System.arraycopy(buf2, 0, buf, 0, buf.length);
					f.repaint();
					f.setTitle(on + "");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			boolean get(int x, int y) {
				return x >= 0 && y >= 0 && x < 100 && y < 100 ? buf[x * 100 + y] : false;
			}
			
			int getNeigh(int x, int y) {
				int n = 0;
				for (int i = -1; i < 2; i++) {
					for (int j = -1; j < 2; j++) {
						if (i == j && i == 0) continue;
						if (get(x + i, y + j)) n++;
					}
				}
				
				return n;
			}
		};
		
		f.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					t.start();
				}
			}
		});
		
		br.close();
	}
	
	public static void Day17_2() {
		int[] v = { 50, 44, 11, 49, 42, 46, 18, 32, 26, 40, 21, 7, 18, 43, 10, 47, 36, 24, 22, 40 };
		
		// must not sort v whysoever
		
		int num = 0;
		int min = 0; // min is 4
		
		for (int i = 0; i <= Math.pow(2, v.length); i++) {
			String s = Integer.toBinaryString(i);
			while (s.length() < v.length)
				s = "0" + s;
			
			String o = "";
			
			int c = 0;
			int d = 0;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '1') {
					c += v[j];
					o += " + " + v[j];
					d++;
				}
			}
			
			if (c == 150) {
				if (d == 4) min++;
				num++;
				System.out.println(s + " = " + o + " = " + c);
			}
		}
		
		System.out.println(num);
		System.out.println(min);
	}
	
	public static void Day17_1() {
		int[] v = { 50, 44, 11, 49, 42, 46, 18, 32, 26, 40, 21, 7, 18, 43, 10, 47, 36, 24, 22, 40 };
		
		// must not sort v whysoever
		
		int num = 0;
		for (int i = 0; i <= Math.pow(2, v.length); i++) {
			String s = Integer.toBinaryString(i);
			while (s.length() < v.length)
				s = "0" + s;
			
			String o = "";
			
			int c = 0;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '1') {
					c += v[j];
					o += " + " + v[j];
				}
			}
			
			if (c == 150) {
				num++;
				System.out.println(s + " = " + o + " = " + c);
			}
		}
		
		System.out.println(num);
	}
	
	public static void Day16_2() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day16.txt")));
		String line = "";
		String bestLine = "";
		int partNum = 0;
		final String[] parts = { "children: 3", "samoyeds: 2", "pomeranians: 2", "pomeranians: 1", "pomeranians: 0", "akitas: 0", "vizslas: 0", "goldfish: 4", "goldfish: 3", "goldfish: 2", "goldfish: 1", "goldfish: 0", "cars: 2", "perfumes: 1" };
		while ((line = br.readLine()) != null) {
			int partNumber = 0;
			for (String p : parts) {
				if (line.contains(p)) partNumber++;
			}
			
			int cI = line.indexOf("cats: ");
			if (cI > -1) {
				String s = line.substring(cI + 6);
				if (s.indexOf(",") > -1) s = s.substring(0, s.indexOf(","));
				if (Integer.parseInt(s) > 7) partNumber++;
			}
			
			int tI = line.indexOf("trees: ");
			if (tI > -1) {
				String s = line.substring(tI + 7);
				if (s.indexOf(",") > -1) s = s.substring(0, s.indexOf(","));
				if (Integer.parseInt(s) > 3) partNumber++;
			}
			
			if (partNumber > partNum) {
				bestLine = line;
				partNum = partNumber;
			}
		}
		
		System.out.println(bestLine);
		
		br.close();
	}
	
	public static void Day16_1() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day16.txt")));
		String line = "";
		String bestLine = "";
		int partNum = 0;
		final String[] parts = { "children: 3", "cats: 7", "samoyeds: 2", "pomeranians: 3", "akitas: 0", "vizslas: 0", "goldfish: 5", "trees: 3", "cars: 2", "perfumes: 1" };
		while ((line = br.readLine()) != null) {
			int partNumber = 0;
			for (String p : parts) {
				if (line.contains(p)) partNumber++;
			}
			
			if (partNumber > partNum) {
				bestLine = line;
				partNum = partNumber;
			}
		}
		
		System.out.println(bestLine);
		
		br.close();
	}
	
	public static void Day15_2() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day15.txt")));
		String line = "";
		int[][] cfg = new int[4][5];
		int ind = 0;
		while ((line = br.readLine()) != null) {
			String[] s = line.replace(",", "").split(" ");
			cfg[ind][0] = Integer.parseInt(s[2]);
			cfg[ind][1] = Integer.parseInt(s[4]);
			cfg[ind][2] = Integer.parseInt(s[6]);
			cfg[ind][3] = Integer.parseInt(s[8]);
			cfg[ind++][4] = Integer.parseInt(s[10]);
		}
		
		long highest = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				for (int k = 0; k < 100; k++) {
					inner: for (int l = 0; l < 100; l++) {
						if (i + j + k + l != 100) continue;
						
						long val = 1;
						for (int m = 0; m < 5; m++) {
							long sum = Math.max(0, i * cfg[0][m] + j * cfg[1][m] + k * cfg[2][m] + l * cfg[3][m]);
							if (m == 4) {
								if (sum != 500) continue inner;
							} else val *= sum;
							
						}
						if (val > highest) highest = val;
					}
				}
			}
		}
		
		System.out.println(highest);
		
		br.close();
	}
	
	public static void Day15_1() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day15.txt")));
		String line = "";
		int[][] cfg = new int[4][4];
		int ind = 0;
		while ((line = br.readLine()) != null) {
			String[] s = line.replace(",", "").split(" ");
			cfg[ind][0] = Integer.parseInt(s[2]);
			cfg[ind][1] = Integer.parseInt(s[4]);
			cfg[ind][2] = Integer.parseInt(s[6]);
			cfg[ind++][3] = Integer.parseInt(s[8]);
		}
		
		long highest = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				for (int k = 0; k < 100; k++) {
					for (int l = 0; l < 100; l++) {
						if (i + j + k + l != 100) continue;
						
						long val = 1;
						for (int m = 0; m < 4; m++) {
							long sum = Math.max(0, i * cfg[0][m] + j * cfg[1][m] + k * cfg[2][m] + l * cfg[3][m]);
							val *= sum;
							
						}
						if (val > highest) highest = val;
					}
				}
			}
		}
		
		System.out.println(highest);
		
		br.close();
	}
	
	public static void Day14_2() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day14.txt")));
		String line = "";
		
		/**
		 * [x][0] = speed<br>
		 * [x][1] = runTime<br>
		 * [x][2] = restTime<br>
		 */
		int[][] cfg = new int[9][3];
		int id = 0;
		while ((line = br.readLine()) != null) {
			String[] s = line.split(" ");
			cfg[id][0] = Integer.parseInt(s[3]);
			cfg[id][1] = Integer.parseInt(s[6]);
			cfg[id++][2] = Integer.parseInt(s[13]);
		}
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 3; j++)
				System.out.print(cfg[i][j] + "	");
			System.out.println("");
		}
		
		/**
		 * [x][0] = km<br>
		 * [x][1] = remainingTime<br>
		 * [x][2] = 1 / 0 sleep<br>
		 * [x][3] = points<br>
		 */
		int[][] states = new int[9][4];
		for (int i = 0; i < 9; i++)
			states[i][1] = cfg[i][1];
		
		ArrayList<Integer> lead = new ArrayList<>();
		for (int i = 0; i < 2503; i++) {
			int highest = 0;
			for (int j = 0; j < 9; j++) {
				states[j][1]--;
				if (states[j][2] == 0) {
					states[j][0] += cfg[j][0];
				}
				if (states[j][1] <= 0) {
					states[j][2] = states[j][2] == 1 ? 0 : 1;
					if (states[j][2] == 0) states[j][1] = cfg[j][1];
					else states[j][1] = cfg[j][2];
				}
				if (states[j][0] > highest) highest = states[j][0];
			}
			
			for (int j = 0; j < 9; j++) {
				if (states[j][0] == highest) states[j][3]++;
			}
			
			lead.clear();
		}
		
		int highest = 0;
		for (int i = 0; i < 9; i++)
			highest = states[i][3] > highest ? states[i][3] : highest;
		
		System.out.println(highest);
		br.close();
	}
	
	public static void Day14_1() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day14.txt")));
		String line = "";
		
		/**
		 * [x][0] = speed<br>
		 * [x][1] = runTime<br>
		 * [x][2] = restTime<br>
		 */
		int[][] cfg = new int[9][3];
		int id = 0;
		while ((line = br.readLine()) != null) {
			String[] s = line.split(" ");
			cfg[id][0] = Integer.parseInt(s[3]);
			cfg[id][1] = Integer.parseInt(s[6]);
			cfg[id++][2] = Integer.parseInt(s[13]);
		}
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 3; j++)
				System.out.print(cfg[i][j] + "	");
			System.out.println("");
		}
		
		/**
		 * [x][0] = km<br>
		 * [x][1] = remainingTime<br>
		 * [x][2] = 1 / 0 sleep<br>
		 */
		int[][] states = new int[9][3];
		for (int i = 0; i < 9; i++)
			states[i][1] = cfg[i][1];
		
		ArrayList<Integer> lead = new ArrayList<>();
		for (int i = 0; i < 2503; i++) {
			for (int j = 0; j < 9; j++) {
				states[j][1]--;
				if (states[j][2] == 0) {
					states[j][0] += cfg[j][0];
				}
				if (states[j][1] <= 0) {
					states[j][2] = states[j][2] == 1 ? 0 : 1;
					if (states[j][2] == 0) states[j][1] = cfg[j][1];
					else states[j][1] = cfg[j][2];
				}
			}
			
			lead.clear();
		}
		
		int highest = 0;
		for (int i = 0; i < 9; i++)
			highest = states[i][0] > highest ? states[i][0] : highest;
		
		System.out.println(highest);
		br.close();
	}
	
	public static void Day13_2() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day13.txt")));
		String line = "";
		
		int[][] matrix = new int[9][9];
		final String[] names = { "Alice", "Bob", "Carol", "David", "Eric", "Frank", "George", "Mallory", "ME" };
		ArrayList<String> nameList = new ArrayList<>();
		for (String s : names)
			nameList.add(s);
		while ((line = br.readLine()) != null) {
			String[] s = line.substring(0, line.length() - 1).split(" ");
			matrix[nameList.indexOf(s[0])][nameList.indexOf(s[s.length - 1])] = Integer.parseInt(s[3]) * (s[2].equals("lose") ? -1 : 1);
		}
		
		for (int i = -1; i < 9; i++) {
			if (i > -1) System.out.print(names[i] + "	");
			for (int j = 0; j < 9; j++) {
				if (i == -1) System.out.print("	" + names[j]);
				else System.out.print(matrix[i][j] + "	");
			}
			System.out.println("");
		}
		
		int highest = 0;
		for (int a = 0; a < 9; a++) {
			for (int b = 0; b < 9; b++) {
				if (b == a) continue;
				for (int c = 0; c < 9; c++) {
					if (c == b || c == a) continue;
					for (int d = 0; d < 9; d++) {
						if (d == c || d == b || d == a) continue;
						for (int e = 0; e < 9; e++) {
							if (e == d || e == c || e == b || e == a) continue;
							for (int f = 0; f < 9; f++) {
								if (f == e || f == d || f == c || f == b || f == a) continue;
								for (int g = 0; g < 9; g++) {
									if (g == f || g == e || g == d || g == c || g == b || g == a) continue;
									for (int h = 0; h < 9; h++) {
										if (h == g || h == f || h == e || h == d || h == c || h == b || h == a) continue;
										for (int i = 0; i < 9; i++) {
											if (i == h || i == g || i == f || i == e || i == d || i == c || i == b || i == a) continue;
											int val = matrix[a][b] + matrix[b][a] + matrix[b][c] + matrix[c][b] + matrix[c][d] + matrix[d][c] + matrix[d][e] + matrix[e][d] + matrix[e][f] + matrix[f][e] + matrix[f][g] + matrix[g][f] + matrix[g][h] + matrix[h][g] + matrix[h][i] + matrix[i][h] + matrix[i][a] + matrix[a][i];
											if (val > highest) {
											//@off
											System.out.printf("(%d)%s(%d) : (%d)%s(%d) : (%d)%s(%d) : (%d)%s(%d) : (%d)%s(%d) : (%d)%s(%d) : (%d)%s(%d) : (%d)%s(%d) : (%d)%s(%d) = %d\n",
											                  matrix[a][i], names[a], matrix[a][b], 
											                  matrix[b][a], names[b], matrix[b][c], 
											                  matrix[c][b], names[c], matrix[c][d], 
											                  matrix[d][c], names[d], matrix[d][e],
											                  matrix[e][d], names[e], matrix[e][f],
											                  matrix[f][e],	names[f], matrix[f][g],
											                  matrix[g][f],	names[g], matrix[g][h], 
											                  matrix[h][g], names[h], matrix[h][i],
											                  matrix[i][h], names[i], matrix[i][a], val);
											//@on
												highest = val;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(highest);
		
		br.close();
	}
	
	public static void Day13_1() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day13.txt")));
		String line = "";
		
		int[][] matrix = new int[8][8];
		final String[] names = { "Alice", "Bob", "Carol", "David", "Eric", "Frank", "George", "Mallory" };
		ArrayList<String> nameList = new ArrayList<>();
		for (String s : names)
			nameList.add(s);
		while ((line = br.readLine()) != null) {
			String[] s = line.substring(0, line.length() - 1).split(" ");
			matrix[nameList.indexOf(s[0])][nameList.indexOf(s[s.length - 1])] = Integer.parseInt(s[3]) * (s[2].equals("lose") ? -1 : 1);
		}
		
		for (int i = -1; i < 8; i++) {
			if (i > -1) System.out.print(names[i] + "	");
			for (int j = 0; j < 8; j++) {
				if (i == -1) System.out.print("	" + names[j]);
				else System.out.print(matrix[i][j] + "	");
			}
			System.out.println("");
		}
		
		int highest = 0;
		for (int a = 0; a < 8; a++) {
			for (int b = 0; b < 8; b++) {
				if (b == a) continue;
				for (int c = 0; c < 8; c++) {
					if (c == b || c == a) continue;
					for (int d = 0; d < 8; d++) {
						if (d == c || d == b || d == a) continue;
						for (int e = 0; e < 8; e++) {
							if (e == d || e == c || e == b || e == a) continue;
							for (int f = 0; f < 8; f++) {
								if (f == e || f == d || f == c || f == b || f == a) continue;
								for (int g = 0; g < 8; g++) {
									if (g == f || g == e || g == d || g == c || g == b || g == a) continue;
									for (int h = 0; h < 8; h++) {
										if (h == g || h == f || h == e || h == d || h == c || h == b || h == a) continue;
										int val = matrix[a][b] + matrix[b][a] + matrix[b][c] + matrix[c][b] + matrix[c][d] + matrix[d][c] + matrix[d][e] + matrix[e][d] + matrix[e][f] + matrix[f][e] + matrix[f][g] + matrix[g][f] + matrix[g][h] + matrix[h][g] + matrix[h][a] + matrix[a][h];
										if (val > highest) {
											//@off
											System.out.printf("(%d)%s(%d) : (%d)%s(%d) : (%d)%s(%d) : (%d)%s(%d) : (%d)%s(%d) : (%d)%s(%d) : (%d)%s(%d) : (%d)%s(%d) = %d\n",
											                  matrix[a][h], names[a], matrix[a][b], 
											                  matrix[b][a], names[b], matrix[b][c], 
											                  matrix[c][b], names[c], matrix[c][d], 
											                  matrix[d][c], names[d], matrix[d][e],
											                  matrix[e][d], names[e], matrix[e][f],
											                  matrix[f][e],	names[f], matrix[f][g],
																				matrix[g][f],	names[g], matrix[g][h], 
																				matrix[h][g], names[h], matrix[h][a], val);
											//@on
											highest = val;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(highest);
		
		br.close();
	}
	
	//day 12.2 var sum=0;function a(o){if(typeof o=="number")return parseInt(o);if(typeof o=="string")return 0;var s=0;for(var i in o){if (isNaN(parseInt(i)) && o[i]=="red") return 0;}for(var i in o)s+=a(o[i]);return s;}console.log(a(v));
	//day 12.1 var sum=0;function a(o){if(typeof o=="number")return parseInt(o);if(typeof o=="string")return 0;var s=0;for(var i in o)s+=a(o[i]);return s;}console.log(a(v));
	
	public static void Day11() {
		String s = "hxbxwxba" /*"hxbxxyzz"*//*part 2*/;
		int[] string = new int[8];
		for (int i = 0; i < 8; i++)
			string[i] = s.charAt(i) - 'a';
		int[] start = new int[8];
		System.arraycopy(string, 0, start, 0, 8);
		
		boolean wrapped = false;
		ArrayList<Integer> pairChars = new ArrayList<>();
		while (true) {
			if (wrapped && string[0] > start[0]) break;
			string[7]++;
			for (int i = 7; i >= 0; i--) {
				if (string[i] == ('i' - 'a') || string[i] == ('o' - 'a') || string[i] == ('l' - 'a')) string[i]++;
				if (string[i] > 25) {
					string[i] %= 26;
					if (i > 0) string[i - 1]++;
					else wrapped = true;
				}
			}
			
			boolean abc = false;
			for (int i = 0; i < 5; i++) {
				if (string[i] == string[i + 1] - 1 && string[i] == string[i + 2] - 2) {
					abc = true;
					break;
				}
			}
			if (!abc) continue;
			
			pairChars.clear();
			int pairs = 0;
			for (int i = 0; i < 7; i++) {
				if (string[i] == string[i + 1] && !pairChars.contains(string[i])) {
					pairChars.add(string[i]);
					pairs++;
				}
				if (pairs >= 2) break;
			}
			
			if (pairs >= 2) break;
		}
		
		System.out.println("---");
		for (int i = 0; i < 8; i++)
			System.out.print((char) ('a' + string[i]));
		System.out.println("");
	}
	
	public static void Day10() {
		String s = "1113222113", t = s;
		
		for (int iun = 0; iun < 40/*50*//*part 2*/; iun++) {
			long time = System.currentTimeMillis();
			s = new String(t);
			t = "";
			
			int cC = 0;
			int cN = 0;
			for (int i = 0; i < s.length(); i++) {
				int c = Integer.parseInt(s.substring(i, i + 1));
				if (c == cN) {
					cC++;
				} else {
					if (cN == 0) {
						cC = 1;
						cN = c;
					} else {
						t += cC + "" + cN;
						cC = 1;
						cN = c;
					}
				}
			}
			t += cC + "" + cN;
			System.out.println(iun + " (" + NumberFormat.getInstance().format(t.length()) + ") " + NumberFormat.getInstance().format(System.currentTimeMillis() - time) + "ms");
		}
		
		System.out.println(t.length());
	}
	
	public static int Day9_Factorial(int n) {
		if (n == 0 || n == 1) return 1;
		return n * Day9_Factorial(n - 1);
	}
	
	public static void Day9() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day9.txt")));
		String line = "";
		
		int[][] matrix = new int[8][8];
		final String[] locs = { "Faerun", "Norrath", "Tristram", "AlphaCentauri", "Arbre", "Snowdin", "Tambi", "Straylight" };
		ArrayList<String> locations = new ArrayList<>();
		for (String s : locs)
			locations.add(s);
		while ((line = br.readLine()) != null) {
			String[] s = line.split(" ");
			matrix[locations.indexOf(s[0])][locations.indexOf(s[2])] = Integer.parseInt(s[4]);
			matrix[locations.indexOf(s[2])][locations.indexOf(s[0])] = Integer.parseInt(s[4]);
		}
		
		HashMap<String, Integer> paths = new HashMap<>();
		int smallest = Integer.MAX_VALUE;
		int longest = 0;
		for (int a = 0; a < 8; a++) {
			for (int b = 0; b < 8; b++) {
				if (b == a) continue;
				for (int c = 0; c < 8; c++) {
					if (c == b || c == a) continue;
					for (int d = 0; d < 8; d++) {
						if (d == c || d == b || d == a) continue;
						for (int e = 0; e < 8; e++) {
							if (e == d || e == c || e == b || e == a) continue;
							for (int f = 0; f < 8; f++) {
								if (f == e || f == d || f == c || f == b || f == a) continue;
								for (int g = 0; g < 8; g++) {
									if (g == f || g == e || g == d || g == c || g == b || g == a) continue;
									for (int h = 0; h < 8; h++) {
										if (h == g || h == f || h == e || h == d || h == c || h == b || h == a) continue;
										int val = matrix[a][b] + matrix[b][c] + matrix[c][d] + matrix[d][e] + matrix[e][f] + matrix[f][g] + matrix[g][h];
										if (val < smallest) {
											smallest = val;
											//											System.out.println(String.format("%s -> %s(%d) -> %s(%d) -> %s(%d) -> %s(%d) -> %s(%d) -> %s(%d) -> %s(%d) = %d", locs[a], locs[b], matrix[a][b], locs[c], matrix[b][c], locs[d], matrix[c][d], locs[e], matrix[d][e], locs[f], matrix[e][f], locs[g], matrix[f][g], locs[h], matrix[g][h], val));
										}
										if (val > longest) longest = val;
										paths.put(locs[a] + "->" + locs[b] + "->" + locs[c] + "->" + locs[d] + "->" + locs[e] + "->" + locs[f] + "->" + locs[g] + "->" + locs[h], val);
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(smallest);
		System.out.println(longest);
		
		
		br.close();
	}
	
	public static void Day8() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day8.txt")));
		
		String c = "", s = "", t = "";
		while ((c = br.readLine()) != null) {
			s += c;
			t += "\"" + c.replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
		}
		System.out.println(t.length() - s.length());
		br.close();
	}
	
	public static class Day7_Node {
		String src;
		String op;
		String name, lName, rName;
		/**
		 * either shift value or fixed number
		 */
		int parameter = -1;
		
		int value = -1;
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Day7_Node) return src.equals(((Day7_Node) obj).src);
			else return false;
		}
		
		@Override
		public String toString() {
			return name;
		}
		
		public boolean isFixed() {
			return lName == null && rName == null && parameter >= 0;
		}
		
		public int getValue(HashMap<String, Day7_Node> nodes) {
			if (value == -1) value = calcValue(nodes);
			return value;
		}
		
		private int calcValue(HashMap<String, Day7_Node> nodes) {
			if (isFixed()) return parameter;
			int lValue = lName != null ? nodes.get(lName).getValue(nodes) : parameter;
			int rValue = rName != null ? nodes.get(rName).getValue(nodes) : parameter;
			
			if (op == null) return lValue;
			
			switch (op) {
				case "NOT":
					return ~rValue;
				case "AND":
					return lValue & rValue;
				case "OR":
					return lValue | rValue;
				case "RSHIFT":
					return lValue >> rValue;
				case "LSHIFT":
					return lValue << rValue;
				default: {
					System.out.println("oh hello");
					return 6;
				}
			}
		}
	}
	
	public static Day7_Node Day7_root = null;
	
	public static void Day7() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day7.txt")));
		String line = "";
		
		HashMap<String, Day7_Node> nodes = new HashMap<>();
		
		while ((line = br.readLine()) != null) {
			line = line.trim();
			if (line.length() == 0) continue;
			Day7_Node n = new Day7_Node();
			String[] s = line.split(" ");
			n.src = line;
			n.name = s[s.length - 1];
			if (s[0].equals("NOT")) {
				n.op = "NOT";
				n.rName = s[1];
			} else if (s[1].equals("->")) {
				if (s[0].matches("\\d+")) n.parameter = Integer.parseInt(s[0]);
				else n.lName = s[0];
			} else {
				if (s[0].matches("\\d+")) n.parameter = Integer.parseInt(s[0]);
				else n.lName = s[0];
				n.op = s[1];
				if (s[2].matches("\\d+")) n.parameter = Integer.parseInt(s[2]);
				else n.rName = s[2];
			}
			if (n.name.equals("a")) Day7_root = n;
			else nodes.put(n.name, n);
		}
		
		int value = Day7_root.getValue(nodes);
		// part 2
		
		System.out.println(value);
		nodes.values().forEach(e -> e.value = -1);
		Day7_root.value = -1;
		
		System.out.println(nodes.get("b").src);
		nodes.get("b").parameter = value;
		
		System.out.println(Day7_root.getValue(nodes));
		
		br.close();
	}
	
	
	public static void Day6_2() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day6.txt")));
		String line = "";
		
		int[][] grid = new int[1000][1000];
		while ((line = br.readLine()) != null) {
			line = line.trim();
			if (line.length() == 0) continue;
			
			String[] s = line.split(" ");
			int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
			String s1 = "";
			if (s[0].equals("toggle")) s1 = s[1];
			else s1 = s[2];
			x1 = Integer.parseInt(s1.split(",")[0]);
			y1 = Integer.parseInt(s1.split(",")[1]);
			
			x2 = Integer.parseInt(s[s.length - 1].split(",")[0]);
			y2 = Integer.parseInt(s[s.length - 1].split(",")[1]);
			
			for (int x = x1; x <= x2; x++) {
				for (int y = y1; y <= y2; y++) {
					if (s[0].equals("toggle")) grid[x][y] += 2;
					else if (s[1].equals("off")) grid[x][y] = Math.max(0, grid[x][y] - 1);
					else if (s[1].equals("on")) grid[x][y]++;
				}
			}
		}
		
		int lit = 0;
		for (int x = 0; x < 1000; x++) {
			for (int y = 0; y < 1000; y++) {
				lit += grid[x][y];
			}
		}
		System.out.println(lit);
		br.close();
	}
	
	
	public static void Day6_1() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day6.txt")));
		String line = "";
		
		boolean[][] grid = new boolean[1000][1000];
		while ((line = br.readLine()) != null) {
			line = line.trim();
			if (line.length() == 0) continue;
			
			String[] s = line.split(" ");
			int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
			String s1 = "";
			if (s[0].equals("toggle")) s1 = s[1];
			else s1 = s[2];
			x1 = Integer.parseInt(s1.split(",")[0]);
			y1 = Integer.parseInt(s1.split(",")[1]);
			
			x2 = Integer.parseInt(s[s.length - 1].split(",")[0]);
			y2 = Integer.parseInt(s[s.length - 1].split(",")[1]);
			
			for (int x = x1; x <= x2; x++) {
				for (int y = y1; y <= y2; y++) {
					if (s[0].equals("toggle")) grid[x][y] = !grid[x][y];
					else if (s[1].equals("off")) grid[x][y] = false;
					else if (s[1].equals("on")) grid[x][y] = true;
				}
			}
		}
		
		int lit = 0;
		for (int x = 0; x < 1000; x++) {
			for (int y = 0; y < 1000; y++) {
				if (grid[x][y]) lit++;
			}
		}
		System.out.println(lit);
		br.close();
	}
	
	
	public static void Day5_2() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day5.txt")));
		String line = "";
		int nice = 0;
		while ((line = br.readLine()) != null) {
			System.out.println("");
			line = line.trim();
			if (line.length() == 0) continue;
			//			if (line.contains("ab") || line.contains("cd") || line.contains("pq") || line.contains("xy")) continue;
			HashMap<String, Point> map = new HashMap<>();
			String last = "";
			String prevToLast = "";
			boolean doubled = false;
			lines: for (int i = 0; i < line.length(); i++) {
				String s = line.substring(i, i + 1);
				
				if (last.length() > 0) {
					Point p = map.getOrDefault(last + s, new Point(0, -1));
					if (p.y == -1 || p.y < i - 1) {
						p.x++;
						p.y = i;
						System.out.print(last + s);
						map.put(last + s, p);
					}
				}
				
				if (prevToLast.length() > 0 && s.equals(prevToLast)) doubled = true;
				
				if (doubled && i == line.length() - 1) {
					//					System.out.println("---");
					for (Iterator<Entry<String, Point>> iter = map.entrySet().iterator(); iter.hasNext();) {
						Entry<String, Point> e = iter.next();
						//						System.out.println(e);
						if (e.getValue().x >= 2) {
							nice++;
							break lines;
						}
					}
				}
				
				prevToLast = last;
				last = s;
				
			}
		}
		System.out.println(nice);
		br.close();
	}
	
	
	public static void Day5_1() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day5.txt")));
		String line = "";
		int nice = 0;
		while ((line = br.readLine()) != null) {
			line = line.trim();
			if (line.length() == 0) continue;
			if (line.contains("ab") || line.contains("cd") || line.contains("pq") || line.contains("xy")) continue;
			int vowels = 0;
			boolean doubled = false;
			String last = "";
			for (int i = 0; i < line.length(); i++) {
				String s = line.substring(i, i + 1);
				if ("aeiou".indexOf(s) > -1) vowels++;
				if (last.length() > 0 && s.equals(last)) doubled = true;
				last = s;
				if (vowels >= 3 && doubled) {
					System.out.println(line);
					nice++;
					break;
				}
			}
		}
		System.out.println(nice);
		br.close();
	}
	
	
	public static void Day4() throws NoSuchAlgorithmException {
		String secret = "bgvyzdsv";
		int num = 1;
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		while (true) {
			String s = DatatypeConverter.printHexBinary(md.digest((secret + num).getBytes()));
			if (s.startsWith("000000")) {
				System.out.println(num + ", " + s);
				break;
			}
			num++;
		}
	}
	
	// day3.2var x1=0,x2=0,y1=0,y2=0,houses=["0_0"],amount;for(i=0;i<v.length-1;i++){var s=v.substring(i,i+1);if(s=="^"){if(i%2==0)y1++;else y2++;}if(s=="<"){if(i%2==0)x1--;else x2--;}if(s==">"){if(i%2==0)x1++;else x2++;}if(s=="v"){if(i%2==0)y1--;else y2--;}var str=(i%2==0?x1:x2)+"_"+(i%2==0?y1:y2);if(houses.indexOf(str) == -1)houses.push(str);}
	// day3.1var x=0,y=0,houses=["0_0"],amount;for(i=0;i<v.length-1;i++){var s=v.substring(i,i+1);if(s=="^")y++;if(s=="<")x++;if(s==">")x--;if(s=="v")y--;if(houses.indexOf(x+"_"+y) == -1)houses.push(x+"_"+y);}
	
	// day2.2 var ribbonAll=0;for(i in presents){if(presents[i].indexOf("x") == -1) continue;var s=presents[i].split("x"),l=parseInt(s[0]),w=parseInt(s[1]),h=parseInt(s[2]),ribbon=Math.min(2*(l+w),Math.min(2*(w+h),2*(h+l))) + l*w*h;ribbonAll+=ribbon;}
	// day2.1 for(i in presents){if(presents[i].indexOf("x") == -1) continue;var s=presents[i].split("x"),l=parseInt(s[0]),w=parseInt(s[1]),h=parseInt(s[2]),paper=2*l*w+2*w*h+2*h*l+Math.min(l*w,Math.min(w*h,h*l));console.log(s);paperAll+=paper;}
	
	//	public static void Day1() {
	//		int pos = 0;
	//		for (int i = 0; i < Day1.length(); i++) {
	//			if (Day1.charAt(i) == '(') pos++;
	//			else pos--;
	//			
	//			if (pos == -1) System.out.println(i + 1);
	//		}
	//		
	//		System.out.println(pos);
	//	}
}
