public class LinkedStack<T> implements StackInterface<T>
{
	private LLNode<T> top;
	private int size;

	public LinkedStack()
	{
		top = null;
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

		return top.getInfo();
	}

	public T pop()
	{
		if (empty())
			throw new StackUnderflowException();

		T item = top.getInfo();
		top = top.getLink();
		size--;
		return item;
	}

	public T push(T item)
	{
		LLNode<T> node = new LLNode<T>(item);
		node.setLink(top);
		top = node;
		size++;
		return item;
	}

	public void clear()
	{
		top = null;
		size = 0;
	}

	public int search(Object o)
	{
		int position = 1;
		for (LLNode<T> current = top; current != null; current = current.getLink())
		{
			if (o == null ? current.getInfo() == null : o.equals(current.getInfo()))
				return position;
			position++;
		}
		return -1;
	}
}
