package cz.mg.c.core.entities;

import cz.mg.test.Assert;

import static cz.mg.c.core.entities.CPointer.NULL;

public class CObjectTest {
    public static void main(String[] args) {
        System.out.print("Running " + CObjectTest.class.getSimpleName() + " ... ");

        CObjectTest test = new CObjectTest();
        test.testNull();
        test.testNonnull();

        System.out.println("OK");
    }

    private void testNull() {
        Assert.assertThatCode(() -> new CObject(NULL))
            .throwsException(NullPointerException.class);
    }

    private void testNonnull() {
        CObject object = new CObject(7L);
        Assert.assertEquals(7L, object.address());
    }
}
