package ds;

public class BasicBinaryTree<X extends Comparable<X>> {
	
	private Node root;
	private int size;
	
	public BasicBinaryTree()
	{
		this.root = null;
	}
	
	public void add(X item)
	{
		
		Node node = new Node(item);
		
		//if this is the first item in the tree, set it to root
		if(root == null)
		{
			this.root = node;
			System.out.println("Set roo:" + node.getItem());
			this.size++;
		}
		else {
			insert(this.root, node);
		}
		
	}
	
	public boolean contains(X item)
	{
		Node currentNode = getNode(item);
		
		if(currentNode == null)
		{
			//didnt find it
			return false;
		}
		else {
			return true;
		}
		
	}
	
	public boolean delete(X item)
	{
		boolean deleted = false;
		
		//make sure the root isn't null meaning the tree is empty
		if(this.root == null)
		{
			return false;
		}
		
		//find the node to delete
		Node currentNode = getNode(item);
		
		if(currentNode != null)
		{
			//if the node to delete doesnt have any children, just delete it
			if(currentNode.getLeft() == null && currentNode.getRight() == null)
			{
				unlink(currentNode, null);
				deleted = true;
			}
			// if the node to delete only has a right child, remove it in the hierachy
			else if (currentNode.getLeft()== null && currentNode.getRight() != null)
			{
				unlink(currentNode, currentNode.getRight());
				deleted = true;
				
			}
			//if the node to delete only has a left child, remove it
			else if(currentNode.getLeft() != null && currentNode.getRight()== null)
			{
				unlink(currentNode, currentNode.getLeft());
				deleted = true;
			}
			//the node has both children, do a node swap to delete
			else {
				Node child = currentNode.getLeft();
				while(child.getRight() != null && child.getLeft() != null)
				{
					child = child.getRight();
				}
				
				//we have the right most leaf node. we can replace the current node with this node
				child.getParent().setRight(null); //remove the leaf node from the current position
				
				child.setLeft(currentNode.getLeft());
				child.setRight(currentNode.getRight());
				
				unlink(currentNode, child);
				deleted = true;
				
			}
		}
		
		if(deleted)
		{
			this.size--;
		}
		
		return deleted;
		
	}
	
	private void unlink(Node currentNode, Node newNode)
	{
		//if this is the root node, we replace that a little differently
		if(currentNode == this.root)
		{
			newNode.setLeft(currentNode.getLeft());
			newNode.setRight(currentNode.getRight());
			this.root = newNode;
		}
		else if(currentNode.getParent().getRight() == currentNode)
		{
			currentNode.getParent().setRight(newNode);
		}else {
			currentNode.getParent().setLeft(newNode);
		}
	}
	
	private Node getNode(X item)
	{
		Node currentNode = this.root;
		
		while(currentNode != null)
		{
			int val = item.compareTo(currentNode.getItem());
			
			//see if the node is a match
			if(val == 0)
			{
				return currentNode;
			}
			//if the val is less than 0 we go to the left side of the tree
			else if(val < 0)
			{
				currentNode = currentNode.getLeft();
			}
			//otherwise we go to the right side
			else {
				currentNode = currentNode.getRight();
			}
		}
		return null;
	}
	
	private void insert(Node parent, Node child)
	{
		//if child is a less than the parent, it goes left
		if(child.getItem().compareTo(parent.getItem()) < 0) {
			//if left child node is null, we've found our spot
			if(parent.getLeft() == null)
			{
				parent.setLeft(child);
				child.setParent(parent);
				this.size++;
			}
			//otherwise we need to call insert again and test for left or right(recursion)
			else {
				insert(parent.getLeft(), child);
			}
		}
		//if the child is greater than the parent, it goes right
		else if(child.getItem().compareTo(parent.getItem())> 0)
		{
			//if the right node is null, we've found our spot
			if(parent.getRight() == null)
			{
				parent.setRight(child);
				child.setParent(parent);
				this.size++;
			}
			//otherwise we need to call insert again and test for left or right (recursion)
			else {
				insert(parent.getRight(), child);
			}
		}
		
		//if parent and child are equal to zero
		//we do nothing
		
		
	}
	
	public int size()
	{
		return size;
	}
	private class Node{
		
		private Node left;
		private Node right;
		private Node parent;
		private X item;
		
		
		public Node(X item) {
			
			this.item = item;
			this.left = null;
			this.right = null;
			this.parent = null;
		}


		public Node getLeft() {
			return left;
		}


		public void setLeft(Node left) {
			this.left = left;
		}


		public Node getRight() {
			return right;
		}


		public void setRight(Node right) {
			this.right = right;
		}


		public Node getParent() {
			return parent;
		}


		public void setParent(Node parent) {
			this.parent = parent;
		}


		public X getItem() {
			return item;
		}


		public void setItem(X item) {
			this.item = item;
		}
		
		
		
		
	}

}
