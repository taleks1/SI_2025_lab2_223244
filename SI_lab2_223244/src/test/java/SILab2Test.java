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
        // Тест 1: allItems == null -> RuntimeException
        Exception ex1 = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(null, "1234567890123456");
        });
        assertEquals("allItems list can't be null!", ex1.getMessage());

        // Тест 2: Item без име (null) -> RuntimeException
        Exception ex2 = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(createItems(new Item(null, 1, 100, 0)), "1234567890123456");
        });
        assertEquals("Invalid item!", ex2.getMessage());


        // Тест 4: discount == 0, price <= 300, quantity <= 10
        double sum4 = SILab2.checkCart(createItems(new Item("Bread", 1, 50, 0)), "1234567890123456");
        assertEquals(50 * 1, sum4);

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
