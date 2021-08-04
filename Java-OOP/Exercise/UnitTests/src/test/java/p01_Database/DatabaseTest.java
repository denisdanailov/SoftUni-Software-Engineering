package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;
    private static final Integer[] NUMBERS = {5,8,20,67,43};

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void shouldCreateValidObject() {

        Integer[] databaseElements = database.getElements();
        Assert.assertEquals("Count of elements is incorrect.", databaseElements.length, NUMBERS.length);

        for (int i = 0; i < databaseElements.length ; i++) {
            Assert.assertEquals("Arrays are not the same!" ,NUMBERS[i], databaseElements[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenUseMoreThanSixteenElements() throws OperationNotSupportedException {
        Integer [] numbers = new Integer[17];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenUseLessThanOneElement() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddShouldThrowWhenParamNull() throws OperationNotSupportedException {
        database.add(null);

    }


    @Test
    public void testAddShouldElement() throws OperationNotSupportedException {
        database.add(7);

        Assert.assertEquals(database.getElements().length, 6);
        Assert.assertEquals(database.getElements()[database.getElements().length - 1], Integer.valueOf(7));

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowWIthEmptyDate() throws OperationNotSupportedException {

        for (int i = 0; i < NUMBERS.length ; i++) {
            database.remove();
        }

        database.remove();
    }

    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {

        database.remove();

        Integer[] elementInDatabase = database.getElements();
        Assert.assertEquals(elementInDatabase.length, NUMBERS.length - 1 );
        Assert.assertEquals(elementInDatabase[elementInDatabase.length - 1], Integer.valueOf(67));
    }
}
