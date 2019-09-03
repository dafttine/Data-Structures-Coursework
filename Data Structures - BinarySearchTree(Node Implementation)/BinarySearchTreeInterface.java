public interface BinarySearchTreeInterface<T>{
  public boolean hasEntry(BinaryNode<T> root, T value);
  public T addEntry(BinaryNode<T> root, T entry);
  public BinaryNode<T> removeEntry(BinaryNode<T> root, T entry);
  public T findPredecessor(BinaryNode<T> root, T value, T tempPredecessor);
  public T findSuccessor(BinaryNode<T> root, T value, T tempPredecessor);
  public void inorderTraverse(BinaryNode<T> a);
  public void preorderTraverse(BinaryNode<T> a);
  public void postorderTraverse(BinaryNode<T> a);
}
