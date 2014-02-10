/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.plechinger.autoreloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lukas
 */
public class Settings {

  private static Settings instance = null;

  public static Settings getInstance() {
    if (instance == null) {
      instance = new Settings();
    }
    return instance;
  }

  private static final String settingsFileString = System.getProperty("user.home") + File.separator + ".autoreloader";
  private final Properties properties = new Properties();
  private final File file;

  private Settings() {
    file = new File(settingsFileString);
    try {
      properties.load(new FileInputStream(file));
    } catch (IOException ex) {
    }
  }

  public File getSelectedDirectory() {
    return new File(properties.getProperty("selectedDirectory", System.getProperty("user.home")));
  }

  public void setSelectedDirectory(File file) {
    properties.setProperty("selectedDirectory", file.getAbsolutePath());
    store();
  }

  public void store() {
    try {
      properties.store(new FileOutputStream(file), "Properties of Plechi's AutoReloader");
    } catch (IOException ex) {
     
    }
  }
}
