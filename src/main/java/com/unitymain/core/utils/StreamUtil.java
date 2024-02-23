package com.unitymain.core.utils;

import java.util.*;

public class StreamUtil {


    String[][] map = new String[][]{
            {"⚫", "⚫", "⚫", "⚫", "🚫", "🚫", "🚫", "🚫", "🚫", "⚫"},
            {"⚫", "🚫", "🚫", "🚫", "⚫", "⚫", "⚫", "⚫", "🚫", "⚫"},
            {"🚫", "🚫", "⭕", "⚫", "📦", "🚫", "🚫", "⚫", "🚫", "⚫"},
            {"🚫", "⭕", "⭕", "📦", "⚫", "📦", "⚫", "⚫", "😀", "🚫"},
            {"🚫", "⭕", "⭕", "⚫", "📦", "⚫", "📦", "⚫", "🚫", "🚫"},
            {"🚫", "🚫", "🚫", "🚫", "🚫", "🚫", "⚫", "⚫", "🚫", "⚫"},
            {"⚫", "⚫", "⚫", "⚫", "🚫", "🚫", "🚫", "🚫", "🚫", "⚫"},
    };
    Map<String,Integer> ps = new HashMap<String, Integer>(){{
        put("x",0);
        put("y",0);
    }};

//    String[] zd = new String[3];
    List<Map<String,Integer>> zd = new ArrayList<>();
    Map<String,String> mp = new HashMap<String,String>(){{
        put("wall", "🚫");
        put("way", "⚫");
        put("person", "😀");
        put("point", "⭕");
        put("box", "📦");
    }};

    public static void main(String[] args) {
        StreamUtil streamUtil = new StreamUtil();
        streamUtil.start();
        streamUtil.find();
        Scanner scanner = new Scanner(System.in);
        while (true){
            String next = scanner.next();
            String nana ="";
            if(next.length()>2){
                nana = next.substring(0,1);
            }else{
                nana = next;
            }
            //上
            if (nana.equals("w")) {
                streamUtil.move(-1, 0);
            }
            //右
            else if (nana.equals("d")) {
                streamUtil.move(0, 1);
            }
            //下
            else if (nana.equals("s")) {
                streamUtil.move(1, 0);
            }
            //左
            else if (nana.equals("a")) {
                streamUtil.move(0, -1);
            }

            streamUtil.flush();
            if (streamUtil.isEnd()) {
                System.out.println("恭喜过关");
                break;
            }
        }

    }

    public void move(int yy, int xx) {
        if (!map[(ps.get("y") + yy)][ps.get("x") + xx].equals(mp.get("wall")) ) {
            if (map[ps.get("y") + yy][ps.get("x") + xx].equals(mp.get("box")) ) {
                if (
                        !map[ps.get("y") + yy + yy][ps.get("x") + xx + xx].equals(mp.get("wall"))  &&
                                !map[ps.get("y") + yy + yy][ps.get("x") + xx + xx].equals(mp.get("box"))
                ) {
                    map[ps.get("y") + yy][ps.get("x") + xx] = mp.get("person");
                    map[ps.get("y") + yy + yy][ps.get("x") + xx + xx] = mp.get("box");
                    map[ps.get("y")][ps.get("x")] = mp.get("way");
                    ps.put("y",ps.get("y") + yy);
                    ps.put("x",ps.get("x") + xx);
                }
            } else {
                map[ps.get("y") + yy][ps.get("x") + xx] = mp.get("person");
                if (isToPoint(ps.get("x"), ps.get("y"))) {
                    map[ps.get("y")][ps.get("x")] = mp.get("point");
                } else {
                    map[ps.get("y")][ps.get("x")] = mp.get("way");
                }
                ps.put("y",ps.get("y") + yy);
                ps.put("x",ps.get("x") + xx);
            }
        }
    }

    public void start() {
        flush();
    }

    public boolean isEnd() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].equals(mp.get("person")) ) {
                    if (isToPoint(j, i)) {
                        return false;
                    }
                }
                if (map[i][j].equals(mp.get("point"))) {
                    for (int k = 0; k < zd.size(); k++) {
                        if (zd.get(k).get("y") == i && zd.get(k).get("x") == j) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean isToPoint(int x, int y) {
        for (int i = 0; i < zd.size(); i++) {
            if (zd.get(i).get("x") == x && zd.get(i).get("y") == y) {
                return true;
            }
        }
        return false;
    }

    public void find() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].equals(mp.get("person")) ) {
                    ps.put("y",i);
                    ps.put("x",j);
                }
                if (map[i][j].equals(mp.get("point")) ) {
                    Map wz = new HashMap<String,Integer>();
                    wz.put("y",i);
                    wz.put("x",j);
                    zd.add(wz);
                }
            }
        }
    }

    public void flush() {
        String str = "";
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                str += map[i][j];
            }
            str += "\n";
        }
        System.out.println(str);
    }
}
