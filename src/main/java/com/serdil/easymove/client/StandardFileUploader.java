package com.serdil.easymove.client;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Sinan Erdil on 26.08.2015.
 */
public class StandardFileUploader implements FileUploader {

    public void upload(Socket s, File f) throws IOException {
        IOUtils.copy(new FileInputStream(f), s.getOutputStream());
    }
}
