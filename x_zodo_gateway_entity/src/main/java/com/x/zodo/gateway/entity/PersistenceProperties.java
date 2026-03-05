package com.x.zodo.gateway.entity;

import com.x.base.core.entity.AbstractPersistenceProperties;

public final class PersistenceProperties extends AbstractPersistenceProperties {

	public static class ZodoGateway {
		private ZodoGateway() {

		}
		public static final String table = "ZODO_GATEWAY_LOG";
		public static final String passportBlackTable = "ZODO_PASSPORT_BLACK";
	}
}
