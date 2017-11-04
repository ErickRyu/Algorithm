package Algospot;

import java.util.Scanner;
import java.util.Stack;

public class Bracket2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		while(TC-- > 0){
			String input = sc.next();
			char brackets[] = input.toCharArray();
			Stack<Character> brStack = new Stack<>();
			boolean res = true;
			for(int i = 0; i < input.length(); i++){
				switch (brackets[i]){
				case ')':
					if(brStack.isEmpty()){
						res = false;
						break;
					}
					char poped = brStack.pop();
					if(poped != '('){
						res = false;
						break;
					}
					break;
				case '}':
					if(brStack.isEmpty()){
						res = false;
						break;
					}
					poped = brStack.pop();
					if(poped != '{'){
						res = false;
						break;
					}
					break;
				case ']':
					if(brStack.isEmpty()){
						res = false;
						break;
					}
					poped = brStack.pop();
					if(poped != '['){
						res = false;
						break;
					}
					break;
				default:
					brStack.push(brackets[i]);
					break;
				}
			}
			if(!brStack.isEmpty())
				res = false;
			System.out.println(res? "YES":"NO");
				
		}
		sc.close();
	}
}
