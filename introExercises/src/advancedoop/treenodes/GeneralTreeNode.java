package advancedoop.treenodes;

public class GeneralTreeNode<E> extends AbstractTreeNode<E> {

    private TreeNode<E>[] children;

    @SuppressWarnings("unchecked")
    public GeneralTreeNode(int numberOfChildren) {
        children = (TreeNode<E>[]) new TreeNode[numberOfChildren];
    }


    public int getNumberOfChildren() {
        return children.length;
    }

    public TreeNode<E> getChild(int childIndex) {
        return children[childIndex];
    }

    public void setChild(int childIndex, TreeNode<E> child) {
        children[childIndex] = child;
    }

}
