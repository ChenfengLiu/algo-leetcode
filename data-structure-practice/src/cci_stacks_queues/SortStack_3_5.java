package cci_stacks_queues;

import java.util.Stack;

/**
 * Sort Stack: Write a program to sort a stack such that the smallest items are
 * on the top. You can use an additional temporary stack, but you may not copy
 * the elements into any other data structure (such as an array). The stack
 * supports the following operations: push, pop, peek, and is Empty.
 * 
 * @author chenfeng
 *
 */
public class SortStack_3_5 {

	public static void main(String[] args) {
		//create test case
		Stack<Integer> s = new Stack<Integer>();
		s.push(5);
		s.push(10);
		s.push(7);
		
		Stack<Integer> result = sortStack(s);
		System.out.println(result.toString());
		

	}
	
	
	public static Stack<Integer> sortStack(Stack<Integer> s){
		Stack<Integer> result = new Stack<Integer>();
		
		while(!s.isEmpty()){
			int temp = s.pop();
			while(!result.isEmpty() && result.peek() > temp){
				s.push(result.pop());
			}
			result.push(temp);
		}
		
		return result;
	}

}
