package com.company.boardlayer.exception;

import java.io.Serial;

public class BoardException extends RuntimeException {

    @Serial
    public static final long serialVersionUID = 1L;

    public BoardException(String msg) {
        super(msg);
    }
}
