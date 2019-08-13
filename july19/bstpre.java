import java.util.*;
public class bstpre {
    static Node root;
    public static class Node {
        int data;
        Node left;
        Node right;
    }

    static int[] ngei(int[] arr)
    {
        int[] res = new int[arr.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(arr.length - 1);
        res[arr.length - 1] = arr.length;

        for(int i = arr.length - 2; i >= 0; i--){
            while(stack.size() > 0 && arr[i] > arr[stack.peek()]){
                stack.pop();
            }

            res[i] = stack.size() == 0? arr.length : stack.peek();
            stack.push(i);
        }

        return res;
    }

    static boolean printpost(int[] pre, int[] nge, int s, int e,
                          int min, int max){
        if(s > e){
            return true;
        }
       
        int val = pre[s];
        int ngei = nge[s];

        if(val < min || val > max){
            return false;
        }

        boolean lf = printpost(pre, nge, 
                  s + 1, ngei - 1 <= e? ngei - 1: e, 
                  min, pre[s]);
        boolean rf = printpost(pre, nge, ngei, e, pre[s], max);
        
        System.out.println(pre[s]);
        return lf && rf;
    }

    public static void main(String[] args){
        int[] pre = {50, 25, 12, 10, 20, 75, 87, 80, 78, 82};
        int[] nge = ngei(pre);

        printpost(pre, nge, 0, pre.length - 1);
    }
}