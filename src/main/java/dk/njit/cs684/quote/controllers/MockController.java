package dk.njit.cs684.quote.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class MockController {
    private static final Logger logger = LoggerFactory.getLogger(MockController.class);

    @PostMapping("/user/signin")
    public boolean signin(@RequestParam("username") String username,
                          @RequestParam("password") String password) {
        if (username == null) username = "";
        if (password == null) password = "";

        return Arrays.asList(
                "davud:root",
                "grace:root",
                "chika:root"
        ).contains(username + ":" + password);
    }
}
