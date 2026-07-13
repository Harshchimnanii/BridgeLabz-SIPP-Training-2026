import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getPlanName();

    boolean isValidPlan();
}

class VegetarianMeal implements MealPlan {
    @Override
    public String getPlanName() {
        return "Vegetarian";
    }

    @Override
    public boolean isValidPlan() {
        return true;
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getPlanName() {
        return "Vegan";
    }

    @Override
    public boolean isValidPlan() {
        return true;
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getPlanName() {
        return "Keto";
    }

    @Override
    public boolean isValidPlan() {
        return true;
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getPlanName() {
        return "High-Protein";
    }

    @Override
    public boolean isValidPlan() {
        return true;
    }
}

class Meal<T extends MealPlan> {
    private final String userName;
    private final T mealPlan;

    public Meal(String userName, T mealPlan) {
        this.userName = userName;
        this.mealPlan = mealPlan;
    }

    public String getUserName() {
        return userName;
    }

    public T getMealPlan() {
        return mealPlan;
    }
}

public class PersonalizedMealPlanGenerator {

    public static <T extends MealPlan> Meal<T> generateMealPlan(String user, T plan) {
        if (!plan.isValidPlan()) {
            throw new IllegalArgumentException("Invalid meal plan: " + plan.getPlanName());
        }
        System.out.println("Generated " + plan.getPlanName() + " meal plan for " + user);
        return new Meal<>(user, plan);
    }

    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = generateMealPlan("Aman", new VegetarianMeal());
        Meal<VeganMeal> veganMeal = generateMealPlan("Riya", new VeganMeal());
        Meal<HighProteinMeal> proteinMeal = generateMealPlan("Nina", new HighProteinMeal());

        List<Meal<? extends MealPlan>> plans = new ArrayList<>();
        plans.add(vegMeal);
        plans.add(veganMeal);
        plans.add(proteinMeal);

        System.out.println("\nGenerated meal plans:");
        for (Meal<? extends MealPlan> meal : plans) {
            System.out.println(" - " + meal.getUserName() + " : " + meal.getMealPlan().getPlanName());
        }
    }
}
