package com.x.zodo.gateway.control.jaxrs.gateway;

import com.x.base.core.project.exception.PromptException;

public class ExceptionZodoGatewayClassNotExists extends PromptException {

	private static final long serialVersionUID = 1859164370743532895L;

	public ExceptionZodoGatewayClassNotExists(String id ) {
		super("指定的示例信息不存在.ID:" + id );
	}
}
