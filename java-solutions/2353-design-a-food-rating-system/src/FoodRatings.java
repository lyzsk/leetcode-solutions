import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author sichu
 * @date 2023/12/17
 **/
public class FoodRatings {
    public Map<String, PriorityQueue<Info>> cuisineMap;
    public Map<String, Info> foodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineMap = new HashMap<>(16);
        foodMap = new HashMap<>(16);
        for (int i = 0; i < foods.length; i++) {
            Info info = new Info(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], info);
            if (cuisineMap.containsKey(cuisines[i])) {
                cuisineMap.get(cuisines[i]).add(info);
            } else {
                PriorityQueue<Info> maxheap = new PriorityQueue<>(new Comparator<Info>() {
                    @Override
                    public int compare(Info o1, Info o2) {
                        int res = o2.rate - o1.rate;
                        if (res == 0) {
                            return o1.food.compareTo(o2.food);
                        }
                        return res;
                    }
                });
                maxheap.add(info);
                cuisineMap.put(cuisines[i], maxheap);
            }
        }
    }

    public void changeRating(String food, int newRating) {
        Info prev = foodMap.get(food);
        Info cur = new Info(food, prev.cuisine, newRating);
        foodMap.put(food, cur);
        prev.food = "";
        cuisineMap.get(prev.cuisine).add(cur);
    }

    public String highestRated(String cuisine) {
        while (cuisineMap.get(cuisine).peek().food.equals("")) {
            cuisineMap.get(cuisine).remove();
        }
        return cuisineMap.get(cuisine).peek().food;
    }

    public class Info {
        String food;
        String cuisine;
        int rate;

        public Info(String food, String cuisine, int rate) {
            this.food = food;
            this.cuisine = cuisine;
            this.rate = rate;
        }
    }
}
