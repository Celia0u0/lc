package queueFromS;

class MyQueue {
	Node inStack;
	Node outStack;
	Boolean reOut;// 需要更新outstack
	Boolean reIn;// 需要更新instack
    /** Initialize your data structure here. */
    public MyQueue() {
    	reOut = false;
    	reIn = false;
    }
 
    private void refreshOutStack() {
		if(reOut){
	    	outStack = new Node(inStack.val, null);
	    	Node temp = inStack.pre;
	    	while(temp != null){
	    		outStack = new Node(temp.val,outStack);
	    		temp = temp.pre;
	    	}
	    	reOut = false;
		}
	}
    
    private void refreshInStack() {
		if(reIn){
			if(outStack == null){
				inStack = null;
			}else{
				inStack = new Node(outStack.val, null);
		    	Node temp = outStack.pre;
		    	while(temp != null){
		    		inStack = new Node(temp.val,inStack);
		    		temp = temp.pre;
		    	}
			}
	    	reIn = false;
		}
	}
    /** Push element x to the back of queue. */
    public void push(int x) {
    	refreshInStack();
    	if(empty()){
    		this.inStack = new Node(x, null);
    	}else{
    		inStack = new Node(x, inStack);
    	}
    	this.reOut = true;
    	
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	refreshOutStack();
    	if(empty()){
    		return -1;//出错
    	}else{
    		int result = outStack.val;
        	outStack = outStack.pre;
        	this.reIn = true;
        	return result;
    	}
    	
    }
    
    /** Get the front element. */
    public int peek() {
    	refreshOutStack();
    	if(empty()){
    		return -1;//出错
    	}else{
    		return outStack.val;
    	}
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	boolean flag = (!reIn && inStack == null)||(!reOut && outStack == null);
    	return flag;
    }
    
    public static void main(String[] args){
    	MyQueue obj = new MyQueue();
    	obj.push(1);
    	int param_3 = obj.peek();
    	System.out.println(param_3);
    	
    	int param_2 = obj.pop();
    	System.out.println(param_2);
    	
    	boolean param_4 = obj.empty();
    	System.out.println(param_4);
    }
}

/*
class Node{
	int val;
	Node pre;
	Node(int val, Node pre){
		this.val = val;
		this.pre = pre;
	}
}
*/

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
