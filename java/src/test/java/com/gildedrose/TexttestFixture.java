package com.gildedrose;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

import com.csvreader.CsvReader;

/**
 * This test fixture allows you to test the method 'updateQuality' in the GildedRose class
 * using TextTest (see http://texttest.org)
 *
 * It expects to find a csv file in the current working directory called 'items.csv'. It parses this file
 * to populate a list of items. It then calls 'updateQuality' on the list and prints the result.
 *
 * You may also pass a command line argument, which should be an integer indicating how many times to call
 * 'updateQuality' if you want it to do it more than once, to simulate several days worth of updates.
 */
public class TexttestFixture {
    public static void main(String[] args) throws Exception {
        System.out.println("OMGHAI!");
        List<Item> items = new ArrayList<>();

        Path csvFile = Paths.get("items.csv");
        if (Files.exists(csvFile)) {
            CsvReader itemsCsv = new CsvReader("items.csv");
            itemsCsv.readHeaders();
            while (itemsCsv.readRecord()) {
                String name = itemsCsv.get("Name");
                int sellIn = Integer.parseInt(itemsCsv.get("sellIn"));
                int quality = Integer.parseInt(itemsCsv.get("quality"));
                items.add(new Item(name, sellIn, quality));
            }
        }
        Item[] itemsArr = new Item[items.size()];
        GildedRose app = new GildedRose(items.toArray(itemsArr));

        int days = 1;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}