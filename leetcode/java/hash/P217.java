package leetcode.java.hash;

import java.util.HashSet;
import java.util.Set;

public class P217 {
	
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums) {
            if(set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

}
