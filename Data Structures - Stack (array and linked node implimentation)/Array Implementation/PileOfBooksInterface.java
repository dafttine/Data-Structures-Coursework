
public interface PileOfBooksInterface <T> {

  /** Gets the number of books in the pile.
  @return An integer value equating to the number of books in the stack */
    public int getNumOfBooks();
    
  /** Checks if the pile is full.
  @return True/false depending on contents of pile. */
    public boolean isFull();
    
  /**Checks if the pile is empty
  @return true/false depending on contents of pile.*/  
    public boolean isEmpty();
    
  /** Adds a new book on top of the pile.
  @param Book to be added.
  @return True/false depending if the book can be added to the top */
    public boolean addBook(T Book);
    
  /** Removes one book from the top of the pile/the last array value.
  @return The book removed or null if nothing could be removed. */
    public boolean removeBook();
    
  /** Removes one book in a specific position in the pile, so long as given value has a book.
   * This is done by removing and shifting the books so that the order is kept.
  @param Book to be removed.
  @return True/false if the book removal was successful. */
    public boolean removeBook(T Book);
    
  /** Removes all books from desk by removing one value at a time. */
    public void clear();
    
  /** Counts the number of times a certain book is in the pile. I used a for loop and a counter 
   * for this.
  @param Book The entry to be counted.
  @return The number of times a book appears in the pile. */
    public int getFrequencyOf(T Book);
    
  /** Tests whether the pile contains a certain book through searching through the array.
  @param Book to find.
  @return True/false if the book is in the pile. */
    public boolean contains(T Book);

  /** Retrieves all books within the pile.
  @return A newly allocated array of all books in the pile. */
    public T[] toArray();

} // end BagInterface

