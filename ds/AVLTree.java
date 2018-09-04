/**
 * Created by vikasnaiyar on 04/09/18.
 */
public class AVLTree {

    public static void main(String[] args) {
        Node root = insert(null, 10);

         /* Constructing tree given in the above figure */
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("Preorder traversal" +
                " of constructed tree is : ");
        preOrder(root);
    }

    static void preOrder(Node node) {
        if(node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static Node insert(Node node, int key) {
        if(node == null) {
            return new Node(key);
        }

        if(key > node.key) {
            node.right = insert(node.right,key);
        } else if(key < node.key) {
            node.left = insert(node.left, key);
        } else {  // in case of node with same key
            return node;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        node.height = 1 + Math.max(leftHeight, rightHeight);

        int heightDiff = leftHeight - rightHeight;

        // left left case
        if(heightDiff > 1 && key < node.left.key) {
            node = rotateRight(node);
        }

        // right right case
        if(heightDiff < -1 && key > node.right.key) {
            node = rotateLeft(node);
        }

        //  left right case
        if(heightDiff > 1 && key > node.left.key) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        //  right left case
        if(heightDiff < -1 && key < node.right.key) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    static Node rotateLeft(Node node) {
        Node rightChild = node.right;
        Node rightLeftAncestor = rightChild.left;

        rightChild.left = node;
        node.right = rightLeftAncestor;

        node.height = Math.max(height(node.left), height(node.right));
        rightChild.height = Math.max(height(rightChild.left), height(rightChild.right));

        return rightChild;
    }

    static Node rotateRight(Node node) {
        Node leftChild = node.left;
        Node leftRightAncestor = leftChild.right;

        leftChild.right = node;
        node.left = leftRightAncestor;

        node.height = Math.max(height(node.left), height(node.right));
        leftChild.height = Math.max(height(leftChild.left), height(leftChild.right));

        return leftChild;
    }

    static int height(Node node) {
        if(node == null) {
            return 0;
        }

        return node.height;
    }


    static class Node {
        int height;
        int key;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
        }
    }






}
