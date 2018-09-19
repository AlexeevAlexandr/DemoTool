package services;

import model.LineC;
import model.LineD;

import java.util.List;

public class Tool {

    public String evaluate(String inputString) {

        Parser parser = new Parser(inputString);
        StringBuilder result = new StringBuilder();

        for(LineD lineD : parser.getListLineD()){
            List<LineC> listC = parser.parseToListC(parser.createTmplForSearchC(lineD));
            Integer sum = 0;
            Integer counter = 0;
            for(LineC lineC : listC) {
                if (lineD.isDateIn(lineC)) {
                    sum += lineC.getTime();
                    counter++;
                }
            }
            result.append((0 == counter ) ?  "-" : String.valueOf(sum/counter));
            result.append(" ");
        }
        return result.toString();
    }
}