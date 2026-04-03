package com.solvd.taxi.model.generics;

public class ServiceResult<T> {

    private T data;
    private String message;

    public ServiceResult(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public T getData() {
        return data;
    }
}
