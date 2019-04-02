package cardhand;

public interface List<E> {

	E get(int i);
	
	E set(int i, E e);
	
	void add(int i, E e);
	
	E remove(int i);
	
	int size();
	
	boolean isEmpty();

}
