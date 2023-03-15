import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.prefs.Preferences;

public class Settings {
    private static final String PREFS_FILE = "appIDE.conf.xml";
    private static final String IDESETTINGS_NODE = "ide";
    private static final String APPSETTINGS_NODE = "app";
    private static final String WINSETTINGS_NODE = "win";

    static Preferences idesettings = Preferences.userRoot().node(IDESETTINGS_NODE);
    static Preferences appsettings = idesettings.node(APPSETTINGS_NODE);
    static Preferences winsettings = idesettings.node(WINSETTINGS_NODE);

    public static void storeSettings() {
        App.LOGGER.info("Saving settings");

        winsettings.putInt(WINSETTING.WINH.name(), App.getInstance().getSize().height);
        winsettings.putInt(WINSETTING.WINW.name(), App.getInstance().getSize().width);
        winsettings.putInt(WINSETTING.WINX.name(), App.getInstance().getLocation().x);
        winsettings.putInt(WINSETTING.WINY.name(), App.getInstance().getLocation().y);

        try {
            idesettings.exportSubtree(new FileOutputStream(PREFS_FILE));
            idesettings.flush();
        } catch (Exception e) {
            App.LOGGER.warning(e.getMessage());
        }
    }

    public static void loadSettings() {
        try {
            Preferences.importPreferences(new FileInputStream(PREFS_FILE));
            idesettings = Preferences.userRoot().node(IDESETTINGS_NODE);
            appsettings = idesettings.node(APPSETTINGS_NODE);
            winsettings = idesettings.node(WINSETTINGS_NODE);

            winsettings = Preferences.userRoot().node(WINSETTINGS_NODE);
        } catch (Exception e) {
            App.LOGGER.warning(e.getMessage());
        }
        App.LOGGER.info("Loading settings");
    }

    public static String getSetting(Enum<?> setting, String def){
        if(setting instanceof APPSETTING)
            return appsettings.get(setting.name(), def);
        if(setting instanceof WINSETTING)
            return winsettings.get(setting.name(), def);
        return def;
    }
    public static void setSetting(Enum<?> setting, String value){
        if(setting instanceof APPSETTING)
            appsettings.put(setting.name(), value);
        if(setting instanceof WINSETTING)
            winsettings.put(setting.name(), value);
    }

    public static boolean getSetting(Enum<?> setting, boolean def){
        return Boolean.parseBoolean(getSetting(setting, Boolean.toString(def)));
    }
    public static void setSetting(Enum<?> setting, boolean value){
        setSetting(setting, Boolean.toString(value));
    }

    public static int getSetting(Enum<?> setting, int def){
        return Integer.parseInt(getSetting(setting, Integer.toString(def)));
    }
    public static void setSetting(Enum<?> setting, int value){
        setSetting(setting, Integer.toString(value));
    }

    enum WINSETTING{
        WINX,
        WINY,
        WINW,
        WINH
    }

    enum APPSETTING {
        cbCenter,
        cbMax,
        comboLang,
        cbSavePos,
        cbSaveSize,
        cbSaveDir,
        cbSaveOpened,
        cbHideMenu,
        cbUndockToolbar,
        cbLockToolbar,
        cbDarkMode
    }
}

