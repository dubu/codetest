package greek;

import org.junit.Test;

public class GreekTree {


    /**
     *
     *
     *
     * tree size
     * https://www.geeksforgeeks.org/write-a-c-program-to-calculate-size-of-a-tree/
     *
     *
     *
     *
     *
     */
    @Test
    public void treeTest() {

        /* creating a binary tree and entering the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("The size of binary tree is : " + tree.size()); //5
    }

    private class BinaryTree {
        public Node root;

        public int size() {

            if (root == null) {
                return 0;
            }

            int sum = 1;
            Node n = root;


            if(n.left != null){
                sum =  sum + countNode(n);
            }

            while (n.right != null){

                sum =  sum + countNode(n.right);
                n = n.right;

            }

//            System.out.printf(sum);
            System.out.println(sum);
            return sum;
        }
    }

    private int countNode(Node nNode) {
        int count = 0 ;
        while (nNode != null){
            count = count + 1;
            nNode = nNode.left;
        }
        return count;
    }

    private class Node {
        public Node left;
        public Node right;

        public Node(int i) {


        }
    }
}
