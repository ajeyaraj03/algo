package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ajeya.hb on 16/08/16.
 */
public class RightTree {

    public  static List<Integer> results = new ArrayList<>();

    public static void main(String[] args)
    {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);

        displayTree(treeNode);

        for(int i =0; i < results.size(); i++)
        {
            System.out.println(results.get(i));
        }
    }

    public static void displayTree(TreeNode root)
    {
        if(root ==null)
        {
            return;
        }
        results.add(root.val);
        displayTree(root.right);

    }
}
