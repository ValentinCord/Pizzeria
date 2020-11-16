package be.ac.umons;

import be.ac.umons.abstractFactory.ChoixPizza;
import be.ac.umons.abstractFactory.Dominos;
import be.ac.umons.abstractFactory.FabriqueAbstraite;
import be.ac.umons.abstractFactory.PizzaHut;
import be.ac.umons.database.DBSingleton;
import be.ac.umons.ingredients.*;
import be.ac.umons.pizzas.Carbonara;
import be.ac.umons.pizzas.FruttiDiMare;
import be.ac.umons.pizzas.Margherita;
import be.ac.umons.pizzas.Proscuitto;
import be.ac.umons.util.AnsiColor;
import be.ac.umons.util.ColorPrint;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.chrono.MinguoEra;
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
        int stock;
        //Technicien obs = new Technicien();

        BigDecimal prixPizza = BigDecimal.ZERO;
        Map<String, Ingredient> ingredients = new HashMap<>();

        try {

            DBSingleton db = DBSingleton.getSingleton("jdbc:mysql://localhost:8889/tp6_db_java", "root", "root");

            ResultSet rs = db.querySelect("SELECT * FROM ingredients");
            // Lecture ligne par ligne de la DB
            while (rs.next()) {
                Ingredient ingredient = new Ingredient();
                ingredient.setName(rs.getString("name"));
                ingredient.setPrice(rs.getBigDecimal("price"));
                ingredient.setStock(rs.getInt("stock"));
                ingredients.put(ingredient.getName(), ingredient);

                //ingredient.register(obs);
                //obs.setSubject(ingredient);

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

        ingredients.forEach((k, v) -> System.out.println(k + " : " + v.getPrice() + " €, " + v.getStock() + " disponible(s) "));

        // Regard si l'on sait calculer le prix d'une pizza
        Margherita margherita = new Margherita(ingredients);

        FruttiDiMare fruitdemer = new FruttiDiMare(ingredients);

        Proscuitto proscuitto = new Proscuitto(ingredients);


        // regarde s'il ajoute bien les olives pour les pizzahuts
        ChoixPizza myfoodd;
        FabriqueAbstraite fd = new Dominos();
        myfoodd  = fd.createPizza();
        FruttiDiMare mypizzad = new FruttiDiMare(ingredients);
        System.out.println(myfoodd.type(mypizzad, ingredients));

        ChoixPizza myfoodh;
        FabriqueAbstraite fh = new PizzaHut();
        myfoodh = fh.createPizza();
        Carbonara mypizzah = new Carbonara(ingredients);
        System.out.println(myfoodh.type(mypizzah, ingredients));


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

