package ds;

public class BasicHashTable<X,Y> {
	
	private HashEntry[] data;
	private int capacity;
	
	
	
	
	public BasicHashTable(int tableSize) {
		
		this.capacity = tableSize;
		this.data = new HashEntry[capacity];
	}




	private class HashEntry<X,Y>
	{
		private X key;
		private Y value;
		
		
		public HashEntry(X key, Y value) {
			super();
			this.key = key;
			this.value = value;
		}
		public X getKey() {
			return key;
		}
		public void setKey(X key) {
			this.key = key;
		}
		public Y getValue() {
			return value;
		}
		public void setValue(Y value) {
			this.value = value;
		}
		
		
	}
	
	

}
