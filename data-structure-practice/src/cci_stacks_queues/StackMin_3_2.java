package cci_stacks_queues;

import java.util.Stack;

/**
 * Stack Min: How would you design a stack which, in addition to push and pop,
 * has a function min which returns the minimum element? Push, pop and min
 * should all operate in 0(1) time.
 * 
 * @author chenfeng
 *
 */
public class StackMin_3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/////////////////////////////////////////////////////////
	// solv1
	/////////////////////////////////////////////////////////
	public static class StackMin extends Stack<NodeWithMin> {
		public void push(int value) {
			int newMin = Math.min(value, min());
			super.push(new NodeWithMin(value, newMin));
		}

		public int min() {
			if (this.isEmpty())
				return Integer.MAX_VALUE;
			else
				return peek().min;
		}
	}

	public static class NodeWithMin {
		public int value;
		public int min;

		public NodeWithMin(int v, int m) {
			value = v;
			min = m;
		}
	}

	/////////////////////////////////////////////////////////
	// solv2
	/////////////////////////////////////////////////////////
	public static class StackMin2 extends Stack<Integer> {
		Stack<Integer> s2;

		public StackMin2() {
			s2 = new Stack<Integer>();
		}

		public void push(int v) {
			if (v <= min())
				s2.push(v);
			super.push(v);
		}

		public Integer pop() {
			int value = super.pop();
			if (value == min())
				s2.pop();
			return value;
		}

		public int min() {
			if (s2.isEmpty())
				return Integer.MAX_VALUE;
			else
				return s2.peek();
		}
	}

}
