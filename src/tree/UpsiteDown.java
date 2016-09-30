package tree;

/**
 * Created by ajeya.hb on 16/08/16.
 */
public class UpsiteDown {

    private static TreeNode newRootRoot;

    public static void main(String [] args)
    {
        int [] intArray = {1,2,3,4,5};
        TreeNode  node = TreeUtility.converArrayToTree(intArray);
        TreeNode rootNode =  displayUpsiteDown(node);
        System.out.println("fdfsf");
       // TreeUtility.displayNode( displayUpsiteDown(node));
    }

    private static TreeNode displayUpsiteDown(TreeNode root) {
        if(root ==null)
        {

            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode newRoot = displayUpsiteDown(left);
        if(left != null)
        {
            newRoot.right = root;
            newRoot.left  = right;
        }
        else
        {
            //left only be mull for the last left node
            newRootRoot = root;
        }
        root.left =null;
        root.right =null;
        return root;
    }
}
