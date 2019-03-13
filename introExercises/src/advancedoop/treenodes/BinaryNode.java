package advancedoop.treenodes;

public class BinaryNode<E> extends AbstractTreeNode<E>{
    private TreeNode<E> child1;
    private TreeNode<E> child2;
    private static final int NUM_CHILDREN = 2;



    @Override
    public int getNumberOfChildren() {
        return NUM_CHILDREN;
    }

    @Override
    public TreeNode<E> getChild(int childIndex) {
        if (childIndex == 0) {
            return child1;
        } else if (childIndex == 1){
            return child2;
        }
        assert false;
        return null;
    }

    @Override
    public void setChild(int childIndex, TreeNode<E> child) {
        if (childIndex == 0) {
            this.child1 = child;
        } else if (childIndex == 1) {
            this.child2 = child;
        } else {
            assert false;
        }
    }



}
