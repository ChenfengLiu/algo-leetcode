package cci_stacks_queues;

/**
 * Three in One: Describe how you could use a single array to implement three
 * stacks.
 * 
 * @author chenfeng
 *
 */
public class ThreeInOne_3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static class ThreeInOneStack {
		private int numberOfStacks = 3;
		private int stackCapacity;
		private int[] values;
		private int[] sizes;

		private ThreeInOneStack(int stackSize) {
			stackCapacity = stackSize;
			values = new int[stackSize * numberOfStacks];
			sizes = new int[numberOfStacks];
		}

		public void push(int stackNum, int value) throws Exception {
			if (isFull(stackNum))
				throw new Exception();

			sizes[stackNum]++;
			values[indexOfTop(stackNum)] = value;
		}

		public int pop(int stackNum) throws Exception {
			if (isEmpty(stackNum))
				throw new Exception();

			int topIndex = indexOfTop(stackNum);
			int value = values[topIndex];
			values[topIndex] = 0;
			sizes[stackNum]--;
			return value;
		}

		public int peek(int stackNum) throws Exception {
			if (isEmpty(stackNum))
				throw new Exception();

			return values[indexOfTop(stackNum)];
		}

		public int indexOfTop(int stackNum) {
			int offset = stackNum * stackCapacity;
			int size = sizes[stackNum];
			return offset + size - 1;
		}

		public boolean isEmpty(int stackNum) {
			return sizes[stackNum] == 0;
		}

		public boolean isFull(int stackNum) {
			return sizes[stackNum] == stackCapacity;
		}

	}

}
