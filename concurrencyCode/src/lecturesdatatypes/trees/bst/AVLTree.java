package lecturesdatatypes.trees.bst;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class AVLTree<E extends Comparable<E>> implements BST<E> {

    private AvlNode<E> root = null;

    public AVLTree(E element) {
        root = new AvlNode<E>(element);
    }

    public AVLTree() {
        root = null;
    }

    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        for (int i = 0; i < 7; i++) {
            tree.add(i);
            System.out.println(tree);
        }

        tree.remove(5);
        System.out.println(tree);

        tree.remove(4);
        tree.remove(6);
        System.out.println(tree);


    }

    @Override
    public boolean contains(E element) {
        return contains(root, element);
    }

    private boolean contains(AvlNode<E> subtree, E element) {
        if (subtree == null) {
            return false;
        } else if (subtree.element.compareTo(element) == 0) {
            return true;
        } else if (subtree.element.compareTo(element) > 0) {
            return contains(subtree.left, element);
        } else {
            return contains(subtree.right, element);
        }
    }

    @Override
    public boolean add(E element) {
        Set<AvlNode<E>> addedNodes = new HashSet<>();
        root = add(root, element, addedNodes);
        return !addedNodes.isEmpty();
    }

    private AvlNode<E> add(AvlNode<E> subtree, E newElement, Set<AvlNode<E>> addedNodes) {
        if (subtree == null) {
            subtree = new AvlNode(newElement);
            addedNodes.add(subtree);

        } else if (subtree.element.compareTo(newElement) == 0) {
            return subtree; // the node is already in. No change

        } else if (subtree.element.compareTo(newElement) > 0) {
            subtree.left = add(subtree.left, newElement, addedNodes);
            subtree = rebalanceIfNeeded(subtree);

        } else {  // subtree.element.compareTo(newElement) < 0
            subtree.right = add(subtree.right, newElement, addedNodes);
            subtree = rebalanceIfNeeded(subtree);
        }

        subtree.height = Math.max(height(subtree.left), height(subtree.right)) + 1;
        return subtree;
    }

    @Override
    public boolean remove(E element) {
        Set<AvlNode<E>> removedNodes = new HashSet<>();
        root = remove(root, element, removedNodes);
        return !removedNodes.isEmpty();
    }

    private AvlNode<E> remove(AvlNode<E> subtree, E element, Set<AvlNode<E>> removedNodes) {
        if (subtree == null) {
            return null; //the node is not in: no change

        } else if (subtree.element.compareTo(element) == 0) {
            removedNodes.add(subtree);
            subtree = deleteNode(subtree);

        } else if (subtree.element.compareTo(element) > 0) {
            subtree.left = remove(subtree.left, element, removedNodes);
            subtree = rebalanceIfNeeded(subtree);

        } else {
            subtree.right = remove(subtree.right, element, removedNodes);
            subtree = rebalanceIfNeeded(subtree);
        }
        //subtree.height = Math.max(height(subtree.left), height(subtree.right)) + 1;
        return subtree;
    }

    private int height(AvlNode<E> node) {
        // Return -1 if null to simplify unbalance check
        return node == null ? -1 : node.height;
    }

    private AvlNode<E> rebalanceIfNeeded(AvlNode<E> subtree) {
        final int deltaHeight = height(subtree.left) - height(subtree.right);

        if (deltaHeight == 2) { // unbalanced to the left
            if (height(subtree.left.left) >= height(subtree.left.right)) {
                return rightRotation(subtree);
            } else {
                return leftRightRotation(subtree);
            }

        } else if (deltaHeight == -2) { // unbalanced to the right
            if (height(subtree.right.right) >= height(subtree.right.left)) {
                return leftRotation(subtree);
            } else {
                return rightLeftRotation(subtree);
            }
        } else {
            return subtree;
        }
    }


    private AvlNode<E> rightRotation(AvlNode<E> subtree) {
        AvlNode tempTree = subtree.left;
        subtree.left = tempTree.right;
        tempTree.right = subtree;

        subtree.height = Math.max(height(subtree.left), height(subtree.right)) + 1;
        tempTree.height = Math.max(height(tempTree.left), subtree.height) + 1;
        return tempTree;
    }

    private AvlNode<E> leftRotation(AvlNode<E> subtree) {
        AvlNode<E> tempTree = subtree.right;
        subtree.right = tempTree.left;
        tempTree.left = subtree;

        subtree.height = Math.max(height(subtree.left), height(subtree.right)) + 1;
        tempTree.height = Math.max(subtree.height, height(tempTree.right)) + 1;
        return tempTree;
    }

    private AvlNode<E> leftRightRotation(AvlNode<E> node) {
        node.left = leftRotation(node.left);
        return rightRotation(node);
    }

    private AvlNode<E> rightLeftRotation(AvlNode<E> node) {
        node.right = rightRotation(node.right);
        return leftRotation(node);
    }


    /* utility methods identical to the basic LinkedNodesBST implementation */

    private AvlNode<E> deleteNode(AvlNode<E> node) {
        if (node.left == null && node.right == null) {
            return null; //leaf node
        } else if (node.left != null && node.right == null) {
            return node.left;
        } else if (node.left == null && node.right != null) {
            return node.right;
        } else {
            //Replace with min node from the right subtree
            AvlNode<E> replacementNode = findMinNode(node.right);
            replacementNode.right = removeMinNode(node.right);
            replacementNode.left = node.left;
            return replacementNode;
        }
    }

    private AvlNode<E> findMinNode(AvlNode<E> subtree) {
        if (subtree.left == null) {
            return subtree;
        } else {
            return findMinNode(subtree.left);
        }
    }

    private AvlNode<E> removeMinNode(AvlNode<E> subtree) {
        if (subtree.left == null) {
            return subtree.right;
        } else {
            subtree.left = removeMinNode(subtree.left);
            return subtree;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        toString(root, 0, stringBuilder);
        return stringBuilder.toString() + '\n';
    }

    private void toString(AvlNode<E> node, int indentation, StringBuilder stringBuilder) {
        if (node == null) {
            return;
        }
        IntStream.range(0, indentation).forEach(i -> stringBuilder.append("  "));
        stringBuilder.append(node.element + "\n");
        toString(node.left, indentation + 1, stringBuilder);
        toString(node.right, indentation + 1, stringBuilder);
    }


    private class AvlNode<E> {

        private E element;
        private AvlNode<E> left;
        private AvlNode<E> right;
        private int height;


        AvlNode(E element) {
            this.element = element;
            this.height = 0;
        }


    }
}

