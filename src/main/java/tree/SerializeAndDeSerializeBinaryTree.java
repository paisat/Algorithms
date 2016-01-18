package tree;

/**
 * Created by sarvothampai on 20/11/15.
 *
 *
 * Time Complexity : O(N)
 *
 */
public class SerializeAndDeSerializeBinaryTree {


    public static void main(String []args){

        SerializeAndDeSerializeBinaryTree obj =new SerializeAndDeSerializeBinaryTree();

        TreeNode root =new TreeNode(1);
        root.left= null;
        root.right=new TreeNode(2);

        System.out.println(obj.serialize(root));

        TreeNode desRoot = obj.deserialize(obj.serialize(root));

        System.out.println("yes");

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        String serialize="null,";

        if(root!=null){

            StringBuilder sb =new StringBuilder();
            SerializeHelper(root,sb);

            serialize=sb.toString();

        }

        return serialize;

    }

    private void SerializeHelper(TreeNode root,StringBuilder serialize){

        if(root==null){
            serialize.append("null,");
            return;
        }

        serialize.append(root.val+",");
        SerializeHelper(root.left,serialize);
        SerializeHelper(root.right,serialize);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data!=null && data.length()!=0){

            int index[] =new int[1];
            index[0]=0;

            String value[]=data.split(",");

            return deserializeHelper(value,index);
        }

        return null;


    }

    private TreeNode  deserializeHelper(String value[],int index[]){


        if( index[0]==value.length  ){
            return null;
        }




        String node = value[index[0]++];

        if(node.equals("null")){
            return null;
        }

        TreeNode root =new TreeNode(Integer.parseInt(node));


        root.left = deserializeHelper(value,index);
        root.right = deserializeHelper(value , index);


        return root;

    }
}
