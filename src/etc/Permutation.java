package etc;

import java.util.Arrays;
import java.util.LinkedList;

public class Permutation {
    static int n;
    static boolean[] taken;
    static LinkedList<Integer> permuList;

    public static void main(String[] args) {
        permuList = new LinkedList<>();
        n = 10;
        taken = new boolean[n];
        Arrays.fill(taken, false);
        permutation_bruteForce(n);
    }
    public static void permutation_bruteForce(int restNum){
        if(restNum == 0){
            System.out.println(permuList);
            return;
        }
        for(int i = 0; i < n; i++){
            if(taken[i]) continue;

            taken[i] = true;
            permuList.addLast(i);

            permutation_bruteForce(restNum-1);

            permuList.removeLast();
            taken[i] = false;
        }


    }
}
