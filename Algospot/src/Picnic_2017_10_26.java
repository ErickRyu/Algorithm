import java.util.Arrays;

public class Picnic_2017_10_26 {
    static boolean[] matched;
    static boolean[][] isFriend;
    public static void main(String[] args) {
        int friendNum = 4;

        matched = new boolean[friendNum];
        isFriend = new boolean[friendNum][friendNum];
        for(int i = 0; i < matched.length; i++){

            Arrays.fill(isFriend[i], false);
        }
        Arrays.fill(matched, false);
        isFriend[0][1] = true;
        isFriend[1][0] = true;
        isFriend[1][2] = true;
        isFriend[2][1] = true;
        isFriend[2][3] = true;
        isFriend[3][2] = true;
        isFriend[3][0] = true;
        isFriend[0][3] = true;
        isFriend[0][2] = true;
        isFriend[2][0] = true;
        isFriend[1][3] = true;
        isFriend[3][1] = true;
//
//        isFriend[0][2] = true;
//        isFriend[2][0] = true;
//        isFriend[1][3] = true;
//        isFriend[3][1] = true;
        int count = countFriend(friendNum, friendNum);
        System.out.println(count);
/*
        for(int i = 0; i < friendNum; i++){
            for(int j = 0; j < friendNum; j++){
                for(int k = 0; k < friendNum; k++){
                    for(int h = 0; h <friendNum; h++){
                        if(matched[i][j] || i == j || i ==k || i ==h|| j == k|| j ==h || k==h) continue;
                        if(matched[k][h]) continue;
                        if(isFriend[i][j] && isFriend[k][h]) {
                            matched[i][j] = true;
                            matched[j][i] = true;
                            matched[k][h] = true;
                            matched[h][k] = true;
                            System.out.println(i + ", " + j + "__" + k + ", " + h);
                        }
                    }
                }
            }
        }
        */
    }

    public static int countFriend(int toMatchFriendNum, int friendNum){
        if(toMatchFriendNum == 0){
            return 1;
        }
        int countFriend = 0;

        int firstFree = -1;
        for(int i = 0; i < friendNum; i++){
            if(!matched[i]){
                firstFree = i;
                break;
            }
        }


        for (int j = 0; j < friendNum; j++) {
            if (!isFriend[firstFree][j] || matched[firstFree] || matched[j] || firstFree == j) continue;
            matched[firstFree] = true;
            matched[j] = true;
            countFriend += countFriend(toMatchFriendNum - 2, friendNum);
            matched[firstFree] = false;
            matched[j] = false;

        }

        return countFriend;
    }
}
