package com.serdil.easymove.client;

import java.io.File;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Sinan Erdil on 26.08.2015.
 */
public interface FileUploader {
    void upload(Socket s, File f) throws IOException;
}
