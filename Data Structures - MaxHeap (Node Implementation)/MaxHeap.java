import java.util.*;
public class MaxHeap implements MaxHeapInterface
{
  private int[]   seqHeap;
  private int[]   smartHeap;
  private int[]   set;
  private int[] SwapsforSmart = new int[20];
  private int smartIndex = 0;
  private int seqIndex = 0;
  private int[] SwapsforSeq = new int [20];
  private int seqlastIndex = 0;
  private int optlastIndex = 0;
  private int numOfSwapsSeq = 0;
  private int numOfSwapsSmart = 0;
  private static final int DEFAULT_CAPACITY = 101;
 
  
  public MaxHeap() {
    smartHeap = new int[DEFAULT_CAPACITY];
    seqHeap = new int[DEFAULT_CAPACITY];
    set = new int[100];
    optlastIndex = 0;
    seqlastIndex = 0;
  }
  
  public void setGenerator1() {
    ArrayList<Integer> list = new ArrayList<Integer>(100);
    for(int index = 0; index < 100; index++) {
      list.add(index);
    }
   Collections.shuffle(list);
   for(int i = 0; i < 100; i++) {
     set[i] = (int) list.get(i);   
   }
  }
  
  public void setGenerator2() {
    for(int i = 0; i < 100; i++) {
      int val = i+1;
      set[i] = val;
    }
  }
  
  private void reheapOpt(int root) {
    boolean fin = false;
    int orphan = smartHeap[root];
    int lcIndex = 2 * root;
      while(!fin && (lcIndex < 101)) {
        int largerChild = lcIndex;
        int rcIndex = lcIndex + 1;
        if((rcIndex <= optlastIndex) && (smartHeap[rcIndex] > (smartHeap[largerChild]))){
          if(smartHeap[rcIndex] > (smartHeap[largerChild])) {
          largerChild = rcIndex;
          }
        }
        
        if(orphan < (smartHeap[largerChild])) {
          smartHeap[root] = smartHeap[largerChild];
          root = largerChild;
          lcIndex = 2 * root;
        }
        else
          fin = true;
        numOfSwapsSmart++;
      }
      smartHeap[root] = orphan;
  }
  
  //reheap for Optimal Method
  private void reheapOpt1(int root) {
  boolean fin = false;
  int orphan = smartHeap[root];
  int lcIndex = 2 * root;
    while(!fin && (lcIndex < 101)) {
      int largerChild = lcIndex-1;
      int rcIndex = lcIndex;
      if((rcIndex <= optlastIndex) && (smartHeap[rcIndex] > (smartHeap[largerChild]))){
        if(smartHeap[rcIndex] > (smartHeap[largerChild])) {
        largerChild = rcIndex;
        }
      }
      
      if(orphan < (smartHeap[largerChild])) {
        smartHeap[root] = smartHeap[largerChild];
        root = largerChild;
        lcIndex = 2 * root;
      }
      else
        fin = true;
      numOfSwapsSmart++;
    }
    smartHeap[root] = orphan;
  }
  
  //reheap method for Seq Array
  private void reheapSeq(int root) {
  boolean fin = false;
  int orphan = seqHeap[root];
  int lcIndex = 2 * root;
    while(!fin && (lcIndex < 101)) {
      int largerChild = lcIndex;
      int rcIndex = lcIndex + 1;
      if((rcIndex < 101) && (seqHeap[rcIndex] > (seqHeap[largerChild]))) {
        largerChild = rcIndex;
      }
    
      if(orphan < (seqHeap[largerChild])) {
        seqHeap[root] = seqHeap[largerChild];
        root = largerChild;
        lcIndex = 2 * root;
      }
      else
        fin = true;
      numOfSwapsSeq++;
    }
    seqHeap[root] = orphan;
  }
  
  public int getNumOfSwapsSeq() {
    return numOfSwapsSeq;
  }
  
  public int getNumOfSwapsSmart() {
    return numOfSwapsSmart;
  }
  
  public void add(int newEntry) {
      int newIndex = seqlastIndex + 1;
      int parent = newIndex / 2;
        while((parent > 0) && newEntry > seqHeap[parent]) {
          seqHeap[newIndex] = seqHeap[parent];
          newIndex = parent;
          parent = newIndex /2;
          numOfSwapsSeq++;
        }
      seqHeap[newIndex] = newEntry;
      seqlastIndex++;
  }
  
  public void add1(int newEntry) {
  int newIndex = seqlastIndex + 1;
  int parent = newIndex / 2;
    while((parent > 0) && newEntry > seqHeap[parent]) {
      seqHeap[newIndex] = seqHeap[parent];
      newIndex = parent;
      parent = newIndex /2;
      numOfSwapsSeq++;
    }
    seqHeap[newIndex] = newEntry;
    seqlastIndex++;
  }
  
   
  public void addSmart() {
    int smartSwaps = 0;
     for(int setIndex = 0; setIndex < 100; setIndex++) {
         int temp = set[setIndex];
         smartHeap[setIndex+1] = temp;
         optlastIndex++;
     }
    for(int root = 50; root > 0; root--) {
     reheapOpt(root);
     smartSwaps++;
    }
    SwapsforSmart[smartIndex] = smartSwaps;
    smartIndex++;
  }

  public void addSmart1() {
  int smartSwaps = 0;
   for(int setIndex = 0; setIndex < 100; setIndex++) {
       int temp = set[setIndex];
       smartHeap[setIndex+1] = temp;
       optlastIndex++;
   }
    for(int root = 50; root > 0; root--) {
      reheapOpt1(root);
      smartSwaps++;
  }
    SwapsforSmart[smartIndex] = smartSwaps;
    smartIndex++;
  }
  
  public void addSeq() { 
    for(int i = 0; i < set.length; i++) {
      add(set[i]);
    }
    SwapsforSeq[seqIndex] = numOfSwapsSeq;
    seqIndex++;
  }
  
  public int removeMaxSmart() { 
    int root = 0;
    if(!optIsEmpty()) {
      root = smartHeap[1];
      smartHeap[1] = smartHeap[optlastIndex];
      optlastIndex--;
      reheapOpt(1);
    }
    return root;
  }
  
  public int removeMaxSeq() {
    int root = 0;
    if(!seqIsEmpty()) {
      root = seqHeap[1];
      seqHeap[1] = seqHeap[seqlastIndex];
      seqlastIndex--;
      reheapSeq(1);
    }
    return root;
  }

  public void addSeq1() { 
  seqlastIndex = 0;
  for(int i = 0; i < set.length; i++) {
    add1(set[i]);
  }
    SwapsforSeq[seqIndex] = numOfSwapsSeq;
    seqIndex++;
    numOfSwapsSeq = 0;
  }
  
  public boolean seqIsEmpty() { 
    return seqlastIndex < 1;
  }
  public boolean optIsEmpty() { 
    return optlastIndex < 1;
  }
  
  public void averageSmart() {
    int sum = 0;
    for(int i = 0; i < 20; i++) {
      sum += SwapsforSmart[i];
    }
    int average = sum/20;
    System.out.println(average);
  }
  
  public void averageSeq() {
  int sum = 0;
  for(int i = 0; i < 20; i++) {
    sum += SwapsforSeq[i];
  }
  int average = sum/20;
  System.out.println(average);
}

  public void printSeqHeap() {
    for(int i = 1; i < 11; i++) {
      System.out.print(seqHeap[i] + ", ");
    }
    System.out.println("...");
  }
  
  public void printOptHeap() {
    for(int i = 1; i < 11; i++) {
      System.out.print(smartHeap[i] + ", ");
    }
    System.out.println("...");
  }

}
