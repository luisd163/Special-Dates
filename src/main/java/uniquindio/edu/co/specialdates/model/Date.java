package uniquindio.edu.co.specialdates.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder @Getter @Setter
public class Date {
    String description;
    String date;

    public Date(String date, String description) {
        this.date = date;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Fecha{" +
                "description='" + description + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
