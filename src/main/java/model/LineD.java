package model;

import java.util.Date;

public class LineD extends Line{
    private Date dateTo = null;

    public LineD(String line) {
        line = line.trim();

        String[] parameters = line.split(" ");

        super.setService(parameters[1]);
        super.setQuestion(parameters[2]);

        typeOfAnswer = parameters[3];

        String[] dates = parameters[4].split("-");
        super.setDataFrom(dates[0]);

        if (dates.length > 1) {
            dateTo = parseDate(dates[1]);
        }
    }

    public boolean isDateIn(LineC c) {
        return !c.getDateFrom().before(dateFrom) && !c.getDateFrom().after(dateTo);
    }
}