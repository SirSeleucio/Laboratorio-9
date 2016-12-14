

public class ArrayQueue implements Queue {
	protected Object[] v;
	protected int front, back;
	public ArrayQueue() {
		// TODO Auto-generated constructor stub
		v = new Object[100];
		makeEmpty();
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (back == front);
	}

	@Override
	public void makeEmpty() {
		// TODO Auto-generated method stub
		front = back = 0;
	}

	@Override
	public void enqueue(Object obj) {
		// TODO Auto-generated method stub
		if (increment(back) == front) {
			v = resize(v, 2*v.length);
			if (back < front) {
				System.arraycopy(v, 0, v, v.length/2, back);
				back += v.length/2;
			}
		}
		v[back] = obj;
		back = increment(back);
	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		Object obj = getFront();
		front = increment(front);
		return obj;
	}

	@Override
	public Object getFront() {
		// TODO Auto-generated method stub
		if(isEmpty()) throw new EmptyQueueException();
		return v[front];
	}
	
	protected int increment(int index) {
		return (index + 1) % v.length;
	}
	protected Object[] resize(Object[] oldArray, int newLength) {
		if(newLength < oldArray.length) throw new IllegalArgumentException();
		Object[] newArray = new Object[newLength];
		System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
		return newArray;
	}
}
