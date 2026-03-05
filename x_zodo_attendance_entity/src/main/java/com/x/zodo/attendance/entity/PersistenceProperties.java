package com.x.zodo.attendance.entity;

import com.x.base.core.entity.AbstractPersistenceProperties;

public final class PersistenceProperties extends AbstractPersistenceProperties {

	public static class Attendance {
		private Attendance() {

		}
		public static final String table = "ZODO_ATTENDANCE_DEVICE";
		public static final String logTable = "ZODO_ATTENDANCE_LOG";

	}
}
