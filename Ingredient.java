import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author Shashank Manda
 */

public class Recipe {

	private String recipeName;
	private int servings;
	private ArrayList<Ingredient> recipeIngredients;
	private double totalRecipeCalories;

	/**
	 * Added Constructors for the class variable.
	 */

	public Recipe() {
		this.recipeName = "";
		this.servings = 0;
		this.recipeIngredients = new ArrayList<Ingredient>();
		this.totalRecipeCalories = 0;
	}

	public Recipe(String recipeName, int servings, ArrayList<Ingredient> recipeIngredients,
			double totalRecipeCalories) {
		this.recipeName = recipeName;
		this.servings = servings;
		this.recipeIngredients = recipeIngredients;
		this.totalRecipeCalories = totalRecipeCalories;
	}

	/**
	 * Added mutators and accessors for the class variable.
	 */

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public int getServings() {
		return servings;
	}

	public void setServings(int servings) {
		this.servings = servings;
	}

	public ArrayList<Ingredient> getRecipeIngredients() {
		return recipeIngredients;
	}

	public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredients) {
		this.recipeIngredients = recipeIngredients;
	}

	public double getTotalRecipeCalories() {
		return totalRecipeCalories;
	}

	public void setTotalRecipeCalories(double totalRecipeCalories) {
		this.totalRecipeCalories = totalRecipeCalories;
	}

	public void printRecipe() {

		int singleServingCalories = (int) (totalRecipeCalories / servings);

		System.out.println("Recipe: " + recipeName + "\nServes:"+servings + "\nIngredients: ");
		int ingredientListSize = recipeIngredients.size();
		for (int index = 0; index < ingredientListSize; index++) {
			System.out.println(" "+(index +1)+"."+recipeIngredients.get(index).getNameOfIngredient());
		}
		System.out.println("\nEach serving has " + singleServingCalories + " Calories");
	}

	public Recipe addNewRecipe() {
		double totalRecipeCalories = 0;
		ArrayList<Ingredient> recipeIngredients = new ArrayList<>();
		Scanner scnr = new Scanner(System.in);

		System.out.println("Please enter the recipe name: ");
		String recipeName = scnr.nextLine();

		System.out.println("Please enter the number of servings: ");
		int servings = scnr.nextInt();

		while (true){
			System.out.println("Please enter the ingredient name or type end if you are finished entering ingredients: ");
			String ingredientName = scnr.next();
			if (ingredientName.toLowerCase().equals("end")) {
				break;
			} else {

				/**
				 * Adding the tempIngredient Object to recipeIngredients
				 * 
				 */
				Ingredient tempIngredient = new Ingredient().addIngredient(ingredientName);
				recipeIngredients.add(tempIngredient);

			}

		} 

		Recipe recipe1 = new Recipe(recipeName, servings, recipeIngredients,
				totalRecipeCalories);
		recipe1.printRecipe();
		return recipe1;
	}
}
