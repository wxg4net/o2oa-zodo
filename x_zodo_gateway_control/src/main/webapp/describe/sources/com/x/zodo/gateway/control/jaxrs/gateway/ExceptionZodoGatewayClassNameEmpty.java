package com.x.zodo.gateway.control.jaxrs.gateway;

import com.x.base.core.project.exception.PromptException;

public class ExceptionZodoGatewayClassNameEmpty extends PromptException {

	private static final long serialVersionUID = 1859164370743532895L;

	public ExceptionZodoGatewayClassNameEmpty() {
		super("保存操作传入的参数分类名称为空，无法进行保存操作.");
	}
}
