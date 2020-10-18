package sda.szczepanski.java.zaaw.task8;

public class ParcelValidator implements Validator<Parcel> {

    public static final int MAX_DIMENSIONS_SUM = 300;
    public static final int MIN_DIMENSION = 30;
    public static final float MAX_EXPRESS_WEIGHT = 15.0f;
    public static final float MAX_STANDARD_WEIGHT = 30.0f;

    @Override
    public boolean validate(Parcel input) {
        return isDimensionsSumValid(input) &&
                isDimensionsMinimumValid(input) &&
                isWeightValid(input);
    }

    private boolean isWeightValid(Parcel input) {
        return input.isExpress() ?
                input.getWeight() <= MAX_EXPRESS_WEIGHT :
                input.getWeight() <= MAX_STANDARD_WEIGHT;
    }

    private boolean isDimensionsMinimumValid(Parcel input) {
        return input.getzLength() >= MIN_DIMENSION &&
                input.getyLength() >= MIN_DIMENSION &&
                input.getxLength() >= MIN_DIMENSION;
    }

    private boolean isDimensionsSumValid(Parcel input) {
        return input.getxLength() + input.getyLength() + input.getzLength() <= MAX_DIMENSIONS_SUM;
    }
}
