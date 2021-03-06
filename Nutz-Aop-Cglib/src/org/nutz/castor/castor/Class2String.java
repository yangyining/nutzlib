package org.nutz.castor.castor;

import org.nutz.castor.Castor;

@SuppressWarnings("unchecked")
public class Class2String extends Castor<Class, String> {

	@Override
	protected String cast(Class src, Class<?> toType, String... args) {
		return src.getName();
	}

}
