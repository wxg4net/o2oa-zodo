package com.x.zodo.gateway.control.jaxrs.gateway;

import com.x.base.core.project.exception.PromptException;

public class ExceptionZodoPassportBlackExists extends PromptException {

    private static final long serialVersionUID = 1859164370743532895L;

    public ExceptionZodoPassportBlackExists(String id ) {
        super("指定的ID存在于黑名单中:" + id );
    }
}

