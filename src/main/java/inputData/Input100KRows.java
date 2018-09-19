package inputData;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Random;

class Input100KRows {

    String add100KRows() {

        String a = random_C_or_D();
        String b = (a.equals("C")) ? randomNumber() + " " : "";

        return a + " " + randomNumber() + " " + randomNumber() + " " + random_P_or_N() + " " + date() + " " + b;
//        return  "C 1.1 8.15.1 P 15.10.2012 83 " +
//                "C 1 10.1 P 01.12.2012 65 " +
//                "C 1.1 5.5.1 P 01.11.2012 117 " +
//                "D 1.1 8 P 01.01.2012-01.12.2012 " +
//                "C 3 10.2 N 02.10.2012 100 " +
//                "D 1 * P 8.10.2012-20.11.2012 " +
//                "D 3 10 P 01.12.2012";
    }

    private String random_C_or_D() {
        return new Random().nextBoolean() ? "C" : "D";
    }

    private String random_P_or_N() {
        return new Random().nextBoolean() ? "P" : "N";
    }

    private String randomNumber(){
        return String.valueOf((int)((Math.random()+1) * 9));
    }

    private String date(){
        return DateTimeFormatter.ofPattern("MM.dd.yyyy").format(LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70)))));
    }
}
