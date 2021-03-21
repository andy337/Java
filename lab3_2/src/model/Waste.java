package model;

public class Waste implements IWeight {

    public double weight;

    @Override
    public double weight() {
        return weight;
    }

    public Waste(double weight) throws Exception {
        if(weight < 0.020 || weight > 0.100)
            throw new Exception(weight + " is not correct!\n" + "Must be from 0.020 to 0.100");
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Waste{" +
                "weight=" + weight +
                '}';
    }
}
