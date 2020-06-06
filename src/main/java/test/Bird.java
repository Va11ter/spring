package test;

import org.springframework.stereotype.Component;
import test.dto.Food;
import test.dto.FoodTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Bird implements Animal {
    static final private List<FoodTypes> possibleFeed = new ArrayList<>(
            Arrays.asList(FoodTypes.BIRD_FOOD, FoodTypes.WORM, FoodTypes.SEED));
    boolean angry = true;

    @Override
    public void voice() {
        System.out.println("Tweet, tweet");
    }

    @Override
    public boolean eat(Food food) {
        angry = false;
        return isAngry();
    }

    @Override
    public boolean isAngry() {
        return angry;
    }

    @Override
    public List<FoodTypes> getPossibleFeedTypes() {
        return new ArrayList<>(possibleFeed);
    }
}
