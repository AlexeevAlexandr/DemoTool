package services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Tools {

    boolean comparingDates(Date date, Date dateStart, Date dateEnd) {
        return date.after(dateStart) && date.before(dateEnd);
    }

    Date parseDate(String string) throws ParseException {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.parse(string);
    }
}
