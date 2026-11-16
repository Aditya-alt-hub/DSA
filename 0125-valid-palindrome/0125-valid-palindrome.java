class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();

        int first=0;
        int last=s.length()-1;

        while(first<=last)
        {
            char one=s.charAt(first);
            char second=s.charAt(last);

            if(!Character.isLetterOrDigit(one))
            {
                first++;
            }
            else if(!Character.isLetterOrDigit(second))
            {
                last--;
            }
            else
            {
                if(Character.toLowerCase(one)!=Character.toLowerCase(second))
                {
                    return false;
                }
                first++;
                last--;
            }

        }
        return true;
    }
}