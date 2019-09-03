public interface PileOfBooksLNInterface<T> {
  /** Gets the number of books in the pile.
  @return An integer value equating to the number of books in the stack */
    public int getNumOfBooks();
    
  /**Checks if the pile is empty
  @return true/false depending on contents of pile.*/  
    public boolean isEmpty();
    
  /** Adds a new book on top of the pile. We do this by first making a new node
   * and then making the first node be it's next node thus making the new node, the 
   * new first node.
  @param Book to be added.
  @return True/false depending if the book can be added to the top */
    public boolean addBook(T Book);
    
  /** Removes one book from the top of the pile aka the first node.
  @return The book removed or null if nothing could be removed. */
    public T removeBook();
    
  /** Removes one book in a specific position in the pile, so long as given value has a book. 
   * We do this by setting the node to the node after the Book we'd like to remove, thus 
   * maintaining the order.
  @param Book to be removed.
  @return True/false if the book removal was successful. */
    public boolean removeBook(T Book);
    
  /** Removes all books from desk by setting the first node to null. */
    public void clear();
    
  /** Counts the number of times a certain book is in the pile by going through a while loop
   * and incrementing.
  @param Book The entry to be counted.
  @return The number of times a book appears in the pile. */
    public int getFrequencyOf(T Book);
    
  /** Tests whether the pile contains a certain book by searching the list node after node.
  @param Book to find.
  @return True/false if the book is in the pile. */
    public boolean contains(T Book);

  /** Retrieves all books within the pile.
  @return A newly allocated array of all books in the pile. */
    public T[] toArray();

} // end BagLNInterface


