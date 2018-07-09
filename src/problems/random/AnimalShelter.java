package problems.random;

/* Return dog or cat in order of received  */

import java.util.LinkedList;

class AnimalShelter {

	abstract class Animal {
		private int order;
		protected String name;

		public Animal(String n) {
			name = n;
		}

		public abstract String name();

		public void setOrder(int ord) {
			order = ord;
		}

		public int getOrder() {
			return order;
		}

		public boolean isOlderThan(Animal a) {
			return this.order < a.getOrder();
		}
	}

	class Cat extends Animal {
		public Cat(String n) {
			super(n);
		}

		public String name() {
			return "Cat: " + name;
		}
	}

	class Dog extends Animal {
		public Dog(String n) {
			super(n);
		}

		public String name() {
			return "Dog: " + name;
		}
	}

	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	private int order = 0;

	private void enqueue(Animal a) {
		a.setOrder(order);
		order++;
		if (a instanceof Dog) {
			dogs.addLast((Dog) a);
		} else if (a instanceof Cat) {
			cats.addLast((Cat) a);
		}
	}

	private Animal dequeueAny() {
		if (dogs.size() == 0) {
			return dequeueCats();
		} else if (cats.size() == 0) {
			return dequeueDogs();
		}
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if (dog.isOlderThan(cat)) {
			return dogs.poll();
		} else {
			return cats.poll();
		}
	}

	private Animal peek() {
		if (dogs.size() == 0) {
			return cats.peek();
		} else if (cats.size() == 0) {
			return dogs.peek();
		}
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if (dog.isOlderThan(cat)) {
			return dog;
		} else {
			return cat;
		}
	}

	private int size() {
		return dogs.size() + cats.size();
	}

	private Dog dequeueDogs() {
		return dogs.poll();
	}

	private Dog peekDogs() {
		return dogs.peek();
	}

	private Cat dequeueCats() {
		return cats.poll();
	}

	private Cat peekCats() {
		return cats.peek();
	}

	public static void main(String[] args) {
		AnimalShelter animals = new AnimalShelter();
		animals.enqueue(animals.new Cat("Callie"));
		animals.enqueue(animals.new Cat("Kiki"));
		animals.enqueue(animals.new Dog("Fido"));
		animals.enqueue(animals.new Dog("Dora"));
		animals.enqueue(animals.new Cat("Kari"));
		animals.enqueue(animals.new Dog("Dexter"));
		animals.enqueue(animals.new Dog("Dobo"));
		animals.enqueue(animals.new Cat("Copa"));

		System.out.println(animals.dequeueAny().name());
		System.out.println(animals.dequeueAny().name());
		System.out.println(animals.dequeueAny().name());

		animals.enqueue(animals.new Dog("Dapa"));
		animals.enqueue(animals.new Cat("Kilo"));

		while (animals.size() != 0) {
			System.out.println(animals.dequeueAny().name());
		}
	}

}
