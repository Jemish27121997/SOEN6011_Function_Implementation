package main.application;


import java.util.ArrayList;
import java.util.List;
/**
 * Caretaker object is responsible to restore object state from Memento.
 * @author Jemish
 *
 */
public class CareTaker {
  public List<Momento> mementoList = new ArrayList<Momento>();

  /**
   * This method adds momento state into momentolist.
   * @param state 
   */
  public void add(Momento state){
    System.out.println("in add momento savestatetomomento");
     mementoList.add(state);
  }

  /**
   * This method gets the momento from list.
   * @param index  
   * @return the momento depending on index
   */
  public Momento get(int index){
    System.out.println("in get momento");
     return mementoList.get(index);
  }
}
