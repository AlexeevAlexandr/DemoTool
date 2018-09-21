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
        DateFormat format = new SimpleDateFormat("d.MMMM.yyyy");
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
        String in = "4," +
                "C 1.1 5.5.1 P 01.11.2012 117," +
                "D 1.1 8 P 01.01.2012-01.12.2012," +
                "C 1.1 5.5.1 P 01.11.2012 118," +
                "D 1.2 8 P 01.01.2012-01.12.2012";
//        String in = inputData.input100KRows();
        Collections.addAll(input, in.split(","));

        int capacity = Integer.parseInt(input.get(0).toString());

        ArrayList<Object> inputC = new ArrayList<>();
        ArrayList<Object> inputD = new ArrayList<>();
        String in2;
        for (int i = 1; i <= capacity; i++) {
            ArrayList<Object> input2 = new ArrayList<>();
            in2 = input.get(i).toString();
            Collections.addAll(input2, in2.split(" "));
            if (input2.get(0).toString().equals("C")){
                Collections.addAll(inputC, input2);
            } else {
                Collections.addAll(inputD, input2);
            }
        }

        System.out.println("Objects C:");
        for (Object object : inputC){
        System.out.println(object);
        }

        System.out.println("Objects D:");
        for (Object object : inputD){
        System.out.println(object);
        }

        String inC;
        String inC2;
        for (int i=0; i<inputD.size(); i++) {
            ArrayList<Object> parserD = new ArrayList<>();
            inC = inputC.get(i).toString().replaceAll("[\\[\\] ]", "");
            Collections.addAll(parserD, inC.split(","));


            System.out.println((parserD.get(1).toString().substring(0,1)));

            for (int ii = 0; ii < inputC.size(); ii++) {
                ArrayList<Object> parserC = new ArrayList<>();
                inC2 = inputD.get(ii).toString().replaceAll("[\\[\\] ]", "");
                Collections.addAll(parserC, inC2.split(","));

                if (((parserD.get(1).toString().substring(0,1)).equals(parserC.get(1).toString().substring(0,1))) &&
                        ((parserD.get(2).toString().substring(0,1)).equals(parserC.get(2).toString().substring(0,1))) &&
                        parsing.between(parsing.parseDate(parserC.get(4).toString()), )
                {
                    System.out.println("ok");
                }
            }
        }
    }
}
