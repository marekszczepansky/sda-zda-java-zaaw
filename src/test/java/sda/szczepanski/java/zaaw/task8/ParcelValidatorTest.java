package sda.szczepanski.java.zaaw.task8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParcelValidatorTest {
    private Validator<Parcel> validator;

    @BeforeEach
    void setUp() {
        validator = new ParcelValidator();
    }

    @Test
    void shouldPassForCorrectStandardParcel() {
        Parcel parcel = new Parcel(100,90,110, 30.0f, false);

        assertTrue(validator.validate(parcel));
    }

    @Test
    void shouldPassForCorrectExpressParcel() {
        Parcel parcel = new Parcel(100,90,110, 15.0f, true);

        assertTrue(validator.validate(parcel));
    }

    @Test
    void shouldFailWhenSizeExceeded() {
        Parcel parcel = new Parcel(110,120,130, 15.0f, true);

        assertFalse(validator.validate(parcel));
    }

    @Test
    void shouldFailWhenOneDimensionTooSmall() {
        Parcel parcel = new Parcel(50,20,30, 15.0f, true);

        assertFalse(validator.validate(parcel));
    }

    @Test
    void shouldFailWhenAllDimensionsTooSmall() {
        Parcel parcel = new Parcel(20,20,10, 15.0f, true);

        assertFalse(validator.validate(parcel));
    }

    @Test
    void shouldPassWhenAllDimensionsExactMinimum() {
        Parcel parcel = new Parcel(30,30,30, 15.0f, true);

        assertTrue(validator.validate(parcel));
    }

    @Test
    void shouldFailWhenExpressParcelTooHeavy() {
        Parcel parcel = new Parcel(50,50,50,16, true);

        assertFalse(validator.validate(parcel));
    }

    @Test
    void shouldFailWhenStandardParcelTooHeavy() {
        Parcel parcel = new Parcel(50,50,50,31, true);

        assertFalse(validator.validate(parcel));
    }
}
