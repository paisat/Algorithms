package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by sarvothampai on 29/12/15.
 * Given a list of child->parent relationships, build a binary tree out of it. All the element Ids inside the tree are unique.
 * <p/>
 * Example:
 * <p/>
 * Given the following relationships:
 * <p/>
 * Child Parent IsLeft
 * 15 20 true
 * 19 80 true
 * 17 20 false
 * 16 80 false
 * 80 50 false
 * 50 null false
 * 20 50 true
 * <p/>
 * <p/>
 * You should return the following tree:
 * 50
 * / \
 * 20 80
 * / \ / \
 * 15 17 19 16
 * <p/>
 * <p/>
 * Function Signature
 * <p/>
 * <p/>
 * /
 **/


public class BuildTreeWithRelationData {


    public TreeNode buildTree(List<Relation> data) {

        TreeNode root = null;

        if (data != null && data.size() >= 0) {

            Map<Integer, List<Relation>> parentChildMap = new HashMap<Integer, List<Relation>>();

            for (Relation r : data) {
                if (r.parent == null) {
                    root = new TreeNode(r.child);
                } else if (parentChildMap.containsKey(r.parent)) {
                    parentChildMap.get(r.parent).add(r);
                } else {
                    List<Relation> childRelations = new ArrayList<Relation>();
                    childRelations.add(r);
                    parentChildMap.put(r.parent, childRelations);
                }

            }

            if (root == null) {
                return root;
            }

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);

            while (!queue.isEmpty()) {

                TreeNode node = queue.poll();

                if (parentChildMap.containsKey(node.val)) {

                    List<Relation> childrens = parentChildMap.get(node.val);

                    for (Relation children : childrens) {


                        if (children != null && children.isLeft) {
                            TreeNode leftNode = new TreeNode(children.child);
                            queue.add(leftNode);
                            node.left = leftNode;
                        }

                        if (children != null && !children.isLeft) {

                            TreeNode rightNode = new TreeNode(children.child);
                            queue.add(rightNode);
                            node.right = rightNode;
                        }

                    }

                }


            }

        }

        return root;
    }

}
