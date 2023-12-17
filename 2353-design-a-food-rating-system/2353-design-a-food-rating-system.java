class FoodRatings {
    HashMap<String, FoodInfo> foodInfos;
    HashMap<String, TreeSet<FoodInfo>> cuisinesMap;
    
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodInfos = new HashMap<>();
        cuisinesMap = new HashMap<>();
        
        for(int i=0;i<foods.length;i++){
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];
            
            FoodInfo obj = new FoodInfo(food, cuisine, rating);
            
            foodInfos.put(food, obj);
            
            cuisinesMap.putIfAbsent(cuisine, new TreeSet<>((a,b)->{
                if(a.rating == b.rating) return a.food.compareTo(b.food);
                return Integer.compare(b.rating, a.rating);
            }));
            
            cuisinesMap.get(cuisine).add(obj);
        }
        
    }
    
    public void changeRating(String food, int newRating) {
        FoodInfo obj = foodInfos.get(food);
        
        TreeSet<FoodInfo> nameRatings = cuisinesMap.get(obj.cuisine);
        
        nameRatings.remove(obj);
        obj.rating = newRating;
        nameRatings.add(obj);
    }
    
    public String highestRated(String cuisine) {
        return cuisinesMap.get(cuisine).first().food;
    }
}

class FoodInfo{
    String food;
    String cuisine;
    int rating;
    
    FoodInfo(String food, String cuisine, int rating){
        this.food = food;
        this.cuisine = cuisine;
        this.rating = rating;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */