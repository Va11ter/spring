package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import test.Animal;
import test.Zoo;
import test.dto.Food;
import test.event.HungryEvent;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZooServiceImpl implements ZooService {
    private final Zoo zoo;
    private final ApplicationContext appContext;

    private List<Food> foodList;
    private Iterator<Food> nextFoodIterator;

    @Autowired
    public ZooServiceImpl(Zoo zoo, ApplicationContext appContext) {
        this.zoo = zoo;
        this.appContext = appContext;
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feed animals by: " + food.getFoodName());
        List<Animal> angryAnimals = zoo.getAnimals()
                .stream()
                .filter(Animal::isAngry)
                .peek(animal -> animal.eat(food))
                .filter(Animal::isAngry)
                .collect(Collectors.toList());
        System.out.println("Angry_animals: " + angryAnimals.toString());
        if (angryAnimals.size() != 0) {
            appContext.publishEvent(new HungryEvent(this, this));
        }
    }

    @Override
    public Iterator<Food> getNextFoodIterator() {
        return nextFoodIterator;
    }

    @Override
    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
        nextFoodIterator = this.foodList.iterator();
    }

    @Override
    public void reInitFoodIterator(){
        nextFoodIterator = foodList.iterator();
    }
}
