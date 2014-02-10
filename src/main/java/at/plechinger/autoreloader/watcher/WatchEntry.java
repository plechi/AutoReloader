/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.plechinger.autoreloader.watcher;

import java.io.File;
import lombok.Data;

/**
 *
 * @author Lukas
 */
@Data
public class WatchEntry {
  private final File file;
  private final boolean recursive;
}
