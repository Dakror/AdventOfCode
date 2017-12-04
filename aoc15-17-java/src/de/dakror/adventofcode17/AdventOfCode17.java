/*******************************************************************************
 * Copyright 2017 Maximilian Stark | Dakror <mail@dakror.de>
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

package de.dakror.adventofcode17;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Maximilian Stark | Dakror
 */
public class AdventOfCode17 {
	static String path = "src\\de\\dakror\\adventofcode17\\";
	
	public static void main(String[] args) {
		Day4_b();
	}
	
	static int getSurroundings(HashMap<String, Integer> grid, int x, int y) {
		int sum = 0;
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				int g = grid.getOrDefault((x + i) + ":" + (y + j), -1);
				if (g > -1) sum += g;
			}
		}
		
		return sum;
	}
	
	static void Day3_b() {
		// Answer was 295229
		
		int input = 289326;
		
		HashMap<String, Integer> grid = new HashMap<>();
		int x = 0, y = 0, rad = 1;
		grid.put("0:0", 1);
		for (;;) {
			// right
			x++;
			int num = getSurroundings(grid, x, y);
			if (num >= input) {
				System.out.println(num);
				return;
			}
			grid.put(x + ":" + y, num);
			
			for (int k = 0; k < rad * 2 - 1; k++) {
				y++;
				
				num = getSurroundings(grid, x, y);
				if (num >= input) {
					System.out.println(num);
					return;
				}
				grid.put(x + ":" + y, num);
			}
			for (int k = 0; k < rad * 2; k++) {
				x--;
				
				num = getSurroundings(grid, x, y);
				if (num >= input) {
					System.out.println(num);
					return;
				}
				grid.put(x + ":" + y, num);
			}
			
			for (int k = 0; k < rad * 2; k++) {
				y--;
				
				num = getSurroundings(grid, x, y);
				if (num >= input) {
					System.out.println(num);
					return;
				}
				grid.put(x + ":" + y, num);
			}
			
			for (int k = 0; k < rad * 2; k++) {
				x++;
				
				num = getSurroundings(grid, x, y);
				if (num >= input) {
					System.out.println(num);
					return;
				}
				grid.put(x + ":" + y, num);
			}
			
			rad++;
		}
	}
	
	static void Day4_a() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day4.txt")));
			System.out.println(br.lines().mapToInt(x -> {
				if (x.trim().length() == 0) return 0;
				String[] s = x.split(" ");
				return Arrays.stream(s).distinct().count() == s.length ? 1 : 0;
			}).sum());
			// 451
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void Day4_b() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day4.txt")));
			System.out.println(br.lines().mapToInt(x -> {
				String[] s = x.split(" ");
				return s.length == Arrays.stream(s).map(y -> (String) y.codePoints().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString()).distinct().count() ? 1 : 0;
			}).sum());
			// 451
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
