class Solution {
    public boolean rotateString(String s, String goal) {
        
        if(s.length()!=goal.length())
        {
            return false;
        }

        String str=new String(s+s);

        return str.contains(goal);

    }
}