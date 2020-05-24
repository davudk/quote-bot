package util;

import dk.njit.cs684.quote.Application;
import grammar.misc.TestDateConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class, TestDateConfiguration.class})
@ActiveProfiles(profiles = "local")
public abstract class TestBase {

}
