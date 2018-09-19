package inputData;

public class InputData {

    //should be the result of (83 100 -)
    public String input1(){
        return  "7 " +
                "C 1.1 8.15.1 P 15.10.2012 83 " +
                "C 1 10.1 P 01.12.2012 65 " +
                "C 1.1 5.5.1 P 01.11.2012 117 " +
                "D 1.1 8 P 01.01.2012-01.12.2012 " +
                "C 3 10.2 N 02.10.2012 100 " +
                "D 1 * P 8.10.2012-20.11.2012 " +
                "D 3 10 P 01.12.2012";
    }

    //should be the result of (85 101 -), for false test
    public String input1False(){
        return  "7 " +
                "C 1.1 8.15.1 P 15.10.2012 85 " +
                "C 1 10.1 P 01.12.2012 65 " +
                "C 1.1 5.5.1 P 01.11.2012 117 " +
                "D 1.1 8 P 01.01.2012-01.12.2012 " +
                "C 3 10.2 N 02.10.2012 100 " +
                "D 1 * P 8.10.2012-20.11.2012 " +
                "D 3 10 P 01.12.2012";
    }

    //should be the result of (20 30 -)
    public String input2(){
        return  "7 " +
                "C 2.1 8.1.1 P 15.10.2012 10 " +
                "C 1.1 8 N 01.12.2012 20 " +
                "C 3 1.5 P 01.11.2012 30 " +
                "D 1 8 P 01.01.2012-01.12.2012 " +
                "C 3 1.5 P 02.10.2012 40 " +
                "D 3 * N 8.10.2012-20.11.2012 " +
                "D 2 8.1 N 25.12.2012";
    }

    //should be the result of (83 100 -), for false test
    public String input2False(){
        return  "7 " +
                "C 1.1 8.15.1 P 15.10.2012 83 " +
                "C 1.1 10.1 P 01.12.2012 65 " +
                "C 3 5.5.1 P 01.11.2012 117 " +
                "D 1.1 8 P 01.01.2012-01.12.2012 " +
                "C 3 10.2 N 02.10.2012 100 " +
                "D 1 * P 8.10.2012-20.11.2012 " +
                "D 3 10 P 01.12.2012";
    }

    public String inputIncorrectNumberLinesException(){
        return  "6" +
                "C 1.1 8.15.1 P 15.10.2012 83 " +
                "C 1.1 10.1 P 01.12.2012 65 " +
                "C 3 5.5.1 P 01.11.2012 117 " +
                "D 1.1 8 P 01.01.2012-01.12.2012 " +
                "C 3 10.2 N 02.10.2012 100 " +
                "D 1 * P 8.10.2012-20.11.2012 " +
                "D 3 10 P 01.12.2012";
    }

    public String inputParseException(){
        return  "17 " +
                "C 1.1 8.15.1 P 15.10.2012 83 " +
                "C 1 10.1 P 01.12.2012 65 " +
                "C 1.1 5.5.1 P 01.11.2012 117 " +
                "D 1.1 8 P 01.01.2012-01.12.2012 " +
                "C 3 10.2 N 02.10.2012 100 " +
                "D 1 * P 8.10.2012-20.11.2012 " +
                "D 3 10 P 01.12.2012";
    }

    public String inputParseDateException(){
        return  "7 " +
                "C 1.1 8.15.1 P 15.10.2012 83 " +
                "C 1 10.1 P 01.12.2012 65 " +
                "C 1.1 5.5.1 P 01.11.2012 117 " +
                "D 1.1 8 P 01.01.2012-01.12.2012 " +
                "C 3 10.2 N 02.10.2012 100 " +
                "D 1 * P 8.10.2012-20.11.2012 " +
                "D 3 10 *P 01.12.2012";
    }

    public String input100KRows(){
        Input100KRows data = new Input100KRows();
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
        input.append(data.add100KRows());
        }
        return "1000 " + input.toString();
    }
    public static void main(String[] args) {
        InputData data = new InputData();
        System.out.println(data.input100KRows());

    }
}