package uniquindio.edu.co.specialdates.repos;

import uniquindio.edu.co.specialdates.model.Date;

public interface IDatesRepo {

    public boolean createDate(String description, String date) throws Exception;
    public boolean removeDate(Date date) throws Exception;

}
