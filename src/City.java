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


    /**
     * method:  getCODE
     * purpose: gets this city's code
     *
     * @return  this city's code
     */
    public int getCODE() {
        return CODE;
    }

    /**
     * method:  getID
     * purpose: gets this city's ID
     *
     * @return  this city's ID
     */
    public String getID() {
        return ID;
    }

    /**
     * method:  getNAME
     * purpose: gets this city's name
     *
     * @return  this city's name
     */
    public String getNAME() {
        return NAME;
    }

    /**
     * method:  getPOPULATION
     * purpose: gets this city's population
     *
     * @return  this city's population
     */
    public int getPOPULATION() {
        return POPULATION;
    }

    /**
     * method:  getELEVATION
     * purpose: gets this city's elevation
     *
     * @return  this city's elevation
     */
    public int getELEVATION() {
        return ELEVATION;
    }

    /**
     * method:  getInfo
     * purpose: gets this city's id, name, population,
     *          and elevation
     *
     * @return  this city's info
     */
    public String getInfo(){
        return "CODE:\t" + CODE +
                "\nID:\t\t" + ID +
                "\nNAME:\t" + NAME +
                "\nPOP:\t" + POPULATION +
                "\nELV:\t" + ELEVATION +
                "\n";
    }

    /**
     * method:  getString
     * purpose: gets the String representation of the city
     *
     * @return  this city's name
     */
    public String toString(){
        return NAME;
    }
}
