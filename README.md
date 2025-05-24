# SI_2025_lab2_223244
Александра Трпчевска 223244

2.  Control Flow Graph
   ![CFG](https://github.com/user-attachments/assets/88fedc84-9e9e-43ff-9f44-3e8d2e38c38f)

3.  Цикломатската комплексност
Цикломатската комплексност е 9. се пресметува на два начини:
   - бр.на ребра-бр.на јазли+2=34-27+2=9
   -се бројат регионите во графикот=9

4. минимално терба да се поминат 5 теста. обработени се во табелата според Every Statement критериумот.
прв: се прака празна низа односно вредноста на итемс има вредност нулл и тука доага до фрланје на првиот исклучок.
се поминуваат само 1,2 и 23

    @Test
    void testAllItemsNull() {
        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(null, "1234567890123456");
        });
        assertEquals("allItems list can't be null!", ex.getMessage());
    }
   втор:Создаваме листа со еден Item кој има null за name.
се поминуваат редовите: 1,3,4.1,4.2,5,6,7
@Test
    void testItemWithNullName() {
        List<Item> items = List.of(new Item(null, 1, 100, 0));
        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(items, "1234567890123456");
        });
        assertEquals("Invalid item!", ex.getMessage());
    }
трет:Item со discount > 0, price <= 300, quantity <= 10, валидна картичка
Овој тест покрива гранка кога discount > 0 (линија 10-11), и не се активира sum -= 30 (линија 9) затоа што условите не се исполнети.
  @Test
    void testItemWithDiscount() {
        List<Item> items = List.of(new Item("Milk", 2, 100, 0.1));
        double sum = SILab2.checkCart(items, "1234567890123456");
        // Expected sum: 2 * 100 * (1 - 0.1) = 180.0
        assertEquals(180.0, sum, 0.0001);
    }
четврти: Item со discount == 0, price <= 300, quantity <= 10


    @Test
    void testItemWithoutDiscount() {
        List<Item> items = List.of(new Item("Bread", 1, 50, 0));
        double sum = SILab2.checkCart(items, "1234567890123456");
        // Expected sum: 1 * 50 = 50.0
        assertEquals(50.0, sum, 0.0001);
    }
петти:Item со price > 300 (активација на sum -= 30), и невалидна картичка 
    @Test
    void testItemPriceAbove300AndInvalidCard() {
        List<Item> items = List.of(new Item("Laptop", 1, 500, 0));
        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(items, "abcd567890123456");
        });
        // sum -= 30 would happen before exception, but exception stops execution
        assertEquals("Invalid card number!", ex.getMessage());
    }


 ![image](https://github.com/user-attachments/assets/22a2d49a-3871-44f6-9edd-2f1f2d949b37)

