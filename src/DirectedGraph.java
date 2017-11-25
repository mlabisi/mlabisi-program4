import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/************************************************************
 * File:    DirectedGraph.java
 * Author:  Mora Labisi
 * Course:  CS 241.01 Data Structures and Algorithms II
 *
 * Assignment:  Program Four
 * Due:         Thursday, 11/30/2017
 *
 * Last Modified:   11/24/17
 *
 * Description:
 * This java class is the implementation of the Directed
 * Graph data type. It uses vertices and edges.
 ************************************************************/
public class DirectedGraph<T> implements WeightedGraphInterface<T> {
    private ArrayList<VertexInterface<T>> vertices;
    private int edgeCount;

    // C O N S T R U C T O R

    /**
     * This is the default constructor for the DirectedGraph
     * class.
     */
    public DirectedGraph() {
        vertices = new ArrayList<>();
        edgeCount = 0;
    }

    // P R I V A T E   I N S T A N C E   M E T H O D S

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

        VertexInterface<T> beginVertex = findVertex(begin);
        VertexInterface<T> endVertex = findVertex(end);

        if ((beginVertex != null) && (endVertex != null))
            result = beginVertex.connect(endVertex, weight);

        if (result && weight > 0) {
            edgeCount++;
        } else if (result && (weight == 0)) {
            edgeCount--;
        }

        return result;
    }

    /**
     * method:  findVertex
     * purpose: this helper method will find the vertex
     * whose label matches the given data
     *
     * @param value the value of the label
     * @return the vertex or null if not found
     */
    private VertexInterface<T> findVertex(T value) {
        VertexInterface<T> found = null;
        for (VertexInterface<T> vertex : vertices) {
            if (vertex.getLabel() == value) {
                found = vertex;
            }
        }

        return found;
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
        boolean found = false;


        VertexInterface<T> beginVertex = findVertex(begin);
        VertexInterface<T> endVertex = findVertex(end);

        if ((beginVertex != null) && (endVertex != null)) {
            Iterator<VertexInterface<T>> neighbors = beginVertex.getNeighborIterator();

            while (!found && neighbors.hasNext()) {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (endVertex.equals(nextNeighbor)) {
                    found = true;
                }
            }
        }

        return found;
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
        return vertices.isEmpty();
    }

    /**
     * method:  getNumberOfVertices
     * purpose: gets the number of vertices in the graph
     *
     * @return the number of vertices
     */
    @Override
    public int getNumberOfVertices() {
        return vertices.size();
    }

    /**
     * method:  getNumberOfEdges
     * purpose: gets the number of edges in the graph
     *
     * @return the number of edges
     */
    @Override
    public int getNumberOfEdges() {
        return edgeCount;
    }

    public void displayEdges() {
        for (VertexInterface<T> vertex : vertices) {
            Iterator<VertexInterface<T>> neighbors = vertex.getNeighborIterator();

            if (!neighbors.hasNext()) {
                System.out.println(vertex.getLabel() + " is not connected to any other cities.");
            } else {
                while (neighbors.hasNext()) {
                    VertexInterface<T> nextNeighbor = neighbors.next();
                    System.out.println(vertex.getLabel() +
                            " --> " +
                            nextNeighbor.getLabel() +
                            " (" + ((Vertex<T>) vertex).getDistance(nextNeighbor) + ")");
                }
            }
        }
    }

    /**
     * method:  clear
     * purpose: removes all vertices and edges from the graph
     */
    @Override
    public void clear() {
        vertices.clear();
        edgeCount = 0;
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
        StringBuilder str = new StringBuilder();
        int distance = 0;
        String route = "";

        VertexInterface<T> beginVertex = findVertex(begin);
        VertexInterface<T> endVertex = findVertex(end);
        ArrayList info = dijkstra(beginVertex, endVertex);
        route = (String) info.get(1);
        distance = (Integer) info.get(0);

        if(!route.equalsIgnoreCase(endVertex.getLabel().toString())) {
            str.append("The minimum distance between ").append(beginVertex.getLabel())
                    .append(" and ").append(endVertex.getLabel()).append(" is ")
                    .append(distance).append(" through the route ")
                    .append(route);
        } else{
            str.append("There is no route between ").append(beginVertex.getLabel())
                    .append(" and ").append(endVertex.getLabel())
                    .append("!");
        }

        return str.toString();
    }

    /**
     * method:  dijkstra
     * purpose: implementation of dijkstra's algorithm to find
     *          cheapest path between vertices
     *
     * @param begin the beginning vertex
     * @param end   the ending vertex
     * @return  an ArrayList containing the distance of and vertices in
     *          the cheapest path
     */
    @SuppressWarnings("unchecked")
    private ArrayList dijkstra(VertexInterface<T> begin, VertexInterface<T> end) {
        ArrayList info = new ArrayList();
        StringBuilder path = new StringBuilder();
        for (VertexInterface<T> vertex : vertices) {
            vertex.unvisit();
            vertex.setCost(1000000);
            vertex.setPredecessor(null);
        }

        boolean done = false;

        Comparator<VertexInterface<T>> comparator = new VertexComparator();
        PriorityQueue<VertexInterface<T>> vertexQueue = new PriorityQueue<>(comparator);

        begin.setCost(0);
        vertexQueue.add(begin);

        while (!done && !vertexQueue.isEmpty()) {
            VertexInterface<T> current = vertexQueue.remove();

            if (!current.isVisited()) {
                current.visit();

                if (begin.equals(end)) {
                    done = true;
                } else {
                    Iterator<VertexInterface<T>> neighbors = current.getNeighborIterator();

                    while (neighbors.hasNext()) {
                        VertexInterface<T> neighbor = neighbors.next();
                        int pathWeight = ((Vertex<T>) current).getDistance(neighbor);

                        if (!neighbor.isVisited()) {
                            int neighborCost = pathWeight + current.getCost();
                            neighbor.setCost(neighborCost);
                            neighbor.setPredecessor(current);
                            vertexQueue.add(neighbor);
                        } // end if
                    } // end while
                } // end if else
            } // end if
        } // end while

        int pathCost = end.getCost();
        path.append(end.getLabel());

        VertexInterface<T> current = end;

        while (current.hasPredecessor()) {
            current = current.getPredecessor();
            path.insert(0, " --> ");
            path.insert(0, current.getLabel());
        } // end while

        info.add(pathCost);
        info.add(path.toString());

        return info;
    } // end dijkstra

    /**
     * This private class is used to organize the Priority Queue
     * of vertices.
     */
    private class VertexComparator implements Comparator<VertexInterface<T>> {
        public int compare(VertexInterface<T> vertex1, VertexInterface<T> vertex2) {
            return vertex1.compareTo(vertex2);
        }
    }

}
