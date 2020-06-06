package test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import test.dto.Food;
import test.dto.FoodTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
public class Dog implements Animal {
    private static ArrayList<FoodTypes> feedTypes = new ArrayList<>(
            Arrays.asList(FoodTypes.DOG_FOOD, FoodTypes.SAUSAGE));
    private boolean angry = true;

    public void voice() {
        System.out.println("gav");
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
