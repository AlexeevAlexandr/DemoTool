import org.junit.Test;
import inputData.InputData;
import services.Parsing;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class DoTest {
    private InputData inputData = new InputData();
    private Parsing parsing = new Parsing();
    private String check = "83 100 -";
    private String check2 = "- 30 -";

    @Test
    public void TestData1() throws ParseException {
        assertEquals(check, parsing.doWork(inputData.input1()).trim());
    }

    @Test(expected = AssertionError.class)
    public void TestFalseData1() throws ParseException {
        assertEquals(check, parsing.doWork(inputData.input2()).trim());
    }

    @Test()
    public void TestData2() throws ParseException {
        assertEquals(check2, parsing.doWork(inputData.input2()).trim());
    }

    @Test(expected = AssertionError.class)
    public void TestFalseData2() throws ParseException {
        assertEquals(check2, parsing.doWork(inputData.input1()).trim());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestIncorrectNumberLinesException() throws ParseException {
        parsing.doWork(inputData.inputIncorrectNumberLinesException());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestParseException() throws ParseException {
        parsing.doWork(inputData.inputParseException());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestParseDateException() throws ParseException {
        parsing.doWork(inputData.inputParseDateException());
    }

    @Test
    public void Test100K() throws ParseException {
        assertEquals(check2, parsing.doWork(inputData.input100KRows()).trim());
    }
}
