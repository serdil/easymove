package com.serdil.easymove.handlers;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Sinan Erdil on 26.08.2015.
 */
public interface RequestHandler {
    void handle(Socket s) throws IOException;
}
