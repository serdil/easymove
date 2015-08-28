package com.serdil.easymove.app;

import com.serdil.easymove.handlers.SingleFileRequestHandlerFactory;
import com.serdil.easymove.server.FileServer;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Sinan Erdil on 26.08.2015.
 */
public class EasyMove {
    public static void main(String[] args) throws IOException {

        int argInd = 0;
        boolean stdout = false;
        while (args.length > argInd && args[argInd].charAt(0) == '-') {
            switch (args[argInd++]) {
                case "-stdout":
                    stdout = true;
                    break;
            }
        }

        int argLen = args.length - argInd;
        if (argLen == 0) {
            if (!stdout) System.out.println("server running");
            new FileServer(2015,
                    new SingleFileRequestHandlerFactory(stdout)).start();
        } else if (argLen > 2) {
            System.err.println("Usage: easymove [<host> <file>]");
        } else if (argLen == 1) {
            System.out.println("sending stdin");
            sendFile(args[argInd], System.in);
        } else {
            System.out.println("sending file");
            InputStream is = new FileInputStream(args[argInd + 1]);
            sendFile(args[argInd], is);
        }
    }

    private static void sendFile(String host, InputStream is)
            throws IOException {
        Socket s = new Socket(host, 2015);
        OutputStream os = s.getOutputStream();
        IOUtils.copy(is, os);
        os.close();
        is.close();
    }
}
