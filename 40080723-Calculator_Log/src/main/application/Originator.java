package main.application;
/**
 * Originator creates and stores states in Memento objects.
 * @author Jemish
 *
 */
public class Originator {
  private String state;

  
  public void setState(String state){
     this.state = state;
  }

  public String getState(){
     return state;
  }

 /**
  * This method saves state in momento objects.
  * @return the momento object
  */
  public Momento saveStateToMemento(){
    System.out.println("in savestatetomomento");
     return new Momento(state);
  }

  /**
   * This method get the state from momento object.
   * @param memento object
   */
  public void getStateFromMemento(Momento memento){
    System.out.println("in getstatetomomento");
     state = memento.getState();
  }
}
