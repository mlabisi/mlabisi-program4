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
 * Last Modified:   11/24/17
 *
 * Description:
 * This java class is the implementation of the Vertex
 * object to be used in a Graph. It includes an inner class
 * that represents the Edge object and a Weight and a Neighbor
 * Iterator.
 ************************************************************/
public class Vertex<T> implements VertexInterface<T>{
    private T label;
    private ArrayList<Edge> edgeList;
    private VertexInterface<T> previous;
    private boolean visited;
    private int weight;

    // C O N S T R U C T O R

    /**
     * This is the default constructor for the Vertex class
     *
     * @param label the data that this vertex will hold
     */
    public Vertex(T label) {
        this.label = label;
        edgeList = new ArrayList<>();
        visited = false;
        previous = null;
        weight = 0;
    }

    // G E T T E R S

    /**
     * method:  getLabel
     * purpose: gets this vertex's label
     *
     * @return the object that labels the vertex
     */
    @Override
    public T getLabel() {
        return label;
    }

    /**
     * method:  getDistance
     * purpose: gets the distance of the edge between this vertex
     *          and a given destination vertex
     *
     * @param end   the destination vertex
     * @return  the distance
     */
    public int getDistance(VertexInterface<T> end) {
        int distance = 0;
        for (Edge anEdge : edgeList) {
            if (anEdge.getDest().equals(end)) {
                distance = anEdge.getWeight();
                break;
            }
        }
        return distance;
    }

    /**
     * method:  getNeighborIterator
     * purpose: creates an iterator of this vertex's neighbors
     *
     * @return an iterator of neighboring vertices
     */
    @Override
    public Iterator<VertexInterface<T>> getNeighborIterator() {
        return new NeighborIterator();
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
        return new WeightIterator();
    }

    // P U B L I C   I N S T A N C E   M E T H O D S
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
        boolean result = false;
        if (!this.equals(end)) {
            Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
            boolean duplicateEdge = false;

            while (!duplicateEdge && neighbors.hasNext()) {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (end.equals(nextNeighbor))
                    duplicateEdge = true;
            }


            if (!duplicateEdge) {
                edgeList.add(new Edge(end, weight));
                result = true;
            } else if (weight == 0) {
                for (Edge anEdge : edgeList) {
                    if (anEdge.getDest().equals(end)) {
                        anEdge.setWeight(weight);
                        break;
                    }
                }
                updateEdges();
                result = true;
            }
        }
        return result;
    }

    // D I J K S T R A ' S   H E L P E R   M E T H O D S

    /**
     * method:  getCost
     * purpose: gets the recorded cost of the path to this
     * vertex
     *
     * @return the cost of the path
     */
    @Override
    public int getCost() {
        return weight;
    }

    /**
     * method:  setCost
     * purpose: records the shortest weight of a path
     * to this vertex
     *
     * @param weight
     */
    @Override
    public void setCost(int weight) {
        this.weight = weight;
    }

    /**
     * method:  visit
     * purpose: marks this vertex as visited
     */
    @Override
    public void visit() {
        visited = true;
    }

    /**
     * method:  unvisit
     * purpose: removes the visited mark for this vertex
     */
    @Override
    public void unvisit() {
        visited = false;
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
        return visited;
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
        return !edgeList.isEmpty();
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
        VertexInterface<T> result = null;
        Iterator<VertexInterface<T>> neighbors = getNeighborIterator();

        while (neighbors.hasNext() && (result == null)) {
            VertexInterface<T> nextNeighbor = neighbors.next();
            if (!nextNeighbor.isVisited()) {
                result = nextNeighbor;
            }
        }
        return result;
    }

    /**
     * method:  setPredecessor
     * purpose: records a previous vertex on the path to this vertex
     *
     * @param predecessor the previous vertex
     */
    @Override
    public void setPredecessor(VertexInterface<T> predecessor) {
        this.previous = predecessor;
    }

    /**
     * method:  getPredecessor
     * purpose: gets the recorded predecessor of this vertex
     *
     * @return the predecessor or null if not found
     */
    @Override
    public VertexInterface<T> getPredecessor() {
        return previous;
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
        return previous != null;
    }

    // H E L P E R   M E T H O D S


    /**
     * method:  updateEdges
     * purpose: this helper method removes any edges
     * whose weight is 0
     */
    private void updateEdges() {
        int i = 0;
        ArrayList<Edge> toRemove = new ArrayList<>();

        while (i < edgeList.size()) {
            if (edgeList.get(i).weight == 0) {
                toRemove.add(edgeList.get(i));
            }
            i++;
        }

        edgeList.removeAll(toRemove);
    }

    @Override
    public int compareTo(VertexInterface<T> other) {
        int value = 0;
        if(getCost() < other.getCost()){
            value = -1;
        } else if(getCost() > other.getCost()){
            value = 1;
        } else
            value = 0;

        return value;
    }

    /**
     * method:  equals
     * purpose: overrides the equals method and constitutes two
     * equal vertices as two vertices with equal labels
     *
     * @param other the other Vertex
     * @return true if the objects are equal
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object other) {
        boolean result;
        if ((other == null) || (getClass() != other.getClass())) {
            result = false;
        } else {
            Vertex<T> otherVertex = (Vertex<T>) other;
            result = label.equals(otherVertex.label);
        }

        return result;
    }

    /**
     * method:  toString
     * purpose: gets the String representation of the vertex
     *
     * @return  the vertex's label as a String
     */
    @Override
    public String toString() {
        return label.toString();
    }

    // I N N E R   C L A S S E S

    /**
     * This private inner class represents an edge object.
     */
    private class Edge {
        private VertexInterface<T> dest;
        private int weight;

        /**
         * This is the default constructor for the Edge class.
         *
         * @param dest  the destination vertex
         * @param weight    the weight of the edge
         */
        private Edge(VertexInterface<T> dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        /**
         * method:  getDest
         * purpose: gets the destination vertex
         *
         * @return  the destination vertex
         */
        private VertexInterface<T> getDest() {
            return dest;
        }

        /**
         * method:  getCost
         * purpose: gets the weight of the edge
         *
         * @return  the weight of the edge
         */
        private int getWeight() {
            return weight;
        }

        /**
         * method:  setCost
         * purpose: sets the weight of this edge
         *
         * @param weight    the weight to be set
         */
        private void setWeight(int weight) {
            this.weight = weight;
        }
    }

    /**
     * This private inner class will deal with edges to a vertex's
     * adjacent vertices.
     */
    private class NeighborIterator implements Iterator<VertexInterface<T>> {
        private Iterator<Edge> edges;

        /**
         * This is the default constructor for the NeighborIterator.
         */
        private NeighborIterator() {
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
            if (edges.hasNext()) {
                Edge edgeToNextNeighbor = edges.next();
                nextNeighbor = edgeToNextNeighbor.getDest();
            } else
                throw new NoSuchElementException();

            return nextNeighbor;
        }
    }

    /**
     * This private inner class will deal with weights of the edges
     * to a vertex's adjacent vertices.
     */
    private class WeightIterator implements Iterator<Integer> {

        private Iterator<Edge> edges;

        /**
         * This is the default constructor for the WeightIterator.
         */
        private WeightIterator() {
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
        public Integer next() {
            int weightToNeighbor = -1;
            if (edges.hasNext()) {
                Edge edgeToNextNeighbor = edges.next();
                weightToNeighbor = edgeToNextNeighbor.getWeight();
            } else
                throw new NoSuchElementException();

            return weightToNeighbor;
        }
    }
}
