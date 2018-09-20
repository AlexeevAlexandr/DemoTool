import org.junit.Test;
import inputData.InputData;
import services.Tool;

import static org.junit.Assert.assertEquals;

public class DoTest {
    private InputData inputData = new InputData();
    private Tool tool = new Tool();
    private String check = "83 100 -";
    private String check2 = "20 30 -";

    @Test
    public void TestData1() {
        assertEquals(check, tool.evaluate(inputData.input1()).trim());
    }

    @Test(expected = AssertionError.class)
    public void TestFalseData1() {
        assertEquals(check, tool.evaluate(inputData.input1False()).trim());
    }

    @Test()
    public void TestData2() {
        assertEquals(check2, tool.evaluate(inputData.input2()).trim());
    }

    @Test(expected = AssertionError.class)
    public void TestFalseData2() {
        assertEquals(check2, tool.evaluate(inputData.input2False()).trim());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestIncorrectNumberLinesException() {
        tool.evaluate(inputData.inputIncorrectNumberLinesException());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestParseException() {
        tool.evaluate(inputData.inputParseException());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestParseDateException() {
        tool.evaluate(inputData.inputParseDateException());
    }

    @Test
    public void Test100K() {
        assertEquals(check, tool.evaluate(inputData.input100KRows()).trim());
    }
}
