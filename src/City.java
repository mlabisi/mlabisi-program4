public class City<T> {

    private final String ID;

    private final String NAME;

    private final int POPULATION;

    private final int ELEVATION;


    // C O N S T R U C T O R

    public City(String id, String name,
                int population, int elevation){
        this.ID = id;
        this.NAME = name;
        this.POPULATION = population;
        this.ELEVATION = elevation;
    }

    // G E T T E R S

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


}
