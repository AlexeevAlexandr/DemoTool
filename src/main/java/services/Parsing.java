package services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

public class Parsing {
    private Tools tools = new Tools();

    public String doWork(String inputData) throws ParseException {

        //Collection and separation on parts of input data
        ArrayList<Object> input = new ArrayList<>();
        Collections.addAll(input, inputData.split(","));

        //separation of data on C and D
        ArrayList<Object> inputC = new ArrayList<>();
        ArrayList<Object> inputD = new ArrayList<>();
        String in2;
        int capacity = Integer.parseInt(input.get(0).toString());
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
        StringBuilder answer = new StringBuilder();
        //getting rows D one by one, for compare with each rows C
        for (Object anInputD : inputD) {
            ArrayList<Object> parserD = new ArrayList<>();
            inD = anInputD.toString().replaceAll("[\\[\\] ]", "");
            Collections.addAll(parserD, inD.split(","));

            //getting a date for comparison
            ArrayList<Object> listParseDateD = new ArrayList<>();
            inDate = parserD.get(4).toString().replaceAll("[\\[\\] ]", "");
            Collections.addAll(listParseDateD, inDate.split("-"));

            if (listParseDateD.size() == 1) {
                listParseDateD.add(parserD.get(4).toString().replaceAll("[\\[\\] ]", ""));
            }

            //comparing of parameters, counting of scores
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
                            (tools.comparingDates(tools.parseDate(parserC.get(4).toString()),
                                    tools.parseDate(listParseDateD.get(0).toString()),
                                    tools.parseDate(listParseDateD.get(1).toString()))))
                    {
                        count++;
                        result += Integer.parseInt(parserC.get(5).toString());
                    }
                } else {
                    if (((parserD.get(1).toString().substring(0, 1)).equals(parserC.get(1).toString().substring(0, 1))) &&
                            (tools.comparingDates(tools.parseDate(parserC.get(4).toString()),
                                    tools.parseDate(listParseDateD.get(0).toString()),
                                    tools.parseDate(listParseDateD.get(1).toString()))))
                    {
                        count++;
                        result += Integer.parseInt(parserC.get(5).toString());
                    }
                }
            }
            if (result > 0) {
                answer.append(result / count).append(" ");
            } else {
                answer.append("- ");
            }
        }
        return answer.toString();
    }
}



