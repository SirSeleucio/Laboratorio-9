
public class ArrayStack implements Stack {
	protected Object[] v;
	protected int vSize;
	public ArrayStack() {
		// TODO Auto-generated constructor stub
		v = new Object[100];
		makeEmpty();
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (vSize == 0);
	}

	@Override
	public void makeEmpty() {
		// TODO Auto-generated method stub
		vSize = 0;
	}

	@Override
	public void push(Object obj) {
		// TODO Auto-generated method stub
		if (vSize == v.length) v = resize(v, 2*vSize);
	    v[vSize++] = obj;
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		Object obj = top();
		vSize--;
		return obj;
	}

	@Override
	public Object top() {
		// TODO Auto-generated method stub
		if (isEmpty()) throw new EmptyStackException();
		return v[vSize - 1];
	}
	protected Object[] resize(Object[] oldArray, int newLength){  
		if (newLength < oldArray.length) throw new IllegalArgumentException();
		Object[] newArray = new Object[newLength];
		System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
		return newArray;
	}
}
