package com.x.zodo.attendance.control;

import com.x.base.core.project.exception.PromptException;

public class ExceptionWithMessage extends PromptException {


    private static final long serialVersionUID = 7627685102009613628L;

    public ExceptionWithMessage(String message) {
        super(message);
    }
}
