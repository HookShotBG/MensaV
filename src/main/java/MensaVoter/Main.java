package MensaVoter;

import spark.Spark;

import java.util.ArrayList;
import java.util.HashMap;

import static spark.Spark.*;

public class Main {
    static TemplatingEngine te = new TemplatingEngine("/MensaVoter");

    static String getMenus(MenuManager mm) {
        ArrayList<Menu> menus = new ArrayList<>();
        for (int i = 0; i < mm.getMenuCount(); i++) {
            menus.add(mm.getMenu(i));
        }
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("menus", menus);
        return te.renderTemplate("today.ftl", data);
    }


    public static void main(String args[]) {
        MenuManager mm = new MenuManager();
        mm.loadMenus("20181120");
        mm.getMenu(0).like();
        mm.getMenu(1).like();
        mm.getMenu(1).like();
        System.out.println(mm.getMenu(0).getLikes());
        System.out.println(mm.getMenu(1).getLikes());
        mm.getMenu(0).addComment("Chicken wie Schuhsohle");
        mm.getMenu(0).addComment("Auch Trockenreis braucht Wasser!!");
        System.out.println(mm.getMenu(0).getComments());


        int hp = 4567; // Default Port
        ProcessBuilder processBuilder = new ProcessBuilder(); if (processBuilder.environment().get("PORT") != null) {
            hp = Integer.parseInt(processBuilder.environment().get("PORT")); }
        Spark.port(hp);

        get("/", (req, res) -> getMenus(mm));
        get("/menucount", (req, res) -> mm.getMenuCount());
        get("/menu/:no/likes", (req, res) -> mm.getMenu(Integer.parseInt(req.params("no"))).getLikes());
        post("/menu/:no/likes", (req, res) -> {
            mm.getMenu(Integer.parseInt(req.params("no"))).like();
            return mm.getMenu(Integer.parseInt(req.params("no"))).getLikes();
        });

        get("/menu/:no/comments", (req, res) -> mm.getMenu(Integer.parseInt(req.params("no"))).getComments());
        post("/menu/:no/comments", (req, res) -> {
            mm.getMenu(Integer.parseInt(req.params("no"))).addComment(req.queryParams("comment"));
            return mm.getMenu(Integer.parseInt(req.params("no"))).getComments();
        });

    }
}
