
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Venkat Sasank
 */

public class RecipeBox {

	private ArrayList<Recipe> listOfRecipes = new ArrayList<Recipe>();


	public ArrayList<Recipe> getListOfRecipes() {
		return listOfRecipes;
	}

	public void setListOfRecipes(ArrayList<Recipe> listOfRecipes) {
		this.listOfRecipes = listOfRecipes;
	}

	public RecipeBox() {
		this.listOfRecipes = new ArrayList<Recipe>();
	}

	public RecipeBox(ArrayList<Recipe> listOfRecipes) {
		this.listOfRecipes = listOfRecipes;
	}

	public void printAllRecipeDetails(String selectedRecipe) {

		Recipe tempRecipe = new Recipe();


		for (int i = 0; i < listOfRecipes.size(); i++) {

			tempRecipe  = listOfRecipes.get(i);
			if (tempRecipe .getRecipeName().equalsIgnoreCase(selectedRecipe))
				tempRecipe .printRecipe();
		}
	}

	public void printAllRecipeNames() {
		int numberOfRecipes = listOfRecipes.size();
		for (int i = 0; i < numberOfRecipes; i++) {
			Recipe tempRecipe  = listOfRecipes.get(i);
			System.out.println((i+1) + ". " + tempRecipe .getRecipeName()+"\n");
		}
	}

	public void addNewRecipe() {

		Recipe temporaryRecipe = new Recipe();

		listOfRecipes.add(temporaryRecipe.addNewRecipe());

	}


	public static void main(String[] args) {

		RecipeBox myRecipeBox = new RecipeBox();
		Scanner scnr = new Scanner(System.in);

		System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n"
				+ "3. Print All Recipe Names\n" + "\nPlease select a menu item:");
		while (scnr.hasNextInt() || scnr.hasNextLine()) {
			int input = scnr.nextInt();

			if (input == 1) {
				myRecipeBox.addNewRecipe();
			} else if (input == 2) {
				System.out.println("Which recipe?\n");
				String selectedRecipeName = scnr.next();
				myRecipeBox.printAllRecipeDetails(selectedRecipeName);

			}

			else if (input == 3) {
				myRecipeBox.printAllRecipeNames();
			} else {
				System.out.println("\nMenu\n" + "1. Add Recipe\n" + "2. Print Recipe\n" + "3. Adjust Recipe Servings\n"
						+ "\nPlease select a menu item:");
			}

			System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n"
					+ "3. Print All Recipe Names\n" + "\nPlease select a menu item:");
		}

		scnr.close();
	}

}

