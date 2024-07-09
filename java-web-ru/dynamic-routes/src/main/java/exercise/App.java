package exercise;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;

import javax.swing.plaf.LabelUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN

// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}", ctx -> {
            var id = ctx.pathParam("id");
            Map<String, String> result = new HashMap<>();
                for (var company : COMPANIES) {
                    if (company.containsValue(id)) {
                        result.put("name", company.get("name"));
                        result.put("phone", company.get("phone"));
                        result.put("id", company.get("id"));
                    }
                }
                if (result.isEmpty()) {
                    ctx.status(404);
                    ctx.contentType("text/plain");
                    ctx.result("error");
                }

            ctx.json(result);
                });

        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
