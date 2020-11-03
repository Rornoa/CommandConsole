package building_procedure;

import object_of_collection.Coordinates;

public class BandCoordinatesBuilder implements ICoordinateBuilder {
    private int x;
    private double y;
    public BandCoordinatesBuilder(){

    }

    @Override
    public void setX() {

    }

    @Override
    public void setY() {

    }

    @Override
    public Coordinates create() {
        System.out.println("Бла бла бла");
        setX();
        setY();
        return new Coordinates(x,y);
    }
}
