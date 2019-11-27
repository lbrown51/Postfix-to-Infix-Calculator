
public class Queue<AnyType> implements QueueInteface<AnyType>{
	private QueueNode<AnyType> head = new QueueNode<AnyType>();
	private QueueNode<AnyType> tail = new QueueNode<AnyType>();
	public Queue(){
		head.next =  tail;
		tail.prev = head;
	}
	
	
	public boolean isEmpty() {
		if (head.next == tail && tail.prev == head)
			return true;
		else
			return false;
	}

	
	public void enqueue(AnyType x) {
		QueueNode<AnyType> Node = new QueueNode<AnyType>();
		Node.data = x;
		
		Node.next = head.next;
		Node.prev = head;
		Node.next.prev = Node;
		head.next = Node;
		
		
		
	}

	
	public AnyType dequeue() {
		if (isEmpty())
			return null;
		else{
		QueueNode<AnyType> Node = tail.prev;
		Node.prev.next = tail;
		Node.next.prev = Node.prev;
		return Node.data;}
	}

	
	public AnyType peek() {
		QueueNode<AnyType> Node = tail.prev;
		return Node.data;
	}
	
	public void printQueue(){
		QueueNode<AnyType> Current = tail.prev;
		while(Current != head){
			System.out.println(Current.data);
			Current = Current.prev;
		}
		

	}

}
