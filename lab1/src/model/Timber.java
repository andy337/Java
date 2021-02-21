package model;

public class Timber {

    private Wood wood;
    private float length;
    private float height;
    private float width;

    public Wood getWood() {
        return wood;
    }

    public float getLength() {
        return length;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public Timber(Wood wood, float length, float height, float width) {
        this.wood = wood;
        this.length = length;
        this.height = height;
        this.width = width;
    }

    public float volume(){ // об'єм
        return length * height * width;
    }

    public float weight(){ // вага
        return wood.getDencity() * volume();
    }

    @Override
    public String toString() {
        return "Timber{" +
                "wood=" + wood +
                ", length=" + length +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
