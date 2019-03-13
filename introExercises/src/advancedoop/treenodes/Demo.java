package advancedoop.treenodes;

public class Demo {


    public static void main(String[] args) {

//        final TreeNode<String> root = new GeneralTreeNode<String>(4);
//        final TreeNode<String> child0 = new BinaryNode<String>();
//        final TreeNode<String> child1 = new BinaryNode<String>();
//        final TreeNode<String> child2 = new LeafNode<String>();
//        final TreeNode<String> child3 = new LeafNode<String>();
//        final TreeNode<String> child00 = new LeafNode<String>();
//        final TreeNode<String> child01 = new LeafNode<String>();
//        final TreeNode<String> child10 = new LeafNode<String>();
//        final TreeNode<String> child11 = new BinaryNode<String>();
//        final TreeNode<String> child110 = new LeafNode<String>();
//        final TreeNode<String> child111 = new LeafNode<String>();
//
//        root.setKey("Animal");
//        child0.setKey("Reptile");
//        child1.setKey("Bird");
//        child2.setKey("Mammal");
//        child3.setKey("Insect");
//        child00.setKey("Lizard");
//        child01.setKey("Salamander");
//        child10.setKey("Raven");
//        child11.setKey("Finch");
//        child110.setKey("Gold finch");
//        child111.setKey("Green finch");
//
//        root.setChild(0, child0);
//        root.setChild(1, child1);
//        root.setChild(2, child2);
//        root.setChild(3, child3);
//
//        child0.setChild(0, child00);
//        child0.setChild(1, child01);
//
//        child1.setChild(0, child10);
//        child1.setChild(1, child11);
//
//        child11.setChild(0, child110);
//        child11.setChild(1, child111);
//
//        System.out.println("Incomplete tree of life:");
//        System.out.println(root);

        TreeNode<String> root = new GeneralTreeNode<>(2);
        root.setKey("Main");
        TreeNode<String> c1 = new LeafNode<>();
        c1.setKey("Hello");
        TreeNode<String> c2 = new LeafNode<>();
        c2.setKey("James");
        TreeNode<String> c3 = new LeafNode<>();
        c3.setKey("ABC");
        root.setChild(0, c1);
        root.setChild(1, c2);

        System.out.println(root);

        OriginalTreeNode<Integer> root1 = new OriginalTreeNode<>(2);
        root1.setKey(0);
        OriginalTreeNode<Integer> a1 = new OriginalTreeNode<>(0);
        a1.setKey(1);
        OriginalTreeNode<Integer> a2 = new OriginalTreeNode<>(0);
        a2.setKey(2);

        root1.setChild(0, a1);
        root1.setChild(1, a2);

        OriginalTreeNode<Integer> clonedRoot1 = root1.clone();
        clonedRoot1.setKey(100);
        System.out.println(root1.getKey());
        System.out.println(clonedRoot1.getKey());




    }
}
