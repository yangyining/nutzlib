package org.nutz.ioc.val;

import org.nutz.ioc.IocMaking;
import org.nutz.ioc.ValueProxy;
import org.nutz.ioc.loader.Loaders;

public class ArrayValue implements ValueProxy {

	private ValueProxy[] values;

	public ArrayValue(IocMaking ing, Object[] array) {
		values = new ValueProxy[array.length];
		for (int i = 0; i < values.length; i++)
			values[i] = ing.makeValue(Loaders.object2value(array[i]));
	}

	public Object get(IocMaking ing) {
		Object[] re = new Object[values.length];
		for (int i = 0; i < values.length; i++)
			re[i] = values[i].get(ing);
		return re;
	}

}
