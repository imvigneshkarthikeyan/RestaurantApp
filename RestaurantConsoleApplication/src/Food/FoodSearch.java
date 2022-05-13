package Food;

import static Utilities.UiUtils.*;
import static Utilities.ValidatorUtils.*;

public class FoodSearch {
    public void searchFood(FoodDatabase foodDatabase) {
        drawDoubleLine();
        System.out.println("Enter food to search: ");
        String enteredFood = scanner.next();
        if (foodDatabase.getfoodMap().containsKey(enteredFood)) {
            System.out.println("Food found " + foodDatabase.getfoodMap().get(enteredFood));
        }
    }
}
