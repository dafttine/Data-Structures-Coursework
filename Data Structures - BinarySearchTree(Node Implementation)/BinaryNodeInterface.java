
public interface BinaryNodeInterface<T> {
  public T getData();
  public void setData(T data);
  public void setLeftChild(BinaryNode<T> lc);
  public void setRightChild(BinaryNode<T> rc);
  public BinaryNode<T> getLeftChild();
  public BinaryNode<T> getRightChild();
  public BinaryNode<T> getRightMost();
  public BinaryNode<T> getLeftMost();
  public boolean hasRightChild();
  public boolean hasLeftChild();
  public boolean isLeaf();
  
}

