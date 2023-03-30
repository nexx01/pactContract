package org.example.dto;

public class RequestWrapperDto<T> {

    T object;

    public RequestWrapperDto(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }
}
