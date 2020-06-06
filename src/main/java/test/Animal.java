package test;

import test.dto.Food;
import test.dto.FoodTypes;

import java.util.List;

public interface Animal {
    void voice();

    boolean eat(Food food);

    boolean isAngry();

    List<FoodTypes> getPossibleFeedTypes();
}
