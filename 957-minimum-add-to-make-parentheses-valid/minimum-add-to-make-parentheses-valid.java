class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int invalidCount = 0;

        for(char i:s.toCharArray()){
            if(i=='('){
                st.push(')');
            }else if(st.isEmpty() || st.pop()!=i){
                invalidCount++;

            }
        }
        while(!st.isEmpty()){
           st.pop();
           invalidCount++;
        }
        return invalidCount;
    }
}