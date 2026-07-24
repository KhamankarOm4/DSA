class Solution {
    public String decodeString(String s) {
        Deque<Integer> intstack = new ArrayDeque<>();
        Deque<String> strstack = new ArrayDeque<>();
        int rnum = 0;
        for(char c:s.toCharArray()){
            if(c>='0' && c<='9'){
                rnum = rnum*10 + (c-'0');
            }else if(c=='['){
                intstack.push(rnum);
                rnum = 0;
                strstack.push(String.valueOf(c));
            }else if(c==']'){
                String temp = "";
                while(!strstack.isEmpty() && !strstack.peek().equals("[")){
                   temp = strstack.pop() + temp;
                }
                strstack.pop();
                int num = intstack.pop();
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<num;i++){
                    sb.append(temp);
                }
                strstack.push(sb.toString());
            }else{
                strstack.push(String.valueOf(c));
            }
        }

        String result = "";
        while(!strstack.isEmpty()){
            result = strstack.pop() + result;
        }
        return result;
    }
}