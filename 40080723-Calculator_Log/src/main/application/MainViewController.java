
package main.application;

import java.text.DecimalFormat;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
/**
 * This class implements logarithm function, power function, calculates natural log and 
 * validates input values and type. 
 * @author Jemish
 *
 */

public class MainViewController {
    
  @FXML private TextArea display;
  @FXML private Button one;
  @FXML private Button two;
  @FXML private Button three;
  @FXML private Button four;
  @FXML private Button five;
  @FXML private Button six;
  @FXML private Button seven;
  @FXML private Button eight;
  @FXML private Button nine;
  @FXML private Button zero;
  @FXML private Button times;
  @FXML private Button divided;
  @FXML private Button plus;
  @FXML private Button minus;
  @FXML private Button log;
  @FXML private Button buttonMemoryRead;
  @FXML private Button buttonMemoryWrite;
  @FXML private Button buttonDelete;
  
  private Boolean[] operator = new Boolean[5];
  private int operatorCount = 0;
  private static boolean flag = false;
  double[] temporary = {0, 0};
  
  private String actualText;
  
  private Main main;
  
  public static Originator originator = new Originator();
  public static CareTaker careTaker = new CareTaker();
  
  /**
   * Default constructor.
   */
  public MainViewController() {
    System.out.println("");
  }
  
  /**
   * This method sets display editable.
   * @param main object
   */
  public void setMain(Main main) {
    this.main = main;
    display.setEditable(false);
    
    display.setText("0");
    for (int i = 0; i < 5; i++) {
      operator[i] = false;
    }
  }
  
  
  /**
   * This method calculates a raised to b.
   * @param a value of base
   * @param b value of exponent
   * @return a raised to b
   */
  public double calculatePower(double a,double b) {
    //return Math.pow(a, b);
    double p = 1;
    for (int i = 1; i <= b; i++) {
      p = p * a;
    }
    return p; //return Math.pow(a, b);
  }
  
  
  /**
   * This method calculates natural logarithm using Maclaurin's Series.
   * @param n input value for ln
   * @return the natural log (ln)
   */
  public double calculateNaturalLog(double n) {
    
    double sum = 0;
    double j = (n - 1) / (n + 1);
    for (int i = 1; i <= 999; i++) {
      double k = 2 * i - 1;
      sum += (1 / k) * (calculatePower(j,k));
    }
    System.out.println("Natural Log (ln) result :" + 2 * sum);
    return 2 * sum;

  }
  
  
  /**
   * This method calculates log_b(x) using natural log. e.g. log_b(x) = ln(x)/ln(b)
   * @param x input value
   * @param b base value
   * @return the log of x base b
   */
  public double calculateLogxBaseb(double x,double b) {
    double value = calculateNaturalLog(x);
    double base = calculateNaturalLog(b);
    double result = value / base;
    return result; 
  }
  
  
  /**
   * This method validates the input value x.
   * @param value x
   * @return true if it is properly defined otherwise returns false
   */
  public boolean validateValue1(String value) {
    Alert alert = new Alert(AlertType.INFORMATION);
    try {  
      if (Double.parseDouble(value) <= 0) {
        alert.setTitle("Alert !!!");
        alert.setContentText("Value of x should be within its domain !!");
        alert.showAndWait();
        return false;
      } else {
        return true;
      }
    } catch (NumberFormatException e) {  
      alert.setTitle("Alert !!!");
      alert.setContentText("Input type is not properly defined, it should be number !!");
      alert.showAndWait();
      return false;      
    }
  }
  
  
  /**
   * This method validates the input base value b.
   * @param value base b
   * @return true if it is properly defined otherwise returns false
   */
  public boolean validateValue2(String value) {
    Alert alert = new Alert(AlertType.INFORMATION);
    try {  
      if (Double.parseDouble(value) <= 0 || Double.parseDouble(value) == 1) {
        alert.setTitle("Alert !!!");
        alert.setContentText("Value of x should be within its domain !!");
        alert.showAndWait();
        return false;
      } else {
        return true;
      }
    } catch (NumberFormatException e) {  
      alert.setTitle("Alert !!!");
      alert.setContentText("Input type is not properly defined, it should be number !!");
      alert.showAndWait();
      return false;  
    }
  }
  
  
  /**
   * This method validates the input value x.
   * @param value x
   * @return true if it is properly defined otherwise returns false
   */
  public boolean validateValue11(String value) {

    try {  
      if (Double.parseDouble(value) <= 0) {
        System.out.println("Value of x should be within its domain !!");
        return false;
      } else {
        return true;
      }
    } catch (NumberFormatException e) { 
      System.out.println("Input type is not properly defined, it should be number !!");
      return false;  
    }
  }
  
  
  /**
   * This method validates the input base value b.
   * @param value base b
   * @return true if it is properly defined otherwise returns false
   */
  public boolean validateValue22(String value) {
    try {  
      if (Double.parseDouble(value) <= 0 || Double.parseDouble(value) == 1) {
        System.out.println("Value of x should be within its domain !!");
        return false;
      } else {
        return true;
      }
    } catch (NumberFormatException e) { 
      System.out.println("Input type is not properly defined, it should be number !!");
      return false;  
    }
  }
  
  
  
