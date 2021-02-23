package removeOuterParentheses;

/**给出一个非空有效字符串 S，考虑将其进行原语化分解，
 * 使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * 
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 
 */

class Solution {
    public String removeOuterParentheses(String S) {
    	StringBuffer result = new StringBuffer();
    	char[] input = S.toCharArray();
    	int l = input.length;
    	
    	int stack_i = 0;//简化->不用线性表只存一个游标
    	//StringBuffer temp = new StringBuffer();
    	for(int j = 0; j < l; j++){
    		char cur = input[j];
    		if(cur == '('){
    			if(stack_i > 0){
    				//非最外层括号
    				result.append(cur);
    			}
    			stack_i++; //推入栈
    		}else{
    			stack_i--;//遇到')',将一个'('推出栈
    			if(stack_i > 0){
    				result.append(cur);
    			}
    		}
    	}
    	
    	
    	return result.toString();
    }
}
