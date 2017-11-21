import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/************************************************************
 * File:    Vertex.java
 * Author:  Mora Labisi
 * Course:  CS 241.01 Data Structures and Algorithms II
 *
 * Assignment:  Program Four
 * Due:         Thursday, 11/30/2017
 *
 * Last Modified:   11/21/17
 *
 * Description:
 * This java class is the implementation of the Vertex
 * object to be used in a Graph. It includes an inner class
 * that represents the Edge object and a Neighbor Iterator.
 ************************************************************/
public class Vertex<T> implements VertexInterface<T>{
    private T data;
    private ArrayList<Edge> edgeList;
    private VertexInterface<T> previous;
    private boolean visited;
    private int weight;

    // C O N S T R U C T O R

    /**
     * This is the default constructor for the Vertex class
     *
     * @param data  the data that this vertex will hold
     */
    public Vertex(T data){
        this.data = data;
        edgeList = new ArrayList<>();
        visited = false;
        previous = null;
        weight = 0;
    }

    /**
     * method:  getLabel
     * purpose: gets this vertex's label
     *
     * @return the object that labels the vertex
     */
    @Override
    public T getLabel() {
        return null;
    }

    /**
     * method:  visit
     * purpose: marks this vertex as visited
     */
    @Override
    public void visit() {

    }

    /**
     * method:  unvisit
     * purpose: removes the visited mark for this vertex
     */
    @Override
    public void unvisit() {

    }

    /**
     * method:  isVisited
     * purpose: checks whether this vertex has been visited
     *
     * @return true or false depending on whether or not
     * this vertex has been visited
     */
    @Override
    public boolean isVisited() {
        return false;
    }

    /**
     * method:  connect
     * purpose: connects this vertex to a given vertex with a
     * weighted edge
     *
     * @param end    the vertex that ends the egde
     * @param weight the weight of the edge
     * @return true or false depending on whether or not the
     * edge was added
     */
    @Override
    public boolean connect(VertexInterface<T> end, int weight) {
        return false;
    }

    /**
     * method:  getNeighborIterator
     * purpose: creates an iterator of this vertex's neighbors
     *
     * @return an iterator of neighboring vertices
     */
    @Override
    public Iterator<VertexInterface<T>> getNeighborIterator() {
        return null;
    }

    /**
     * method:  getWeightIterator
     * purpose: creates an iterator of the weights of the edges
     * that connect this vertex to its neighbors
     *
     * @return an iterator of edge weights
     */
    @Override
    public Iterator<Integer> getWeightIterator() {
        return null;
    }

    /**
     * method:  hasNeighbor
     * purpose: checks whether this vertex has neighbor(s)
     *
     * @return true or false depending on whether or not this
     * vertex has a neighbor
     */
    @Override
    public boolean hasNeighbor() {
        return false;
    }

    /**
     * method:  getUnvisitedNeighbor
     * purpose: gets an unvisited neighbor of this vertex
     *
     * @return the unvisited neighbor vertex or null if
     * no such vertex is found
     */
    @Override
    public VertexInterface<T> getUnvisitedNeighbor() {
        return null;
    }

    /**
     * method:  setPredecessor
     * purpose: records a previous vertex on the path to this vertex
     *
     * @param predecessor the previous vertex
     */
    @Override
    public void setPredecessor(VertexInterface<T> predecessor) {

    }

    /**
     * method:  getPredecessor
     * purpose: gets the recorded predecessor of this vertex
     *
     * @return the predecessor or null if not found
     */
    @Override
    public VertexInterface<T> getPredecessor() {
        return null;
    }

    /**
     * method:  hasPredecessor
     * purpose: checks if a predecessor has been recorded
     *
     * @return true or false depending on whether or not
     * a predecessor was recorded
     */
    @Override
    public boolean hasPredecessor() {
        return false;
    }

    /**
     * method:  setCost
     * purpose: records the shortest weight of a path
     * to this vertex
     *
     * @param weight
     */
    @Override
    public void setWeight(int weight) {

    }

    /**
     * method:  getWeight
     * purpose: gets the recorded cost of the path to this
     * vertex
     *
     * @return the cost of the path
     */
    @Override
    public int getWeight() {
        return 0;
    }

//    public String toString(){
//        return data.toString();
//    }

    /**
     * This private inner class represents an edge object.
     */
    private class Edge{
        private VertexInterface<T> dest;
        private int weight;

        public Edge(VertexInterface<T> dest, int weight){
            this.dest = dest;
            this.weight = weight;
        }

        public VertexInterface<T> getDest() {
            return dest;
        }

        public int getWeight() {
            return weight;
        }
    }

    /**
     * This private inner class will deal with edges to a vertex's
     * adjacent vertices.
     */
    private class NeighborIterator implements Iterator<VertexInterface<T>>{
        private Iterator<Edge> edges;

        private NeighborIterator(){
             edges = edgeList.listIterator();
        }

        /**
         * method:  hasNext
         * purpose: returns true if the iteration has more elements.
         *
         * @return true if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return edges.hasNext();
        }

        /**
         * method:  next
         * purpose: returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public VertexInterface<T> next() {
            VertexInterface<T> nextNeighbor = null;
            if(edges.hasNext()){
                Edge edgeToNextNeighbor = edges.next();
                nextNeighbor = edgeToNextNeighbor.getDest();
            } else
                throw new NoSuchElementException();

            return nextNeighbor;
        }
    }
}
