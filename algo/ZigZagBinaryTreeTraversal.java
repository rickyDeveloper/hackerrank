package algo;

/**
 * Created by vikasnaiyar on 05/09/18.
 */
public class ZigZagBinaryTreeTraversal {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node leftChild = new Node(2);
        Node rightChild = new Node(3);
        root.left = leftChild;
        root.right = rightChild;

        leftChild.left = new Node(4);
        leftChild.right = new Node(5);

        rightChild.left = new Node(6);
        rightChild.right = new Node(7);

        int h = height(root);

        boolean left = false;

        for (int i = 1; i <= h; i++) {
            printZigZag(root, i, left);
            System.out.println();
            left = !left;
        }
    }


    /**
     * 1 true 0
     * 3+1 2+1
     *
     *
     *
     * @param node
     */
    private static void printZigZag(Node node, int level, boolean left) {

        if(node == null) {
            return;
        }

        if(level == 1) {
            System.out.print(node.key + " ");
        } else {

            if(left) {
                printZigZag(node.left, level-1, left);
                printZigZag(node.right, level-1,left);
            } else {
                printZigZag(node.right, level-1, left);
                printZigZag(node.left, level-1, left);
            }
        }




    }

    private static int height(Node node) {
        if(node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    static class Node {
        int key;
        Node left, right;
        Node(int key) {
            this.key = key;
        }
    }


}
