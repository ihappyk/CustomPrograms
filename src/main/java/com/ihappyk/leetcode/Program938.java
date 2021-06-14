package com.java.leetcode;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Program938
{
    public static void rangeSumBST(TreeNode root, int L,int R) {
        List<Integer> arraylist = new ArrayList<Integer>();
        if(root == null) return;
    }

    public static void rangeSumBST(TreeNode root, int L, int R, List<Integer> arrayList)
    {
        if(root == null) return;
        rangeSumBST(root.left, L, R, arrayList);
        if(root.val >= L && root.val <=R)
            arrayList.add(root.val);
        rangeSumBST(root.right, L, R, arrayList);
    }
}
