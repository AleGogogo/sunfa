package javaexmple;

import java.util.List;

public interface Graph<V> {
    public int getSize() ;
    public List<V> getVertics() ;
	public V getVertex(int index) ;
	public int getIndex(V v) ;
	public List<Integer> getNeighbors(int index) ;
	public int getDegree(int v) ;
	public int[][]  getAdjacencyMatrix() ;
	public boolean addEdge(int u,int v) ;
	public boolean addVertex(V vertex) ;
	public AbstractGraph<V>.Tree dfs(int v) ;
	public void printEdges();

}
