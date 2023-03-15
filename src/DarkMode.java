import java.awt.*;
import java.util.HashMap;

public class DarkMode {
    HashMap<String,Color> lst = new HashMap<>();

    DarkMode() {
        lst.put("BG_COLOR",new Color(0,0,0));
        lst.put("FG_COLOR",new Color(255,255,255));
    }

    public Color GetConstrain(String name){
        return lst.get(name);
    }
}
