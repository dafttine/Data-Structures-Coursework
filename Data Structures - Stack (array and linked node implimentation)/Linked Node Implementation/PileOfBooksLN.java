
public class PileOfBooksLN<T> implements PileOfBooksLNInterface<T>{
class Node{
  private T data;
  private Node next;
 
  private Node(T dataPortion) {
    this(dataPortion, null);
  }
  public Node(T dataPortion, Node nextNode) {
    data = dataPortion;
    next = nextNode;
  }
  private T getData() {
    return data;
  }
  private void setData(T newData) {
    data = newData;
  }
  private Node getNextNode() {
    return next;
  }
  private void setNextNode(Node nextNode) {
    next = nextNode;
  }
}

private Node firstNode;
private int numOfEntries;

public PileOfBooksLN() {
  firstNode = null;
  numOfEntries = 0;
  System.out.println("New Pile Made!");
}

public int getNumOfBooks() {
  return numOfEntries;
}

public boolean isEmpty() {
  if(numOfEntries == 0) {
    return true;
  }
  else {
    return false;
  }
}

public boolean addBook(T Book) {
  Node newNode = new Node(Book);
  newNode.next = firstNode;
  firstNode = newNode;
  numOfEntries++;
  System.out.println("The book has been added to the pile:" + Book.toString());
  return true;
}

public T removeBook() {
  T temp = null;
  if(firstNode !=null) {
    temp = firstNode.getData();
    firstNode = firstNode.getNextNode();
    numOfEntries--;
    System.out.println("The book has been removed: " + temp.toString() + ".");
  }
  else {
    System.out.println("There is nothing left in the pile to remove.");
  }
  return temp;
}

public boolean removeBook(T Book) {
  boolean result = false;  
  if(contains(Book)) {
  
    boolean beforeNodeN = true;
    Node currentNode = firstNode;
    Node nodeN= getIndex(Book);
    while(beforeNodeN == true) {
      if(currentNode.next.equals(nodeN)) {
        beforeNodeN = false;
      }
      else {
        currentNode = currentNode.getNextNode();
      }
    }
    currentNode.setNextNode(nodeN.next);
    System.out.println("The book has been removed: " + Book.toString() + ".");
    numOfEntries--;
   }
  else {
    System.out.println("That book is not in the pile.");
  }
    return result;
}

public void clear() {
  firstNode = null;
}

public int getFrequencyOf(T Book) {
  int freq = 0;
  int counter = 0;
  Node currentNode = firstNode;
  while((counter<numOfEntries) && (currentNode !=null)) {
    if(Book.equals(currentNode.getData())) {
      freq++;
    }
  counter++;
  currentNode = currentNode.getNextNode();
  }
  System.out.println("The book, " + Book.toString() + " appears in the pile " + freq + " times.");
  return freq;
}

/** Locates the Node that has the specific Book data
 * @param Book that is within the list that the user is looking for.
 * @return returns the Node that contains the Book.*/
public Node getIndex(T Book) {
  boolean found = false;
  Node currentNode = firstNode;
  while(!found && (currentNode!=null)) {
    if(Book.equals(currentNode.getData())) {
      found = true;
    }
    else {
      currentNode = currentNode.getNextNode();
    }
  }
  return currentNode;
}

public boolean contains(T Book) {
 boolean found = false;
 Node currentNode = firstNode;
 while(!found && (currentNode !=null)) {
   if(Book.equals(currentNode.getData())) {
     found = true;
   }
   else {
     currentNode = currentNode.getNextNode();
   }
 }
 return found;
}

public T[] toArray() {
  @SuppressWarnings("unchecked")
  T[] array = (T[])new PileOfBooksLN[numOfEntries];
  int index = 0;
  Node currentNode = firstNode;
  while((index<numOfEntries) && (currentNode != null)) {
    array[index] = currentNode.getData();
    index++;
    currentNode = currentNode.getNextNode();
  }
  return array;
}

public String toString() {
  String string = "";
  int i = 0;
  Node currentNode = firstNode;
  if(i < numOfEntries && currentNode!=null) {
    string = "This pile contains (top to bottom) : ";
    while(i<numOfEntries) {
      string += "\n";
      string += currentNode.getData();
      currentNode = currentNode.getNextNode();
      i++;
    }
  }
  else {
    System.out.println("There is nothing in the pile.");
  }
return string;
}

public static void main(String[] args) {
System.out.println("Testing: Creating a new Pile.");
PileOfBooksLN<String> A = new PileOfBooksLN<String>();

  System.out.println("\nTesting: If the Pile is Empty.");
  System.out.println(A.isEmpty());
  System.out.println("\nTesting: If the Pile is Empty.");
  A.addBook("Saiyuki");
  System.out.println(A.isEmpty());

  System.out.println("\nTesting: Adding to the Pile A.");
  A.addBook("Harry Potter");
  A.addBook("Mathilda");
  A.addBook("Mathilda");
  A.addBook("Lord of the Rings");
  A.addBook("The Hobbit");

System.out.println(A.toString());


System.out.println("\nTesting: Removing from the Pile's top. And then a specific book.");
A.removeBook();
A.removeBook("Harry Potter");

System.out.println(A.toString());

System.out.println("\nTesting: Number of Books currently in Pile.");
System.out.println(A.getNumOfBooks());

System.out.println("\nTesting: Frequency of Book.");
A.getFrequencyOf("Mathilda");
A.getFrequencyOf("Harry Potter");
A.getFrequencyOf("Saiyuki");
A.getFrequencyOf("Lord of the Rings");

System.out.println("\nTesting: Removing from an empty pile.");
A.removeBook();
A.removeBook();
A.removeBook();
A.removeBook();
A.removeBook();

System.out.println("\nTesting: Emptying a Pile.");
System.out.println("Adding to Pile.");
A.addBook("Harry Potter");
A.addBook("Mathilda");
A.addBook("Mathilda");
A.addBook("Lord of the Rings");
A.addBook("The Hobbit");
A.addBook("Harry Potter");
A.addBook("Edgar Allen Poe");
System.out.println(A.toString());
System.out.println("\nCleared Pile.");
A.clear();
System.out.println(A.toString());

}

}
