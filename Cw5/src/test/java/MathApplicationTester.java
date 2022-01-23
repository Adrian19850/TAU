import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.reset;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

    private MathApplication mathApplication;
    private CalculatorService calcService;

    @Before
    public void setUp(){
        mathApplication = new MathApplication();
        calcService = mock(CalculatorService.class);
        mathApplication.setCalculatorService(calcService);
    }

    @Test
    public void testAdd(){
        when(calcService.add(5.0,6.0)).thenReturn(11.0);
        Assert.assertEquals(mathApplication.add(5.0, 6.0),11.0,0);

    }
    @Test
    public void testAddGiven(){
         given(calcService.add(13.0,15.0)).willReturn(28.0);
        double result = calcService.add(13.0,15.0);
        Assert.assertEquals(result,28.0,0);
    }
    @Test
    public void testSubtract(){
         when(calcService.subtract(20.0,10.0)).thenReturn(10.0);
        Assert.assertEquals(mathApplication.subtract(20.0, 10.0),10.0,0);
    }
    @Test
    public void testGiven(){
         given(calcService.subtract(10.0,5.0)).willReturn(5.0);
        Assert.assertEquals(mathApplication.subtract(10.0, 5.0),5.0,0);
    }
    @Test
    public void testMultiply(){
         when(calcService.multiply(5.0,5.0)).thenReturn(25.0);
        Assert.assertEquals(mathApplication.multiply(5.0, 5.0),25.0,0);
    }
    @Test
    public void testMultiplyGiven(){
        given(calcService.multiply(6.0,7.0)).willReturn(42.0);
        Assert.assertEquals(mathApplication.multiply(6.0, 7.0),42.0,0);
    }
    @Test
    public void testDivide(){
         when(calcService.divide(25.0,5.0)).thenReturn(5.0);
        Assert.assertEquals(mathApplication.divide(25.0, 5.0),5.0,0);
    }
    @Test
    public void testDivideGiven(){
        given(calcService.divide(25.0,5.0)).willReturn(5.0);
        Assert.assertEquals(mathApplication.divide(25.0, 5.0),5.0,0);
    }
}