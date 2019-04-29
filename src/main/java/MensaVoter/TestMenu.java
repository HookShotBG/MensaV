package MensaVoter;

import com.google.gson.Gson;

import com.google.gson.GsonBuilder;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class TestMenu {
    public static void main(String[] args) {
        Menu [] menus;
        try {
            Gson gson = new GsonBuilder().create();
            // JSON-Datei in die Variable menu einlesen
            FileInputStream fis = new FileInputStream("20181120.json"); Reader reader = new InputStreamReader(fis, "UTF8");
            menus = gson.fromJson(reader, Menu[].class); reader.close();
            for(Menu m: menus){
                m.printMenu();
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }
}
