class Solution {
    public int evalRPN(String[] tokens) {
    String  str = "+-/*";

    Stack<Integer> st = new Stack<>();
    for(int i=0;i<tokens.length;i++){
        String token = tokens[i];
            if(str.contains(token)){
               int op2=st.pop();
               int op1=st.pop();

               int val =0;

               switch(token){
                case "+":
                      val = op1+op2;
                      break;
                case "-":
                      val = op1-op2;
                      break;
                case "*":
                      val = op1*op2;
                      break;
                case "/":
                      val = op1/op2;
                      break;
               }

               st.push(val);
                
            }else{
                st.push(Integer.parseInt(token));
            }
    }

            return st.peek();
    }
}