package etc;

import java.util.Arrays;
import java.util.LinkedList;

public class Pick_example {
    public static void main(String[] args) {
        Pick_example pe = new Pick_example();
        LinkedList<Integer> list = new LinkedList<>();
        pe.pick(7, list, 4);
    }
    public void pick(int n, LinkedList<Integer> picked, int toPick){
        if(toPick == 0) {
            printPicked(picked);
            return;
        }
        int smallest = picked.isEmpty()? 0 : picked.getLast() + 1;

        for(int next = smallest; next < n; ++next){
            picked.addLast(next);
            pick(n, picked, toPick - 1);
            picked.removeLast();
        }

    }
    public void printPicked(LinkedList<Integer> picked){
        System.out.println(Arrays.toString(picked.toArray()));
    }
}
