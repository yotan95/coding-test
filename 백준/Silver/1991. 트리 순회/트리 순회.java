import java.util.*;
import java.io.*;

public class Main{
    static HashMap<String, Node> graph = new HashMap<String, Node>();
    static int n;
    static StringBuilder sb;

    public static class Node{
        String value;
        Node left;
        Node right;

        Node(String value){
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException{
        readData();
        pro();
        System.out.println(sb.toString());
    }

    public static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for(int i = 0 ; i < n; i++){
            String[] s = br.readLine().split(" ");
            graphAdd(s[0], s[1], s[2]);
        }
    }

    public static Node getNode(String s){
        if(s.equals(".")) return null;
        return graph.computeIfAbsent(s, Node::new);
    }

    static void graphAdd(String root, String left, String right){
        Node n = getNode(root);
        n.left = getNode(left);
        n.right = getNode(right);
    }
    public static void pro(){
        preOrder("A");
        sb.append("\n");
        inOrder("A");
        sb.append("\n");
        postOrder("A");
    }

    public static void preOrder(String root){
        Node node = graph.get(root);
        sb.append(node.value);
        if(node.left != null)
            preOrder(node.left.value);
        if(node.right != null)
            preOrder(node.right.value);
    }

    public static void inOrder(String root){
        Node node = graph.get(root);
        if(node.left != null){
            inOrder(node.left.value);
        }
        sb.append(root);
        if(node.right != null){
            inOrder(node.right.value);
        }

    }
    public static void postOrder(String root){
        Node node = graph.get(root);
        if(node.left != null)
            postOrder(node.left.value);
        if(node.right!= null)
            postOrder(node.right.value);
        sb.append(root);
    }
}