import java.util.*;
public class Driver {
	public static void main(String [] args) {
		Stack s = new Stack();
		Scanner scan = new Scanner(System.in);
		String s1= scan.next();
		for(int i=0;i<s1.length();i++) {
			s.push(s1.charAt(i));
		}
		String s2="";
		for(int i=0;i<s1.length();i++) {
			s2=s2+s.top();
			s.pop();
		}
		System.out.println(s2);
		int j=0;
		for(int i=0;i<s1.length();i++)
		{
			if(s1.charAt(i)!=s2.charAt(i)) {
				System.out.println(s1+ " is NOT a palindrome.");
				break;
			}
			j++;
		}
		if(j==s1.length()) {
			System.out.println(s1 + " is a palindrome.");
		}
		scan.close();
	}
	
	
}
