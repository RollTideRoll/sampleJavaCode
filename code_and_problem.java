/***********************************
   name of the problem:  Wildcard Matching
  
   Descriptions are shown below.
   
   Implement wildcard pattern matching with support for '?' and '*'.

   '?' Matches any single character.
   '*' Matches any sequence of characters (including the empty sequence).

   The matching should cover the entire input string (not partial).

   The function prototype should be:
   bool isMatch(const char *s, const char *p)

   Some examples:
   isMatch("aa","a") ¡ú false
   isMatch("aa","aa") ¡ú true
   isMatch("aaa","aa") ¡ú false
   isMatch("aa", "*") ¡ú true
   isMatch("aa", "a*") ¡ú true
   isMatch("ab", "?*") ¡ú true
   isMatch("aab", "c*a*b") ¡ú false
*************************************/



public class Solution {
    public boolean isMatch(String s, String p) {
        if (s==null || p==null) return false;
        if (s.length()==0 && p.length()==0) return true;
        if (p.length()==0) return false;
        int sPtr=0, pPtr=0;
        int pStar=-1, sStarPos=-1;
        while (sPtr!=s.length() || pPtr!=p.length()) {
            if (sPtr==s.length()) {
                if (p.charAt(pPtr)=='*') 
                    pPtr++;
                else 
                    return false;
            }
            else if (pPtr==p.length()) {
                if (pStar==-1) return false;
                pPtr=pStar+1;
                sPtr=sStarPos+1;
                sStarPos++;
            }
            else {
                if (s.charAt(sPtr)==p.charAt(pPtr) || p.charAt(pPtr)=='?') {
                    sPtr++;
                    pPtr++;
                }
                else if (p.charAt(pPtr)=='*') {
                    pStar=pPtr;
                    pPtr++;
                    sStarPos=sPtr;
                }
                else { // means p.charAt(pPtr)!=s.charAt(sPtr) and no special char in pPtr
                    if (pStar==-1) return false;
                    pPtr=pStar+1;
                    sPtr=sStarPos+1;
                    sStarPos++;
                }
            }
        }
        return true;
    }
}