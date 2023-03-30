package org.example.dto;

public class RespnonseWrapperDto<T> {

    T object;

    public RespnonseWrapperDto(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }
}
