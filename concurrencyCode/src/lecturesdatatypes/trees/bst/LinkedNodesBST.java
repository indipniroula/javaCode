package lecturesdatatypes.trees.bst;

import java.util.*;
import java.util.stream.IntStream;

public class LinkedNodesBST<E extends Comparable<E>> implements BST<E> {

    private class Node<E> {

        private E element;
        private Node<E> left;
        private Node<E> right;

        public Node(E element) {
            this.element = element;
        }

    }

    protected Node<E> root;

    public LinkedNodesBST() {
        this.root = null;
    }

    public LinkedNodesBST(E element) {
        this.root = new Node<>(element);
    }

    public static void main(String[] args) {
        LinkedNodesBST<Integer> tree = new LinkedNodesBST<>();

        tree.add(10);
        tree.add(9);
        tree.add(11);
        tree.add(8);
        tree.add(12);
        tree.add(13);
        System.out.println(tree);
        System.out.println(tree.traverseDepthFirstWithStack());
        System.out.println(tree.traversePostorder());

        tree.remove(14);
        System.out.println(tree);
    }


    public boolean add(E newElement) {
        if (root == null) {
            root = new Node<>(newElement);
            return true;
        } else {
            return add(root, newElement);
        }
    }


    private boolean add(Node<E> subtree, E newElement) {
        if (subtree.element.compareTo(newElement) == 0) {
            return false; //node already in
        } else if (subtree.element.compareTo(newElement) > 0) {

            if (subtree.left == null) {
                subtree.left = new Node<>(newElement);
                return true;
            } else {
                return add(subtree.left, newElement);
            }

        } else {
            if (subtree.right == null) {
                subtree.right = new Node<>(newElement);
                return true;
            } else {
                return add(subtree.right, newElement);
            }
        }
    }

    @Override
    public boolean contains(E element) {
        return contains(root, element);
    }

    private boolean contains(Node<E> subtree, E element) {
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
    public boolean remove(E element) {
        Set<Node<E>> deletedNode = new HashSet();
        root = remove(root, element, deletedNode);
        return !deletedNode.isEmpty();
    }

    private Node<E> remove(Node<E> subtree, E element, Set<Node<E>> deletedNode) {
        if (subtree == null) {
            return null; //the node is not in
        } else if (subtree.element.compareTo(element) < 0) {
            subtree.right = remove(subtree.right, element, deletedNode);
        } else if (subtree.element.compareTo(element) > 0) {
            subtree.left = remove(subtree.left, element, deletedNode);
        } else {
            deletedNode.add(subtree);
            subtree = deleteNode(subtree);
        }
        return subtree;
    }

    private Node<E> deleteNode(Node<E> node) {
        if (node.left == null && node.right == null) {
            return null; //leaf node
        } else if (node.left != null && node.right == null) {
            return node.left;
        } else if (node.left == null && node.right != null) {
            return node.right;
        } else {
            //Replace with min node from the right subtree
            Node<E> replacementNode = findMinNode(node.right);
            replacementNode.right = removeMinNode(node.right);
            replacementNode.left = node.left;
            return replacementNode;
        }
    }

    private Node<E> findMinNode(Node<E> subtree) {
        if (subtree.left == null) {
            return subtree;
        } else {
            return findMinNode(subtree.left);
        }
    }

    private Node<E> removeMinNode(Node<E> subtree) {
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

    private void toString(Node<E> node, int indentation, StringBuilder stringBuilder) {
        if (node == null) {
            return;
        }
        IntStream.range(0, indentation).forEach(i -> stringBuilder.append("  "));
        stringBuilder.append(node.element + "\n");
        toString(node.left, indentation + 1, stringBuilder);
        toString(node.right, indentation + 1, stringBuilder);
    }


    /* examples of traversals */

    public List<E> traversePreorder() {
        List<E> traversal = new ArrayList<>();
        traversePreorder(root, traversal);
        return traversal;
    }

    private void traversePreorder(Node<E> subtree, List<E> traversal) {
        if (subtree == null) {
            return;
        }
        traversal.add(subtree.element);
        traversePreorder(subtree.left, traversal);
        traversePreorder(subtree.right, traversal);
    }

    public List<E> traverseInorder() {
        List<E> traversal = new ArrayList<>();
        traverseInorder(root, traversal);
        return traversal;
    }

    private void traverseInorder(Node<E> subtree, List<E> traversal) {
        if (subtree == null) {
            return;
        }
        traverseInorder(subtree.left, traversal);
        traversal.add(subtree.element);
        traverseInorder(subtree.right, traversal);
    }

    public List<E> traversePostorder() {
        List<E> traversal = new ArrayList<>();
        traversePostorder(root, traversal);
        return traversal;
    }

    private void traversePostorder(Node<E> subtree, List<E> traversal) {
        if (subtree == null) {
            return;
        }
        traversePostorder(subtree.left, traversal);
        traversePostorder(subtree.right, traversal);
        traversal.add(subtree.element);
    }

    // this method implements a post-order traversal using a stack
    public List<E> traverseDepthFirstWithStack() {
        List<E> traversal = new ArrayList<>();
        traverseDepthFirstWithStack(root, traversal);
        return traversal;
    }

    private void traverseDepthFirstWithStack(Node<E> subtree, List<E> traversal) {
        if (subtree == null) {
            return;
        }
        Deque<Node<E>> stack = new ArrayDeque<>(); // same behavior of java.util.Stack<E>, but faster
        Node<E> current = subtree;
        Node<E> lastNodeVisited = null;

        while (!stack.isEmpty() || current != null) {
            if (current != null) { // go in depth
                stack.push(current);
                current = current.left;
            } else {
                Node<E> peekNode = stack.peekFirst();
                if (peekNode.right != null && lastNodeVisited != peekNode.right) {
                    current = peekNode.right;
                } else {
                    traversal.add(peekNode.element);
                    lastNodeVisited = stack.removeFirst();
                }
            }
        }
    }

    public List<E> traverseBreadthFirst() {
        List<E> traversal = new ArrayList<>();
        traverseBreadthFirst(root, traversal);
        return traversal;
    }

    private void traverseBreadthFirst(Node<E> subtree, List<E> traversal) {
        Deque<Node<E>> queue = new ArrayDeque<>();
        queue.addLast(subtree);
        while (!queue.isEmpty()) {
            Node<E> node = queue.pollFirst();
            traversal.add(node.element);
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
    }



}

