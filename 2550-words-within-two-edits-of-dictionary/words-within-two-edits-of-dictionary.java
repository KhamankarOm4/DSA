class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> list = new ArrayList<>();
        List<String> res = new ArrayList<>();
        
        for(String d:dictionary){
            list.add(d);
        }
        for(String q:queries){
          if(list.contains(q)){
            res.add(q);
          }else{
            int qlen = q.length();
            for(String d:dictionary){
                 int count = 0;
              for(int i=0;i<qlen;i++){
                if(q.charAt(i)==d.charAt(i)){
                    continue;
                }else  count++;
              }
              if(count<=2){
                 res.add(q);
                 break;
                 }  
            }
          }
        }
       return res; 
    }
}