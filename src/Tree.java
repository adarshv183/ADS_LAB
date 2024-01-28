public class Tree {
    static class Node {
        int value;
        Node left, right;

        Node(int value){
            this.value = value;
            left = null;
            right = null;
        }
    }
    public Node root;
    public Tree(){
        root = null;
    }
    public void insert(int val){
        Node node = new Node(val);
        if(root == null){
            root = node;
            return;
        }
        Node current = root, parent = null;
        while(true){
            parent = current;
            if(val < current.value){
                current = current.left;
                if(current == null){
                    parent.left = node;
                    return;
                }
            }else{
                current = current.right;
                if(current == null){
                    parent.right = node;
                    return;
                }
            }
        }
    }
    private void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.println(root.value);
            inorder(root.right);
        }
    }
    public void preorder(){
        preorder(root);
    }
    private void preorder(Node root){
        if(root!=null){
            System.out.println(root.value);
            preorder(root.left);
            preorder(root.right);
        }
    }
    public void inorder(){
        inorder(root);
    }

    public void postorder(){
        postorder(root);
    }
    private void postorder(Node root){
        if(root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.value);
        }
    }
    public static void main(String[] args) {
        Tree bt = new Tree();
        bt.insert(50);
        bt.insert(30);
        bt.insert(70);
        bt.insert(60);
        bt.insert(10);
        bt.insert(90);
        bt.inorder();
        System.out.println();
        bt.postorder();
        System.out.println();
        bt.preorder();

    }
}
