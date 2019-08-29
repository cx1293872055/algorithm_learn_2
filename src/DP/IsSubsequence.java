package DP;

public class IsSubsequence {
    public static void main(String[] args) {
        String a = "abc";
        String b = "ahbgdc";
        isSubsequence(a,b);
    }
    public static boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()){
            index = t.indexOf(c, index+1);
            System.out.println(index);
            if (index == -1) return false;
        }
        return true;
    }
}
