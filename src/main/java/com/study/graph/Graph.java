package com.study.graph;

/**
 * 图接口，方便使用泛型
 * @Author Created by Daniel
 */
public interface Graph {
    /**
     * 获取点数量
     * @return
     */
    int getN();

    /**
     * 获取边数量
     * @return
     */
    int getM();

    /**
     * 添加边
     * @param v
     * @param w
     */
    void addEdge(int v, int w);

    /**
     * 打印图
     */
    void show();
}
