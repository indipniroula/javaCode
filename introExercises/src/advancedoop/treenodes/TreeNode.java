package advancedoop.treenodes;

public interface TreeNode<E> {

    int getNumberOfChildren();

    TreeNode<E> getChild(int childIndex);

    void setChild(int childIndex, TreeNode<E> child);

    E getKey();

    void setKey(E key);

}
