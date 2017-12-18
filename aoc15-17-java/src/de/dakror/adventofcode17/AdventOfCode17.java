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
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeSet;

/**
 * @author Maximilian Stark | Dakror
 */
public class AdventOfCode17 {
    static String path = "src\\de\\dakror\\adventofcode17\\";

    public static void main(String[] args) {
        Day18_b();
    }

    static void Day18_b() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day18.txt")));

            final long[][] registers = new long[2][26];
            registers[1]['p' - 'a'] = 1;

            final List<Long>[] queues = new List[2];
            queues[0] = Collections.synchronizedList(new LinkedList<>());
            queues[1] = Collections.synchronizedList(new LinkedList<>());

            final String[] commands = br.lines().toArray(x -> new String[x]);

            final boolean[] waiting = new boolean[2];

            final long[] sent = new long[2];

            for (int i = 0; i < 2; i++) {
                final int index = i;
                new Thread() {
                    @Override
                    public void run() {
                        long val = 0;
                        for (int i = 0; i < commands.length;) {
                            String[] p = commands[i].split(" ");
                            boolean incr = true;
                            switch (p[0]) {
                            case "snd":
                                try {
                                    val = Integer.parseInt(p[1]);
                                } catch (Exception e) {
                                    val = registers[index][p[1].charAt(0) - 'a'];
                                }
                                //                                System.out.println(index + " sending");
                                synchronized (queues[(index + 1) % 2]) {
                                    queues[(index + 1) % 2].add(val);
                                }
                                System.out.println(index + " sent");
                                sent[index]++;
                                break;
                            case "set":
                                try {
                                    val = Integer.parseInt(p[2]);
                                } catch (Exception e) {
                                    val = registers[index][p[2].charAt(0) - 'a'];
                                }
                                registers[index][p[1].charAt(0) - 'a'] = val;
                                break;
                            case "add":
                                try {
                                    val = Integer.parseInt(p[2]);
                                } catch (Exception e) {
                                    val = registers[index][p[2].charAt(0) - 'a'];
                                }
                                registers[index][p[1].charAt(0) - 'a'] += val;
                                break;
                            case "mul":
                                try {
                                    val = Integer.parseInt(p[2]);
                                } catch (Exception e) {
                                    val = registers[index][p[2].charAt(0) - 'a'];
                                }
                                registers[index][p[1].charAt(0) - 'a'] *= val;
                                break;
                            case "mod":
                                try {
                                    val = Integer.parseInt(p[2]);
                                } catch (Exception e) {
                                    val = registers[index][p[2].charAt(0) - 'a'];
                                }
                                registers[index][p[1].charAt(0) - 'a'] %= val;
                                break;
                            case "jgz":
                                long val1 = 0;
                                try {
                                    val1 = Integer.parseInt(p[1]);
                                } catch (Exception e) {
                                    val1 = registers[index][p[1].charAt(0) - 'a'];
                                }
                                try {
                                    val = Integer.parseInt(p[2]);
                                } catch (Exception e) {
                                    val = registers[index][p[2].charAt(0) - 'a'];
                                }
                                if (val1 > 0) {
                                    i += val;
                                    incr = false;
                                }
                                break;
                            case "rcv":
                                //                                System.out.println(index + " receiving");
                                synchronized (queues[index]) {
                                    if (queues[index].size() > 0) {
                                        registers[index][p[1].charAt(0) - 'a'] = queues[index].remove(0);
                                        System.out.println(index + " received a");

                                        break;
                                    }
                                }

                                int other = (index + 1) % 2;
                                waiting[index] = true;
                                while (queues[index].size() == 0) {//37017
                                    System.out.println(index + " waiting");
                                    if (waiting[other]) {
                                        System.err.println(sent[1]);
                                        System.exit(0);
                                    }
                                }
                                waiting[index] = false;
                                System.out.println(index + " received b");

                                break;
                            }
                            if (incr) i++;
                        }
                    }
                }.start();
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void Day18_a() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day18.txt")));

            long[] registers = new long[26];

            String[] commands = br.lines().toArray(x -> new String[x]);

            long val = 0;
            long played = 0;
            for (int i = 0; i < commands.length;) {
                String[] p = commands[i].split(" ");
                boolean incr = true;
                switch (p[0]) {
                case "snd":
                    played = registers[p[1].charAt(0) - 'a'];
                    break;
                case "set":
                    try {
                        val = Integer.parseInt(p[2]);
                    } catch (Exception e) {
                        val = registers[p[2].charAt(0) - 'a'];
                    }
                    registers[p[1].charAt(0) - 'a'] = val;
                    break;
                case "add":
                    try {
                        val = Integer.parseInt(p[2]);
                    } catch (Exception e) {
                        val = registers[p[2].charAt(0) - 'a'];
                    }
                    registers[p[1].charAt(0) - 'a'] += val;
                    break;
                case "mul":
                    try {
                        val = Integer.parseInt(p[2]);
                    } catch (Exception e) {
                        val = registers[p[2].charAt(0) - 'a'];
                    }
                    registers[p[1].charAt(0) - 'a'] *= val;
                    break;
                case "mod":
                    try {
                        val = Integer.parseInt(p[2]);
                    } catch (Exception e) {
                        val = registers[p[2].charAt(0) - 'a'];
                    }
                    registers[p[1].charAt(0) - 'a'] %= val;
                    break;
                case "jgz":
                    long val1 = 0;
                    try {
                        val1 = Integer.parseInt(p[1]);
                    } catch (Exception e) {
                        val1 = registers[p[1].charAt(0) - 'a'];
                    }
                    try {
                        val = Integer.parseInt(p[2]);
                    } catch (Exception e) {
                        val = registers[p[2].charAt(0) - 'a'];
                    }
                    if (val1 > 0) {
                        i += val;
                        incr = false;
                    }
                    break;
                case "rcv":
                    if (registers[p[1].charAt(0) - 'a'] > 0) {
                        System.out.println(played);
                        // 8600
                        return;
                    }
                    break;
                }
                if (incr) i++;
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void Day17_b() {
        int p = 0;
        int s = 371;
        int val = 0;
        for (int i = 0; i < 50_000_000; i++) {
            p = (p + s) % (i + 1);
            if (p == 0) val = i + 1;
            p++;
        }
        System.out.println(val);
        // 39170601
    }

    static void Day17_a() {
        LinkedList<Integer> buf = new LinkedList<>();
        int p = 0;
        int s = 371;
        buf.add(0);
        for (int i = 0; i < 2017; i++) {
            for (int j = 0; j < s; j++)
                p = (p + 1) % buf.size();
            buf.add(p + 1, i + 1);
            p++;
        }
        System.out.println(buf.get(buf.indexOf(2017) + 1));
        // 1311
    }

    static class Day16_Node {
        char p;
        Day16_Node prev, next;

        public Day16_Node(char c) {
            p = c;
        }

        public void add(char c) {
            if (next == null) {
                next = new Day16_Node(c);
                next.prev = this;
            } else {
                next.add(c);
            }
        }

        @Override
        public String toString() {
            return p + (next != null ? next.toString() : "");//"[" + (prev != null ? prev.p : "") + "]" + p + "," + (next != null ? next : "");
        }

        Day16_Node spin(int num) {
            Day16_Node start = this;
            for (int i = 0; i < 16 - num; i++)
                start = start.next;

            start.prev.next = null;

            Day16_Node end = start;
            while (end.next != null)
                end = end.next;
            end.next = this;
            prev = end;
            start.prev = null;

            return start;
        }

        void swap(int a, int b) {
            Day16_Node n = this;
            Day16_Node m = null;
            Day16_Node o = null;
            for (int i = 0; i < 16; i++) {
                if (i == a) m = n;
                if (i == b) o = n;
                //                if (m != null && o != null) break;
                n = n.next;
            }

            char c = m.p;
            m.p = o.p;
            o.p = c;
        }

        void exchange(int a, int b) {
            Day16_Node n = this;
            Day16_Node m = null;
            Day16_Node o = null;
            for (int i = 0; i < 16; i++) {
                if (n.p == a) m = n;
                if (n.p == b) o = n;
                //                if (m != null && o != null) break;

                n = n.next;
            }

            char c = m.p;
            m.p = o.p;
            o.p = c;
        }
    }

    static void Day16_b() {
        Day16_Node list = new Day16_Node('a');
        for (int i = 1; i < 16; i++) {
            list.add("abcdefghijklmnop".charAt(i));
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day16.txt")));

            String l = br.readLine();

            String[] instr = l.split(",");

            int[][] cache = new int[instr.length][];
            char[] mode = new char[instr.length];

            int a = 0, b = 0;

            //            long sp = 0, xp = 0, pp = 0;
            //            int sc = 0, xc = 0, pc = 0;

            HashMap<String, Integer> strs = new HashMap<String, Integer>();

            for (int i = 0; i < 60; i++) {
                for (int j = 0; j < instr.length; j++) {
                    if (i == 0)
                        mode[j] = instr[j].charAt(0);
                    //                    long t = System.nanoTime();
                    switch (mode[j]) {
                    case 's': {
                        if (cache[j] == null) {
                            a = Integer.parseInt(instr[j].substring(1));
                            cache[j] = new int[] { a };
                        } else {
                            a = cache[j][0];
                        }
                        list = list.spin(a);
                        //                        sp += System.nanoTime() - t;
                        //                        sc++;
                        break;
                    }
                    case 'x': {
                        if (cache[j] == null) {
                            String[] p = instr[j].substring(1).split("\\/");
                            a = Integer.parseInt(p[0]);
                            b = Integer.parseInt(p[1]);
                            cache[j] = new int[] { a, b };
                        } else {
                            a = cache[j][0];
                            b = cache[j][1];
                        }
                        list.swap(a, b);
                        //                        xp += System.nanoTime() - t;
                        //                        xc++;
                        break;
                    }
                    case 'p': {
                        if (cache[j] == null) {
                            String[] p = instr[j].substring(1).split("\\/");
                            a = p[0].charAt(0);
                            b = p[1].charAt(0);
                            cache[j] = new int[] { a, b };
                        } else {
                            a = cache[j][0];
                            b = cache[j][1];
                        }
                        list.exchange(a, b);
                        //                        pp += System.nanoTime() - t;
                        //                        pc++;
                        break;
                    }
                    }
                }

                String s = list.toString();
                Integer o = strs.get(s);
                if (o != null) {
                    System.out.println("Repetition: " + i + " vs. " + o);
                    System.out.println(s);
                } else {
                    strs.put(s, i);
                }

                //                Thread.sleep(50);

                if (i % 100_000 == 0 && i > 0)
                    System.out.println(i/* + ", " + (sp / (double) sc) + ", " + (xp / (double) xc) + ", " + (pp / (double) pc) + ", (" + sc + ", " + xc + ", " + pc + ")"*/);
            }

            for (Entry<String, Integer> e : strs.entrySet()) {
                if (e.getValue() == 1_000_000_000 % 60 - 1) System.out.println(e.getKey());
            }

            // pnhajoekigcbflmd

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void Day16_a() {
        String prog = "abcdefghijklmnop";
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day16.txt")));

            String l = br.readLine();

            String[] instr = l.split(",");
            for (String s : instr) {
                switch (s.charAt(0)) {
                case 's': {
                    int off = prog.length() - Integer.parseInt(s.substring(1));
                    prog = prog.substring(off) + prog.substring(0, off);
                    break;
                }
                case 'x': {
                    String[] p = s.substring(1).split("\\/");
                    int a = Integer.parseInt(p[0]);
                    int b = Integer.parseInt(p[1]);
                    System.out.println(a + ", " + b);
                    if (a < b) {
                        prog = prog.substring(0, a) + prog.charAt(b) + prog.substring(a + 1, b) + prog.charAt(a) + prog.substring(b + 1);
                    } else {
                        prog = prog.substring(0, b) + prog.charAt(a) + prog.substring(b + 1, a) + prog.charAt(b) + prog.substring(a + 1);
                    }
                    break;
                }
                case 'p': {
                    String[] p = s.substring(1).split("\\/");
                    int a = prog.indexOf(p[0]);
                    int b = prog.indexOf(p[1]);
                    if (a < b) {
                        prog = prog.substring(0, a) + prog.charAt(b) + prog.substring(a + 1, b) + prog.charAt(a) + prog.substring(b + 1);
                    } else {
                        prog = prog.substring(0, b) + prog.charAt(a) + prog.substring(b + 1, a) + prog.charAt(b) + prog.substring(a + 1);
                    }
                    break;
                }
                }
            }

            System.out.println(prog);
            // ceijbfoamgkdnlph

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void Day15_b() {
        long a = 699;
        long b = 124;

        int count = 0;

        for (int i = 0; i < 5_000_000; i++) {
            do {
                a = (a * 16807) % Integer.MAX_VALUE;
            } while (a % 4 != 0);
            do {
                b = (b * 48271) % Integer.MAX_VALUE;
            } while (b % 8 != 0);
            if (((short) a) == ((short) b)) count++;
        }

        System.out.println(count);
        // 313
    }

    static void Day15_a() {
        long a = 699;
        long b = 124;

        int count = 0;

        for (int i = 0; i < 40_000_000; i++) {
            a = (a * 16807) % Integer.MAX_VALUE;
            b = (b * 48271) % Integer.MAX_VALUE;
            if (((short) a) == ((short) b)) count++;
        }

        System.out.println(count);
        // 600
    }

    static byte[][] Day14_map = new byte[128][16];

    static void Day14_b() {
        String input = "ljoxqyyw";
        for (int i = 0; i < 128; i++) {
            BigInteger bi = new BigInteger(knotHash(input + "-" + i), 16);
            Day14_map[i] = new byte[16];
            byte[] bs = bi.toByteArray();
            System.arraycopy(bs, Math.max(0, bs.length - 16), Day14_map[i], Math.max(0, 16 - bs.length), 16);
        }
        int groups = 0;
        for (int i = 0; i < 128; i++) {
            for (int j = 0; j < 128; j++) {
                if (Day14_removeGroup(i, j)) groups++;
            }
        }
        System.out.println(groups);
        // 1074
    }

    static boolean Day14_isSet(int x, int y) {

        return ((Day14_map[y][x / 8] >> (7 - (x % 8))) & 1) != 0;
    }

    static void Day14_unset(int x, int y) {
        Day14_map[y][x / 8] &= ~(1 << (7 - (x % 8)));
    }

    static boolean Day14_removeGroup(int x, int y) {
        if (!Day14_isSet(x, y)) return false;

        Day14_unset(x, y);
        if (x > 0) Day14_removeGroup(x - 1, y);
        if (y > 0) Day14_removeGroup(x, y - 1);
        if (x < 127) Day14_removeGroup(x + 1, y);
        if (y < 127) Day14_removeGroup(x, y + 1);

        return true;
    }

    static void Day14_a() {
        String input = "ljoxqyyw";
        int used = 0;
        for (int i = 0; i < 128; i++) {
            BigInteger bi = new BigInteger(knotHash(input + "-" + i), 16);
            used += bi.bitCount();
        }
        System.out.println(used);
        // 8316
    }

    static void Day13_b() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day13.txt")));

            HashMap<Integer, Integer> map = new HashMap<>();
            String s = null;
            int max = 0;
            while ((s = br.readLine()) != null) {
                String[] p = s.split(": ");
                int i = Integer.parseInt(p[0]);
                max = i;
                map.put(i, Integer.parseInt(p[1]));
            }

            int offset = 0;
            while (true) {
                boolean all = true;
                for (int i = 0; i <= max; i++) {
                    int mod = map.getOrDefault(i, 0);
                    if (mod > 0) {
                        if ((i + offset) % (2 * mod - 2) == 0) {
                            all = false;
                            break;
                        }
                    }
                }
                if (!all) {
                    offset++;
                } else {
                    System.out.println(offset);

                    // 3905748
                    break;
                }
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void Day13_a() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day13.txt")));

            HashMap<Integer, Integer> map = new HashMap<>();
            String s = null;
            int max = 0;
            while ((s = br.readLine()) != null) {
                String[] p = s.split(": ");
                int i = Integer.parseInt(p[0]);
                max = i;
                map.put(i, Integer.parseInt(p[1]));
            }

            int severity = 0;
            for (int i = 0; i <= max; i++) {
                int mod = map.getOrDefault(i, 0);
                if (mod > 0) {
                    if (i % (2 * mod - 2) == 0) {
                        severity += i * mod;
                    }
                }
            }

            System.out.println(severity);
            // 788

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static ArrayList<TreeSet<Integer>> Day12_list = new ArrayList<>();

    static TreeSet<Integer> Day12_seen = new TreeSet<>();

    static void Day12_a() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day12.txt")));

            String l = null;
            while ((l = br.readLine()) != null) {
                String[] p = l.substring(l.indexOf("<->") + 4).split(", ");
                TreeSet<Integer> s = new TreeSet<>();
                for (String p1 : p) {
                    s.add(Integer.parseInt(p1));
                }
                Day12_list.add(s);
            }

            int count = Day12_rec(0);

            System.out.println(count);
            // 169

            Day12_seen.clear();

            int concomp = 0;

            while (Day12_seen.size() < Day12_list.size()) {
                for (int i = 0; i < Day12_list.size(); i++) {
                    if (!Day12_seen.contains(i)) {
                        Day12_rec(i);
                        concomp++;
                    }
                }
            }

            System.out.println(concomp);
            // 179

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int Day12_rec(int node) {
        if (Day12_seen.contains(node)) return 0;

        int count = 1;

        Day12_seen.add(node);

        for (int i : Day12_list.get(node)) {
            if (!Day12_seen.contains(i)) {
                count += Day12_rec(i);
                Day12_seen.add(i);
            }
        }

        return count;
    }

    static void Day11() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day11.txt")));

            int x = 0, y = 0, z = 0;
            int max = 0;
            String[] sp = br.readLine().split(",");
            for (String s : sp) {
                switch (s) {
                case "n": {
                    y++;
                    z--;
                    break;
                }
                case "nw": {
                    x--;
                    y++;
                    break;
                }
                case "ne": {
                    x++;
                    z--;
                    break;
                }
                case "sw": {
                    x--;
                    z++;
                    break;
                }
                case "se": {
                    x++;
                    y--;
                    break;
                }
                case "s": {
                    y--;
                    z++;
                    break;
                }
                }

                int dist = (Math.abs(x) + Math.abs(y) + Math.abs(z)) / 2;
                if (dist > max) max = dist;
            }

            System.out.println((Math.abs(x) + Math.abs(y) + Math.abs(z)) / 2);
            System.out.println(max);
            // 743
            // 1493
            // thanks to https://www.redblobgames.com/grids/hexagons/

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static String knotHash(String input) {
        int[] slots = new int[256];
        for (int i = 0; i < slots.length; i++)
            slots[i] = i;

        int[] leng = input.chars().toArray();

        int[] lengths = new int[leng.length + 5];
        System.arraycopy(leng, 0, lengths, 0, leng.length);
        System.arraycopy(new int[] { 17, 31, 73, 47, 23 }, 0, lengths, lengths.length - 5, 5);

        int skip = 0;
        int pos = 0;
        for (int k = 0; k < 64; k++) {
            for (int i = 0; i < lengths.length; i++) {
                // reverse list
                int le = lengths[i];
                for (int j = 0; j < le / 2; j++) {
                    int pa = (pos + j) % slots.length;
                    int pb = (pos + le - j - 1) % slots.length;
                    int a = slots[pa];
                    slots[pa] = slots[pb];
                    slots[pb] = a;
                }
                pos += le + skip;
                skip++;
            }
        }

        String out = "";

        for (int i = 0; i < 16; i++) {
            int dense = 0;
            for (int j = 0; j < 16; j++) {
                dense ^= slots[i * 16 + j];
            }
            String s = Integer.toHexString(dense);
            if (s.length() < 2) s = "0" + s;
            out += s;
        }

        return out;
    }

    static void Day10_b() {
        String hash = knotHash("130,126,1,11,140,2,255,207,18,254,246,164,29,104,0,224");

        System.out.println(hash);
        // e1462100a34221a7f0906da15c1c979a
    }

    static void Day10_a() {
        int[] slots = new int[256];
        for (int i = 0; i < slots.length; i++)
            slots[i] = i;

        int[] lengths = { 130, 126, 1, 11, 140, 2, 255, 207, 18, 254, 246, 164, 29, 104, 0, 224 };
        int skip = 0;
        int pos = 0;
        for (int i = 0; i < lengths.length; i++) {
            // reverse list
            int le = lengths[i];
            for (int j = 0; j < le / 2; j++) {
                int pa = (pos + j) % slots.length;
                int pb = (pos + le - j - 1) % slots.length;
                int a = slots[pa];
                slots[pa] = slots[pb];
                slots[pb] = a;
            }
            pos += le + skip;
            skip++;
            //            System.out.println(Arrays.toString(slots));
        }

        System.out.println(slots[0] * slots[1]);
        // 38628
    }

    static void Day9() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day9.txt")));

            String l = br.readLine();
            int score = 0;
            int depth = 0;
            int garbo = 0;
            boolean garb = false;
            for (int i = 0; i < l.length(); i++) {
                switch (l.charAt(i)) {
                case '{':
                    if (!garb) depth++;
                    else garbo++;
                    break;
                case '}':
                    if (!garb) {
                        score += depth;
                        depth--;
                    } else garbo++;
                    break;
                case '<':
                    if (garb)
                        garbo++;
                    garb = true;
                    break;
                case '>':
                    garb = false;
                    break;
                case '!':
                    i++;
                    break;
                default:
                    if (garb) garbo++;

                }
            }

            System.out.println(score);
            System.out.println(garbo);

            // 10050
            // 4482

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int Day8_max = 0;

    static void Day8() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day8.txt")));

            HashMap<String, Integer> registers = new HashMap<String, Integer>();

            br.lines().forEach(x -> {
                String[] p = x.trim().split(" ");
                int v = registers.getOrDefault(p[4], 0);
                boolean okay = false;
                switch (p[5]) {
                case ">":
                    if (v > Integer.parseInt(p[6])) okay = true;
                    break;
                case "<":
                    if (v < Integer.parseInt(p[6])) okay = true;
                    break;
                case ">=":
                    if (v >= Integer.parseInt(p[6])) okay = true;
                    break;
                case "<=":
                    if (v <= Integer.parseInt(p[6])) okay = true;
                    break;
                case "!=":
                    if (v != Integer.parseInt(p[6])) okay = true;
                    break;
                case "==":
                    if (v == Integer.parseInt(p[6])) okay = true;
                    break;
                }
                if (okay) {
                    int newVal = registers.getOrDefault(p[0], 0) + (p[1].equals("dec") ? -1 : 1) * Integer.parseInt(p[2]);
                    if (newVal > Day8_max) Day8_max = newVal;
                    registers.put(p[0], newVal);
                }
            });
            br.close();

            int max = 0;
            for (Entry<String, Integer> e : registers.entrySet()) {
                if (e.getValue() > max) max = e.getValue();
            }

            System.out.println(max);
            // 4832
            System.out.println(Day8_max);
            // 5443
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static HashMap<String, Integer> Day7_nodes = new HashMap<String, Integer>();
    static HashMap<String, Integer> Day7_weights = new HashMap<String, Integer>();
    static HashMap<String, String[]> Day7_trees = new HashMap<String, String[]>();

    static void Day7_b() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day7.txt")));

            br.lines().forEach(x -> {
                String[] a = x.split("->");
                String[] ax = a[0].trim().split(" ");
                Day7_nodes.put(ax[0].trim(), Integer.parseInt(ax[1].substring(1, ax[1].length() - 1)));
                if (a.length > 1) {
                    Day7_trees.put(ax[0].trim(), a[1].trim().split(", "));
                }
            });
            br.close();

            Day7_b_calculateWeight("mkxke");

            // 268
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int Day7_b_calculateWeight(String node) {
        String[] children = Day7_trees.get(node);
        int myWeight = Day7_nodes.get(node);
        if (children == null) return myWeight;

        HashMap<Integer, ArrayList<String>> weights = new HashMap<Integer, ArrayList<String>>();
        for (String s : children) {
            int weight = Day7_b_calculateWeight(s);

            ArrayList<String> r = weights.getOrDefault(weight, new ArrayList<>());
            r.add(s);
            weights.put(weight, r);
        }

        if (weights.size() > 1) {
            int anyWeight = 0;
            boolean err = false;
            String errName = null;
            int errWeight = 0;
            for (Entry<Integer, ArrayList<String>> e : weights.entrySet()) {
                if (e.getValue().size() == 1) {
                    err = true;
                    errName = e.getValue().get(0);
                    errWeight = e.getKey();
                } else {
                    anyWeight = e.getKey();
                }
            }
            if (err) {
                System.out.println("Alarm! " + errName + " has a different weight. Wanted " + anyWeight + ", got " + errWeight + ". " + errName + " weighs " + Day7_nodes.get(errName));
                return 0;
            }
        }

        return myWeight + children.length * weights.entrySet().iterator().next().getKey();
    }

    static void Day7_a() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day7.txt")));
            HashSet<String> left = new HashSet<String>();
            HashSet<String> right = new HashSet<String>();

            br.lines().forEach(x -> {
                String[] a = x.split("->");
                left.add(a[0].substring(0, a[0].indexOf(" ")));
                if (a.length > 1) {
                    String[] b = a[1].trim().split(", ");
                    for (String s : b)
                        right.add(s);
                }
            });

            left.removeAll(right);
            System.out.println(left);

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void Day6_b() {
        int[] buf = { 5, 1, 10, 0, 1, 7, 13, 14, 3, 12, 8, 10, 7, 12, 0, 6 };
        ArrayList<String> seen = new ArrayList<String>();
        int i = 0;
        while (true) {
            int max = 0, k = 0;
            for (int j = 0; j < buf.length; j++) {
                if (buf[j] > max) {
                    max = buf[j];
                    k = j;
                }
            }

            String str = Arrays.toString(buf);
            int index = seen.indexOf(str);
            if (index > -1) {
                System.out.println(i - index);
                // 1086
                return;
            }
            seen.add(str);

            buf[k] = 0;
            for (int j = 0; j < max; j++) {
                buf[(k + j + 1) % buf.length]++;
            }

            i++;
        }
    }

    static void Day6_a() {
        int[] buf = { 5, 1, 10, 0, 1, 7, 13, 14, 3, 12, 8, 10, 7, 12, 0, 6 };
        HashSet<String> seen = new HashSet<String>();
        int i = 0;
        while (true) {
            int max = 0, k = 0;
            for (int j = 0; j < buf.length; j++) {
                if (buf[j] > max) {
                    max = buf[j];
                    k = j;
                }
            }
            if (!seen.add(Arrays.toString(buf))) break;

            buf[k] = 0;
            for (int j = 0; j < max; j++) {
                buf[(k + j + 1) % buf.length]++;
            }

            System.out.println(Arrays.toString(buf));

            i++;
        }
        System.out.println(i + "");
        // 5042
    }

    static void Day5_b() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day5.txt")));
            int[] arr = br.lines().mapToInt(Integer::parseInt).toArray();
            int i = 0;
            for (int j = 0; j >= 0 && j < arr.length; i++) {
                int o = arr[j];
                if (o >= 3) arr[j]--;
                else arr[j]++;
                j += o;
            }
            System.out.println(i);
            // 27502966
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void Day5_a() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path + "Day5.txt")));
            int[] arr = br.lines().mapToInt(Integer::parseInt).toArray();
            int i = 0;
            for (int j = 0; j >= 0 && j < arr.length; i++) {
                j += arr[j]++;
            }
            System.out.println(i);
            // 373543
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
                return s.length == Arrays.stream(s).map(y -> y.codePoints().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString()).distinct().count() ? 1 : 0;
            }).sum());
            // 451
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
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
}
