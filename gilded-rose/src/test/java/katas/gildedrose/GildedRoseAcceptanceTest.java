package katas.gildedrose;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GildedRoseAcceptanceTest {
	private static final String CORRECT_VALUE_MULTIPLE_VALUES = "OMGHAI!" + '\n' + "-------- day 0 --------" + '\n' + "name, sellIn, quality" + '\n'
			+ "+5 Dexterity Vest, 10, 20" + '\n' + "Aged Brie, 2, 0" + '\n' + "Elixir of the Mongoose, 5, 7" + '\n' + "Sulfuras, Hand of Ragnaros, 0, 80" + '\n'
			+ "Sulfuras, Hand of Ragnaros, -1, 80" + '\n' + "Backstage passes to a TAFKAL80ETC concert, 15, 20" + '\n'
			+ "Backstage passes to a TAFKAL80ETC concert, 10, 49" + '\n' + "Backstage passes to a TAFKAL80ETC concert, 5, 49" + '\n'
			+ "Conjured Mana Cake, 3, 6" + '\n' + "\n" + "-------- day 1 --------" + '\n' + "name, sellIn, quality" + '\n' + "+5 Dexterity Vest, 9, 19" + '\n'
			+ "Aged Brie, 1, 1" + '\n' + "Elixir of the Mongoose, 4, 6" + '\n' + "Sulfuras, Hand of Ragnaros, 0, 80" + '\n'
			+ "Sulfuras, Hand of Ragnaros, -1, 80" + '\n' + "Backstage passes to a TAFKAL80ETC concert, 14, 21" + '\n'
			+ "Backstage passes to a TAFKAL80ETC concert, 9, 50" + '\n' + "Backstage passes to a TAFKAL80ETC concert, 4, 50" + '\n' + "Conjured Mana Cake, 2, 5"
			+ '\n' + '\n';

	private final class FakePrintStream {
		private final ByteArrayOutputStream outContent;
		private final PrintStream out;

		public FakePrintStream() throws IOException {
			outContent = new ByteArrayOutputStream();
			out = new PrintStream(outContent);

		}

		public boolean equals(String valueToCompare) {
			return (outContent.toString().equals(valueToCompare));

		}

		public PrintStream getOut() {
			return out;
		}

	}

	FakePrintStream fakeOut;

	// TODO add test for FakePrintStream
	@Before
	public void setUp() throws IOException {
		fakeOut = new FakePrintStream();
	}

	@After
	public void tearDown() {
		fakeOut = null;
	}

	@Test
	public void testMultipleItemsTwoDaysFine() throws IOException {

		/* set up fake stream */
		PrintStream oldStream = System.out;
		System.setOut(fakeOut.getOut());

		// TODO add tests for difs. args
		/* set up args */
		String args[] = new String[0];

		System.out.println("OMGHAI!");
		Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20), //
				new Item("Aged Brie", 2, 0), //
				new Item("Elixir of the Mongoose", 5, 7), //
				new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
				new Item("Sulfuras, Hand of Ragnaros", -1, 80), new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49), new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				// this conjured item does not work properly yet
				new Item("Conjured Mana Cake", 3, 6) };

		GildedRose app = new GildedRose(items);

		int days = 2;
		if (args.length > 0) {
			days = Integer.parseInt(args[0]) + 1;
		}

		// TODO Add acceptance tests for this input
		for (int i = 0; i < days; i++) {
			System.out.println("-------- day " + i + " --------");
			System.out.println("name, sellIn, quality");
			for (Item item : items) {
				System.out.println(item);
			}
			System.out.println();
			app.updateQuality();
		}

		/* restore stream */
		System.setOut(oldStream);
		// check values
		Assert.assertTrue(fakeOut.equals(CORRECT_VALUE_MULTIPLE_VALUES));

	}

}
