package uniquindio.edu.co.specialdates.model;

import lombok.Getter;
import lombok.Setter;
import uniquindio.edu.co.specialdates.util.Constants;
import uniquindio.edu.co.specialdates.util.Persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Main {
    ArrayList<Date> dates;

    public Main() {
        this.dates = readData();
    }

    public ArrayList<Date> readData() {
        try {
            Object data = Persistence.deserializeObject(Constants.PATH_DATES);
            if (data != null) {
                return (ArrayList<Date>)data;
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public void saveData(List<Date> dates) {
        try {
            Persistence.serializeObject(Constants.PATH_DATES, dates);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
