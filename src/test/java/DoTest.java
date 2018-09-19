import services.Tool;
import org.junit.Test;
import services.InputData;

import static org.junit.Assert.assertEquals;

public class DoTest {
    private InputData inputData = new InputData();
    private Tool tool = new Tool();

    @Test
    public void TestData() {
        String check = "83 100 -";
        assertEquals(tool.evaluate(inputData.input()).trim(), check);

    }
}
