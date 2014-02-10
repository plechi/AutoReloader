package at.plechinger.autoreloader;

import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UnknownHostException
    {
       System.out.println(Inet4Address.getLocalHost().getHostAddress());
        AutoReloaderGUI.main(args);
    }
}
