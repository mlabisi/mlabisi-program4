import java.util.ArrayList;

/************************************************************
 * File:    DirectedGraph.java
 * Author:  Mora Labisi
 * Course:  CS 241.01 Data Structures and Algorithms II
 *
 * Assignment:  Program Four
 * Due:         Thursday, 11/30/2017
 *
 * Last Modified:   11/21/17
 *
 * Description:
 * This java class is the implementation of the Directed
 * Graph data type. It uses vertices and edges.
 ************************************************************/
public class DirectedGraph<T> implements WeightedGraphInterface<T> {
    private ArrayList<VertexInterface<T>> vertices;
    private int edgeCount;

    // C O N S T R U C T O R

    public DirectedGraph(){
        vertices = new ArrayList<>();
        edgeCount = 0;
    }

    /**
     * method:  addVertex
     * purpose: adds a given vertex to the graph
     *
     * @param vertexLabel distinct object that labels the new
     *                    vertex
     * @return true or false depending on whether or not the
     * vertex was added
     */
    @Override
    public boolean addVertex(T vertexLabel) {
        return vertices.add(new Vertex<>(vertexLabel));
    }

    /**
     * method:  addEdge
     * purpose: adds a weighted edge between two distinct vertices
     *
     * @param begin  an object that labels the origin vertex
     * @param end    an object that labels the destination vertex
     * @param weight the value of the edge's weight
     * @return true or false depending on whether or not the edge
     * was added
     */
    @Override
    public boolean addEdge(T begin, T end, int weight) {
        boolean result = false;

        VertexInterface<T> beginVertex = vertices.get(vertices.indexOf(begin));
        VertexInterface<T> endVertex = vertices.get(vertices.indexOf(end));

        if((beginVertex != null) && (endVertex != null))
            result = beginVertex.connect(endVertex, weight);

        return result;
    }

    /**
     * method:  hasEdge
     * purpose: determines if an edge exists between two vertices
     *
     * @param begin an object that labels the origin vertex
     * @param end   an object that labels the destination vertex
     * @return true or false depending on whether or not an edge
     * exists
     */
    @Override
    public boolean hasEdge(T begin, T end) {
        return false;
    }

    /**
     * method:  isEmpty
     * purpose: checks whether or not the graph is empty
     *
     * @return true or false depending on whether or not the
     * graph is empty
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * method:  getNumberOfVertices
     * purpose: gets the number of vertices in the graph
     *
     * @return the number of vertices
     */
    @Override
    public int getNumberOfVertices() {
        return 0;
    }

    /**
     * method:  getNumberOfEdges
     * purpose: gets the number of edges in the graph
     *
     * @return the number of edges
     */
    @Override
    public int getNumberOfEdges() {
        return 0;
    }

    /**
     * method:  clear
     * purpose: removes all vertices and edges from the graph
     */
    @Override
    public void clear() {

    }

    /**
     * method:  getShortestPath
     * purpose: uses Dijkstra's algorithm to find the shortest
     * path between two vertices
     *
     * @param begin an object that labels the origin vertex
     * @param end   an object that labels the destination vertex
     * @return a message that tells the distance and path of
     * the shortest path
     */
    @Override
    public String getShortestPath(T begin, T end) {
        return null;
    }
}
