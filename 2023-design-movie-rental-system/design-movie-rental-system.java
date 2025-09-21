class MovieRentingSystem {
      private Map<String, Integer> priceMap;
    // unrented movies per movie id
    private Map<Integer, TreeSet<int[]>> available;
    // rented movies globally
    private TreeSet<int[]> rented;

    public MovieRentingSystem(int n, int[][] entries) {
        priceMap = new HashMap<>();
        available = new HashMap<>();
        rented = new TreeSet<>((a, b) -> 
            a[0] != b[0] ? a[0] - b[0] : 
            a[1] != b[1] ? a[1] - b[1] : 
            a[2] - b[2]); // sort by price, shop, movie

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            priceMap.put(key(shop, movie), price);
            available.computeIfAbsent(movie, k -> new TreeSet<>(
                (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]
            )).add(new int[]{price, shop});
        } 
    }
    
    public List<Integer> search(int movie) {
         List<Integer> res = new ArrayList<>();
        if (!available.containsKey(movie)) return res;
        Iterator<int[]> it = available.get(movie).iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            res.add(it.next()[1]);
            count++;
        }
        return res;
    }
    
    public void rent(int shop, int movie) {
          int price = priceMap.get(key(shop, movie));
        available.get(movie).remove(new int[]{price, shop});
        rented.add(new int[]{price, shop, movie});
    }
    
    public void drop(int shop, int movie) {
        int price = priceMap.get(key(shop, movie));
        rented.remove(new int[]{price, shop, movie});
        available.get(movie).add(new int[]{price, shop});
    }
    
    public List<List<Integer>> report() {
         List<List<Integer>> res = new ArrayList<>();
        Iterator<int[]> it = rented.iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            int[] cur = it.next();
            res.add(Arrays.asList(cur[1], cur[2]));
            count++;
        }
        return res;
    }

    private String key(int shop, int movie) {
        return shop + "#" + movie; 
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */