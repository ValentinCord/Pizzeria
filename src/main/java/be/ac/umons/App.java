package be.ac.umons;

import be.ac.umons.database.DBSingleton;
import be.ac.umons.util.AnsiColor;
import be.ac.umons.util.ColorPrint;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
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
            while (rs.next()) {

                // A chaque nouvelle ligne, on cree un ingredient avec ses propres caract.
                Ingredient ingredient = new Ingredient();
                ingredient.setName(rs.getString("name"));
                ingredient.setPrice(rs.getBigDecimal("price"));
                // ingredient.setStock(rs.getInteger("stock"));
                ingredients.put(ingredient.getName(), ingredient);

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

        Pizza prosciutto = new Pizza("Proscuitto");
        prosciutto.addIngredient(ingredients.get("Dough"));
        prosciutto.addIngredient(ingredients.get("Tomato Sauce"));
        prosciutto.addIngredient(ingredients.get("Cheese"));
        prosciutto.addIngredient(ingredients.get("Ham"));
        // System.out.println(prosciutto.toString());

        /*
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

