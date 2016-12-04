import java.util.Scanner;

public class QUADTREE {
	static int toSee = 0;
	static String qTree;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		while(TC-- > 0){
			qTree = sc.next();
			toSee = 0;
			System.out.println(reverseTree());
			
		}
		sc.close();
	}
	
	public static String reverseTree(){
		String leftUpper, rightUpper, leftLower, rightLower;
		if(toSee == qTree.length()-1)
			return Character.toString(qTree.charAt(toSee));
		
		if(qTree.charAt(toSee) == 'x'){
			toSee++;
			leftUpper = reverseTree();
			rightUpper = reverseTree();
			leftLower = reverseTree();
			rightLower = reverseTree();
			
		}else{
			toSee++;
			return Character.toString(qTree.charAt(toSee-1)); 
		}
		return "x" + leftLower + rightLower + leftUpper + rightUpper;
		
		
	}
}
