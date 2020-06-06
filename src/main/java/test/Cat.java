package test;

import org.springframework.stereotype.Component;
import test.dto.Food;
import test.dto.FoodTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Cat implements Animal {
    private static ArrayList<FoodTypes> possibleFeed = new ArrayList<>(
            Arrays.asList(FoodTypes.CAT_FOOD, FoodTypes.SAUSAGE));
    private boolean angry = true;

    public void voice() {
        System.out.println("mi");
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
