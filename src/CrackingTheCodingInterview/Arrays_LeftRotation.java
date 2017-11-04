package CrackingTheCodingInterview;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;
public class Arrays_LeftRotation {

    public int[] solution(int k, int[] arr){
        int len = arr.length;
        int[] resArr = new int[len];
        for(int i = 0; i < len; i++){
            resArr[i] = arr[(i+k)%len];
        }
        return resArr;
    }
    public void solution2(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            int index = (a_i - k)%n;
            index = index < 0? index + n : index;
            a[index] = in.nextInt();
        }
        for(int val : a){
            System.out.print(val + " ");
        }
    }
    @Test
    public void test(){
        assertArrayEquals(new int[]{5,1, 2,3, 4}, solution(4, new int[]{1,2,3,4,5}));

    }
}
