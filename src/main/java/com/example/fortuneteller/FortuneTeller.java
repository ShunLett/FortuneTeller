/**
 * @author Shun Lett Pyae Oo
 * Date: 15th May 2025
 * Description: logic for the Fortune Teller App such as storing, adding, removing, and retrieving fortunes.
 */
package com.example.fortuneteller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collection;


public class FortuneTeller {
    private List<String> fortunes;
    private Random random;

    /**
     * Constructs the logic class and initializes with default fortunes.
     */
    public FortuneTeller() {
        fortunes = new ArrayList<>();
        random = new Random();

        // Default fortunes
        fortunes.add("You will have a great day!");
        fortunes.add("Something wonderful is about to happen.");
        fortunes.add("A surprise awaits you around the corner.");
        fortunes.add("You will meet someone important soon.");
        fortunes.add("Hard work will pay off this week.");
        fortunes.add("Stay patient — good news is coming.");
        fortunes.add("An exciting opportunity will present itself.");
        fortunes.add("Success is closer than you think.");
        fortunes.add("You’ll make someone’s day.");
        fortunes.add("A financial reward is on its way.");
        fortunes.add("Take the chance.");
    }

    /**
     *@return a random fortune string
     */
    public String getRandomFortune() {
        if (fortunes.isEmpty()) return "No fortunes available at the moment.";
        return fortunes.get(random.nextInt(fortunes.size()));
    }

    /**
     * Returns a copy of the fortune list.
     * @return a list of fortunes
     */
    public List<String> getFortunes() {
        return new ArrayList<>(fortunes);
    }

    /**
     * Adds a new fortune to the list.
     * @param fortune the fortune string to add
     */
    public void addFortune(String fortune) {
        fortunes.add(fortune);
    }


    /**
     * Removes multiple fortunes at once.
     * @param selected the fortunes to remove
     */
    public void removeFortunes(Collection<String> selected) {
        fortunes.removeAll(selected);
    }
}
