package test.service;

import test.dto.Food;

import java.util.Iterator;
import java.util.List;

public interface ZooService {
    void feed(Food food);
    Iterator<Food> getNextFoodIterator();
    void setFoodList(List<Food> foodList);
    public void reInitFoodIterator();
}
