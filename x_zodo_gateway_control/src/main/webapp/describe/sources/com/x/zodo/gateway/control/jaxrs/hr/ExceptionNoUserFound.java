package com.x.zodo.gateway.control.jaxrs.hr;

import com.x.base.core.project.exception.PromptException;

public class ExceptionNoUserFound extends PromptException {

    private static final long serialVersionUID = 1859164370743532895L;

    public ExceptionNoUserFound(Throwable e, String message ) {
        super("未找到指定用户身份！message:" + message, e );
    }
}
