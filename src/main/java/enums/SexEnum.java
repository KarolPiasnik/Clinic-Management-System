package enums;

import java.io.Serializable;

public enum SexEnum implements Serializable {
    FEMALE("Kobieta"),
    MALE("Mężczyzna");

    private String text;

    SexEnum(String sex) {
        this.text = sex;
    }

    @Override
    public String toString() {
        return text;
    }
}



