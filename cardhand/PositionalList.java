package cardhand;

public interface PositionalList<E> {

	Position<E> first();
	
	Position<E> last();
	
	Position<E> before(Position<E> p);
	
	Position<E> after(Position<E> p);
	
	Position<E> addFirst(E element);
	
	Position<E> addLast(E element);
	
	Position<E> addBefore(Position<E> p, E element);
	
	Position<E> addAfter(Position<E> p, E element);
	
	E set(Position<E> p, E element);
	
	E remove(Position<E> p);
	
	int size();
	
	boolean isEmpty();

}
