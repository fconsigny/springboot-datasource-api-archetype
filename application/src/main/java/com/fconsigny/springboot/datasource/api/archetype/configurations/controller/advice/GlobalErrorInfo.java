package com.fconsigny.springboot.datasource.api.archetype.configurations.controller.advice;

public class GlobalErrorInfo {
    public final String url;
    public final String ex;

    public GlobalErrorInfo(String url, Exception ex) {
        this.url = url;
        this.ex = ex.getLocalizedMessage();
    }
}
