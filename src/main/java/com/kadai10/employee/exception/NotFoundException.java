package com.kadai10.employee.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super();
    }

    public NotFoundException(int id) {
        super("ID:" + id + "は見つかりません");
    }
}
