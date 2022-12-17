package models;

public class Case {

    private Integer x;
    private Integer y;

    private boolean isAvailable;

    private Double coefPassage;

    private boolean isCible;

    public Case(Integer x,Integer y){
        this.x = x;
        this.y = y;
        this.isAvailable = true;
        this.coefPassage = 0.00;
        this.isCible = false;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Double getCoefPassage() {
        return coefPassage;
    }

    public void setCoefPassage(Double coefPassage) {
        this.coefPassage = coefPassage;
    }

    public boolean isCible() {
        return isCible;
    }

    public void setCible(boolean cible) {
        isCible = cible;
    }

    @Override
    public String toString() {
        return "Case{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
