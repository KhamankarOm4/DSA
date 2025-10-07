class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] result = new int[rains.length];
        Arrays.fill(result, -1);
        
        TreeSet<Integer> sunnyDays = new TreeSet<>();
        Map<Integer, Integer> lastRainedLakes = new HashMap<>();
        
        for (int day = 0; day < rains.length; day++) {
            int lake = rains[day];
            
            if (lake > 0) {
                if (lastRainedLakes.containsKey(lake)) {
                    Integer dryDay = sunnyDays.higher(lastRainedLakes.get(lake));
                    if (dryDay == null) {
                        return new int[0];
                    }
                    result[dryDay] = lake;
                    sunnyDays.remove(dryDay);
                }
                lastRainedLakes.put(lake, day);
            } else {
                sunnyDays.add(day);
                result[day] = 1;
            }
        }
        
        return result;
    }
}