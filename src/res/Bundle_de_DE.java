package res;	// zgodnie z nazwą katalogu, gdzie jest klasa
import java.util.ListResourceBundle;
public class Bundle_de_DE extends ListResourceBundle {

    //@Overwrites
    protected Object[][] getContents(){
        return new Object[][]{
                {"APP_NAME", "IDE-Prototyp"},
                {"DBG_SIZE", "Size"},
                {"DBG_POS", "Position"},
                // MENÜ główne
                {"MENU_FILE", "File"},
                {"MENU_FILE_NEW", "Neu"},
                {"MENU_FILE_OPEN", "Open"},
                {"MENU_FILE_CONF", "Einstellungen"},
                {"MENU_FILE_QUIT", "Quit"},
                // TOOLBAR - pasek narzędziowy
                {"TBAR_FILE_OPEN", "Open"},
                {"TBAR_FILE_SAVE", "Speichern"},
                {"TBAR_COPY", "Copy"},
                {"TBAR_PASTE", "Einfügen"},
                // EINSTELLUNGEN - ustawienia
                {"CONF_WIN_TTL", "Einstellungen"},
                {"CONF_LBL_AVL_SETT", "Verfügbare Einstellungen"},
                {"CONF_BTN_REJECT", "Ablehnen"},
                {"CONF_BTN_STORE", "Speichern"},
                {"CONF_FSET_WIN", "Fenster"},
                {"CONF_SET_WIN_CENTER", "Start zentriert"},
                {"CONF_SET_WIN_MAX", "Start maximiert"},
                {"CONF_SET_KEEP_POS", "Position speichern"},
                {"CONF_SET_KEEP_SIZE", "Größe merken"},
                {"CONF_FSET_IDE", "IDE"},
                {"CONF_SET_LANG", "Schnittstellensprache"},
                {"CONF_SET_KEEP_DIR", "zapamiętaj katalog przeglądania"},
                {"CONF_SET_KEEP_OPEN_FILES", "zapamiętaj otwarte pliki"},
                {"CONF_FSET_GUI", "GUI"},
                {"CONF_SET_HIDE_MENU", "Hauptmenü ausblenden"},
                {"CONF_SET_UNDOCK_TBAR", "odpięty pasek narzędziowy"},
                {"CONF_SET_LOCK_TBAR", "zablokuj pasek narzędziowy"},
                {"CONF_SET_DARK_MODE", "Dunkler Modus"},
        };
    }
}

