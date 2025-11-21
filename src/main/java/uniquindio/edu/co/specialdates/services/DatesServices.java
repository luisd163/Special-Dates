package uniquindio.edu.co.specialdates.services;

import uniquindio.edu.co.specialdates.controllers.PrincipalController;
import uniquindio.edu.co.specialdates.model.Date;
import uniquindio.edu.co.specialdates.model.Main;
import uniquindio.edu.co.specialdates.repos.IDatesRepo;

import java.util.ArrayList;

public class DatesServices implements IDatesRepo {

    private final Main main = PrincipalController.getInstance().getMain();

    ArrayList<Date> dates = main.getDates();

    @Override
    public boolean createDate(String description, String date) throws Exception {
        if(description.isEmpty()) {
            throw new Exception("The description cannot be empty");
        }
        if(date.isEmpty()) {
            throw new Exception("The date cannot be empty");
        }
        Date date1 = Date.builder()
                .description(description)
                .date(date)
                .build();

        dates.add(date1);
        return true;

    }

    @Override
    public boolean removeDate(Date date) throws Exception {
        if(date == null) {
            throw new Exception("Select a date to remove");
        }
        if(!dates.contains(date)) {
            throw new Exception("The date does not exist");
        }
        dates.remove(date);
        return true;
    }
}
