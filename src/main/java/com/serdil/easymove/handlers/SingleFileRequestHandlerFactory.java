package com.serdil.easymove.handlers;

/**
 * Created by Sinan Erdil on 26.08.2015.
 */
public class SingleFileRequestHandlerFactory extends RequestHandlerFactory {
    private boolean stdout;

    public SingleFileRequestHandlerFactory() {
        this(false);
    }

    public SingleFileRequestHandlerFactory(boolean stdout) {
        this.stdout = stdout;
    }

    @Override
    public RequestHandler create() {
        return new SingleFileRequestHandler(stdout);
    }
}
