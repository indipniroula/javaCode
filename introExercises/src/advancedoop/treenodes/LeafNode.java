package advancedoop.treenodes;

public class LeafNode<E> extends AbstractTreeNode<E> {

    private static final int NUM_CHILDREN = 0;

    @Override
    public int getNumberOfChildren() {
        return NUM_CHILDREN;
    }

    @Override
    public TreeNode<E> getChild(int childIndex) {
        return null;
    }

    @Override
    public void setChild(int childIndex, TreeNode<E> child) {

    }

    @Override
    public TreeNode<E> clone() {
        return null;
    }


}
