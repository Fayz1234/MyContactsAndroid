package models;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class ConfirmationReceiptModel implements Serializable {
    private String heading;
    private LinkedHashMap<String, String> data;

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public LinkedHashMap<String, String> getData() {
        return data;
    }

    public void setData(LinkedHashMap<String, String> data) {
        this.data = data;
    }
}
