package ds;

public class BasicLinkedList<X> {
	
	private Node first;
	private Node last;
	private int nodeCount;

	public BasicLinkedList() {
		
		first = null;
		last = null;
		nodeCount = 0;
		
	}
	
	public void add(X item)
	{
		if(first == null)
		{
			first = new Node(item);
			last = first;
		}
		
		else {
			Node newLastNode = new Node(item);
			last.setNextNode(newLastNode);
			last = newLastNode;
			
		}
		nodeCount++;
	}
	
	
	public void insert(X item, int position)
	{
		if(size() < position )
		{
			throw new IllegalStateException("the list is smaller than position specified");
			
		}
		
		Node currentNode = first;
		
		//start at 1 because we are already on the first node
		for(int i = 1; i < position && currentNode != null; i++)
		{
			//severs the link chain and reconnects with the new node
			Node newNode = new Node(item);
			Node nextNode = currentNode.getNextNode();
			currentNode.setNextNode(newNode);
			newNode.setNextNode(nextNode);
			nodeCount++;
		}
	}
	
	public X removeAt(int position)
	{
		if(size() < position)
		{
			throw new IllegalStateException("the list is smaller than position specified");

			
		}
		
		Node currentNode = first;
		Node previousNode = first;
		
		for(int i = 1; i < position && currentNode != null; i++)
		{
			previousNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		
		//now update the pointer and throw away the old first
		X nodeItem = currentNode.getNodeItem();
		previousNode.setNextNode(currentNode.getNextNode());
		nodeCount--;
		return nodeItem;
		
	}
	
	//constant time O(1)
	public X remove()
	{
		if(first == null)
		{
			throw new IllegalStateException("list is empty");
		}
		X nodeItem = first.getNodeItem();
		
		//now update the first pointer and throw away the old result
		first = first.getNextNode();
		nodeCount--;
		return nodeItem;
		
	}
	
	public X get(int position)
	{
		if(first == null)
		{
			throw new IllegalStateException("the list is empty");
			
		}
		
		Node currentNode = first;
		
		for(int i = 1; i < size() && currentNode !=null; i++)
		{
			if(i == position)
			{
				return currentNode.getNodeItem();
			}
			
			currentNode = currentNode.getNextNode();
			
		}
		//if we didnt find it then return null
		return null;
	}
	
	public int find(X item)
	{
		if(first == null)
		{
			throw new IllegalStateException("the list is empty");
			
		}
		
		Node currentNode = first;
		
		for(int i = 1; i  < size() && currentNode != null; i++)
		{
			if(currentNode.getNodeItem().equals(item))
			{
				return i;
			}
			currentNode = currentNode.getNextNode();
		}
		//if we didn't fidn it, then return -1
		
		return -1;
	}
	
	public String toString()
	{
		StringBuffer contents = new StringBuffer();
		Node curNode = first;
		
		while(curNode != null)
		{
			contents.append(curNode.getNodeItem());
			curNode = curNode.getNextNode();
			
			if(curNode != null)
			{
				contents.append(", ");
			}
		}
		return contents.toString();
	}
	
	public int size()
	{
		return nodeCount;
	}
	
	
	private class Node{
		private Node nextNode;
		private X nodeItem;
		
		public Node(X nodeItem) {
			
			this.nodeItem = nodeItem;
		}
		
		public void setNextNode(Node nextNode)
		{
			this.nextNode = nextNode;
			
		}
		
		public Node getNextNode()
		{
			return nextNode;
		}
		
		public X getNodeItem()
		{
			return nodeItem;
		}

	}
	
	


}
