import java.util.*;

public class lca {
    public static class Node {
        int data;
        Node left;
        Node right;
    }

    static Node lca = null;
    static int dist = 0;
    public static boolean lca(Node node, int d1, int d2){
        if(node == null){
            return false;
        }

        boolean sf = node.data == d1 || node.data == d2;
        boolean lf = lca != null || lca(node.left, d1, d2);
        boolean rf = lca != null || lca(node.right, d1, d2);
        
        if(lca != null){
            dist++;
            if(dist == p){
                plca = node;
            }
        }
        
        if(lf && rf || sf && lf || sf && rf){
            if(lca == null){
                lca = node;
                dist = 1;
            } 
        }

        

        return sf || lf || rf;
    }

    public static void main(String[] args){

    }
}