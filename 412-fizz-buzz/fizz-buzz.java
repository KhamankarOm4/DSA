class Solution {
    public List<String> fizzBuzz(int n) {
       List<String> R = new ArrayList<String>();
       for(int i=1;i<=n;i++){
        if(i%3==0&&i%5==0){
            R.add("FizzBuzz");
        }else if(i%3==0){
            R.add("Fizz");
        }else if(i%5==0){
            R.add("Buzz");
        }else{
            R.add(Integer.toString(i));
        }

       }
       return R; 
    }
}