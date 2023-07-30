package leetcode.tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class oneninenine {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()){
            int n = q.size();
            for (int i = 0; i < n; i++) {
                root = q.poll();
                if (i == 0){
                    ans.add(root.val);
                }
                if (root.left != null){
                    q.offer(root.left);
                }
                if (root.right != null){
                    q.offer(root.right);
                }
            }
        }
        return ans;
    }
}
