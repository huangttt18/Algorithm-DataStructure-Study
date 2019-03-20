package com.study.graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 从文件中读取数据来生成图
 * @Author Created by Daniel
 */
public class GraphUtil {

    public static void readGraph(Graph graph, String filename) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            int v, e;
            String[] split = line.split(" ");
            v = Integer.parseInt(split[0]);
            if (v != graph.getN()) {
                return;
            }
            e = Integer.parseInt(split[1]);
            for (int i = 0;i < e;i ++) {
                line = br.readLine();
                String[] splits = line.split(" ");
                int a, b;
                a = Integer.parseInt(split[0]) - 1;
                b = Integer.parseInt(split[1]) - 1;
                graph.addEdge(a, b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
