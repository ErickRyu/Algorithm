package etc;

public class Kakao_1 {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        int[] arr3 = new int[arr1.length];
        String[] res = new String[arr1.length];
        for(int i = 0; i < arr1.length; i++){
            arr3[i] = arr1[i] | arr2[i];
            res[i] = Integer.toBinaryString(arr3[i]);
            while(res[i].length() < n){
                res[i] = "0" + res[i];
            }
            res[i] = res[i].replaceAll("0", " ");
            res[i] = res[i].replaceAll("1", "#");

            System.out.println(res[i]);
        }



        /*
        String[] res = new String[arr1.length];

        for(int i = 0; i < arr3.length; i++){
            int a = arr3[i];
            StringBuilder sb = new StringBuilder();
            while(a > 0){
                sb.append(a%2 == 0 ? " " : "#");
                a /= 2;
            }
            System.out.println(sb.reverse());
        }
        */
    }
}
