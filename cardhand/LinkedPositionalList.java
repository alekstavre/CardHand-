package cardhand;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.swing.text.ElementIterator;


public class LinkedPositionalList<E> implements PositionalList<E>{

	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;

	public LinkedPositionalList() {
		header = new Node(null, null, null);
		trailer = new Node(null, header, null);
		header.setNext(trailer);
	}

	@Override
	public Position<E> first() {
		return position(header.getNext());
	}

	@Override
	public Position<E> last() {
		return position(trailer.getPrevious());
	}

	@Override
	public Position<E> before(Position<E> p) throws IllegalStateException {
		Node<E> node = validate(p);
		return position(node.getPrevious());
	}

	@Override
	public Position<E> after(Position<E> p) throws IllegalStateException {
		Node<E> node = validate(p);
		return position(node.getNext());
	}


	private Position<E> addBetween(E element, Node<E> predecessor, Node<E> successor) {
		Node<E> newest = new Node<>(element, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrevious(newest);
		size++;
		return newest;
	}

	@Override
	public Position<E> addFirst(E element) {
		return this.addBetween(element, header, header.getNext());
	}

	@Override
	public Position<E> addLast(E element) {
		return this.addBetween(element, trailer, trailer.getPrevious());
	}

	@Override
	public Position<E> addBefore(Position<E> position, E element) throws IllegalStateException {
		Node<E> node = validate(position);
		return this.addBetween(element, node.getPrevious(), node);
	}

	@Override
	public Position<E> addAfter(Position<E> position, E element) throws IllegalStateException {
		Node<E> node = validate(position);
		return this.addBetween(element, node, node.getNext());
	}

	@Override
	public E set(Position<E> position, E element) throws IllegalStateException {
		Node<E> node = validate(position);
		E removed = node.getElement();
		node.setElement(element);
		return removed;
	}

	@Override
	public E remove(Position<E> position) throws IllegalArgumentException {
		Node<E> node = validate(position);
		Node<E> predecessorNode = node.getPrevious();
		Node<E> sucessorNode = node.getNext();
		predecessorNode.setNext(sucessorNode);
		sucessorNode.setPrevious(predecessorNode);

		size--;

		E element = node.getElement();


		node.setElement(null);
		node.setPrevious(null);
		node.setNext(null);

		return element;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	private Node<E> validate(Position<E> position) throws IllegalStateException {
		if (!(position instanceof Node)) {
			throw new IllegalStateException("Invalid position");
		}

		Node<E> node = (Node<E>) position;

		if (node.getNext() == null) {     
			throw new IllegalStateException("'position' is no longer in the list");
		}

		return node;
	}

	private Position<E> position(Node<E> node) {
		if (node == header || node == trailer) {
			return null;
		}

		return node;
	}

	public Iterable<Position<E>> positions() {
		return new PositionIterable();
	}


	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	//-----nested iterator class-----

	private class PositionIterator implements Iterator<Position<E>> {

		private Position<E> cursor = first();   
		private Position<E> recent = null;        

		@Override
		public boolean hasNext() {
			return cursor != null;
		}

		@Override
		public Position<E> next() {
			if (cursor == null) {
				throw new NoSuchElementException("Nothing to get");
			}

			recent = cursor;
			cursor = after(cursor);
			return recent;
		}

		@Override
		public void remove() {
			if (recent == null) {
				throw new IllegalStateException("Nothing to remove");
			}

			LinkedPositionalList.this.remove(recent);
			recent = null;          
		}
	}

	private class PositionIterable implements Iterable<Position<E>> {

		@Override
		public Iterator<Position<E>> iterator() {
			return new PositionIterator();
		}
	}

	
	private class ElementIterator implements Iterator<E> {

		Iterator<Position<E>> positionIterator = new PositionIterator();

		@Override
		public boolean hasNext() {
			return positionIterator.hasNext();
		}

		@Override
		public E next() {
			return positionIterator.next().getElement();
		}

		@Override
		public void remove() {
			positionIterator.remove();
		}
	}

	public static void insertSort(PositionalList<Integer> list) {
		Position<Integer> marker = list.first();   

		while (marker != list.last()) {
			Position<Integer> pivot = list.after(marker);

			if (marker.getElement() < pivot.getElement()) {
				marker = pivot;
			} else {
				Position<Integer> walk = marker;

				while (walk != list.first() && list.before(walk).getElement() > pivot.getElement()) {
					walk = list.before(walk);
				}

				list.remove(pivot);
				list.addBefore(walk, pivot.getElement());
			}
		}
	}
}