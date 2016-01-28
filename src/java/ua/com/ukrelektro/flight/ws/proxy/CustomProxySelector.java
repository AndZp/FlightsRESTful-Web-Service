/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.ukrelektro.flight.ws.proxy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class CustomProxySelector extends ProxySelector {

    @Override
    public List select(URI uri) {
        ArrayList list = new ArrayList();
        if (uri.getScheme().toUpperCase().equals("HTTP")) {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 8085));
            
            list.add(proxy);
        }
        return list;
    }

    @Override
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
        System.err.println("Connection to " + uri + " failed.");
    }
}