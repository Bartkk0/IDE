import java.util.*;

public class Localisation {
    public static ResourceBundle resources;

    public static Vector<Language> languageModel = new Vector<Language>(){
        {
            addElement(new Language("pl_PL", "Polski"));
            addElement(new Language("de_DE", "Niemiecki"));
            addElement(new Language("es_ES", "Hiszpański"));
            addElement(new Language("en_US", "Angielski"));
            addElement(new Language("fr_FR", "Francuski"));
            addElement(new Language("uk_UK", "Ukraiński"));
        }
    };

    private static HashMap<String, Locale> localeMapping = new HashMap<String, Locale>(){
        {
            put("pl_PL", new Locale("pl", "PL"));
            put("de_DE", new Locale("de", "DE"));
            put("es_ES", new Locale("es", "ES"));
            put("en_US", new Locale("en", "US"));
            put("fr_FR", new Locale("fr", "FR"));
            put("uk_UK", new Locale("uk", "UK"));
        }
    };

    public static Locale GetLocale(String code){
        return localeMapping.get(code);
    }

    public static void SetLanguage(Locale locale){
        resources = ResourceBundle.getBundle("res.Bundle", locale);
    }

    public static String GetString(String name){
        if(resources == null)
            SetLanguage(GetLocale("en_US"));
        try {
            return resources.getString(name);
        }catch (MissingResourceException e){
            return name;
        }
    }
}
