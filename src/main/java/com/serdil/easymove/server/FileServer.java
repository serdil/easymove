package com.serdil.easymove.server;

import com.serdil.easymove.handlers.RequestHandler;
import com.serdil.easymove.handlers.RequestHandlerFactory;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by Sinan Erdil on 26.08.2015.
 */
public class FileServer {
    private int port;
    private ServerSocket servSock;
    RequestHandlerFactory rhf;
    private boolean active;

    public FileServer(int port, RequestHandlerFactory rhf) throws IOException {
        this.port = port;
        this.servSock = new ServerSocket(port);
        this.rhf = rhf;
    }

    public void stop() {
        active = false;
    }

    public void start() throws IOException {
        active = true;
        RequestHandler rh = rhf.create();
        while (active) {
            rh.handle(servSock.accept());
        }
    }
}
