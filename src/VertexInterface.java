import java.util.Iterator;
/************************************************************
 * File:    VertexInterface.java
 * Author:  Mora Labisi
 * Course:  CS 241.01 Data Structures and Algorithms II
 *
 * Assignment:  Program Four
 * Due:         Thursday, 11/30/2017
 *
 * Last Modified:   11/24/17
 *
 * Description:
 * This java interface is the implementation of the Vertex
 * object in a Graph. It includes the method signatures
 * for the required functions of a Vertex.
 ************************************************************/
public interface VertexInterface<T> extends Comparable<VertexInterface<T>> {

    /**
     * method:  getLabel
     * purpose: gets this vertex's label
     *
     * @return  the object that labels the vertex
     */
    public T getLabel();

    /**
     * method:  visit
     * purpose: marks this vertex as visited
     */
    public void visit();

    /**
     * method:  unvisit
     * purpose: removes the visited mark for this vertex
     */
    public void unvisit();

    /**
     * method:  isVisited
     * purpose: checks whether this vertex has been visited
     *
     * @return  true or false depending on whether or not
     *          this vertex has been visited
     */
    public boolean isVisited();

    /**
     * method:  connect
     * purpose: connects this vertex to a given vertex with a
     *          weighted edge
     *
     * @param end   the vertex that ends the egde
     * @param weight    the weight of the edge
     * @return  true or false depending on whether or not the
     *          edge was added
     */
    public boolean connect(VertexInterface<T> end, int weight);

    /**
     * method:  getNeighborIterator
     * purpose: creates an iterator of this vertex's neighbors
     *
     * @return  an iterator of neighboring vertices
     */
    public Iterator<VertexInterface<T>> getNeighborIterator();

    /**
     * method:  getWeightIterator
     * purpose: creates an iterator of the weights of the edges
     *          that connect this vertex to its neighbors
     *
     * @return  an iterator of edge weights
     */
    public Iterator<Integer> getWeightIterator();

    /**
     * method:  hasNeighbor
     * purpose: checks whether this vertex has neighbor(s)
     *
     * @return  true or false depending on whether or not this
     *          vertex has a neighbor
     */
    public boolean hasNeighbor();

    /**
     * method:  getUnvisitedNeighbor
     * purpose: gets an unvisited neighbor of this vertex
     *
     * @return  the unvisited neighbor vertex or null if
     *          no such vertex is found
     */
    public VertexInterface<T> getUnvisitedNeighbor();

    /**
     * method:  setPredecessor
     * purpose: records a previous vertex on the path to this vertex
     *
     * @param predecessor the previous vertex
     */
    public void setPredecessor(VertexInterface<T> predecessor);

    /**
     * method:  getPredecessor
     * purpose: gets the recorded predecessor of this vertex
     *
     * @return  the predecessor or null if not found
     */
    public VertexInterface<T> getPredecessor();

    /**
     * method:  hasPredecessor
     * purpose: checks if a predecessor has been recorded
     *
     * @return  true or false depending on whether or not
     *          a predecessor was recorded
     */
    public boolean hasPredecessor();

    /**
     * method:  setCost
     * purpose: records the shortest weight of a path
     *          to this vertex
     */
    public void setCost(int weight);

    /**
     * method:  getCost
     * purpose: gets the recorded cost of the path to this
     *          vertex
     *
     * @return  the cost of the path
     */
    public int getCost();

    /**
     * method:  compareTo
     * purpose: accurately compares two vertices
     *
     * @param other the other Vertex
     * @return the appropriate integer representation
     * of the comparison
     */
    @Override
    public int compareTo(VertexInterface<T> other);
}
