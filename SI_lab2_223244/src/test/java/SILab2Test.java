import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class SILab2Test {

    // Помошна метода за создавање листа од предмети
    private List<Item> createItems(Item... items) {
        return Arrays.asList(items);
    }


    // Тестови за Every Statement критериум
    @Test
    void everyStatementTest() {
        // 1. Test allItems == null throws exception
        RuntimeException ex1 = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(null, "1234567890123456");
        });
        assertEquals("allItems list can't be null!", ex1.getMessage());

        // 2. Test item with null name throws exception
        List<Item> itemsWithNullName = Arrays.asList(new Item(null, 1, 100, 0));
        RuntimeException ex2 = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(itemsWithNullName, "1234567890123456");
        });
        assertEquals("Invalid item!", ex2.getMessage());

        // 3. Test item with discount calculates sum correctly (with -30 discount from code)
        List<Item> itemsWithDiscount = Arrays.asList(new Item("Milk", 2, 100, 0.1));
        double sumWithDiscount = SILab2.checkCart(itemsWithDiscount, "1234567890123456");
        assertEquals(150.0, sumWithDiscount, 0.0001);  // променето од 180.0 во 150.0

        // 4. Test item without discount calculates sum correctly
        List<Item> itemsWithoutDiscount = Arrays.asList(new Item("Bread", 1, 50, 0));
        double sumWithoutDiscount = SILab2.checkCart(itemsWithoutDiscount, "1234567890123456");
        assertEquals(50.0, sumWithoutDiscount, 0.0001);

        // 5. Test price > 300 with invalid card number throws exception
        List<Item> expensiveItems = Arrays.asList(new Item("Laptop", 1, 500, 0));
        RuntimeException ex3 = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(expensiveItems, "abcd567890123456");
        });
        assertEquals("Invalid character in card number!", ex3.getMessage());
    }

    // Тестови за Multiple Condition критериум
    @Test
    void multipleConditionTest() {
        // Тест 1: price <= 300, discount <= 0, quantity <= 10 -> sum НЕ се одзема 30
        double sum1 = SILab2.checkCart(createItems(new Item("Item1", 5, 100, 0)), "1234567890123456");
        assertEquals(100 * 5, sum1);

        // Тест 2: quantity > 10
        double sum2 = SILab2.checkCart(createItems(new Item("Item2", 11, 100, 0)), "1234567890123456");
        assertEquals(100 * 11 - 30, sum2);

        // Тест 3: discount > 0
        double sum3 = SILab2.checkCart(createItems(new Item("Item3", 5, 100, 0.1)), "1234567890123456");
        assertEquals(100 * 5 * 0.9 - 30, sum3);

        // Тест 4: discount > 0 и quantity > 10
        double sum4 = SILab2.checkCart(createItems(new Item("Item4", 11, 100, 0.1)), "1234567890123456");
        assertEquals(100 * 11 * 0.9 - 30, sum4);

        // Тест 5: price > 300
        double sum5 = SILab2.checkCart(createItems(new Item("Item5", 5, 400, 0)), "1234567890123456");
        assertEquals(400 * 5 - 30, sum5);

        // Тест 6: price > 300 и quantity > 10
        double sum6 = SILab2.checkCart(createItems(new Item("Item6", 11, 400, 0)), "1234567890123456");
        assertEquals(400 * 11 - 30, sum6);

        // Тест 7: price > 300 и discount > 0
        double sum7 = SILab2.checkCart(createItems(new Item("Item7", 5, 400, 0.1)), "1234567890123456");
        assertEquals(400 * 5 * 0.9 - 30, sum7);

        // Тест 8: price > 300 и discount > 0 и quantity > 10
        double sum8 = SILab2.checkCart(createItems(new Item("Item8", 11, 400, 0.1)), "1234567890123456");
        assertEquals(400 * 11 * 0.9 - 30, sum8);
    }
}
