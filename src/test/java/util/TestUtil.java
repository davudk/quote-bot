package util;

import dk.njit.cs684.quote.model.queries.QueryBase;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.function.Consumer;

public class TestUtil {

    public static <T extends QueryBase> void performTest(String filename,
                                                   Consumer<String[]> consumer) throws IOException {
        for (String line : getLines(filename)) {
            System.out.println(line);

            line = line.trim();
            if (line.length() == 0) continue;

            final String[] parts = getParts(line);
            consumer.accept(parts);
            System.out.flush();
            System.err.flush();
        }
        System.out.println("SUCCESS");
    }

    private static String[] getLines(String filename) throws IOException {
        final InputStream stream = TestUtil.class.getClassLoader().getResourceAsStream(filename);
        Assert.assertNotNull(stream);

        final String text = IOUtils.toString(stream, Charset.defaultCharset());
        return text.split("\r?\n");
    }

    private static String[] getParts(String line) {
        return Arrays.stream(line.split("~"))
                .map(String::trim)
                .filter(p -> p.length() > 0)
                .toArray(String[]::new);
    }
}
