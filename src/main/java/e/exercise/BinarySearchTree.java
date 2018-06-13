package e.exercise;

/**
 * Binary search tree for int.
 * Поиск родительского узла в дереве.
 */
public class BinarySearchTree {

    private static class Node {
        int key;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
        }
    }

    private Node root;
    private int size = 0;

    public void add(int key) {
        if (this.root == null) {
            this.root = new Node(key);
            this.size++;
        } else {
            this.add(root, key);
        }
    }

    private void add(Node node, int key) {
        if (node.key > key) {
            if (node.left == null) {
                node.left = new Node(key);
                this.size++;
            } else {
                this.add(node.left, key);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(key);
                this.size++;
            } else {
                this.add(node.right, key);
            }
        }
    }

    public int[] toArray() {
        int[] result = new int[this.size];
        int index = 0;
        this.toArray(this.root, result, index);
        return result;
    }

    private int toArray(Node node, int[] result, int index) {
        if (node != null) {
            index = toArray(node.left, result, index);
            result[index++] = node.key;
            index = toArray(node.right, result, index);
        }
        return index;
    }

    public int parentKey(int key) {
        return parentKey(this.root, key);
    }

    private int parentKey(Node node, int key) {
        int result = -1;
        if (node != null) {
            if (node.left != null && node.left.key == key
                || node.right != null && node.right.key == key) {
                result = node.key;
            } else {
                result = parentKey(node.left, key);
                if (result == -1) {
                    result = parentKey(node.right, key);
                }
            }
        }
        return result;
    }
}
