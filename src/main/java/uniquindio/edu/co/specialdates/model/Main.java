package uniquindio.edu.co.specialdates.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class Main {
    ArrayList<Date> dates = new ArrayList<>();

    public Main() {
        this.dates = new ArrayList<>();
    }

}
