package com.friedchicken.account.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "Home page",
        description = "Welcome page for getting the quick entrance"
)
@RestController
public class HomeController {

    @GetMapping(path = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String root() {
        return """
            <!DOCTYPE html>
            <html><head><meta charset="UTF-8"><title>BankMate Account API</title></head>
            <body>
            <h1>BankMate Account API</h1>
            <ul>
            <li><a href="/swagger-ui.html">Swagger API</a></li>
            <li><a href="/h2-console">H2</a></li>
            </ul>
            </body></html>
            """;
    }
}
