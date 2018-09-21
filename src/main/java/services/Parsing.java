package services;

import inputData.InputData;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Parsing {

    private Date parseDate(String string) throws ParseException {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.parse(string);
    }

    private boolean between(Date date, Date dateStart, Date dateEnd) {
        if (date != null && dateStart != null && dateEnd != null) {
            return date.after(dateStart) && date.before(dateEnd);
        }
        return false;
    }

    public static void main(String[] args) throws ParseException {
        Parsing parsing = new Parsing();
        InputData inputData = new InputData();
        ArrayList<Object> input = new ArrayList<>();
//        String in = "7," +
//                "C 1.1 8.15.1 P 15.10.2012 83," +
//                "C 1 10.1 P 01.12.2012 65," +
//                "C 1.1 5.5.1 P 01.11.2012 117," +
//                "D 1.1 8 P 01.01.2012-01.12.2012," +
//                "C 3 10.2 N 02.10.2012 100," +
//                "D 1 * P 8.10.2012-20.11.2012," +
//                "D 3 10 P 01.12.2012";
        String in = inputData.input100KRows();
        Collections.addAll(input, in.split(","));

        int capacity = Integer.parseInt(input.get(0).toString());

        ArrayList<Object> inputC = new ArrayList<>();
        ArrayList<Object> inputD = new ArrayList<>();
        String in2;
        for (int i = 1; i <= capacity; i++) {
            ArrayList<Object> input2 = new ArrayList<>();
            in2 = input.get(i).toString();
            Collections.addAll(input2, in2.split(" "));
            if (input2.get(0).toString().equals("C")) {
                Collections.addAll(inputC, input2);
            } else {
                Collections.addAll(inputD, input2);
            }
        }
        String inD;
        String inC;
        String inDate;
        for (Object anInputD : inputD) {
            ArrayList<Object> parserD = new ArrayList<>();
            inD = anInputD.toString().replaceAll("[\\[\\] ]", "");
            Collections.addAll(parserD, inD.split(","));

            ArrayList<Object> listParseDateD = new ArrayList<>();
            inDate = parserD.get(4).toString().replaceAll("[\\[\\] ]", "");
            Collections.addAll(listParseDateD, inDate.split("-"));
            if (listParseDateD.size() == 1) {
                listParseDateD.add(parserD.get(4).toString().replaceAll("[\\[\\] ]", ""));
            }

            int count = 0;
            int result = 0;
            for (Object anInputC : inputC) {
                ArrayList<Object> parserC = new ArrayList<>();
                inC = anInputC.toString().replaceAll("[\\[\\] ]", "");
                Collections.addAll(parserC, inC.split(","));

                String s = parserD.get(2).toString();
                if (!s.equals("*")) {
                    if (((parserD.get(1).toString().substring(0, 1)).equals(parserC.get(1).toString().substring(0, 1))) &&
                            ((parserD.get(2).toString().substring(0, 1)).equals(parserC.get(2).toString().substring(0, 1))) &&
                            (parsing.between(parsing.parseDate(parserC.get(4).toString()),
                                    parsing.parseDate(listParseDateD.get(0).toString()),
                                    parsing.parseDate(listParseDateD.get(1).toString())))) {
                        count++;
                        result += Integer.parseInt(parserC.get(5).toString());
                    }
                } else {
                    if (((parserD.get(1).toString().substring(0, 1)).equals(parserC.get(1).toString().substring(0, 1))) &&
                            (parsing.between(parsing.parseDate(parserC.get(4).toString()),
                                    parsing.parseDate(listParseDateD.get(0).toString()),
                                    parsing.parseDate(listParseDateD.get(1).toString())))) {
                        count++;
                        result += Integer.parseInt(parserC.get(5).toString());
                    }
                }
            }
            if (result > 0) {
                System.out.print(result / count + " ");
            } else {
                System.out.print("- ");
            }
        }
    }
}


