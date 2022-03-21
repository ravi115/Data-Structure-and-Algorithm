package trees;

import AdvancedProblem.BinaryTree;

import java.util.*;

public class LeftViewTree {


    public static void recursiveLeftView(BinaryTree node, int level, Map<Integer, Integer> map) {

        if (map.containsKey(level)) return;
        map.put(level, node.getData());
        level++;
        if (node.getLeftChild() != null) recursiveLeftView(node.getLeftChild(), level, map);
        if (node.getRightChild() != null) recursiveLeftView(node.getRightChild(), level, map);
    }



    public static List<Integer> leftViewIteratively(BinaryTree node) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(node);
        int level = 0;
        while (!queue.isEmpty()) {
            BinaryTree temp = queue.poll();//18
            if (!map.containsKey(level)) {
                map.put(level, temp.getData());
            }
            if (temp.getLeftChild() != null) queue.add(temp.getLeftChild()); //5
            if (temp.getRightChild() != null) queue.add(temp.getRightChild());//18, 9
            level++;//2
        }
        return new ArrayList<>(map.values()) ;
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree(10);
        tree.setLeftChild(new BinaryTree(5));
        tree.setRightChild(new BinaryTree(18));
        tree.getLeftChild().setRightChild(new BinaryTree(9));
        tree.getRightChild().setRightChild(new BinaryTree(21));
        //tree.getLeftChild().getLeftChild().setRightChild(new BinaryTree(9));
        System.out.println("left view is ::" + leftViewIteratively(tree));
        Map<Integer, Integer> map = new HashMap<>();
        recursiveLeftView(tree, 0, map);
        System.out.println("---> recursively :: " + map);

        /**
         *
         *          10
         *         /  \
         *        5    18
         *         \    \
         *          9    21
         *
         *
         */
    }

}
