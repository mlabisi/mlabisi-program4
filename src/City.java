/************************************************************
 * File:    DirectedGraph.java
 * Author:  Mora Labisi
 * Course:  CS 241.01 Data Structures and Algorithms II
 *
 * Assignment:  Program Four
 * Due:         Thursday, 11/30/2017
 *
 * Last Modified:   11/23/17
 *
 * Description:
 * This java class is the representation of a City.
 ************************************************************/
public class City<T> {

    private final int CODE;

    private final String ID;

    private final String NAME;

    private final int POPULATION;

    private final int ELEVATION;


    // C O N S T R U C T O R

    /**
     * This is the default constructor for the
     * City
     *
     * @param code  integer code for city
     * @param id    2 letter ID
     * @param name  name of the city
     * @param population    population of the city
     * @param elevation elevation of the city
     */
    public City(int code, String id, String name,
                int population, int elevation){
        this.CODE = code;
        this.ID = id;
        this.NAME = name;
        this.POPULATION = population;
        this.ELEVATION = elevation;
    }

    // G E T T E R S


    public int getCODE() {
        return CODE;
    }

    public String getID() {
        return ID;
    }

    public String getNAME() {
        return NAME;
    }

    public int getPOPULATION() {
        return POPULATION;
    }

    public int getELEVATION() {
        return ELEVATION;
    }

    public String getInfo(){
        return "ID:\t\t" + ID +
                "\nNAME:\t" + NAME +
                "\nPOP:\t" + POPULATION +
                "\nELV:\t" + ELEVATION +
                "\n";
    }

    public String toString(){
        return NAME;
    }
}
