package model;

public class Waste implements IWeight{

    public double weight;

    @Override
    public double weight() {
        return weight;
    }

    public Waste(double weight){
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Waste{" +
                "weight=" + weight +
                '}';
    }
}
