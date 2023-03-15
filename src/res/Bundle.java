package res;

import java.util.ListResourceBundle;
import java.util.ResourceBundle;

public class Bundle extends ListResourceBundle {
    protected Object[][] getContents(){
        return new Object[][]{
                {"appName", "Prototyp IDE"},
                {"dbgSize", "Rozmiar"},
                {"dbgPos", "Pozycja"},
                // MENU główne
                {"MENU_FILE", "Plik"},
                {"MENU_FILE_NEW", "Nowy"},
                {"MENU_FILE_OPEN", "Otwórz"},
                {"MENU_FILE_CONF", "Preferencje"},
                {"MENU_FILE_QUIT", "Wyjście"},
                // TOOLBAR - pasek narzędziowy
                {"TBAR_FILE_OPEN", "Otwórz"},
                {"TBAR_FILE_SAVE", "Zapisz"},
                {"TBAR_COPY", "Kopiuj"},
                {"TBAR_PASTE", "Wklej"},
                // SETTINGS - ustawienia
                {"CONF_WIN_TTL", "Ustawienia"},
                    {"CONF_LBL_AVL_SETT", "Dostępne ustawienia"},
                    {"CONF_BTN_REJECT", "Odrzuć"},
                    {"CONF_BTN_STORE", "Zachowaj"},
                    {"CONF_FSET_WIN", "Okno"},
                        {"CONF_SET_WIN_CENTER","uruchom wyśrodkowane"},
                        {"CONF_SET_WIN_MAX","uruchom zmaksymalizowane"},
                        {"CONF_SET_KEEP_POS","zapamiętaj pozycję"},
                        {"CONF_SET_KEEP_SIZE","zapamiętaj rozmiar"},
                    {"CONF_FSET_IDE", "IDE"},
                        {"CONF_SET_LANG","język interfejsu"},
                        {"CONF_SET_KEEP_DIR","zapamiętaj katalog przeglądania"},
                        {"CONF_SET_KEEP_OPEN_FILES","zapamiętaj otwarte pliki"},
                    {"CONF_FSET_GUI", "GUI"},
                        {"CONF_SET_HIDE_MENU","ukryj menu główne"},
                        {"CONF_SET_UNDOCK_TBAR","odpięty pasek narzędziowy"},
                        {"CONF_SET_LOCK_TBAR","zablokuj pasek narzędziowy"},
                        {"CONF_SET_DARK_MODE","tryb ciemny"},

                {"eot", "Ostatni"}
        };
    }
}
