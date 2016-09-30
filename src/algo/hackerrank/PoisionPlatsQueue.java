package algo.hackerrank;

/**
 * Created by ajeya.hb on 12/09/16.
 */
public class PoisionPlatsQueue {

    public static void main(String[] args)
    {

    }
}

class Queue<T> {

    private TreeNode rootNode;
    private TreeNode curNode;
    int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void enqueue(T value)
    {
        if(rootNode == null)
        {
            rootNode = new TreeNode(value, null);
            curNode = rootNode;
            size++;
        }
        else
        {
            TreeNode<T> data = new TreeNode(value, null);
            curNode.setNextPointer(new TreeNode(value, null));
            curNode = data;
            size ++;
        }
    }

    public T dequeue()
    {
        TreeNode<T> data = rootNode;
        rootNode = rootNode.getNextPointer();
        size --;
        return data.getValue();
    }


}

