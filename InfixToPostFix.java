//Switch with Strings is java 1.7 and above.


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class InfixToPostFix<AnyType> {
	Stack<String> stack = new Stack<String>();
	Queue<String> queue = new Queue<String>();

	public void ITP (File in) throws IOException{
		PrintWriter writer = new PrintWriter("src/answer.txt", "UTF-8");

	    BufferedReader br = new BufferedReader(new FileReader("src/Test.txt"));
	    try {

	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	        	
	        	String[] toEval = line.split("");
	        	
	        	
	        		toPost(toEval);
	        		String newAnswer = evaluate();
	        		writer.println(newAnswer);
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            line = br.readLine();
	            
	            
	            
	            
	            
	            
	            
	        }
	        String everything = sb.toString();
		    //System.out.println(everything);

	    } finally {
	        br.close();
	        writer.close();

	    }
		
		
	}
	
	public void toPost(String[] in){
		for (int i = 0; i < in.length;i++)
		{
		switch (in[i]){
			
		case " ":
			break;
			
		case ")":
			while(!stack.isEmpty() && !stack.peek().equals("(")){
				queue.enqueue(stack.pop());
				i++;
			}
			queue.enqueue(stack.pop());
			i++;
			break;
			
		case "(":
			while (!stack.isEmpty())
				queue.enqueue(stack.pop());
			break;
			
		case "<":
			while (!stack.isEmpty() && (!stack.peek().equals("!") || !stack.peek().equals("-") || !stack.peek().equals("!") || !stack.peek().equals("/") || !stack.peek().equals("*")))
				queue.enqueue(stack.pop());
			stack.push(in[i]);
			break;
			
		case ">":
			while (!stack.isEmpty() && (!stack.peek().equals("!") || !stack.peek().equals("-") || !stack.peek().equals("!") || !stack.peek().equals("/") || !stack.peek().equals("*")))
				queue.enqueue(stack.pop());
			stack.push(in[i]);
			break;
			
			
		case "*":
			while (!stack.isEmpty() && (!stack.peek().equals("+") || !stack.peek().equals("-") || !stack.peek().equals("!")))
				queue.enqueue(stack.pop());
			stack.push(in[i]);
			break;
			
		case "/":
			while (!stack.isEmpty() && (!stack.peek().equals("+") || !stack.peek().equals("-") || !stack.peek().equals("!")))
				queue.enqueue(stack.pop());
			stack.push(in[i]);
			break;
		
		case "+":
			while (!stack.isEmpty() && (!stack.peek().equals("!")))
				queue.enqueue(stack.pop());
			stack.push(in[i]);
			break;
			
		case "-":
			while (!stack.isEmpty() && (!stack.peek().equals("!")))
				queue.enqueue(stack.pop());
			stack.push(in[i]);
			break;
		
		
		
		
		default: 
			String current = in[i];

			int j = 1;
			if (j+i < in.length){	
			while (in[j+i].equals("1") || in[j+i].equals("2") || in[j+i].equals("3") || in[j+i].equals("4") || in[j+i].equals("5")
					|| in[j+i].equals("6") || in[j+i].equals("7") || in[j+i].equals("8") || in[j+i].equals("9") || in[j+i].equals("0") 
					|| in[j+i].equals(".")){
				current = current + in[j+i];
				
				j++;
				if (j+i == in.length-1){	
					break;
				}
			}
		}
			queue.enqueue(current);
			i += j;	
			break;
		}

	}
		
		
		while (!stack.isEmpty())
			queue.enqueue(stack.pop());
		
}
	
	
	
 public String evaluate (){
	 queue.printQueue();
	 while (!queue.isEmpty()){


		 switch(queue.peek()){
		 case "+":
			 stack.push((new Double(Double.parseDouble(stack.pop()) + Double.parseDouble(stack.pop()))).toString());
			 queue.dequeue();
			 break;
		 
		 case "-":
			
			 Double reverse = new Double(Double.parseDouble(stack.pop()));
			 stack.push(new Double((Double.parseDouble(stack.pop()) - reverse)).toString());
			 queue.dequeue();
			 break;
		 case "/":
			 Double divideReverse = new Double(Double.parseDouble(stack.pop()));
			 stack.push(new Double((Double.parseDouble(stack.pop()) / divideReverse)).toString());
			 queue.dequeue();
			 break;
		 case "*":
			 stack.push((new Double(Double.parseDouble(stack.pop()) * Double.parseDouble(stack.pop()))).toString());
			 queue.dequeue();
			 break;
		 case "<":
			 Double lessThanReverse = new Double(Double.parseDouble(stack.pop()));
			 stack.push(new Boolean((Double.parseDouble(stack.pop()) < lessThanReverse)).toString());
			 queue.dequeue();
			 break;
		 case ">":
			 Double greaterThanReverse = new Double(Double.parseDouble(stack.pop()));
			 stack.push(new Boolean((Double.parseDouble(stack.pop()) < greaterThanReverse)).toString());			 queue.dequeue();
			 break;
		
		default:
			 stack.push(queue.dequeue());
			 break;
	 }
	
	 } 
	 return (stack.pop());
	 

	 
 }
}
