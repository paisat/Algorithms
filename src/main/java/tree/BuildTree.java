package tree;

/**
 * Created by sarvothampai on 15/10/15.
 */
public class BuildTree {

    public static void main(String []args){

        BuildTree obj=new BuildTree();

        String arr[]={"1","2","2",null,"5","6"};

        TreeNode root=obj.buildTree(arr);

        System.out.println(root.left);


    }

    public TreeNode buildTree(String arr[]){

        if(arr!=null && arr.length!=0){

            TreeNode root = new TreeNode(Integer.valueOf(arr[0])) ;
            TreeNode cur =root;


            for(int i=0;i<arr.length/2;i++){

                if(2*i+1<arr.length && arr[2*i+1]!=null){
                    cur.left=new TreeNode(Integer.valueOf(arr[2*i+1]));
                }

                if(2*i+2<arr.length && arr[2*i+2]!=null){
                    cur.right =new TreeNode(Integer.valueOf(arr[2*i+2]));
                }

                if(i%2==0 && cur.left!=null){
                    cur=cur.left;
                }

                if(i%2==1 && cur.right!=null ){
                    cur=cur.right;
                }

            }

            return root;

        }

        return null;

    }

}
