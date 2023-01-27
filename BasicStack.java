package ds;

public class BasicStack<X> {

	private X []data;
	private int stackPointer;

	public BasicStack() {
		
		data =  (X[])new String[1000];
		stackPointer = 0;
	}
	

	
	public X pop() {
		
		if(stackPointer == 0)
		{
			throw new IllegalStateException("No more items on the stack");
		}
		
		return data[--stackPointer];
		
	}
	

	
	public int size()
	{
		return stackPointer;
	}

	public void push(X item) {
		
		data[stackPointer++] = item;
		
	}

	public boolean contains(X item) {
		// TODO Auto-generated method stub
		boolean found = false;
		for(int i = 0; i < stackPointer; i++)
		{
			if(data[i].equals(item)) {
				found = true;
				break;
			}
		}
		return found;
	}



	public X access(X item) {
		// TODO Auto-generated method stub
		while(stackPointer > 0)
		{
			X tempItem = pop();
			if(item.equals(tempItem)) {
				return tempItem;
			}
			
		}
		throw new IllegalArgumentException("could not find an item on the stack: " + item);
		
	}



	
	
}
