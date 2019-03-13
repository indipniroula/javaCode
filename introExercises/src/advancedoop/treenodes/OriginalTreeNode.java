package advancedoop.treenodes;

public class OriginalTreeNode<E> {
    private E key;
    private OriginalTreeNode<E>[] children;

    @SuppressWarnings("unchecked")
    public OriginalTreeNode(int numberOfChildren) {
        children = (OriginalTreeNode<E>[]) new OriginalTreeNode[numberOfChildren];
    }

    public int getNumberOfChildren() {
        return children.length;
    }

    public OriginalTreeNode<E> getChild(int childIndex) {
        return children[childIndex];
    }

    public void setChild(int childIndex, OriginalTreeNode<E> child) {
        children[childIndex] = child;
    }

    public E getKey() {
        return key;
    }

    public void setKey(E key) {
        this.key = key;
    }

    public OriginalTreeNode<E> clone() {
        OriginalTreeNode<E> cloned = new OriginalTreeNode<>(getNumberOfChildren());
        cloned.setKey(getKey());
        for (int i = 0; i < getNumberOfChildren(); i++) {
            cloned.setChild(i, getChild(i).clone());
        }
        return cloned;

    }
}
