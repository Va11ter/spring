package test.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import test.Animal;
import test.dto.Food;

import java.time.LocalDateTime;
import java.util.Objects;

@Aspect
@Component
public class AnimalAspect {

    @Pointcut("execution(* test.Animal.eat(..))")
    public void eatPoint() {
    }

    @Before(value = "eatPoint()")
    public void beforeEat() {
        System.out.println("beforeEat() start eat");
    }

    @After(value = "eatPoint()")
    public void afterEat() {
        System.out.println("afterEat() end eat");
    }

    @AfterThrowing(value = "eatPoint()", throwing = "ex")
    public void eatFailed(Throwable ex) {
        System.out.println("eat failed: " + ex.getMessage());
    }

    @AfterReturning(value = "eatPoint()")
    public void eatSuccess(JoinPoint joinPoint) {
        System.out.println("eatSuccess() eat success");
    }

    @Around(value = "eatPoint() && args(food)")
    public Object eatAround(ProceedingJoinPoint proceedingJoinPoint, Food food) throws Throwable {
        Animal animal = (Animal) proceedingJoinPoint.getTarget();
        String target = animal.getClass().toString();
        if (LocalDateTime.now().isAfter(food.getExpirationDate()) || !isGoodFoodType(animal, food)){
            System.out.println("eatAround food " + food.getFoodName() + " doesn't fit for " + animal.toString());
            return false;
        }
        System.out.println("eatAround "+target + " start eat");
        try {
            Object result = proceedingJoinPoint.proceed();
            System.out.println("eatAround "+target + " eat success");
            System.out.println("eatAround "+target + " end eat");
            return result;
        } catch (Throwable e) {
            System.out.println("eatAround "+ target + " eat failed: " + e.getMessage());
            throw e;
        }
    }

    private boolean isGoodFoodType(Animal animal, Food food) {
        return animal.getPossibleFeedTypes().contains(food.getFoodType());
    }
}
