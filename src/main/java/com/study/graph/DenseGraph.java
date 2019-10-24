package com.study.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 稠密图 - 使用邻接矩阵实现
 *
 * @author Created by Daniel
 */
public class DenseGraph implements Graph {

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
     * 矩阵
     */
    private boolean[][] g;

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        for (int i = 0; i < n; i++) {
            g = new boolean[n][n];
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

        if (hasEdge(v, w)) {
            return;
        }
        g[v][w] = true;
        // 如果是无向图
        if (!directed) {
            g[w][v] = true;
        }
        // 边数+1
        m++;
    }

    @Override
    public void show() {

    }

    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        return g[v][w];
    }

    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        List<Integer> adjV = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (g[v][i]) {
                adjV.add(i);
            }
        }
        return adjV;
    }
}
