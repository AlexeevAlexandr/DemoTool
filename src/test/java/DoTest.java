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
        assertEquals(tool.evaluate(inputData.input1()).trim(), check);
    }

    @Test(expected = AssertionError.class)
    public void TestFalseData1() {
        assertEquals(tool.evaluate(inputData.input1False()).trim(), check);
    }

    @Test()
    public void TestData2() {
        assertEquals(tool.evaluate(inputData.input2()).trim(), check2);
    }

    @Test(expected = AssertionError.class)
    public void TestFalseData2() {
        assertEquals(tool.evaluate(inputData.input2False()).trim(), check2);
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
        assertEquals(tool.evaluate(inputData.input100KRows()).trim(), check);
    }
}
