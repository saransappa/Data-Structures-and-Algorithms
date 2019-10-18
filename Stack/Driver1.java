import java.util.*;               // Checking Balanced Parenthesis 
public class Driver1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str= scan.next();
		Stack s= new Stack();
		int flag=0;
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch=='(' || ch =='{' || ch == '['){
				s.push(ch);
			}
			else if(ch==')' || ch ==']' || ch == '}') {
				if(s.isEmpty() || ((ch==')' && s.top()!='(') || (ch==']' && s.top()!='[')|| (ch=='}' && s.top()!='{'))) {
					flag=1;
					System.out.println("Parenthesis are NOT balanced !!!");
					break;
				}
				else {
					s.pop();
				}
			}
		}
		if(s.isEmpty() && flag==0) {
			System.out.println("Parenthesis are Balanced... ");
		}
		scan.close();
	}
}
