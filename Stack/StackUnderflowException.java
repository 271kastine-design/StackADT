public class StackUnderflowException extends RuntimeException
{
    public StackUnderflowException()
    {
        super("Cannot access an element in an empty stack.");
    }

    public StackUnderflowException(String message)
    {
        super(message);
    }
}