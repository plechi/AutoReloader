/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.plechinger.autoreloader.server;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import org.apache.log4j.Logger;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

/**
 *
 * @author Lukas
 */
public class ChangeServer extends WebSocketServer{

  private static final Logger LOG = Logger.getLogger(ChangeServer.class);

  public ChangeServer(int port) throws UnknownHostException {
    super(new InetSocketAddress(port));
  }

  public ChangeServer(InetSocketAddress address) {
    super(address);
  }

  @Override
  public void onOpen(WebSocket ws, ClientHandshake handshake) {
    LOG.info("new connection: " + ws.getRemoteSocketAddress());
  }

  @Override
  public void onClose(WebSocket ws, int i, String string, boolean bln) {
    LOG.info("lost connection: " + ws.getRemoteSocketAddress());
  }

  @Override
  public void onMessage(WebSocket ws, String string) {
    //do nothing
  }

  @Override
  public void onError(WebSocket ws, Exception excptn) {
    //do nothing
  }

  public void sendToAll(String text) {
    Collection<WebSocket> con = connections();
    synchronized (con) {
      for (WebSocket c : con) {
        c.send(text);
      }
    }
  }
  
  public void updateClients(){
    sendToAll("refresh");
  }
  
}
