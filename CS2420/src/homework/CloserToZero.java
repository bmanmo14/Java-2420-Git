package homework;

import java.util.ArrayList;
import java.util.Scanner;

public class CloserToZero {

	public static void main(String[] args) {
		System.out.println("Hello! Welcome, enter a new word!");
		String word = "Hello";
		Scanner a = new Scanner(System.in);
		String b = a.next();

		if (word.equals(b)) {
			System.out.println("Cool.");
		} else {
			System.out.println("okay");
		}
		System.out.println("Now ask me a question yo");
		myDay();
		a.close();
	}

	public static void myDay() {
		ArrayList<String> h = new ArrayList<String>();
		h.add("how are you today");
		Scanner r = new Scanner(System.in);
		while (r.hasNextLine()) {
			ArrayList<String> g = new ArrayList<String>();
			g.add(r.nextLine());
			if (h.equals(g)) {
				System.out.println("My day was amazing!");
				break;
			} else {
				System.out.println("I don't like that question. ask me a new one.");
			}
		}
		r.close();
	}
	/*
	if (index >= count || index < 0) {
		throw new IndexOutOfBoundsException();
	}
	
	Node temp;
	int iterCount = 0;
	if (index <= count / 2) {
		temp = head;
		if (index == 0) {
			removeFirst();
			return head.data;
		}
		while(iterCount < index) {
			temp = temp.next;
			iterCount++;
		}
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
	}
	
	else {
		temp = tail;
		if (index == count -1) {
			tail = temp.prev;
		}
		while(iterCount > index) {
			temp = temp.prev;
			iterCount++;
		}
			temp.next.prev = temp.prev;
			temp.prev.next = temp.next;
	}
	count--;
	return temp.data;
}*/
}
