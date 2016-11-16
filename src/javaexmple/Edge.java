package javaexmple;

public class Edge {
        public int u;
        public int v;
         
        public Edge(int u,int v) {
			// TODO Auto-generated constructor stub
        	this.u = u;
        	this.v = v;
		}

		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return u ==((Edge) obj).u && v == ((Edge)obj).v;
		}
        
}
