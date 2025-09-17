class FoodRatings {

    private Map<String, String> foodToCuisine;
    private Map<String, Integer> foodToRating;
    private Map<String, TreeSet<Food>> cuisineToFoods;

    private static class Food {
        String name;
        int rating;

        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Food)) return false;
            Food other = (Food) obj;
            return this.name.equals(other.name) && this.rating == other.rating;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, rating);
        }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);

            cuisineToFoods
                .computeIfAbsent(cuisine, k -> new TreeSet<>(
                    (a, b) -> a.rating == b.rating
                            ? a.name.compareTo(b.name)
                            : b.rating - a.rating
                ))
                .add(new Food(food, rating));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        int oldRating = foodToRating.get(food);

        TreeSet<Food> foodsSet = cuisineToFoods.get(cuisine);
        foodsSet.remove(new Food(food, oldRating));

        foodToRating.put(food, newRating);
        foodsSet.add(new Food(food, newRating));
    }

    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).first().name;
    }
}
/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */