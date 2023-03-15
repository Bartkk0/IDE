package res;

import java.util.ListResourceBundle;

public class Bundle_es_ES extends ListResourceBundle {
    protected Object[][] getContents(){
        return new Object[][]{
                {"APP_NAME", "prototipo IDE"},
                {"DBG_SIZE", "Tamaño"},
                {"DBG_POS", "Posición"},
                // MENÚ główne
                {"MENU_FILE", "Archivo"},
                {"MENU_FILE_NEW", "Nuevo"},
                {"MENU_FILE_OPEN", "Abrir"},
                {"MENU_FILE_CONF", "Preferencias"},
                {"MENU_FILE_QUIT", "Salir"},
                // BARRA DE HERRAMIENTAS - pasek narzędziowy
                {"TBAR_FILE_OPEN", "Abrir"},
                {"TBAR_FILE_SAVE", "Guardar"},
                {"TBAR_COPY", "Copiar"},
                {"TBAR_PASTE", "Pegar"},
                // AJUSTES - ustawienia
                {"CONF_WIN_TTL", "Configuración"},
                {"CONF_LBL_AVL_SETT", "Configuración disponible"},
                {"CONF_BTN_REJECT", "Rechazar"},
                {"CONF_BTN_STORE", "Guardar"},
                {"CONF_FSET_WIN", "Ventana"},
                {"CONF_SET_WIN_CENTER", "Centrado en el inicio"},
                {"CONF_SET_WIN_MAX", "Iniciar maximizado"},
                {"CONF_SET_KEEP_POS", "Recordar posición"},
                {"CONF_SET_KEEP_SIZE", "Recordar tamaño"},
                {"CONF_FSET_IDE", "IDE"},
                {"CONF_SET_LANG", "Idioma de la interfaz"},
                {"CONF_SET_KEEP_DIR", "zapamiętaj katalog przeglądania"},
                {"CONF_SET_KEEP_OPEN_FILES", "zapamiętaj otwarte pliki"},
                {"CONF_FSET_GUI", "GUI"},
                {"CONF_SET_HIDE_MENU", "Ocultar menú principal"},
                {"CONF_SET_UNDOCK_TBAR", "odpięty pasek narzędziowy"},
                {"CONF_SET_LOCK_TBAR", "zablokuj pasek narzędziowy"},
                {"CONF_SET_DARK_MODE", "Modo oscuro"},
        };
    }
}
