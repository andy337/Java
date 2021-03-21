package model;

public class Timber extends AbstractForm {

    private float length;
    private float height;
    private float width;

    public float getLength() {
        return length;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public Timber(Wood wood, float length, float height, float width) throws Exception {
        super(wood);
        if(wood == null || length <= 0 || height <= 0 || width <= 0) throw new Exception("is not correct");
        this.length = length;
        this.height = height;
        this.width = width;
    }

    public float volume(){ // об'єм
        return length * height * width;
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
