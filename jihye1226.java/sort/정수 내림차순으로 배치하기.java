import java.util.*;
class Solution {
    public long solution(long n) {
        String str = Long.toString(n);
        
        char[] charArr = str.toCharArray();
        
        Arrays.sort(charArr);
        
        StringBuilder sb = new StringBuilder(new String(charArr));
        sb.reverse();
        
        return Long.parseLong(sb.toString());
    }
}