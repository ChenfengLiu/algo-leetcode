package cci_stacks_queues;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too
 * high, it might topple. Therefore, in real life, we would likely start a new
 * stack when the previous stack exceeds some threshold. Implement a data
 * structure SetOfStacks that mimics this. SetO-fStacks should be composed of
 * several stacks and should create a new stack once the previous one exceeds
 * capacity. SetOfStacks. push() and SetOfStacks. pop() should behave
 * identically to a single stack (that is, pop () should return the same values
 * as it would if there were just a single stack).
 * 
 * FOLLOW UP
 * 
 * Implement a function popAt ( int index) which performs a pop operation on a
 * specific sub-stack.
 * 
 * @author chenfeng
 *
 */
public class StackOfPlates_3_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static class SetOfStacks {
		ArrayList<Stack> stacks;
		public int capacity;

		public SetOfStacks(int c) {
			capacity = c;
			stacks = new ArrayList<Stack>();
		}

		public void push(int v) {
			Stack last = getLastStack();
			if (last != null && !isFull(last)) {
				last.push(v);
			} else {
				Stack newStack = new Stack();
				newStack.push(v);
				stacks.add(newStack);
			}
		}

		public int pop() throws Exception {
			Stack last = getLastStack();
			if (last == null)
				throw new Exception();
			int v = (int) last.pop();
			if (last.size() == 0)
				stacks.remove(stacks.size() - 1);
			return v;
		}

		public Stack getLastStack() {
			if (stacks.size() != 0)
				return stacks.get(stacks.size() - 1);
			else
				return null;
		}

		public boolean isFull(Stack s) {
			if (s.size() == capacity)
				return true;
			else
				return false;
		}
	}
}
