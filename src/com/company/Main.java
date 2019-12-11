package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String groceryItem;
        int groceryPrice;
        HashMap<String, Integer> groceryList = new HashMap<String, Integer>();

        System.out.println("Gratulerer med plass på Academy! Nå er det tid for å feire :)");
        System.out.println("Hva trenger du til fruktsalaten?");
        System.out.println("(Skriv 'stop' når du er ferdig for å få en oversikt over handlelisten.)");

        // Continue to ask for new items until exited
        while(true){

            // New grocery item from user input
            groceryItem = scanner.nextLine();

            // Exit the loop if 'stop' or 'nei' is called
            if(groceryItem.toLowerCase().equals("stop")){
                break;
            }

            System.out.println("Hva koster " + groceryItem + "?");

            // Throw an error message and continue the loop if groceryPrice is not an int
            try{
                groceryPrice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Ops.. Det var ikke en gyldig pris. Legg til varen på nytt: ");
                continue;
            }

            // Adding item to groceryList
            groceryList.put(groceryItem, groceryPrice);

            // Prompt for a new grocery item
            System.out.println("Hva mer trenger du?");
        }

        // If groceryList is empty when 'stop' or 'nei' is called
        if(groceryList.size() == 0){
            System.out.println("Handlelisten er tom. Dette blir en kjedelig feiring..");

        } else {
            String maxGrocery = "";
            int maxPrice = 0;
            String minGrocery = "";
            int minPrice = 0;
            int grocerySum = 0;

            System.out.println("\nHer er en liste over alle varene du trenger til fruktsalaten: ");

            // Loop over each grocery item to find max and min values
            for(String grocery : groceryList.keySet()){
                int currentPrice = groceryList.get(grocery);
                grocerySum += currentPrice;

                System.out.println(" - " + grocery + ": " + currentPrice + ",-");

                if(maxPrice == 0 || currentPrice > maxPrice){
                    maxPrice = currentPrice;
                    maxGrocery = grocery;
                }

                if(minPrice == 0 || currentPrice < minPrice){
                    minPrice = currentPrice;
                    minGrocery = grocery;
                }
            }

            // Print summary
            System.out.println("\nTotalt koster fruktsalaten " + grocerySum + ",- kr.");
            System.out.println("Den dyreste varen er '" + maxGrocery + "' som koster " + maxPrice + ",- kr.");
            System.out.println("Den billigste varen er '" + minGrocery + "' som koster " + minPrice + ",- kr.");
        }
    }
}
