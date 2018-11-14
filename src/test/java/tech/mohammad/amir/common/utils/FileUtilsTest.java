package tech.mohammad.amir.common.utils;

import org.junit.Assert;
import org.junit.Test;
import tech.mohammad.amir.common.exceptions.ReaderException;

import java.util.List;

import static tech.mohammad.amir.common.Constants.PRODUCT_CSV_FILE;
import static tech.mohammad.amir.common.utils.TestData.INVALID_CSV_FILE;

public class FileUtilsTest {
    @Test
    public void testReadFileValid() throws Exception {
        List<String> strings = FileUtils.readFileText(PRODUCT_CSV_FILE);
        Assert.assertNotNull(strings);
        Assert.assertEquals(3, strings.size());
    }

    @Test(expected = ReaderException.class)
    public void testReadFileInvalid() throws Exception {
        FileUtils.readFileText(INVALID_CSV_FILE);
    }
}
