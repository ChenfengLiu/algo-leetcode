package cci_stacks_queues;

import java.util.LinkedList;

/**
 * Animal Shelter: An animal shelter, which holds only dogs and cats, operates
 * on a strictly"first in, first out" basis. People must adopt either the
 * "oldest" (based on arrival time) of all animals at the shelter, or they can
 * select whether they would prefer a dog or a cat (and will receive the oldest
 * animal of that type). They cannot select which specific animal they would
 * like. Create the data structures to maintain this system and implement
 * operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat. You may
 * use the built-in Linked list data structure.
 * 
 * @author chenfeng
 *
 */
public class AnimalShelter_3_6 {

	public static void main(String[] args) {
		// create test case

	}

	public static class animalQueue {
		private static LinkedList<Dog> dogs;
		private static LinkedList<Cat> cats;
		private static int time;

		public animalQueue() {
			dogs = new LinkedList<Dog>();
			cats = new LinkedList<Cat>();
			time = 0;
		}

		public void enqueue(Animal a) {
			a.setTime(time);
			time++;

			if (a instanceof Dog)
				dogs.addLast((Dog) a);
			else if (a instanceof Cat)
				cats.addLast((Cat) a);
		}

		public static Animal dequeueAny() {
			if (dogs.isEmpty() && cats.isEmpty())
				return null;
			else if (dogs.isEmpty())
				return cats.removeFirst();
			else if (cats.isEmpty())
				return dogs.removeFirst();
			else {
				return dogs.getFirst().getTime() > cats.getFirst().getTime() ? dogs.removeFirst() : cats.removeFirst();
			}

		}

		public static Animal dequeueDog() {
			if (dogs.isEmpty())
				return null;
			return dogs.removeFirst();
		}

		public static Animal dequeueCat() {
			if (cats.isEmpty())
				return null;
			return cats.removeFirst();
		}
	}

	//////////////////////////////////////////////////
	// Helper classes
	//////////////////////////////////////////////////

	public static class Dog extends Animal {
		public Dog(String name) {
			super(name);
		}
	}

	public static class Cat extends Animal {
		public Cat(String name) {
			super(name);
		}
	}

	public static class Animal {
		private String name;
		private int time;

		public Animal(String name) {
			this.name = name;
		}

		public void setTime(int time) {
			this.time = time;
		}

		public int getTime() {
			return time;
		}
	}

}
