import org.junit.Test;
import services.InputData;
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


}
