package inputData;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Random;

class Input100KRows {

    String add100KRows() {

        String a = random_C_or_D();
        String b = (a.equals("C")) ? " " + randomNumber2() + "," : "-" + date() + ",";

        return a + " " + randomNumber() + " " + randomNumber() + " " + random_P_or_N() + " " + date() + b;

    }

    private String random_C_or_D() {
        return new Random().nextBoolean() ? "C" : "D";
    }

    private String random_P_or_N() {
        return new Random().nextBoolean() ? "P" : "N";
    }

    private String randomNumber(){
        return String.valueOf((int) ((Math.random()+1) * 3));
    }

    private String randomNumber2(){
        return String.valueOf((int) (Math.random() * 200));
    }

    private String date(){
        return DateTimeFormatter.ofPattern("MM.dd.yyyy").format(LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70)))));
    }
}
