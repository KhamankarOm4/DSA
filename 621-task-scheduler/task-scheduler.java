class Solution {
    public int leastInterval(char[] tasks, int n) {
        List<Integer> res = new ArrayList<>(26);
        int count = 0;
        for(int i = 0; i < 26; i++){
            res.add(0);
             }

        for(int i=0;i<tasks.length;i++){
            int idx = tasks[i]-'A';
            res.set(idx,res.get(idx)+1);
            count = Math.max(count,res.get(tasks[i]-'A'));
        }

        int ans = (count-1)*(n+1);

        for(int i=0;i<res.size();i++){
            if(res.get(i)==count){
                ans++;
            }
        }

        return ans>tasks.length?ans:tasks.length;
    }
}