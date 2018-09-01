package enums;

import java.io.Serializable;

public enum WorkerFunctionEnum implements Serializable{
    THERAPIST("Terapeuta"),
    DOCTOR("Doktor");

    private String text;

    WorkerFunctionEnum(String workerFunction) {
        this.text = workerFunction;
    }

    @Override
    public String toString() {
        return text;
    }
}
