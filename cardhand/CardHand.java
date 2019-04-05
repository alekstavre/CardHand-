package cardhand;

public class CardHand<E> extends LinkedPositionalList implements Iterable<E>{

	public void addCard(Node<Card> card) {
		this.addFirst(card);	
	}
	
	public void removeCard (Node<Card> card) {
		this.remove(card);
	}
	
	
		
	@Override
	public String toString() {
		return "card:" + header;
		
	}
}
