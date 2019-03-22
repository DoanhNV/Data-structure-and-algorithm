package datastructure.queue;

public class Main {
	
	public static void main(String[] args) {
		//testQueue();
		
		testStack();
	}
	
	private static void testStack() {
		DStack dStack = new DStack(6);
		dStack.add(1);
		dStack.add(2);
		dStack.add(3);
		dStack.add(4);
		dStack.add(5);
		
		System.out.println(dStack.peek());
		
		//dStack.add(7); Exception
		
		dStack.displayAll();
	}

	private static void testQueue() {
		DQueue dQueueFactory = new DQueue(6);
		
		dQueueFactory.add(1);
		dQueueFactory.add(5);
		dQueueFactory.add(0);
		dQueueFactory.add(7);
		dQueueFactory.pop();
		dQueueFactory.pop();
		dQueueFactory.add(9);
		dQueueFactory.push(10);
		dQueueFactory.add(12);
		dQueueFactory.add(13);
		//dQueueFactory.add(1); // Exception
		
		dQueueFactory.displayAll();
	}
}




