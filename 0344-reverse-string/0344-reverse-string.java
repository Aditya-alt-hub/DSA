class Solution {
    public void reverseString(char[] s) {
        int strt=0;
        int end=s.length-1;

        while(strt<=end)
        {
            char temp=s[strt];
            s[strt]=s[end];
            s[end]=temp;
            strt++;
            end--;
        }
    }
}