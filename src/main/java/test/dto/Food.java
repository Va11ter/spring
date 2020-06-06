package test.dto;

import java.time.LocalDateTime;

public class Food {
    private String foodName;
    private LocalDateTime expirationDate;
    private FoodTypes foodType;

    public String getFoodName() {return foodName;}

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public FoodTypes getFoodType(){return foodType;}

    public void setFoodType(FoodTypes foodType) { this.foodType = foodType;}
}
