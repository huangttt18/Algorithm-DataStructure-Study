package com.study.graph;

import java.util.ArrayList;

/**
 * 稀疏图 - 使用邻接表实现
 * @Author Created by Daniel
 */
public class SparseGraph implements Graph {

    /**
     * 点
     */
    private int n;
    /**
     * 边
     */
    private int m;
    /**
     * 是否有向
     */
    private boolean directed;

    /**
     * 邻接表
     */
    private ArrayList<Integer>[] g;

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new ArrayList[n];
        for (int i = 0;i < n;i ++) {
            g[i] = new ArrayList<>();
        }
    }

    @Override
    public int getN() {
        return n;
    }

    @Override
    public int getM() {
        return m;
    }

    @Override
    public void addEdge(int v, int w) {
        // 边界条件
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        g[v].add(w);
        // 如果是无向图
        if (v != w && !directed) {
            g[w].add(v);
        }
        // 边数+1
        m ++;
    }

    @Override
    public void show() {
        for (int i = 0;i < n;i ++) {
            StringBuilder sb = new StringBuilder();
            sb.append("vertex " + i + ":\t");
            for (int j = 0;j < g[i].size();j ++) {
                sb.append(g[i].get(j) + "\t\n");
            }
        }
    }

    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        for (int i = 0;i < n;i ++) {
            if (g[v].get(i) == w) {
                return true;
            }
        }
        return false;
    }

    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }
}
