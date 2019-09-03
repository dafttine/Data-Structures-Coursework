import java.util.Scanner;
public class MaxHeapMain {

public static void main(String[] args) {
  boolean init = true;
  while(init) {
  System.out.println("Please select how to test the program:"
                + "\n(1) 20 sets of 100 randomly generated integers "
                + "\n(2) Fixed integer values 1-100");
  System.out.print("Enter choice: ");
  Scanner key = new Scanner(System.in);
  
  
    switch(key.next()) {
      
    
      case ("1"):
        MaxHeap set1 = new MaxHeap();
        for(int i = 0; i < 20; i++) {
          set1.setGenerator1(); //generate set for test
          set1.addSmart1();
          set1.addSeq1();
        }
        System.out.print("Average Swaps for series of insertions: ");
        set1.averageSeq();
        System.out.print("Average Swaps for optimal method: ");
        set1.averageSmart();
        System.out.println("===================================================================================================================");
        break;
        
        
        
      case ("2"):
        MaxHeap set2 = new MaxHeap();
        set2.setGenerator2(); //generate set for test
       
        
        set2.addSeq();
        System.out.print("Heap Built using series of insertions: ");
        set2.printSeqHeap();
        System.out.print("Number of Swaps: "); 
        System.out.println(set2.getNumOfSwapsSeq());
        System.out.print("Heap after 10 removals: "); 
        for(int i = 0; i < 10; i++)
          set2.removeMaxSeq();
        set2.printSeqHeap();
        
       
        set2.addSmart();
        System.out.print("Heap Built using optimal method: ");
        set2.printOptHeap();
        System.out.print("Number of Swaps: ");
        System.out.println(set2.getNumOfSwapsSmart());
        System.out.print("Heap after 10 removals: "); 
        for(int i = 0; i < 10; i++)
          set2.removeMaxSmart();
        set2.printOptHeap();
        System.out.println("===================================================================================================================");
        break;
        
      default:
        System.out.println("Please select 1 or 2.");
        break;
    }
  }
 

}

}
