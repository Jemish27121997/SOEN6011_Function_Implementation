package main.application;
/**
 * Memento contains state of an object to be restored
 * @author Jemish
 *
 */
public class Momento {
  private String state;

  /**
   * Parameterized Constructor
   * @param state 
   */
  public Momento(String state){
     this.state = state;
  }

  /**
   * This is getter method.
   * @return state of an object
   */
  public String getState(){
     return state;
  }    
}
