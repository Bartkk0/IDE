package res;

import java.util.ListResourceBundle;

public class Bundle_fr_FR extends ListResourceBundle {
    protected Object[][] getContents(){
        return new Object[][]{
                {"APP_NAME", "prototype IDE"},
                {"DBG_SIZE", "Taille"},
                {"DBG_POS", "Position"},
                // MENU główne
                {"MENU_FILE", "Fichier"},
                {"MENU_FILE_NEW", "Nouveau"},
                {"MENU_FILE_OPEN", "Ouvrir"},
                {"MENU_FILE_CONF", "Préférences"},
                {"MENU_FILE_QUIT", "Quitter"},
                // BARRE D'OUTILS - pasek narzędziowy
                {"TBAR_FILE_OPEN", "Ouvrir"},
                {"TBAR_FILE_SAVE", "Enregistrer"},
                {"TBAR_COPY", "Copier"},
                {"TBAR_PASTE", "Coller"},
                // PARAMÈTRES - ustawienia
                {"CONF_WIN_TTL", "Paramètres"},
                {"CONF_LBL_AVL_SETT", "Paramètres disponibles"},
                {"CONF_BTN_REJECT", "Rejeter"},
                {"CONF_BTN_STORE", "Enregistrer"},
                {"CONF_FSET_WIN", "Fenêtre"},
                {"CONF_SET_WIN_CENTER", "Démarrer centré"},
                {"CONF_SET_WIN_MAX", "Démarrer maximisé"},
                {"CONF_SET_KEEP_POS", "Mémoriser la position"},
                {"CONF_SET_KEEP_SIZE", "Mémoriser la taille"},
                {"CONF_FSET_IDE", "IDE"},
                {"CONF_SET_LANG", "Langue de l'interface"},
                {"CONF_SET_KEEP_DIR", "zapamiętaj katalog przeglądania"},
                {"CONF_SET_KEEP_OPEN_FILES", "zapamiętaj otwarte pliki"},
                {"CONF_FSET_GUI", "GUI"},
                {"CONF_SET_HIDE_MENU", "Masquer le menu principal"},
                {"CONF_SET_UNDOCK_TBAR", "odpięty pasek narzędziowy"},
                {"CONF_SET_LOCK_TBAR", "zablokuj pasek narzędziowy"},
                {"CONF_SET_DARK_MODE", "Mode sombre"},
        };
    }
}
