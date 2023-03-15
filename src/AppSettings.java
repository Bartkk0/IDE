import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AppSettings extends JDialog {
    HashMap<Settings.APPSETTING,JComponent> pf = new HashMap<>();

    JPanel panelMain;

    JPanel panelGeneral;
    JButton btnApply, btnRevert;

    JPanel panelWindow;
    JComboBox<Language> comboLang;
    JCheckBox cbCenter, cbMax, cbSavePos, cbSaveSize;

    JPanel panelIDE;
    JCheckBox cbSaveDir, cbSaveOpened;

    JPanel panelGUI;
    JCheckBox cbHideMenu, cbUndockToolbar, cbLockToolbar, cbDarkMode;

    AppSettings() {
        setTitle(Localisation.GetString("CONF_WIN_TTL"));
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setModal(true);
        //setModalityType(ModalityType.APPLICATION_MODAL);

        Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

        panelMain = new JPanel();
        panelMain.setAlignmentX(LEFT_ALIGNMENT);
        panelMain.setLayout(new GridLayout(0, 1));

        panelGeneral = new JPanel();
        panelGeneral.setLayout(new BoxLayout(panelGeneral, BoxLayout.X_AXIS));
        panelGeneral.setAlignmentX(LEFT_ALIGNMENT);

        panelWindow = new JPanel();
        panelWindow.setLayout(new BoxLayout(panelWindow, BoxLayout.Y_AXIS));
        panelWindow.setBorder(BorderFactory.createTitledBorder(border, Localisation.GetString("CONF_FSET_WIN")));
        panelWindow.setAlignmentX(LEFT_ALIGNMENT);

        panelIDE = new JPanel();
        panelIDE.setLayout(new BoxLayout(panelIDE, BoxLayout.Y_AXIS));
        panelIDE.setAlignmentX(LEFT_ALIGNMENT);
        panelIDE.setBorder(BorderFactory.createTitledBorder(border, Localisation.GetString("CON_FSET_IDE")));

        panelGUI = new JPanel();
        panelGUI.setLayout(new BoxLayout(panelGUI, BoxLayout.Y_AXIS));
        panelGUI.setAlignmentX(LEFT_ALIGNMENT);
        panelGUI.setBorder(BorderFactory.createTitledBorder(border, Localisation.GetString("CONF_FSET_GUI")));

        btnApply = new JButton(Localisation.GetString("CONF_BTN_STORE"));
        btnApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow(true);
            }
        });
        btnRevert = new JButton(Localisation.GetString("CONF_BTN_REJECT"));
        btnRevert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });
        panelGeneral.add(btnApply);
        panelGeneral.add(btnRevert);

        panelWindow.add(new JLabel(Localisation.GetString("CONF_SET_LANG")));

        comboLang = new JComboBox(Localisation.languageModel);
        cbCenter = new JCheckBox(Localisation.GetString("CONF_SET_WIN_CENTER"));
        cbMax = new JCheckBox(Localisation.GetString("CONF_SET_WIN_MAX"));
        cbSavePos = new JCheckBox(Localisation.GetString("CONF_SET_KEEP_SIZE"));
        cbSaveSize = new JCheckBox(Localisation.GetString("CONF_SET_KEEP_SIZE"));
        panelWindow.add(comboLang);
        panelWindow.add(cbCenter);
        panelWindow.add(cbMax);
        panelWindow.add(cbSavePos);
        panelWindow.add(cbSaveSize);

        cbSaveDir = new JCheckBox(Localisation.GetString("CONF_SET_KEEP_DIR"));
        cbSaveOpened = new JCheckBox(Localisation.GetString("CONF_SET_KEEP_OPEN_FILES"));
        panelIDE.add(cbSaveDir);
        panelIDE.add(cbSaveOpened);

        cbHideMenu = new JCheckBox(Localisation.GetString("CONF_SET_HIDE_MENU"));
        cbUndockToolbar = new JCheckBox(Localisation.GetString("CONF_SET_UNDOCK_TBAR"));
        cbLockToolbar = new JCheckBox(Localisation.GetString("CONF_SET_LOCK_TBAR"));
        cbDarkMode = new JCheckBox(Localisation.GetString("CONF_SET_DARK_MODE"));
        panelGUI.add(cbHideMenu);
        panelGUI.add(cbUndockToolbar);
        panelGUI.add(cbLockToolbar);
        panelGUI.add(cbDarkMode);


        panelMain.add(panelGeneral);
        panelMain.add(panelWindow);
        panelMain.add(panelIDE);
        panelMain.add(panelGUI);
        add(panelMain);

        pf.put(Settings.APPSETTING.cbCenter, cbCenter);
        pf.put(Settings.APPSETTING.cbMax,cbMax);
        pf.put(Settings.APPSETTING.comboLang, comboLang);
        pf.put(Settings.APPSETTING.cbSavePos,cbSavePos);
        pf.put(Settings.APPSETTING.cbSaveSize,cbSaveSize);
        pf.put(Settings.APPSETTING.cbSaveDir,cbSaveDir);
        pf.put(Settings.APPSETTING.cbSaveOpened,cbSaveOpened);
        pf.put(Settings.APPSETTING.cbHideMenu,cbHideMenu);
        pf.put(Settings.APPSETTING.cbUndockToolbar,cbUndockToolbar);
        pf.put(Settings.APPSETTING.cbLockToolbar,cbLockToolbar);
        pf.put(Settings.APPSETTING.cbDarkMode,cbDarkMode);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                Settings.loadSettings();
            }

            @Override
            public void windowClosing(WindowEvent e) {
                Settings.loadSettings();
            }
        });

        for (Map.Entry<Settings.APPSETTING, JComponent> ck : pf.entrySet()){
            JComponent component = ck.getValue();
            Settings.APPSETTING key = ck.getKey();
            if(component instanceof JCheckBox){
                JCheckBox cbx = (JCheckBox)component;
                cbx.setSelected(Settings.getSetting(key,false));
            }
            else if(component instanceof JComboBox){
                if(component == comboLang){
                    JComboBox<Language> combo = (JComboBox<Language>)component;

                    String langCode = Settings.getSetting(Settings.APPSETTING.comboLang, "en_US");

                    for (Language lang : Localisation.languageModel){
                        if(lang.getId().equals(langCode)){
                            combo.setSelectedItem(lang);
                            break;
                        }
                    }
                }
            }
        }

        setLocationRelativeTo(null);
        pack();

        setVisible(true);
    }

    private void closeWindow() {
        App.LOGGER.info("Closing settings");
        this.dispose();
    }

    private void closeWindow(boolean store) {
        App.LOGGER.info("Closing settings");
        if (store)
            storeSettings();
        this.dispose();
    }

    private void storeSettings(){
        for (Map.Entry<Settings.APPSETTING, JComponent> ck : pf.entrySet()){
            JComponent component = ck.getValue();
            Settings.APPSETTING key = ck.getKey();
            if(component instanceof JCheckBox){
                JCheckBox cbx = (JCheckBox)component;
                Settings.setSetting(key,cbx.isSelected());
            }
            else if(component instanceof JComboBox){
                JComboBox combo = (JComboBox)component;

                if(combo.getSelectedItem() instanceof Language) {
                    Language lang = (Language) combo.getSelectedItem();
                    Settings.setSetting(key,lang.getId());
                }
            }
        }

        Settings.storeSettings();
    }
}