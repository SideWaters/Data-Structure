package µÚÊ®ÕÂ;

// Introduced in Chapter 10, modified in Chapters 11 and 17
/** Node in a binary tree. */
public class BinaryNode<E>
  implements Parent<E>, java.io.Serializable {

  /** The item associated with this node. */
  private E item;

  /** The node at the root of the left subtree. */
  private BinaryNode<E> left;

  /** The node at the root of the right subtree. */
  private BinaryNode<E> right;

  /** Put item in a leaf node. */
  public BinaryNode(E item) {
    this.item = item;
    // left and right are set to null by default
  }

  /** Put item in a node with the specified subtrees. */
  public BinaryNode(E item,
		           BinaryNode<E> left,
		           BinaryNode<E> right) {
    this.item = item;
    this.left = left;
    this.right = right;
  }

  public BinaryNode<E> getChild(int direction) {
    if (direction < 0) {
      return left;
    } else {
      return right;
    }
  }
  
  /** Return the item associated with this node. */
  public E getItem() {
    return item;
  }

  /** Return the root of the left subtree. */
  public BinaryNode<E> getLeft() {
    return left;
  }

  /** Return the root of the right subtree. */
  public BinaryNode<E> getRight() {
    return right;
  }

  /** Return true if this is a leaf. */
  public boolean isLeaf() {
    return (left == null) && (right == null);
  }

  public void setChild(int direction, BinaryNode<E> child) {
    if (direction < 0) {
      left = child;
    } else {
      right = child;
    }
  }

  /** Replace the item associated with this node. */
  public void setItem(E item) {
    this.item = item;
  }

  /** Replace the left subtree with the one rooted at left. */
  public void setLeft(BinaryNode<E> left) {
    this.left = left;
  }

  /** Replace the right subtree with the one rooted at right. */
  public void setRight(BinaryNode<E> right) {
    this.right = right;
  }

  /**
   * Return a String representation of the tree rooted at this node,
   * traversed inorder.
   */
  public String toStringInorder() {
    String result = "";
    if (left != null) {
      result += left.toStringInorder();
    }
    result += item;
    if (right != null) {
      result += right.toStringInorder();
    }
    return result;
  }

  /**
   * Return a String representation of the tree rooted at this node,
   * traversed postorder.
   */
  public String toStringPostorder() {
    String result = "";
    if (left != null) {
      result += left.toStringPostorder();
    }
    if (right != null) {
      result += right.toStringPostorder();
    }
    result += item;
    return result;
  }

  /**
   * Return a String representation of the tree rooted at this node,
   * traversed preorder.
   */
  public String toStringPreorder() {
    String result = "";
    result += item;
    if (left != null) {
      result += left.toStringPreorder();
    }
    if (right != null) {
      result += right.toStringPreorder();
    }
    return result;
  }

  /**
   * Return a String representation of the tree rooted at this node,
   * traversed level order.
   */
  public String toStringLevelOrder() {
    String result = "";
    Queue<BinaryNode<E>> q = new ArrayQueue<BinaryNode<E>>();
    q.add(this);
    while (!(q.isEmpty())) {
      BinaryNode<E> node = q.remove();
      result += node.item;
      if (node.left != null) {
        q.add(node.left);
      }
      if (node.right != null) {
        q.add(node.right);
      }
    }
    return result;
  }
  
  //---------------------------------------------10.17-------------------------------------------------------------
  public String toString(String a) {
	  String result = "";
	    result += a+item+"\n";
	    if (left != null) {
	      result += left.toString(a+"  ");
	    }
	    if (right != null) {
	      result += right.toString(a+"  ");
	    }
	    return result;
	  }
}
