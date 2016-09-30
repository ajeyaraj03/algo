package tree;

/**
 * Created by ajeya.hb on 16/08/16.
 */
public class TreeUtility {



    public static void displayNode(TreeNode node) {

        if(node == null)
        {
            return;
        }

        displayNode(node.left);
        System.out.println(node.val);
        displayNode(node.right);
    }

    public  static TreeNode converArrayToTree(int [] numbers)
    {
        TreeNode treeNode = new TreeNode(numbers[0]);
        TreeNode rootNode = treeNode;
        for(int i =0; i < numbers.length; i++)
        {


            System.out.println("hiiii"+i);
            //System.out.println(2*i+1);
            int left = 2*i+1;
            int right = 2*i+2;
            if(2*i+1 > numbers.length-1)
            {
                break;
            }
            treeNode.left = new TreeNode(numbers[left]);
            treeNode.right = new TreeNode(numbers[right]);
            if(i %2 ==0) {
                treeNode = treeNode.left;
            }
            else
            {
                treeNode = treeNode.right;
            }
        }

        return rootNode;

    }
}
