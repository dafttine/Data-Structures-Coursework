import java.util.Scanner;
public class BinarySearchTree<T extends Comparable <? super T>>
                                extends BinaryNode<T> 
                                implements BinarySearchTreeInterface<T> 
{

  private BinaryNode<T> root;
  public BinarySearchTree(){
    super();
  }
  
  public T getRoot() {
    return root.getData();
  }

  public void setRootData(T data) {
    this.setData(data); 
  }

public BinaryNode<T> removeEntry(BinaryNode<T> root, T entry) {
  if(hasEntry(root, entry)) {
    if(root != null) {
      T rootData = root.getData();
      if(entry.compareTo(rootData) == 0) {
        root = removeFromRoot(root);
      }
      else if(entry.compareTo(rootData) < 0) {
        BinaryNode<T> leftChild = root.getLeftChild();
        BinaryNode<T> subtreeRoot = removeEntry(leftChild, entry);
        root.setLeftChild(subtreeRoot);
      }
      else {
        BinaryNode<T> rightChild = root.getRightChild();
        root.setRightChild(removeEntry(rightChild, entry));
      } 
    }
  }
  else
    System.out.println(entry + " doesn't exist.");
  return root;
}

public BinaryNode<T> removeFromRoot(BinaryNode<T> root) {
  if(root.hasLeftChild() && root.hasRightChild()) {
    BinaryNode<T> LSubRoot = root.getLeftChild();
    BinaryNode<T> largestNode = findLargest(LSubRoot);
    root.setData(largestNode.getData());
    root.setLeftChild(removeLargest(LSubRoot));
  }
  else if(root.hasRightChild()) {
    root = root.getRightChild();
  }
  else {
    root = root.getLeftChild();
  }
  return root;
}

public BinaryNode<T> findLargest(BinaryNode<T> root){
  if(root.hasRightChild()) {
    root = findLargest(root.getRightChild());
  }
  return root;
}

public BinaryNode<T> removeLargest(BinaryNode<T> root){
  if(root.hasRightChild()) {
    BinaryNode<T> rightChild = root.getRightChild();
    BinaryNode<T> rootNode = removeLargest(rightChild);
    root.setRightChild(rootNode);
  }
  else {
    root = root.getLeftChild();
  }
  return root;
}

public T addEntry(BinaryNode<T> root, T entry) {
  T result = null;
  if(!hasEntry(root ,entry) && root.getData()!=null) {
    assert root != null;
    T rootData = root.getData();
    int comparison = entry.compareTo(rootData);
    if (comparison < 0) {
      if(root.hasLeftChild())
        result = addEntry(root.getLeftChild(), entry);
      else 
        root.setLeftChild(new BinaryNode<T>(entry));
    }
  
    else if(comparison > 0){
      if(root.hasRightChild())
        result = addEntry(root.getRightChild(),entry);
      else 
        root.setRightChild(new BinaryNode<T>(entry));
    }
    else if(comparison == 0){
        result = root.getData();
        root.setData(entry);
    }
    
  }
  else if (root.getData()==null) {
    root.setData(entry);
    result = root.getData();
  }
  else{
    System.out.println( entry + " already exists, ignore.");
  }
  return result;
}

public T findPredecessor(BinaryNode<T> root, T value, T tempPredecessor) {
  if(root == null) {
    System.out.println("Predecessor does not exist.");
    return null;
  }
  else if(root.getData().compareTo(value) == 0) {
    if(root.getLeftChild()!= null)
      return root.getLeftMost().getData();
  }
  else if(value.compareTo(root.getData()) < 0) {
    return findPredecessor(root.getLeftChild(),value, tempPredecessor);
  }
  else {
    tempPredecessor = root.getData();
    return findPredecessor(root.getRightChild(),value, tempPredecessor);
  }
  return tempPredecessor;
}



public T findSuccessor(BinaryNode<T> root, T value, T tempSuccessor) {
  if(root == null) {
    System.out.println("Successor does not exist.");
    return null;
  }
  else if(root.getData().compareTo(value) == 0) {
    if(root.getRightChild()!= null)
      return root.getRightChild().getData();
  }
  else if(value.compareTo(root.getData()) > 0) {
    return findSuccessor(root.getRightChild(),value, tempSuccessor);
  } 
  else {
    tempSuccessor = root.getData();
    return findSuccessor(root.getLeftChild(),value, tempSuccessor);
  }
  return tempSuccessor;
}

public void inorderTraverse(BinaryNode<T> a) {
  if(a!=null) {
    inorderTraverse(a.getLeftChild());
    System.out.print(a.getData() + " ");
    inorderTraverse(a.getRightChild());
  }
}
public void preorderTraverse(BinaryNode<T> a) {
  if(a!=null) {
    System.out.print(a.getData() + " ");
    preorderTraverse(a.getLeftChild());
    preorderTraverse(a.getRightChild());
  }
}
public void postorderTraverse(BinaryNode<T> a) {

 if(a!=null) {
    postorderTraverse(a.getLeftChild());
    postorderTraverse(a.getRightChild());
    System.out.print(a.getData() + " ");
 }
}

public boolean hasEntry(BinaryNode<T> root, T value) {
  boolean result = false;
  if(root.getData()!=null) {
    T rootEntry = root.getData();
    if(value.equals(rootEntry)) {
      result = true;
    }
    else if(value.compareTo(rootEntry) > 0) {
      if(root.getRightChild() != null)
        result = hasEntry(root.getRightChild(),value);
      else
      result = false;
    }
    else if(value.compareTo(rootEntry) < 0) {
      if(root.getLeftChild() != null)
        result = hasEntry(root.getLeftChild(),value);
      else
        result = false;
    }
  }
  return result;
}

//program display
  
  public static void displayMessage() {
    System.out.println("I  Insert a value.");
    System.out.println("D  Delete a value.");
    System.out.println("P  Find the Predecessor.");
    System.out.println("S  Find the Successor.");
    System.out.println("E  Exit the Program."); 
    System.out.println("H  Display this message");
  }

  public static void main(String[] args) {
    boolean init = true;
    boolean init1 = true;
    while(init1) {
      System.out.print("%");
      Scanner key = new Scanner(System.in);
      String passcode = key.nextLine();
      if(passcode.equals("java Project3"))
        init = true;
      else
        init = false;
      BinarySearchTree<Integer> a = new BinarySearchTree<Integer>();
      Scanner key2 = new Scanner(System.in);
      System.out.println("Please enter the initial sequence of values with spaces between values:");
      String input = key2.nextLine();
      String[] inputTokens = input.split(" ");
        for(int i = 0; i < inputTokens.length; i++) {
          int temp;
          temp = Integer.parseInt(inputTokens[i]);
          a.addEntry(a, temp);
       }
       System.out.print("Pre-order: ");
       a.preorderTraverse(a);
       System.out.print("\nIn-order: ");
       a.inorderTraverse(a);
       System.out.print("\nPost-order: ");
       a.postorderTraverse(a);
       System.out.print("\n");
      while(init) {
         System.out.print("\nCommand?");
         Scanner swCommand = new Scanner(System.in);
         String command = swCommand.nextLine(); 
         switch(command.charAt(0)) {
          case 'I' : 
            String tempEntry = "";
            for(int i = 2; i < command.length(); i++) {
              tempEntry += command.charAt(i);
            }
            int insert = Integer.parseInt(tempEntry);
            a.addEntry(a, insert);
            System.out.print("In-order: ");
            a.inorderTraverse(a);
          break;
       
          case 'D':
            String tempDel = "";
            for(int i = 2; i < command.length(); i++) {
              tempDel += command.charAt(i);
            }
            int delete = Integer.parseInt(tempDel);
            a.removeEntry(a, delete);
            System.out.print("In-order: ");
            a.inorderTraverse(a);
          break;
        
          case 'P':
            String tempPred = "";
            for(int i = 2; i < command.length(); i++) {
              tempPred += command.charAt(i);
            }
            int Pred = Integer.parseInt(tempPred);
            System.out.print(a.findPredecessor(a, Pred, null));
          break;
        
          case 'S':
            String tempSucc = "";
            for(int i = 2; i < command.length(); i++) {
              tempSucc += command.charAt(i);
            }
            int Succ = Integer.parseInt(tempSucc);
            System.out.print(a.findSuccessor(a, Succ, null));
            break;
          
          case 'E':
            System.out.println("Thank you for using this program, have a good day.");
            init = false;
            break;
          case 'H':
            displayMessage();
            break;
      }
    }
  }
}

}
