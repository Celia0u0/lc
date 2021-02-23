package removeDuplicates;

class Solution {
	
    public String removeDuplicates(String S) {
    	if(S.equals("")){
    		return "";
    	}
    	//Node stack;
    	//stack = new Node(S.charAt(0),null);
    	
    	int l = S.length();
    	StringBuffer result = new StringBuffer();
    	result.append(S.charAt(0));
    	
    	for(int i = 1; i < l; i++){
    		char cur = S.charAt(i);
    		if(result.length() > 0 && result.charAt(result.length()-1) == cur){
    			result.deleteCharAt(result.length()-1);
    		}else{
    			result.append(cur);
    		}
    	}
    	
    	
    	
    	return result.toString();
    }
    
}

/*
class Node{
	char val;
	Node pre;
	public Node(char val, Node pre){
		this.val = val;
		this.pre = pre;
	}
}*/
