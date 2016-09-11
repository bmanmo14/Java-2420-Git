package assignment10;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class MYChainingHashTable implements Set<String> {
	
	private LinkedList<String>[] storage;
	public int capacity;
	public int count = 0;
	public HashFunctor functor;
	public int collsions;
	
	@SuppressWarnings("unchecked")
	public MYChainingHashTable(int capacity, HashFunctor functor){
		this.capacity = capacity;
		this.functor = functor;
		collsions = 0;
		storage = (LinkedList<String>[]) new LinkedList[capacity];
	}
	
	@Override
	public boolean add(String item) {
		if(contains(item)){
			return false;
		}
		
		int hash =  functor.hash(item) % capacity;
		if(storage[hash] == null){
			storage[hash] = new LinkedList<String>();
			storage[hash].addLast(item);
			count++;
			return true;
		}
		else if(storage[hash] != null){
			collsions++;
			storage[hash].addLast(item);
			count++;
			return true;
		}
		return false;
	}
	@Override
	public boolean addAll(Collection<? extends String> items) {
		Iterator<? extends String> itr = items.iterator();
		while(itr.hasNext()){
			add(itr.next());
		}
		if(containsAll(items)){
			return true;
		}
		else{
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		storage = (LinkedList<String>[]) new LinkedList[capacity];
		count = 0;
	}
	
	@Override
	public boolean contains(String item) {
		int hash =  functor.hash(item) % capacity;
		if(storage[hash] == null){
			return false;
		}
		else if(storage[hash] != null){
			if(storage[hash].contains(item)){
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
	@Override
	public boolean containsAll(Collection<? extends String> items) {
		Iterator<? extends String> itr = items.iterator();
		while(itr.hasNext()){
			if(!contains(itr.next())){
				return false;
			}
		}
		return true;
	}
	@Override
	public boolean isEmpty() {
		if(count == 0){
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public int size() {
		return count;
	}
	
	public int collision(){
		return collsions;
	}
}
