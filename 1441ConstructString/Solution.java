import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
   
        int cur = 0;
        for(int i = 1; i < n+1; i++){
        	if(cur == target.length)
        		break;
        	if(i == target[cur]){
        		result.add("Push");
        		cur += 1;
        	}else{
        		result.add("Push");
        		result.add("Pop");
        	}
        }      
        return result;
    }
}
