package test.application;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DecimalFormat;
import main.application.MainViewController;
import org.junit.Before;
import org.junit.Test;


/**
 * This class is test class for MainViewController which tests all the method such as 
 * validating input values, power values and logarithm function values. 
 * @author Jemish
 * 
 */
public class MainViewControllerTest {

  MainViewController testOb;
  
  /**
   * For before the test case.
   */
  @Before 
  public void before() {
    System.out.println("In before() which is called before every test case method!!");
    testOb = new MainViewController();
  }

  /**
   * This method tests the power method for integers.  
   */
  @Test
  public void testCalculatePower() {
    double result = testOb.calculatePower(2, 5);
    System.out.println("Power result :" + result);
    assertEquals(result, 32.0);
  }
  
  /**
   * This method tests the power method for real number.  
   */
  @Test
  public void testCalculatePower1() {
    double result = testOb.calculatePower(5.5, 3);
    System.out.println("Power result :" + result);
    assertEquals(result, 166.375);
  }
  
  /**
   * This method tests the natural logarithm method.  
   */
  @Test
  public void testCalculateNaturalLog() {
    double result = testOb.calculateNaturalLog(32);
    DecimalFormat df = new DecimalFormat(".#####");
    result = Double.parseDouble(df.format(result));
    assertEquals(result, 3.46574);
  }
  
  /**
   * This method tests the natural logarithm method.  
   */
  @Test
  public void testCalculateNaturalLog1() {
    double result = testOb.calculateNaturalLog(5.5);
    DecimalFormat df = new DecimalFormat(".#####");
    result = Double.parseDouble(df.format(result));
    assertEquals(result, 1.70475);
  }
  
  /**
   * This method tests the logarithm method which calculates log_b(x).  
   */
  @Test
  public void testCalculateLogxBaseb() {
    double result = testOb.calculateLogxBaseb(5.5, 2.2);
    DecimalFormat df = new DecimalFormat(".#####");
    result = Double.parseDouble(df.format(result));
    assertEquals(result, 2.16213);
  }
  
  /**
   * This method tests the logarithm method which calculates log_b(x).  
   */
  @Test
  public void testCalculateLogxBaseb1() {
    double result = testOb.calculateLogxBaseb(32, 2);
    DecimalFormat df = new DecimalFormat(".#####");
    result = Double.parseDouble(df.format(result));
    assertEquals(result, 5.0);
  }
  
  /**
   * This method validates input type that it is properly defined or nor.  
   */
  @Test
  public void testValidateValue1() {
    boolean result = testOb.validateValue11("string");
    assertFalse(result);
  }
  
  /**
   * This method validates input value that value of function is within its domain or not.  
   */
  @Test
  public void testValidateValue11() {
    boolean result = testOb.validateValue11("-5.6");
    assertFalse(result);
  }
  
  /**
   * This method validates input value that value of function is within its domain or not.  
   */
  @Test
  public void testValidateValue111() {
    boolean result = testOb.validateValue11("99.2");
    assertTrue(result);
  }
  
  /**
   * This method validates input base value that it should not be 1.  
   */
  @Test
  public void testValidateValue2() {
    boolean result = testOb.validateValue22("1");
    assertFalse(result);
  }
  
  /**
   * This method validates input base value that it should be within its domain.  
   */
  @Test
  public void testValidateValue22() {
    boolean result = testOb.validateValue22("2.2");
    assertTrue(result);
  }
}
