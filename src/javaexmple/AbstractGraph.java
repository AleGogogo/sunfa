package javaexmple;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AbstractGraph<V> implements Graph<V> {
	//顶点数组
       protected List<V> vertices = new ArrayList<>();
       //邻接边线性表
       protected List<List<Edge>> neighbors;
       protected AbstractGraph() {
		// TODO Auto-generated constructor stub
	}
       protected AbstractGraph(V[] vertics,int[][] edges){
    	   for (int i = 0; i < vertics.length; i++) {
    		   addVertex(vertics[i]);
		} 
    	   createAdjacenycyLists(edges,vertics.length);
       }
       
       protected AbstractGraph(V[] vertics,List<Edge> edges){
    	   for (int i = 0; i < vertics.length; i++) {
    		   addVertex(vertics[i]);
		} 
    	   createAdjacenycyLists(edges,vertics.length);
       }
       
       protected AbstractGraph(List<V>vertics,List<Edge> edges){
    	   for (int i = 0; i < vertics.size(); i++) {
    		   addVertex(vertics.get(i));
		} 
    	   createAdjacenycyLists(edges,vertics.size());
       }
       protected AbstractGraph(List<Edge> edges,int numberOfVertices){
    	   for (int i = 0; i <numberOfVertices; i++) {
    		   addVertex((V)new Integer(i));
		} 
    	   createAdjacenycyLists(edges,numberOfVertices);
       }
       protected AbstractGraph(int[][] edges,int numberOfVertices){
    	   for (int i = 0; i < numberOfVertices; i++) {
    		   addEdge(edges[i][0], edges[i][1]);
		} 
    	   createAdjacenycyLists(edges,numberOfVertices);
       }
	private void createAdjacenycyLists(int[][] edges, int length) {
		// TODO Auto-generated method stub
		for (int i = 0; i < edges.length; i++) {
			addEdge(edges[i][0], edges[i][1]);
		}
	}
	private void createAdjacenycyLists(List<Edge>edges,int numberOfVertices) {
		for (Edge edge : edges) {
			 addEdge(edge.u, edge.v);
		}
		
	}
	//return 顶点的number
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return vertices.size();
	}

	@Override
	public List<V> getVertics() {
		// TODO Auto-generated method stub
		return vertices;
	}

	@Override
	public V getVertex(int index) {
		// TODO Auto-generated method stub
		return vertices.get(index);
	}


    //return the neighbors of the specified vertex
	@Override
	public List<Integer> getNeighbors(int index) {
		List<Integer> result = new ArrayList<>();
	    for (Edge edge : neighbors.get(index)) {
			   result.add(edge.v);
		}
		return result;
	}

	//return the degree for a specified vertex
	@Override
	public int getDegree(int v) {
		// TODO Auto-generated method stub
		return neighbors.get(v).size();
	}

	@Override
	public int[][] getAdjacencyMatrix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addEdge(int u, int v) {
		return addEdge(new Edge(u, v));
		
	}
	protected boolean addEdge(Edge edge) {
		if (edge.u<0||edge.u>getSize()-1) 
			throw new IllegalArgumentException("No such index : " +edge.u);
		if(edge.v<0||edge.v>getSize()-1)
			throw new IllegalArgumentException("No such index : "+edge.v);
		if (!neighbors.get(edge.u).contains(edge)) {
			  neighbors.get(edge.u).add(edge);
			  return true;
		}
		else {
			return false;
		}
		
	}
	@Override
	public boolean addVertex(V vertex) {
		if (!vertices.contains(vertex)) {
			 vertices.add(vertex);
			 neighbors.add(new ArrayList<Edge>());
			 return true;
		}else {
			return false;
		}
	}
	@Override
	public void printEdges() {
		for (int u = 0; u < neighbors.size(); u++) {
			  System.out.print(getVertex(u) + " ( "+u +" ) : ");
			  for (Edge edge : neighbors.get(u)) {
				  System.out.print(" ( "+getVertex(edge.u) + " , "+
						  getVertex(edge.v) + " ) ");
			}
			  System.out.println();
		}
		
	}
	@Override
	public int getIndex(V v) {
		// TODO Auto-generated method stub
		return vertices.indexOf(v);
	}
	
	class Tree{
		  private int root;
		  private  int[] parent;//Store the parent of each vertex
		  private List<Integer> searchOrder;//Store the search order
		  
		  public Tree(int root,int[] parent,List<Integer> searchOrder) {
			// TODO Auto-generated constructor stub
			  this.parent = parent;
			  this.root = root;
			  this.searchOrder = searchOrder;
		}
			public int getRoot() {
				return root;
			}
		public int  getParent(int v) {
			return parent[v];
		}
		public List<Integer> getSearchOrder() {
			return searchOrder;
		}
		public int getNumberOfVerticesFound() {
			return searchOrder.size();
		}
		
		/**
		 * return the path of vertices from a vertex to the root
		 * @param index
		 * @return
		 */
		public List<V> getPath(int index) {
			 ArrayList<V> path = new ArrayList<>();
			 do {
				  path.add(vertices.get(index));
				  index = parent[index];
			} while (index != -1);
			 return path;
		}
		public void printPath(int index) {
			List<V> path = getPath(index);
			System.out.print("A path from "+vertices.get(root) + "to "+vertices.get(index) + ": ");
			for(int i = path.size()-1;i>=0;i--){
				System.out.print(path.get(i) + " ");
			}
		}
		
		public void printTree() {
			System.out.println("Root is: "+ vertices.get(root));
			System.out.println("Edges : ");
			for(int i =0;i<parent.length;i++){
				if (parent[i] !=-1) {
					 System.out.print("( "+vertices.get(parent[i])+", "+vertices.get(i)+ " )  ");
				}
				System.out.println();
			}
		}
	}

	@Override
	public AbstractGraph<V>.Tree dfs(int v) {
		// TODO Auto-generated method stub
	    
		
		return null;
	}

}