  /**
   * This method handle the all the button and set the display according to button Id given in fxml.
   * @param event FXML event
   */
  @FXML
  public void handleClick(Event event) {
    actualText = display.getText();
    if (display.getText().equals("0") || display.getText() == "0") {
      buttonDelete.setText("C");
      display.setText("");
      System.out.println("actualText: " + actualText);
      actualText = "";      
    }
    Button btn = (Button) event.getSource();
    switch (btn.getId()) {
      case "zero" :
        display.appendText("0");
        break;
      case "one" :
        display.appendText("1");
        break;
      case "two" :
        display.appendText("2");
        break;
      case "three" :
        display.appendText("3");
        break;
      case "four" :
        display.appendText("4");
        break;
      case "five" :
        display.appendText("5");
        break;
      case "six" :
        display.appendText("6");
        break;
      case "seven" :
        display.appendText("7");
        break;
      case "eight" :
        display.appendText("8");
        break;
      case "nine" :
        display.appendText("9");
        break;
      case "comma" :
        display.appendText(".");
        break;
      default:
    }
  }
  
  
  /**
   * This method clears text area.
   * @param event FXML event
   */
  @FXML public void delete(Event event) {
    buttonDelete.setText("AC");
    display.setText("0");
    careTaker.mementoList.clear();
    for (int i = 0; i < 2; i++) {
      temporary[i] = 0;
    }
    for (int i = 0; i < 5; i++) {
      operator[i] = false;
    }  
  }
  
  /**
   * This method stores the final result into memory using momento pattern.
   * @param event FXML event
   */
  @FXML public void memoryWrite(Event event) {
    System.out.println("in memory write");
    if (display.getText().split(":").length > 1) {
      String []s = display.getText().split(":");
      originator.setState(s[1]);
    } else {
      originator.setState(display.getText());
    }
    careTaker.add(originator.saveStateToMemento());
  }
  
  /**
   * This method retrieves the state from memory using momento pattern.  
   * @param event FXML Event
   */
  @FXML public void memoryRead(Event event) {
    System.out.println("in memory read");
    originator.getStateFromMemento(careTaker.get(0));
    display.setText("History : " + originator.getState());
  }
  
  
  /**
   * This method performs the action according to user input.
   * @param event FXML event
   */
  @FXML public void operation(Event event) {
    operatorCount++;
    System.out.println("operatorCount: " + operatorCount);
    if (display.getText() != "") {
      actualText = display.getText();
    }
    
    Button btn = (Button) event.getSource();
    String operation = btn.getId();
    switch (operation) {
      case "plus":
        operator[0] = true;
        temporary[0] = Double.parseDouble(display.getText());
        display.setText("");
        break;
      case "minus":
        operator[1] = true;
        temporary[0] = Double.parseDouble(display.getText());
        display.setText("");
        break;
      case "times":
        operator[2] = true;
        temporary[0] = Double.parseDouble(display.getText());
        display.setText("");
        break;
      case "divided":
        operator[3] = true;
        temporary[0] = Double.parseDouble(display.getText());
        display.setText("");
        break;
      case "log":
        operator[4] = true;
        flag = true;
        
        TextInputDialog td = new TextInputDialog(); 
        td.setHeaderText("Enter Value X :");
        td.showAndWait();
        TextField t1 = td.getEditor();
        System.out.println(t1.getText());
        while (!(validateValue1(t1.getText()))) {
          td = new TextInputDialog(); 
          td.setHeaderText("Enter Value X :");
          td.showAndWait();
          t1 = td.getEditor();
          System.out.println(t1.getText());
        }
        temporary[0] = Double.parseDouble(t1.getText());
        System.out.println("Value 1 : " + temporary[0]);
        
        TextInputDialog td1 = new TextInputDialog(); 
        td1.setHeaderText("Enter Base b :");
        td1.showAndWait();
        TextField t2 = td1.getEditor();
        System.out.println(t2.getText());
        while (!(validateValue2(t2.getText()))) {
          td1 = new TextInputDialog(); 
          td1.setHeaderText("Enter Base b :");
          td1.showAndWait();
          t2 = td1.getEditor();
          System.out.println(t2.getText());
        }
        temporary[1] = Double.parseDouble(t2.getText());
        System.out.println("Value 2 : " + temporary[1]);
        
        display.setText("Value X : " + t1.getText() + "\nBase b :" + t2.getText());
        break;
      default:
    }   
  }
  

  /**
   * This method prints final result according to function.
   * @param event FXML event
   */
  @FXML public void result(Event event) {
    double result = 0;
    if (!flag) {
      temporary[1] = Double.parseDouble(display.getText());   
    }
    if (operator[0]) {
      result = temporary[0] + temporary[1];
    } else if (operator[1]) {
      result = temporary[0] - temporary[1];
    } else if (operator[2]) {
      result = temporary[0] * temporary[1];
    } else if (operator[3]) {
      result = temporary[0] / temporary[1];
    } else if (operator[4]) {
      result = calculateLogxBaseb(temporary[0],temporary[1]);
      DecimalFormat df = new DecimalFormat(".#####");
      result = Double.parseDouble(df.format(result));
    }
    System.out.println("result: " + result);
    display.setText("Result : " + Double.toString(result));    
  }
}