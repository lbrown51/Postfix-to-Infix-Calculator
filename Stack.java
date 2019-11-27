
public class Stack<AnyType> implements StackInterface<AnyType> {

	public Stack(){
		
		
		
	}

	private StackNode<AnyType> head = new StackNode<AnyType>();

	public boolean isEmpty() {
		if (head.next == null)
			return true;
		else
			return false;
	}

	
	public void push(AnyType x) {
		
		StackNode<AnyType> Node = new StackNode<AnyType>();
		Node.data = x;
		
			Node.next = head.next;
			head.next = Node;
	}

	
	public AnyType pop() {
		if (isEmpty()){
			return null;
		}
		else{
		StackNode<AnyType> Node = head.next;
		head.next = head.next.next;
		return Node.data;
		}
		
		
		
	}

	@Override
	public AnyType peek() {
		// TODO Auto-generated method stub
		return head.next.data;
	}

	
	public void printStack(){
		StackNode<AnyType> Current = head.next;
		while(Current != null){
			System.out.println(Current.data);
			Current = Current.next;
		}
	}
}
 
