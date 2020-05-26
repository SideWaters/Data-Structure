// Introduced in Chapter 15
/** A potentially weighted graph. */
public class Graph {

  /**
   * edges[i][j] is the weight of the edge from i to j, or 0 if
   * there is no such edge.
   */
  private double[][] edges;

  /** The argument is the number of vertices in this Graph. */
  public Graph(int vertices) {
    edges = new double[vertices][vertices]; // All zero by default
  }

  /** Add an edge of weight 1 from i to j. */
  public void addEdge(int i, int j) { edges[i][j] = 1; }

  /** Add edges of weight 1 from i to j and from j to i. */
  public void addUndirectedEdge(int i, int j) {
    edges[i][j] = 1;
    edges[j][i] = 1;
  }

  /**
   * Return a list of the vertices reachable from source, in
   * breadth-first order.
   */
  public List<Integer> breadthFirstTraverse(int source) {
    List<Integer> result = new ArrayList<Integer>();
    boolean[] visited = new boolean[size()];
    Queue<Integer> q = new LinkedQueue<Integer>();
    visited[source] = true;
    q.add(source);
    while (!(q.isEmpty())) {
      int vertex = q.remove();
      result.add(vertex);
      for (Integer i : neighbors(vertex)) {
        if (!visited[i]) {
          visited[i] = true;
          q.add(i);
        }
      }
    }
    return result;
  }

  /**
   * Return the index of the smallest element of distances,
   * ignoring those in visited.
   */
  protected int cheapest(double[] distances, boolean[] visited) {
    int best = -1;
    for (int i = 0; i < size(); i++) {
      if (!visited[i]
          && ((best < 0) || (distances[i] < distances[best]))) {
        best = i;
      }
    }
    return best;
  }

  /**
   * Return a list of the vertices reachable from source, in depth-
   * first order.
   */
  public List<Integer> depthFirstTraverse(int source) {
    List<Integer> result = new ArrayList<Integer>();
    boolean[] visited = new boolean[size()];
    depthFirstTraverse(source, result, visited);
    return result;
  }

  /**
   * Visit the vertices reachable from vertex, in depth-first order.
   * Add vertices to result as they are visited.
   */
  protected void depthFirstTraverse(int vertex,
                                    List<Integer> result,
                                    boolean[] visited) {
    visited[vertex] = true;
    result.add(vertex);
    for (Integer i : neighbors(vertex)) {
      if (!visited[i]) {
        depthFirstTraverse(i, result, visited);
      }
    }
  }

  /**
   * Return a two-dimensional array of the distances from each vertex
   * to each other vertex.
   */
  public double[][] distances() {
    double[][] result = new double[size()][size()];
    for (int i = 0; i < size(); i++) {
      for (int j = 0; j < size(); j++) {
        result[i][j] = getCost(i, j);
      }
    }
    for (int midpoint = 0; midpoint < size(); midpoint++) {
      for (int i = 0; i < size(); i++) {
        for (int j = 0; j < size(); j++) {
          result[i][j] = Math.min(result[i][j],
                                  result[i][midpoint]
                                  + result[midpoint][j]);
        }
      }
    }
    return result;
  }

  /**
   * Return an array of the distances from source to each other
   * vertex.
   */
  public double[] distancesFrom(int source,String[]path) {
    double[] result = new double[size()];
    java.util.Arrays.fill(result, Double.POSITIVE_INFINITY);
    for(int i=source;i<size();i++) {
    	path[i]=""+i;
    }
    result[source] = 0;
    boolean[] visited = new boolean[size()];
    for (int i = 0; i < size(); i++) {
      int vertex = cheapest(result, visited);
      visited[vertex] = true;
      for (int j = 0; j < size(); j++) {
    	  if(result[vertex]+getCost(vertex, j)<result[j]) {    
    		  result[j] =result[vertex] + getCost(vertex, j);
              path[j]=path[vertex]+"→"+j;
      }
    }}
    return result;
  }

  /** Return the cost to go directly from i to j. */
  public double getCost(int i, int j) {
    if (i == j) {
      return 0.0;
    }
    if (edges[i][j] == 0.0) {
      return Double.POSITIVE_INFINITY;
    }
    return edges[i][j];
  }

  /** Return the weight of the edge from i to j. */
  public double getEdge(int i, int j) {
    return edges[i][j];
  }

  /** Return true if there is an edge from i to j. */
  public boolean hasEdge(int i, int j) {
    return edges[i][j] != 0.0;
  }

  /** Return a minimum spanning tree for this Graph. */
  public Graph minimumSpanningTree() {
    DisjointSetCluster partition = new DisjointSetCluster(size());
    Graph result = new Graph(size());
    Heap<Edge> edges = new Heap<Edge>();
    for (int i = 0; i < size(); i++) {
      for (Integer j : neighbors(i)) {
        edges.add(new Edge(i, j, getEdge(i, j)));
      }
    }
    while (!(edges.isEmpty())) {
      Edge e = edges.remove();
      int i = e.getSource();
      int j = e.getDest();
      if (!(partition.inSameSet(i, j))) {
        partition.mergeSets(i, j);
        result.setUndirectedEdge(i, j, e.getWeight());
      }
    }
    return result;
  }

  /** Return a List of the neighbors of vertex i. */
  public List<Integer> neighbors(int i) {
    List<Integer> result = new ArrayList<Integer>();
    for (int j = 0; j < size(); j++) {
      if (hasEdge(i, j)) {
        result.add(j);
      }
    }
    return result;
  }

  /** Set the weight of the edge from i to j. */
  public void setEdge(int i, int j, double weight) {
    edges[i][j] = weight;
  }

  /** Set the weight of the edge from i to j and from j to i. */
  public void setUndirectedEdge(int i, int j, double weight) {
    edges[i][j] = weight;
    edges[j][i] = weight;
  }

  /** Return the number of vertices in this Graph. */
  public int size() {
    return edges.length;
  }

  /** Return a topological sort of this directed acyclic Graph. */
  public List<Integer> topologicalSort() {
    LinkedList<Integer> result = new LinkedList<Integer>();
    boolean[] visited = new boolean[size()];
    for (int i = 0; i < size(); i++) {
      if (!visited[i]) {
        topologicalTraverse(i, result, visited);
      }
    }
    return result;
  }

  /**
   * Visit the vertices reachable from vertex in depth-first
   * postorder, adding them to result.  The array visited
   * prevents any vertex from being visited more than once.
   */
  protected void topologicalTraverse(int vertex,
                                     LinkedList<Integer> result,
                                     boolean[] visited) {
    visited[vertex] = true;
    for (Integer i : neighbors(vertex)) {
      if (!visited[i]) {
        topologicalTraverse(i, result, visited);
      }
    }
    result.setNext(new ListNode<Integer>(vertex, result.getNext()));
  }
  
  public static void main(String[] args) {
    Graph g = new Graph(6);
    g.addEdge(0, 1);
    g.addEdge(1, 2);
    g.addEdge(2, 5);
    g.addEdge(0, 3);
    g.addEdge(3, 4);
    g.addEdge(4, 5);
    String[]a=new String[6];
    System.out.println(g.depthFirstTraverse(0));
    System.out.println(g.breadthFirstTraverse(0));
    System.out.println(g.topologicalSort());
    System.out.println(java.util.Arrays.toString(g.distancesFrom(0,a)));
    for(int i=0;i<a.length;i++) {
    	System.out.print(a[i]+" ");
    }
    System.out.println(java.util.Arrays.deepToString(g.distances()));
    System.out.println(java.util.Arrays.deepToString(g.minimumSpanningTree().edges));
  }
  
}
