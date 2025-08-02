class Solution {
    public long minCost(int[] basket1, int[] basket2) {
         Map<Integer, Integer> count = new HashMap<>();

        for (int fruit : basket1)
            count.put(fruit, count.getOrDefault(fruit, 0) + 1);
        for (int fruit : basket2)
            count.put(fruit, count.getOrDefault(fruit, 0) - 1);

        List<Integer> aExcess = new ArrayList<>();
        List<Integer> bExcess = new ArrayList<>();

        int minFruit = Integer.MAX_VALUE;

        for (int fruit : basket1)
            minFruit = Math.min(minFruit, fruit);
        for (int fruit : basket2)
            minFruit = Math.min(minFruit, fruit);

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int fruit = entry.getKey();
            int diff = entry.getValue();

            if (diff % 2 != 0) {
                return -1; 
            }

            if (diff > 0) {
                for (int i = 0; i < diff / 2; i++) {
                    aExcess.add(fruit);
                }
            } else if (diff < 0) {
                for (int i = 0; i < (-diff) / 2; i++) {
                    bExcess.add(fruit);
                }
            }
        }

        if (aExcess.size() != bExcess.size()) {
            return -1;
        }

        Collections.sort(aExcess);
        bExcess.sort(Collections.reverseOrder());

        long totalCost = 0;
        for (int i = 0; i < aExcess.size(); i++) {
            int a = aExcess.get(i);
            int b = bExcess.get(i);
            totalCost += Math.min(2 * minFruit, Math.min(a, b));
        }

        return totalCost;
    }
}