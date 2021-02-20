/**定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数
 * 在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * */
class MinStack {
	private Node head;
	
    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {
    	if(head == null){
    		head = new Node(x, x, null);
    	}else{
    		head = new Node(x, Math.min(x, head.curMin), head);
    	}
    	return;
    }
    
    public void pop() {
    	head = head.pre;
    	return;
    }
    
    public int top() {
    	return head.val;
    	
    }
    
    public int min() {
    	return head.curMin;
    }
}

class Node{
	int val;
	int curMin;
	Node pre;
	
	public Node(int val, int min, Node pre){
		this.val = val;
		this.curMin = min;
		this.pre = pre;
	}
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
