public class ArrayStack<T> implements StackInterface<T>
{
	private static final int DEFAULT_CAPACITY = 10;

	private T[] elements;
	private int size;

	@SuppressWarnings("unchecked")
	public ArrayStack()
	{
		elements = (T[]) new Object[DEFAULT_CAPACITY];
		size = 0;
	}

	public int size()
	{
		return size;
	}

	public boolean empty()
	{
		return size == 0;
	}

	public T peek()
	{
		if (empty())
			throw new StackUnderflowException();

		return elements[size - 1];
	}

	public T pop()
	{
		if (empty())
			throw new StackUnderflowException();

		T item = elements[--size];
		elements[size] = null;
		return item;
	}

	public T push(T item)
	{
		if (size == elements.length)
			expandCapacity();

		elements[size++] = item;
		return item;
	}

	public void clear()
	{
		for (int i = 0; i < size; i++)
			elements[i] = null;
		size = 0;
	}

	public int search(Object o)
	{
		int position = 1;
		for (int i = size - 1; i >= 0; i--, position++)
		{
			if (o == null ? elements[i] == null : o.equals(elements[i]))
				return position;
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	private void expandCapacity()
	{
		T[] larger = (T[]) new Object[elements.length * 2];
		System.arraycopy(elements, 0, larger, 0, size);
		elements = larger;
	}
}
