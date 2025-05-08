package cz.mg.c.core;

import cz.mg.annotations.classes.Test;
import cz.mg.test.Assert;

public @Test class CLibraryTest {
    public static void main(String[] args) {
        System.out.print("Running " + CLibraryTest.class.getSimpleName() + " ... ");

        CLibraryTest test = new CLibraryTest();
        test.testLoad();

        System.out.println("OK");
    }

    private void testLoad() {
        Assert.assertThatCode(() -> {
            CLibrary.load(Configuration.LIBRARY_PATH);
        }).doesNotThrowAnyException();
    }
}
