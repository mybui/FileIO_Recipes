
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.nio.file.Paths;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();
        ArrayList<Recipe> food = new ArrayList<>();
        String name = "";
        String time = "";
        
        System.out.println("File to read:");
        String file = scanner.nextLine();
        
        try {
            Scanner myReader = new Scanner(new File(file));
        
            //while (myReader.hasNextLine()) {
            while (true) {
                name = myReader.nextLine();
                time = myReader.nextLine();
                
                while (true) {
                    String line = myReader.nextLine();
                    if (line.equals("")) {
                        Recipe item = new Recipe(name, Integer.valueOf(time), list);
                        food.add(item);
                        System.out.println(item.getIngredient());
                        list = new ArrayList<>();
                        break;
                    }
                    list.add(line);
                }
                
                if (!(myReader.hasNextLine())) {
                    break;
                }
            } 
        } catch (Exception e) {
            food.add(new Recipe(name, Integer.valueOf(time), list));
        }
        
        System.out.println("Commands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        
        while (true) {
            System.out.println("Enter command:");
            String command = scanner.nextLine();
            
            if (command.equals("stop")) {
                break;
            }
        
            if (command.equals("list")) {
                System.out.println("Recipes:");
                for (Recipe i: food) {
                    System.out.println(i);
                    System.out.println(i.getIngredient());
                }
            }
            
            if (command.equals("find name")) {
                System.out.println("Searched word:");
                String word = scanner.nextLine();
                for (Recipe i: food) {
                    if (i.getName().contains(word)) {
                        System.out.println(i);
                    }
                }
            }
            
            if (command.equals("find cooking time")) {
                System.out.println("Max cooking time:");
                int max = Integer.valueOf(scanner.nextLine());
                for (Recipe i: food) {
                    if (i.getTime() <= max) {
                        System.out.println(i);
                    }
                }
            }
            
            if (command.equals("find ingredient")) {
                System.out.println("Ingredient:");
                String ingredient = scanner.nextLine();
                for (Recipe i: food) {
                    System.out.println(i.getIngredient());
                    if (i.getIngredient().contains(ingredient)) {
                        System.out.println(i);
                    }
                }
            }
        }
    }
}
