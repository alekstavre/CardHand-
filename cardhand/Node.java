package cardhand;


public class Node<E> implements Position<E>{

	private E element;
    private Node<E> previous;
    private Node<E> next;
	
    public Node(E element, Node<E> previous, Node<E> next) {
        this.element = element;
        this.previous = previous;
        this.next = next;
     }

    
    public E getElement() throws IllegalStateException {
        if (next == null) {
           throw new IllegalStateException("Position no longer valid");
        }

        return this.element;
     }

     public void setElement(E element) {
        this.element = element;
     }

     public Node<E> getPrevious() {
        return previous;
     }

     public void setPrevious(Node<E> previous) {
        this.previous = previous;
     }

     public Node<E> getNext() {
        return next;
     }

     public void setNext(Node<E> next) {
        this.next = next;
     }
     
    @Override
    public String toString() {
    	return element.toString();
    }
}
