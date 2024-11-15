import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {

        String[] arr = s.split("");
        arr[0] = arr[0].toUpperCase();
        
        for(int i=1; i<arr.length; i++) {
            if(arr[i-1].equals(" ")) {
                arr[i] = arr[i].toUpperCase();
            } else {
                arr[i] = arr[i].toLowerCase();
            }
        }
        
        return Arrays.stream(arr).collect(Collectors.joining());
    }
}