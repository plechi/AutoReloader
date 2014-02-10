/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.plechinger.autoreloader.watcher;

import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;

/**
 *
 * @author Lukas
 */
public enum ChangeType {
  CREATE,
  DELETE,
  MODIFY;
  
  
  public static ChangeType convert(WatchEvent.Kind<Path> event){
    return valueOf(event.name().replace("ENTRY_", ""));
  }
}
