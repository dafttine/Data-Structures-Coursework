
public interface MaxHeapInterface 
{
  //random number generator for option 1
  public void setGenerator1();
  
  //fixed array number generator
  public void setGenerator2();
  
  //adding elements sequentially
  public void addSeq();
  
  /*adding for the option 1, the original addSeq was not working with option 
  1 and it worked for option 2. Given that the deadline is impending, this was
  the best I could do. */
  public void addSeq1();
  
  //adding elements the smart way, same reason as adding sequentially
  public void addSmart1();
  public void addSmart();
  
  //remove max value on the Seq array
  public int removeMaxSeq();
  
  //remove max on the Smart array
  public int removeMaxSmart();
  
  //average swaps for a set of 20 for the smart method
  public void averageSmart();
  
  //average swaps for a set of 20 for the sequential method
  public void averageSeq();
  
  //print the sequential heap array 
  public void printSeqHeap();
  
  //print the optimal heap array
  public void printOptHeap();
  
  //check if the smart heap array is empty
  public boolean optIsEmpty();
  
  //check if the sequential heap array is empty
  public boolean seqIsEmpty();
}
