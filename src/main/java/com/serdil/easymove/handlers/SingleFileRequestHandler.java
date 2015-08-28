package com.serdil.easymove.handlers;

import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Sinan Erdil on 26.08.2015.
 */
public class SingleFileRequestHandler implements RequestHandler {
    boolean stdout;

    public SingleFileRequestHandler() {
        this(false);
    }

    public SingleFileRequestHandler(boolean stdout) {
        this.stdout = stdout;
    }

    public void handle(Socket s) throws IOException {
        InputStream is = s.getInputStream();
        OutputStream os;
        if (stdout) os = System.out;
        else os = new FileOutputStream("easymoveOutput.tar");
        IOUtils.copy(is, os);
        is.close();
        os.flush();
    }
}
