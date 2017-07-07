package cci_stacks_queues;

import java.util.Stack;

/**
 * Queue via Stacks: Implement a MyQueue class which implements a queue using
 * two stacks.
 * 
 * @author chenfeng
 *
 */
public class QueueViaStacks_3_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static class MyQueue<T>{
		Stack<T> newOnTop, oldOnTop;
		
		public MyQueue(){
			newOnTop = new Stack<T>();
			oldOnTop = new Stack<T>();
		}
		
		public int size(){
			return newOnTop.size()+oldOnTop.size();
		}
		
		public void enqueue(T val){
			newOnTop.add(val);
		}
		
		public T dequeue(){
			shiftStacks();
			return oldOnTop.pop();
		}
		
		public T peek(){
			shiftStacks();
			return oldOnTop.peek();
		}
		
		private void shiftStacks(){
			if(oldOnTop.isEmpty()){
				while(!newOnTop.isEmpty()){
					oldOnTop.push(newOnTop.pop());
				}
			}
		}
		
		
	}

}
