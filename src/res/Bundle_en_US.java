package res;

import java.util.ListResourceBundle;

public class Bundle_en_US extends ListResourceBundle {
    protected Object[][] getContents(){
        return new Object[][]{
                {"APP_NAME", "IDE prototype"},
                {"DBG_SIZE", "Size"},
                {"DBG_POS", "Position"},
                // MENU główne
                {"MENU_FILE", "File"},
                {"MENU_FILE_NEW", "New"},
                {"MENU_FILE_OPEN", "Open"},
                {"MENU_FILE_CONF", "Preferences"},
                {"MENU_FILE_QUIT", "Quit"},
                // TOOLBAR - pasek narzędziowy
                {"TBAR_FILE_OPEN", "Open"},
                {"TBAR_FILE_SAVE", "Save"},
                {"TBAR_COPY", "Copy"},
                {"TBAR_PASTE", "Paste"},
                // SETTINGS - ustawienia
                {"CONF_WIN_TTL", "Settings"},
                    {"CONF_LBL_AVL_SETT", "Avaible settings"},
                    {"CONF_BTN_REJECT", "Reject"},
                    {"CONF_BTN_STORE", "Save"},
                    {"CONF_FSET_WIN", "Window"},
                        {"CONF_SET_WIN_CENTER","Start centered"},
                        {"CONF_SET_WIN_MAX","Start maximized"},
                        {"CONF_SET_KEEP_POS","Remember position"},
                        {"CONF_SET_KEEP_SIZE","Remember size"},
                    {"CONF_FSET_IDE", "IDE"},
                        {"CONF_SET_LANG","Interface language"},
                        {"CONF_SET_KEEP_DIR","zapamiętaj katalog przeglądania"},
                        {"CONF_SET_KEEP_OPEN_FILES","zapamiętaj otwarte pliki"},
                    {"CONF_FSET_GUI", "GUI"},
                        {"CONF_SET_HIDE_MENU","Hide main menu"},
                        {"CONF_SET_UNDOCK_TBAR","odpięty pasek narzędziowy"},
                        {"CONF_SET_LOCK_TBAR","zablokuj pasek narzędziowy"},
                        {"CONF_SET_DARK_MODE","Dark mode"},

                {"eot", "Ostatni"}
        };
    }
}
