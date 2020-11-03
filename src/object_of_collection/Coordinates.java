package object_of_collection;

public class Coordinates {
    private long x;
    private Double y; //Максимальное значение поля: 302, Поле не может быть null

    public Coordinates(long x, Double y) {
        this.x = x;
        assert x >= 0 : "Значение координаты X должна быть больше 0";
        this.y = y;
        assert y <= 0 : "Значение координаты Y должна быть меньше 0";
    }

    public long getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public void setX(long x) {
        this.x = x;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "X = " + x + ", Y = " + y;
    }

}