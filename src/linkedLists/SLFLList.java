package linkedLists;
/**
 * Singly linked list with references to its first and its
 * last node. 
 * 
 * @author pirvos
 *
 */

import java.util.NoSuchElementException;

import linkedLists.LinkedList;

public class SLFLList<E> extends SLList<E>
{
	private SNode<E> first, last;   // reference to the first node and to the last node
	int length; 
	
	public SLFLList() {       // to create an empty list instance
		first = last = null; 
		length = 0; 
	}
	
	
	public void addFirstNode(Node<E> nuevo) {
		SNode<E> sn = (SNode<E>) nuevo;
		if(first == null){
			first = last = sn;
		} 
		SNode<E> prev = (SNode<E>) nuevo;
		prev.setNext(first);
		first=prev;
		length++;
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		SNode<E> st = (SNode<E>) target;
		SNode<E> sn = (SNode<E>) nuevo;
		sn.setNext(st.getNext());
		st.setNext(sn);
		if(sn == last)
			last = sn;
		length++;
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		SNode<E> st = (SNode<E>) target;
		SNode<E> sn = (SNode<E>) nuevo;
		if (st == this.first){
			sn.setNext(first);
			first = sn;
		}
		else{
			SNode<E> prev = (SNode<E>)this.getNodeBefore(target);
			prev.setNext(sn);
			sn.setNext(st);
		}
		length++;
		}
	

	public Node<E> getFirstNode() throws NoSuchElementException {
		if(length == 0)
			throw new NoSuchElementException("List is empty");
		
		
		return this.first;
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		if(length == 0)
			throw new NoSuchElementException("List is empty");
		
		return this.last;
	}

	public Node<E> getNodeAfter(Node<E> target) throws NoSuchElementException {
		SNode<E> st = (SNode<E>) target;
		if(last == st){
			throw new NoSuchElementException("Nothing after final node");
		}
		return st.getNext();
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		
		SNode<E> st = (SNode<E>) target;
		if (st==first)
			throw new NoSuchElementException();
		SNode<E> prev = first;
		while (prev != null && prev.getNext() != target) 
			prev = prev.getNext();  
		return prev;
		}
	
//		while(sb.getNext() != target){
//			sb = sb.getNext();
//		}
		
	

	public int length() {
		// TODO Auto-generated method stub
		return this.length;
	}

	public void removeNode(Node<E> target) {
		// TODO Auto-generated method stub
		SNode<E> st = (SNode<E>) target;
		if(length() == 1){
			first = null;
			last = null;
			st.clean();
		}
		
		else if(first == st){
			first = st.getNext();
			st.clean();
		}
		else {
			SNode<E> prev = (SNode<E>) getNodeBefore(st);
			prev.setNext(st.getNext());
				if(target == last)
					last = prev;
				
			st.clean();
		}
		length--;
		
	}
	
	public Node<E> createNewNode() {
		return new SNode<E>();
	}

}