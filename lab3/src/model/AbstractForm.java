package model;

public abstract class AbstractForm implements IWeight {
    protected Wood wood;

    public AbstractForm(Wood wood) {
        this.wood = wood;
    }

    @Override
    public double weight() { // вага
        return wood.getDencity() * volume();
    }

    public Wood getWood() {
        return wood;
    }

    public abstract float volume();
}
