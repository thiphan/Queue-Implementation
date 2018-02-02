package homeWork7;
import java.util.*;

public class InfixCalculate {
	static Stack<String> operators = new Stack<String>();
	static Stack<String> operands = new Stack<String>();
	
	public static int priority(String s) {
		if(s.equals("+")|| s.equals("-"))
			return 1;
		else if(s.equals("*")||s.equals("/"))
			return 2;
		else 
			return 3;
	}
	public static boolean isOperator(String s) {
		if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")||s.equals("^"))
			return true;
		else
			return false;
	}
	public static String defineOperator(String a1, String a2, String s){
		double r = 0.0;
		double n1 = Double.parseDouble(a1);
		double n2 = Double.parseDouble(a2);
		switch(s){
			case "+": r = n2+n1;break;
			case "-": r = n2-n1; break;
			case "*": r = n2*n1; break;
			case "/": r = n2/n1;break;
			case "^": r = Math.pow(n2, n1); break;
			
		}
		return "" + r;
	}
	public static void solve(Stack<String> operator, Stack<String> operand) {
	    if(operator.size()>=2) {    
			String o1=(String)operator.pop();
	        String o2=(String)operator.pop();
	        
	        if(priority(o1)<priority(o2))
	        {
	            operator.push(o1);
	            operator.push(o2);
	        }
	        		
	        else
	        {
	        	String num3=operand.pop();
	            String num4=operand.pop();
	            operand.push(defineOperator(num3,num4, o1));
	            operator.push(o2);
	        }
	    }
	    else {
	    	String num5 = operand.pop();
			String num6 = operand.pop();
			String o5 = operator.pop();
			operand.push(defineOperator(num5,num6,o5));
	    }
    
	}
	public static void calculate(Stack<String> operator, Stack<String> operand, String[] s) {
		for(int i = 0; i< s.length; i++) {
			if(isOperator(s[i])) {
				operator.push(s[i]);
				System.out.println(operator); //test operator stack
			}
			else if(s[i].equals("(")) {
				operator.push("(");
				System.out.println(operator); //test operator stack
			}
			else if(s[i].equals(")")){
				while(!operator.peek().equals("(")) {
					String o1 = operator.pop();
					String o2 = operator.pop();
					String num1 = operand.pop();
					String num2 = operand.pop();
					
					if(o2.equals("(")) {
						operand.push(defineOperator(num1,num2,o1));
						System.out.println("perform " + num2 + o1 + num1);
						System.out.println(operator); //test operator stack
						System.out.println(operand); //test operand stack
						break;
					}
					else if(priority(o1)>priority(o2)) {
						operand.push(defineOperator(num1,num2,o1));

						operator.push(o2);
						System.out.println(operator); //test operator stack

					}
					else {
						operand.push(defineOperator(num1,num2,o2));
						operator.push(o1);
						System.out.println(operator); //test operator stack
						System.out.println(operand); //test operand stack


					}	
				}
			}
			else {
				operand.push(s[i]);
				System.out.println(operand); //test operand stack
			}
			if(i <= s.length-2 && operator.size()== 1 && operand.size()==2 && isOperator(s[i+1]) && priority(s[i+1])<= priority(operator.peek())) {
				String a = operand.pop();
				String b = operand.pop();
				String o = operator.pop();
				operand.push(defineOperator(a,b,o));
				System.out.println(operand);//test operand stack
				System.out.println(operator);//test operator stack
			}
			while(operator.size()>=2 && operand.size()>=3 && operator.search("(")<0){
				solve(operator, operand);
				System.out.println(operand);
				System.out.println(operator);
			}
		}
		String num5 = operand.pop();
		String num6 = operand.pop();
		String o5 = operator.pop();
		operand.push(defineOperator(num5,num6,o5));
		System.out.println("perform " + num6 + o5 + num5);
		System.out.println(operator); //test operator stack
		System.out.println(operand); //test operand stack

		
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inputInfix ="";
		while(!inputInfix.equals("X")){
			System.out.println("Enter an infix expression with spaces between all tokens, X to exit:");
			inputInfix = input.nextLine();
			if(inputInfix.equals("X") || inputInfix.equals("x")) 
				System.exit(0);
			
			else {
				String[] infix = inputInfix.split("\\s+");
				calculate(operators, operands,infix);
				System.out.println("results is: " + operands.pop());
			}
		}
		input.close();
	}
}
