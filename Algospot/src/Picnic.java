import java.util.Arrays;
import java.util.Scanner;

public class Picnic {
	static boolean isChecked[];
	static boolean isFriend[][];
	static int numOfStudent;
	static int numOfFriend;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		while (TC-- > 0) {
			numOfStudent = sc.nextInt();
			numOfFriend = sc.nextInt();
			isChecked = new boolean[numOfStudent];
			isFriend = new boolean[numOfStudent][numOfStudent];
			for (boolean sub[] : isFriend)
				Arrays.fill(sub, false);
			for (int i = 0; i < numOfFriend; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				isFriend[a][b] = true;
				isFriend[b][a] = true;
			}

			// Solution
			int res = solution(0);
			System.out.println(res);
		}
		sc.close();
	}

	public static int solution(int student) {
		int res = 1;
		boolean allChecked = true;
		for (int i = 0; i < numOfStudent; i++) {
			if (!isChecked[i]) {
				allChecked = false;
				break;
			}
		}
		if (allChecked)
			return res;

		res = 0;
		for(int i = 0; i < numOfStudent-1; i++){
			if (isFriend[student][i] && !isChecked[student] && !isChecked[i]) {
				isChecked[student] = true;
				isChecked[i] = true;
				for(int j = i+1; j < numOfStudent; j++){
					res += solution(j);
				}
				isChecked[student] = false;
				isChecked[i] = false;
			}
		}

		return res;
	}

}
