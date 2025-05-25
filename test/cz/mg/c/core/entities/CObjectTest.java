package cz.mg.c.core.entities;

import cz.mg.test.Assert;

import static cz.mg.c.core.entities.CPointer.NULL;

public class CObjectTest {
    public static void main(String[] args) {
        System.out.print("Running " + CObjectTest.class.getSimpleName() + " ... ");

        CObjectTest test = new CObjectTest();
        test.testSize();
        test.testConstructor();
        test.testMetadata();
        test.testNull();
        test.testNonnull();

        System.out.println("OK");
    }

    private void testSize() {
        Assert.assertEquals(1L, CObject.SIZE);
    }

    private void testConstructor() {
        Assert.assertEquals(123L, CObject.CONSTRUCTOR.create(123L).address());
    }

    private void testMetadata() {
        Assert.assertEquals(1L, CObject.METADATA.size());
        Assert.assertEquals(123L, CObject.METADATA.constructor().create(123L).address());
    }

    private void testNull() {
        Assert.assertThatCode(() -> new CObject(NULL))
            .throwsException(NullPointerException.class);
    }

    private void testNonnull() {
        Assert.assertEquals(7L, new CObject(7L).address());
    }
}
