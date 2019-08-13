import java.util.*;

public class prein{
    public static class Node {
        char data;
        Node left;
        Node right;
    }

    static Node construct(char[] pre, int psi, int pei, 
                          char[] in, int isi, int iei){
        if(isi > iei || psi > pei){
            return null;
        }

        int idx = -1;
        for(int i = isi; i <= iei; i++){
            if(in[i] == pre[psi]){
                idx = i;
                break;
            }
        }

        int lhs = idx - isi;

        Node node = new Node();
        node.data = pre[psi];
        node.left = construct(pre, psi + 1, psi + lhs, in, isi, idx - 1);
        node.right = construct(pre, psi + lhs + 1, pei, in, idx + 1, iei);

        return node;
    }


    static Node construct2(char[] post, int psi, int pei, 
                          char[] in, int isi, int iei){
        if(isi > iei || psi > pei){
            return null;
        }
        
        int idx = -1;
        for(int i = isi; i <= iei; i++){
            if(in[i] == post[pei]){
                idx = i;
                break;
            }
        }

        int lhs = idx - isi;

        Node node = new Node();
        node.left = construct2(post, psi + 0, psi + lhs - 1, in, isi, idx - 1);        
        node.right = construct2(post, psi + lhs, pei - 1, in, idx + 1, iei);
        node.data = post[pei];

        return node;
    }

    static Node construct3(char[] pre, int psi, int pei,
                           char[] post, int posi, int poei){

        int idx = -1;
        for(int i = posi; i <= poei; i++){
            if(post[i] == pre[psi + 1]){
                idx = i;
                break;
            }
        }

        int lhs = idx - posi + 1;
        Node node = new Node();
        node.data = pre[psi];
        node.left = construct3(pre, psi + 1, psi + lhs, post, posi + 0, posi + lhs - 1);
        node.right = construct3(pre, psi + lhs + 1, pei, post, posi + lhs, poei - 1);

        return node;
    }

    public static void main(String[] args){
        char[] pre = "abdehcfgij".toCharArray();
        char[] in = "dbheafcigj".toCharArray();
        Node root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }
}