package µÚÊ®ÕÂ;

public class TreeNode<E> {
	/** The item associated with this node. */
	private E item;

	/** The node of this node's child. */
	private TreeNode<E> child;

	/** The node of this node's brother. */
	private TreeNode<E> brother;

	public TreeNode(E item) {
		this.item = item;
	}

	public void setItem(E item) {
		this.item = item;
	}

	// if has child, then give child a brother
	public void setChild(TreeNode<E> child) {
		TreeNode<E> node = this.child;
		if (node == null) {
			this.child = child;
		} else {
			node.setBrother(child);
		}
	}

	// if don't have brother, brother=brother,if have, then set brother's brother
	public void setBrother(TreeNode<E> brother) {
		TreeNode<E> node = this.brother;
		if (node == null) {
			this.brother = brother;
		} else {
			node.setBrother(brother);
		}
	}

	public E getItem() {
		return item;
	}

	public TreeNode<E> getChild() {
		return child;
	}

	public TreeNode<E> getBrother() {
		return brother;
	}

	public String toStringPostorder() {
		String result = "";
		if (brother != null) {
			result += brother.toStringPostorder();
		}
		if (child != null) {
			result += child.toStringPostorder();
		}
		result += item;
		return result;
	}

	public static void main(String args[]) {
		TreeNode<Integer> a = new TreeNode<Integer>(1);
		a.setChild(new TreeNode(2));
		a.getChild().setBrother(new TreeNode(4));
		a.getChild().getBrother().setBrother(new TreeNode(4));
		a.getChild().setChild(new TreeNode(5));
		a.getChild().getChild().setBrother(new TreeNode(6));
		System.out.print(a.toStringPostorder());
	}
}
