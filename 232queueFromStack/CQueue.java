package queueFromS;

class CQueue {
	Node inStack;
	Node outStack;
	Boolean reOut;// 需要更新outstack
	Boolean reIn;// 需要更新instack
	
    public CQueue() {
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
    
    public void appendTail(int value) {
    	refreshInStack();
    	if(empty()){
    		this.inStack = new Node(value, null);
    	}else{
    		inStack = new Node(value, inStack);
    	}
    	this.reOut = true;
    }
    
    public int deleteHead() {
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
    
    private boolean empty() {
    	boolean flag = (!reIn && inStack == null)||(!reOut && outStack == null);
    	return flag;
	}
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

class Node{
	int val;
	Node pre;
	Node(int val, Node pre){
		this.val = val;
		this.pre = pre;
	}
}
