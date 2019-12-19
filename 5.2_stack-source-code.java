import java.util.LinkedList;

public class Stack<T> implements Iterable<Stack> {
    private java.util.LinkedList<T> list = new java.util.LinkedList<T>();

    // Create an empty stack
    public Stack() {
    }

    // Create a Stack with an initail element
    public Stack(T firstElem) {
        push(firstElem);
    }

    // Return the number of elements in the stack
    public int size() {
        return list.size();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return size() == 0;
    }

    // Push an element on the stack
    public void push(T elem) {
        list.addLast(elem);
    }

    // Pop an element off the stack
    // Throws an error if the stack is empty
    public T pop() {
        if (isEmpty())
            throw new java.util.EmptyStackException();
        return list.peekLast();
    }

    // Allow users to iterate through the stack using an iterator
    @Override
    public java.util.Iterator<T> iterator() {
        return list.iterator();
    }
}