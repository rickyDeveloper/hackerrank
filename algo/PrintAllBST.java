package algo;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vikasnaiyar on 15/10/18.
 */
public class PrintAllBST {

    public static  class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

        int nodesCount = 3;

        List<TreeNode> binaryTrees = createAllBSTs(1, nodesCount);

        for (TreeNode binaryTree: binaryTrees) {
            doPreOrderTraversal(binaryTree);
            System.out.println(" ");
        }

    }

    public static void doPreOrderTraversal(TreeNode node) {
        if(node == null) {
            System.out.print(null + " ");
            return;
        }

        System.out.print(node.val + " ");

        if(node.left != null || node.right != null) {

            doPreOrderTraversal(node.left);

            doPreOrderTraversal(node.right);

        }
    }

    public static List<TreeNode> createAllBSTs(int startIndex, int endIndex) {
        List<TreeNode> binaryTrees = new ArrayList<>();

        if(startIndex == endIndex) {
            binaryTrees.add(new TreeNode(startIndex));
        } else if(startIndex < endIndex) {
            for (int i = startIndex; i <= endIndex; i++) {
                List<TreeNode> leftTrees = createAllBSTs(startIndex, i - 1);
                List<TreeNode> rightTrees = createAllBSTs(i + 1, endIndex);

                binaryTrees.addAll(generateAllPermutationOfBSTs(leftTrees, rightTrees, i));
            }
        }

        return binaryTrees;
    }


    public static List<TreeNode> generateAllPermutationOfBSTs( List<TreeNode> leftTrees,  List<TreeNode> rightTrees, int root) {
        List<TreeNode> binaryTrees = new ArrayList<>();
        if(!leftTrees.isEmpty() && !rightTrees.isEmpty()) {
            for (TreeNode leftTree: leftTrees) {
                for (TreeNode rightTree: rightTrees) {
                    TreeNode rootNode = new TreeNode(root);
                    rootNode.left = leftTree;
                    rootNode.right = rightTree;
                    binaryTrees.add(rootNode);
                }
            }
        } else if(!leftTrees.isEmpty()) {
            for (TreeNode leftTree: leftTrees) {
                    TreeNode rootNode = new TreeNode(root);
                    rootNode.left = leftTree;
                    binaryTrees.add(rootNode);
            }
        } else if (!rightTrees.isEmpty()) {
            for (TreeNode rightTree: rightTrees) {
                TreeNode rootNode = new TreeNode(root);
                rootNode.right = rightTree;
                binaryTrees.add(rootNode);
            }
        }

        return binaryTrees;
    }
}

