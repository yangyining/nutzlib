package org.nutz.log;

import static org.junit.Assert.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.nutz.dao.Dao;

public class Log4jTest {

	@Test
	public void test_normal_debug() {
		Log log4nut = Logs.getLog(Dao.class);
		Logger log4j = LogManager.getLogger(Dao.class);

		assertEquals(log4nut.isInfoEnabled(),log4j.isInfoEnabled());
		assertEquals(log4nut.isDebugEnabled(), log4j.isDebugEnabled());
		assertEquals(log4nut.isTraceEnabled(),log4j.isTraceEnabled());
	}

}
