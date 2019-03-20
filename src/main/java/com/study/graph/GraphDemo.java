package com.study.graph;

/**
 * @Author Created by Daniel
 */
public class GraphDemo {

    public static void main(String[] args) {
        String filename = "src/main/java/com/study/graph/graph1.txt";
        SparseGraph sparseGraph = new SparseGraph(13, false);
        GraphUtil.readGraph(sparseGraph, filename);
        sparseGraph.show();
    }
}
