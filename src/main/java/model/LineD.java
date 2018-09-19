package model;

import services.Parser;
import java.util.Date;

public class LineD extends Line{
    private Date dateTo = null;

    public LineD(String line) {
        line = line.trim();
        Parser parser = new Parser();
        if (!parser.isLineD(line)) {
            throw new IllegalArgumentException("Incorrect line format!");
        }
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
        if (null == dateTo && c.getDateFrom().equals(dateFrom)) {
            return true;
        } else return !c.getDateFrom().before(dateFrom) && !c.getDateFrom().after(dateTo);
    }
}