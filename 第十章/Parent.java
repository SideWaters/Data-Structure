package µÚÊ®ÕÂ;

// Introduced in Chapter 11
/**
 * Something which has children, such as a BinarySearchTree or a
 * BinaryNode.
 */
public interface Parent<E> {

  /**
   * Return the left child if direction < 0, or the right child
   * otherwise.
   */
  public BinaryNode<E> getChild(int direction);

  /**
   * Replace the specified child of this parent with the new child.
   * If direction < 0, replace the left child.  Otherwise, replace
   * the right child.
   */
  public void setChild(int direction, BinaryNode<E> child);
  
}
