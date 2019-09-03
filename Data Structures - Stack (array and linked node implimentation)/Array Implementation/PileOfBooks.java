import java.util.Arrays;
public class PileOfBooks<T> implements PileOfBooksInterface<T>{

private T[] pile;
private static final int DEFAULT_CAPACITY = 15;
private int numOfEntries = 0;

public PileOfBooks() {
  /*you can set your own capacity as your desk may see fit, but this is just a starting point*/
  this(DEFAULT_CAPACITY);
}

public PileOfBooks(int capacity) {
  @SuppressWarnings("unchecked")
  T[] tempPile = (T[])new Object[capacity];
  pile = tempPile;
  numOfEntries = 0;
  System.out.println("You have a pile with the capacity for: " + capacity + " books.");
}

/*This method will double the length of the array to accommodate for arrays that are too short.*/
private void expandList() {
  this.pile = Arrays.copyOf(this.pile, 2 * this.pile.length);
}

public int getNumOfBooks() {
  return this.numOfEntries;
}

public boolean isFull() {
  boolean full = false;
  if(this.numOfEntries == pile.length) {
    full = true;
  }
  else {
    full = false;
  }
  return full;
}

public boolean isEmpty() {
  boolean empty = true;
  if(this.numOfEntries > 0) {
    empty = false;
  }
  else {
    empty = true;
  }
  return empty;
}

public boolean addBook(T Book) {
  boolean success = true;
  if(this.isFull()){
    expandList();
    this.pile[this.numOfEntries] = Book;
    this.numOfEntries++;
    System.out.println("We've cleaned up your desk to hold " + this.pile.length + " books. Your book has been added: " + this.toString(Book));
    
  }
  else {
    this.pile[this.numOfEntries] = Book;
    this.numOfEntries++;
    System.out.println("Your book has successfully been added: " + this.toString(Book));
  }
  return success;
}

public boolean removeBook() {
  boolean result = false;
  int index = 0;
  T book = null;
  if(!this.isEmpty()) {
    index = this.numOfEntries-1;
    book = this.pile[index];
    this.pile[index] = null;
    this.numOfEntries--;
    System.out.println("The book has been successfully removed: " + this.toString(book));
  }
  else {
    System.out.println("The pile is empty, there is nothing to remove.");
  }
  return result;
}

public boolean removeBook(T Book) {
  boolean exist = false;
  boolean success = true;
  int index = 0;
  
  for(int i = 0; i<this.numOfEntries ;i++) {
    if(Book.equals(this.pile[i])) {
      exist = true;
      index = i;
    }
  }
   
  if(exist) {
    this.pile[index] = null;
    this.numOfEntries--;
    for(int i = 1; i < this.numOfEntries-1; i++) {
      this.pile[index] = this.pile[index + i];
    }
    this.pile[this.numOfEntries] = null;
    System.out.println("The book has been successfully removed: " + this.toString(Book));
  }
 
  else {
    System.out.println("Sorry, that book does not exist within the pile.");
  }
 return success;
}

public void clear() {
  while(!this.isEmpty()) {
    this.removeBook();
  }
}

public int getFrequencyOf(T Book) {
  int freq = 0;
  for(int i = 0; i < this.numOfEntries; i++) {
    if(this.pile[i].equals(Book)) {
      freq++;
    }
  }
  System.out.println(Book.toString() + " appears " + freq + " times in the pile.");
  return freq;
}

public boolean contains(T Book) {
  boolean there = false;
  for(int i = 0; i > this.pile.length; i++) {
    if(Book.equals(this.pile[i])) {
      there = true;
      break;
    }
    else {
      there = false;
    }
  }
  return there;
}

public T[] toArray() {
  @SuppressWarnings("unchecked")
  T[] result = (T[])new PileOfBooks[this.numOfEntries];
  for(int i = 0; i < this.numOfEntries; i++) {
    result[i] = this.pile[i];
  }  
return result;
}

public String toString() {
  String string = "\nThis pile contains (top to bottom) : ";
  for(int i = this.pile.length-1; i >= 0; i--) {
    string += "\n";
    string += this.pile[i];
  }
return string;
}

public String toString(T Book) {
  String string = (String) Book;   
  return string;
}

public static void main(String[] args) {
  System.out.println("Testing: Creating a new Pile.");
  PileOfBooks<String> A = new PileOfBooks<String>(5);
  PileOfBooks<String> B = new PileOfBooks<String>();
  
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
  
  System.out.println("\nTesting: If the Pile is Full.");
  System.out.println(A.isFull());
  
  System.out.println("\nTesting: Removing from the Pile's top. And then a specific book.");
  A.removeBook();
  A.removeBook("Harry Potter");
  A.removeBook("Oedipus");

  System.out.println(A.toString());
  
  System.out.println("\nTesting: Number of Books currently in Pile.");
  System.out.println(A.getNumOfBooks());
  
  System.out.println("\nTesting: Frequency of Book.");
  A.getFrequencyOf("Mathilda");
  A.getFrequencyOf("Harry Potter");
  
  System.out.println("\nTesting: Removing from an empty pile.");
  A.removeBook();
  A.removeBook();
  A.removeBook();
  A.removeBook();
  A.removeBook();
  
  System.out.println("\nTesting: Emptying a Pile.");
  A.addBook("Harry Potter");
  A.addBook("Mathilda");
  A.addBook("Mathilda");
  A.addBook("Lord of the Rings");
  A.addBook("The Hobbit");
  A.addBook("Harry Potter");
  A.addBook("Edgar Allen Poe");
  System.out.println(A.toString());
  A.clear();
  System.out.println(A.toString());

}
}
