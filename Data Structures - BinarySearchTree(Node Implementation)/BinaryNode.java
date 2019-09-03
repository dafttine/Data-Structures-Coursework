public class BinaryNode<T> implements BinaryNodeInterface<T>{
private T data;
private BinaryNode<T> leftChild;
private BinaryNode<T> rightChild;

  //constructors
  public BinaryNode() {
    this(null);
  }
  public BinaryNode(T data) {
    this(data, null, null);
  }
  public BinaryNode(T data, BinaryNode<T> rc, BinaryNode<T> lc) {
    this.data = data;
    this.leftChild = lc;
    this.rightChild = rc;
  }

  //get data and set nodes methods
  public T getData(){
    return data;
  }
  public void setData(T data) {
    this.data = data;
  }
  public BinaryNode<T> getLeftChild(){
    return leftChild;
  }
  public BinaryNode<T> getRightChild(){
    return rightChild;
  }
  public void setLeftChild(BinaryNode<T> lc){
    this.leftChild = lc;
  }
  public void setRightChild(BinaryNode<T> rc){
    this.rightChild = rc;
  }
  public BinaryNode<T> getRightMost() { 
  if(this.getRightChild() == null)
    return this;
  else
    return this.getRightChild().getRightMost(); 
  } 
  public BinaryNode<T> getLeftMost() {
    if(this.getLeftChild() == null)
      return this;
    else 
      return this.getLeftChild().getLeftMost();
  }
  
  //checks existence of children
  public boolean hasLeftChild() {
    if(leftChild == null)
      return false;
    else {
      return true;
    }
  } 
  public boolean hasRightChild() {
    if(rightChild == null)
      return false;
    else {
      return true;
    }
  }
  public boolean isLeaf() {
    if(this.hasLeftChild() || this.hasRightChild()) 
      return false;
    else
      return true;
  }

}
