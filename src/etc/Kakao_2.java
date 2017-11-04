package etc;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class Kakao_2 {
    public int dart(String input){
        char[] inputChar = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        int numBefore = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < inputChar.length; i++){
            char a = inputChar[i];
            switch (a){
                case 'S':
                    num = Integer.parseInt(sb.toString());
                    list.addLast(num);
                    sb.delete(0, sb.length());
                    break;
                case 'D':
                    num = Integer.parseInt(sb.toString());
                    num = (int)Math.pow(num, 2);
                    list.addLast(num);
                    sb.delete(0, sb.length());
                    break;
                case 'T':
                    num = Integer.parseInt(sb.toString());
                    num = (int)Math.pow(num, 3);
                    list.addLast(num);
                    sb.delete(0, sb.length());
                    break;
                case '*':
                    num = list.getLast();
                    list.removeLast();
                    if(!list.isEmpty()){
                        numBefore = list.getLast();
                        list.removeLast();
                        numBefore *= 2;
                        list.addLast(numBefore);
                    }
                    num *= 2;
                    list.addLast(num);
                    break;
                case '#':
                    num = list.getLast();
                    num *= -1;
                    list.removeLast();
                    list.addLast(num);
                    break;
                default:
                    sb.append(a);
                    break;
            }
        }
        int sum = 0;
        for(int a : list){
            sum += a;
        }
        return sum;
    }
    @Test
    public void test(){
        String input;
        input = "1S2D*3T";
        assertEquals(37, dart(input));
        input = "1D2S#10S";
        assertEquals(9, dart(input));
        input = "1D2S0T";
        assertEquals(3, dart(input));
        input = "1S*2T*3S";
        assertEquals(23,  dart(input));
        input = "1D#2S*3S";
        assertEquals(5, dart(input));
        input = "1T2D3D#";
        assertEquals(-4, dart(input));
        input = "1D2S3T*";
        assertEquals(59, dart(input));
    }
}
