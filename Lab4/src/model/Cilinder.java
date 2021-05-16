package model;

public class Cilinder extends AbstractForm {

    private float length;
    private float diameter;

    public Cilinder(Wood wood, float length, float diameter) throws Exception {
        super(wood);
        if(diameter <= 0 || length <= 0)
            throw new Exception("is not correct\n");
        this.diameter = diameter;
        this.length = length;
    }

    @Override
    public float volume() {
        return (float) (Math.PI * (diameter / 2) * length);
    }

    @Override
    public String toString() {
        return "Cilinder{" +
                "wood=" + wood +
                ", length=" + length +
                ", diameter=" + diameter +
                '}';
    }
}
