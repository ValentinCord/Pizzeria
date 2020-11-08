package be.ac.umons;

import be.ac.umons.database.DBSingleton;
import be.ac.umons.ingredients.*;
import be.ac.umons.util.AnsiColor;
import be.ac.umons.util.ColorPrint;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * The main class of the project.
 *
 */
public class App
{

    public static void main( String[] args )
    {
        String name ;
        BigDecimal price;
        Map<String, Ingredient> ingredients = new HashMap<>();

        try {

            DBSingleton db = DBSingleton.getSingleton("jdbc:mysql://localhost:3306/tp6_db_java", "root", "");

            ResultSet rs = db.querySelect("SELECT * FROM ingredients");
            // Lecture ligne par ligne de la DB
            while (rs.next()){

                if (rs.getString("name").compareTo("Cheese") == 0){
                    Ingredient cheese = new Cheese(rs.getString("name"), rs.getBigDecimal("price"));
                    ingredients.put(cheese.getName(), cheese);
                }
                else if (rs.getString("name").compareTo("Dough") == 0){
                    Ingredient dough = new Dough(rs.getString("name"), rs.getBigDecimal("price"));
                    ingredients.put(dough.getName(), dough);
                }
                else if (rs.getString("name").compareTo("Ham") == 0){
                    Ingredient ham = new Ham(rs.getString("name"), rs.getBigDecimal("price"));
                    ingredients.put(ham.getName(), ham);
                }
                else if (rs.getString("name").compareTo("Mushroom") == 0){
                    Ingredient mushroom = new Mushroom(rs.getString("name"), rs.getBigDecimal("price"));
                    ingredients.put(mushroom.getName(), mushroom);
                }
                else if (rs.getString("name").compareTo("Olive") == 0){
                    Ingredient olive = new Olive(rs.getString("name"), rs.getBigDecimal("price"));
                    ingredients.put(olive.getName(), olive);
                }
                else if (rs.getString("name").compareTo("Sea food") == 0){
                    Ingredient seafood = new Seafood(rs.getString("name"), rs.getBigDecimal("price"));
                    ingredients.put(seafood.getName(), seafood);
                }
                else if (rs.getString("name").compareTo("Tomato Sauce") == 0){
                    Ingredient tomatoSauce = new TomatoSauce(rs.getString("name"), rs.getBigDecimal("price"));
                    ingredients.put(tomatoSauce.getName(), tomatoSauce);
                }
                else if (rs.getString("name").compareTo("White Cream") == 0){
                    Ingredient whiteCream = new WhiteCream(rs.getString("name"), rs.getBigDecimal("price"));
                    ingredients.put(whiteCream.getName(), whiteCream);
                }

            }
            rs.close();

            //updateQueryDemo();

        } catch (SQLException e) {
            ColorPrint.printError("SQL ERROR : " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.print(AnsiColor.RED);
            e.printStackTrace();
            System.out.print(AnsiColor.RESET);
        }

        ingredients.forEach((k, v) -> System.out.println(k + " : " + v.getPrice() + " €"));

        /* meme chose que le for each audessus
        for (Map.Entry<String, Ingredient> ingredientEntry : ingredients.entrySet()) {
            System.out.println(ingredientEntry.getValue().getName() + " : " + ingredientEntry.getValue().getPrice() + " €.");
        }*/



    }

    /**
     * Insert, update, delete example.
     */
    private static void updateQueryDemo() {
        try {
            //DBSingleton db = DBSingleton.getSingleton(url, username, password);
            DBSingleton db = DBSingleton.getSingleton();

            Object[] arguments = new Object[2];
            arguments[0] = formatDotDecimal(new BigDecimal(10.2));
            arguments[1] = "N/A";

            int result = db.queryUpdate("INSERT INTO ingredients(name, price) VALUES ('N/A', '0.0')");
            ColorPrint.printDebug("inserting N/A into ingredients, return value : " + result);

            result = db.queryUpdate("UPDATE ingredients SET price = %s WHERE name = '%s'", arguments);
            ColorPrint.printDebug("updating ingredients return value : " + result);

            ResultSet rs = db.querySelect("SELECT * FROM ingredients");

            while (rs.next()) {
                System.out.println(rs.getString("name") + " : " + rs.getBigDecimal("price"));
            }
            rs.close();

            result = db.queryUpdate("DELETE FROM ingredients WHERE name = '%s'", arguments[1]);
            ColorPrint.printDebug("delete dough from ingredients : " + result);

        } catch (SQLException e) {
            ColorPrint.printError("SQL Error : " + e.getMessage());
        } catch (NullPointerException e) {
            ColorPrint.printError(e.getMessage());
        }
    }

    /**
     * Get a money value as a string with a dot separator for decimals
     * @param money the value to format
     * @return a string representation of a money value
     */
    public static String formatDotDecimal(BigDecimal money) {
        DecimalFormatSymbols decimalSymbol = DecimalFormatSymbols.getInstance();
        decimalSymbol.setDecimalSeparator('.');
        return new DecimalFormat("0.00", decimalSymbol).format(money);
    }

}

