package res;

import java.util.ListResourceBundle;

public class Bundle_uk_UK extends ListResourceBundle {
    protected Object[][] getContents(){
        return new Object[][]{
                {"APP_NAME", "IDE прототип"},
                {"DBG_SIZE", "Розмір"},
                {"DBG_POS", "Позиція"},
                // МЕНЮ główne
                {"MENU_FILE", "File"},
                {"MENU_FILE_NEW", "Новий"},
                {"MENU_FILE_OPEN", "Відкрити"},
                {"MENU_FILE_CONF", "Налаштування"},
                {"MENU_FILE_QUIT", "Quit"},
                // СЛУБКА ІНСТРУМЕНТІВ - pasek narzędziowy
                {"TBAR_FILE_OPEN", "Відкрити"},
                {"TBAR_FILE_SAVE", "Зберегти"},
                {"TBAR_COPY", "Copy"},
                {"TBAR_PASTE", "Вставити"},
                // НАЛАШТУВАННЯ - ustawienia
                {"CONF_WIN_TTL", "Налаштування"},
                {"CONF_LBL_AVL_SETT", "Доступні налаштування"},
                {"CONF_BTN_REJECT", "Відхилити"},
                {"CONF_BTN_STORE", "Зберегти"},
                {"CONF_FSET_WIN", "Вікно"},
                {"CONF_SET_WIN_CENTER", "По центру"},
                {"CONF_SET_WIN_MAX", "Початок розгорнуто"},
                {"CONF_SET_KEEP_POS", "Запам'ятати позицію"},
                {"CONF_SET_KEEP_SIZE", "Запам'ятати розмір"},
                {"CONF_FSET_IDE", "IDE"},
                {"CONF_SET_LANG", "Мова інтерфейсу"},
                {"CONF_SET_KEEP_DIR", "запам'ятовування каталогу перекладу"},
                {"CONF_SET_KEEP_OPEN_FILES", "запікайте відкритий файл"},
                {"CONF_FSET_GUI", "GUI"},
                {"CONF_SET_HIDE_MENU", "Сховати головне меню"},
                {"CONF_SET_UNDOCK_TBAR", "odpięty pasek narzędziowy"},
                {"CONF_SET_LOCK_TBAR", "zablokuj pasek narzędziowy"},
                {"CONF_SET_DARK_MODE", "Темний режим"},
        };
    }
}
