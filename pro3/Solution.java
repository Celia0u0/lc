package pro3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
	//方法三 利用hashmap储存
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int maxlen = 1;
		int len = s.length();
		
		int start = 0;
		int end;
		Set<Character> tempStr = new HashSet<>();
		for(end = 0; end < len; end++){
			while(tempStr.contains(s.charAt(end))){
				tempStr.remove(s.charAt(start));
					start++;
			}
			tempStr.add(s.charAt(end));
			maxlen = Math.max(maxlen, end-start+1);
		}	
		return maxlen;
	}
	/*方法二 一次遍历
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int maxlen = 1;
		int len = s.length();
		char[] strChar = s.toCharArray();
		ArrayList<String> tempStr = new ArrayList<>();
		
		int curl;
		for (int i = 0; i < len; i++) {
			String cur = String.valueOf(strChar[i]);
			if(tempStr.contains(cur)){
				int reIndex = tempStr.indexOf(cur);
				for(int j = 0;j <= reIndex; j++){
                    tempStr.remove(0);
                }
			}
			tempStr.add(cur);
			maxlen = Math.max(maxlen, tempStr.size());
			//curl = tempStr.size();
			//if(curl > maxlen)
			//	maxlen = curl;
			
		}
		return maxlen;
	}*/
	/*方法一 双重遍历
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int maxlen = 1;
		int len = s.length();
		char[] strChar = s.toCharArray();
		ArrayList<String> tempStr;
		
		for (int i = 0; i < len - 1; i++) {
			tempStr = new ArrayList<>();
			for (int j = i; j < len; j++) {
				String cur = String.valueOf(strChar[j]);
				if (tempStr.contains(cur)) {
					maxlen = Math.max(maxlen, tempStr.size());
					break;
				} else {
					tempStr.add(cur);
				}
			}
			maxlen = Math.max(maxlen, tempStr.size());
		}
		return maxlen;

	}*/

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Solution tool = new Solution();

		while (true) {
			String s = scan.nextLine();
			if(s == "0") break;
			int max = tool.lengthOfLongestSubstring(s);
			System.out.println(max);
		}
		scan.close();

	}
}
