package MensaVoter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Menu {
    private String type;
    private String title;
    private String description;
    private double [] prices = new double[3];
    private int likes = 0;
    private ArrayList<String> comments = new ArrayList<>();

    public Menu(String type, String title, String description){
        this.type = type;
        this.title = title;
        this.description = description;
    }

    public Menu(){}

    public void setPrice(double stud, double intern, double extern){
        prices[0] = stud;
        prices[1] = intern;
        prices[2] = extern;
    }

    public void printMenu(){
        System.out.println("Typ: " + type);
        System.out.println("Titel: " + title);
        System.out.println("Beschreibung: "+ description);
        System.out.println("Preise: " + prices[0] + " STUD, " + prices[1] + " INT, " + prices[2] + " EXT");
    }

    public void like(){
        likes++;
    }

    public int getLikes(){
        return likes;
    }

    public void addComment(String comment){
        comments.add(comment);
    }

    public String getComments(){
        String commentValue = "";
        for (String comment : comments){
            commentValue += "-";
            commentValue += comment;
            commentValue += "<br>";
        }
        return commentValue;
    }
    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPrices() {
        return prices[0] + " STUD, " + prices[1] + " INT, " + prices[2] + " EXT";
    }

}
