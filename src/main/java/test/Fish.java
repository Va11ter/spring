package test;

import org.springframework.stereotype.Component;
import test.dto.Food;
import test.dto.FoodTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Fish implements Animal {
    private static ArrayList<FoodTypes> feedTypes = new ArrayList<>(
            Arrays.asList(FoodTypes.WORM, FoodTypes.CUCUMBER));
    private boolean angry = true;

    @Override
    public void voice() {
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
        return new ArrayList<>(feedTypes);
    }

}
