package com.ecodeup.model;

import javax.faces.context.*;

public class YourExceptionHandlerFactory extends ExceptionHandlerFactory {

    private ExceptionHandlerFactory parent;

    public YourExceptionHandlerFactory(ExceptionHandlerFactory parent) {
        this.parent = parent;
    }

    @Override
    public ExceptionHandler getExceptionHandler() {
        return new YourExceptionHandler(parent.getExceptionHandler());
    }

}