package Algospot;

public class Bitmask {
    public static void main(String[] args) {
        /*
        int b = 1;
        b = (b << 2) -1;
        b<<=3;

        System.out.println(Integer.toBinaryString(b));
        System.out.println(b);
        System.out.println(Integer.bitCount(b));
        System.out.println(Integer.numberOfTrailingZeros(b));
        System.out.println(Integer.numberOfLeadingZeros(b));

        int firstTopping = (b & -b);
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(-b));
        System.out.println(firstTopping);
        */
        int pizza = (1 << 3) - 1;
        for(int subset = pizza ; subset > 0; subset = ((subset -1) &pizza)){
            System.out.println(Integer.toBinaryString(subset));
        }
    }
}
