/************************************************************
 * File:    WeightedGraphInterface.java
 * Author:  Mora Labisi
 * Course:  CS 241.01 Data Structures and Algorithms II
 *
 * Assignment:  Program Four
 * Due:         Thursday, 11/30/2017
 *
 * Last Modified:   11/20/17
 *
 * Description:
 * This java interface is the implementation of the Weighted
 * Graph data type. It includes the method signatures
 * for the required functions of a Weighted Graph.
 ************************************************************/
public interface WeightedGraphInterface<T> {

    /**
     * method:  addVertex
     * purpose: adds a given vertex to the graph
     *
     * @param vertexLabel   distinct object that labels the new
     *                      vertex
     * @return  true or false depending on whether or not the
     *          vertex was added
     */
    public boolean addVertex(T vertexLabel);

    /**
     * method:  addEdge
     * purpose: adds a weighted edge between two distinct vertices
     *
     * @param begin an object that labels the origin vertex
     * @param end   an object that labels the destination vertex
     * @param weight    the value of the edge's weight
     * @return  true or false depending on whether or not the edge
     *          was added
     */
    public boolean addEdge(T begin, T end, int weight);

    /**
     * method:  hasEdge
     * purpose: determines if an edge exists between two vertices
     *
     * @param begin an object that labels the origin vertex
     * @param end   an object that labels the destination vertex
     * @return  true or false depending on whether or not an edge
     *          exists
     */
    public boolean hasEdge(T begin, T end);

    /**
     * method:  isEmpty
     * purpose: checks whether or not the graph is empty
     *
     * @return  true or false depending on whether or not the
     *          graph is empty
     */
    public boolean isEmpty();

    /**
     * method:  getNumberOfVertices
     * purpose: gets the number of vertices in the graph
     *
     * @return  the number of vertices
     */
    public int getNumberOfVertices();

    /**
     * method:  getNumberOfEdges
     * purpose: gets the number of edges in the graph
     *
     * @return  the number of edges
     */
    public int getNumberOfEdges();

    /**
     * method:  clear
     * purpose: removes all vertices and edges from the graph
     */
    public void clear();

    /**
     * method:  getShortestPath
     * purpose: uses Dijkstra's algorithm to find the shortest
     *          path between two vertices
     * @param begin an object that labels the origin vertex
     * @param end   an object that labels the destination vertex
     * @return  a message that tells the distance and path of
     *          the shortest path
     */
    public String getShortestPath(T begin, T end);
}
