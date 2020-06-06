import com.sun.codemodel.internal.JForEach;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.Zoo;
import test.configuration.AnnotationConfiguration;
import test.dto.Food;
import test.dto.FoodTypes;
import test.event.HungryEvent;
import test.event.ZooEvent;
import test.service.ZooService;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = getAnnotationContext();
        feedAnimal(context);
    }

    public static List<Food> generateZooFood(){
        List<Food> foodArray = new ArrayList<>();
        for(FoodTypes foodType: FoodTypes.values()){
            Food food = new Food(foodType);
            food.setExpirationDate(LocalDateTime.now().plusHours(6));
            foodArray.add(food);
        }
        return foodArray;
    }

    public static void feedAnimal(ApplicationContext context) {
        ZooService service = context.getBean(ZooService.class);
        service.setFoodList(generateZooFood());
        context.publishEvent(new HungryEvent(service, service));
    }

    public static ApplicationContext getAnnotationContext() {
        return new AnnotationConfigApplicationContext(AnnotationConfiguration.class);
    }
}
