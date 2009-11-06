package org.nutz.ioc.val;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.nutz.ioc.IocMaking;
import org.nutz.ioc.ValueProxy;
import org.nutz.ioc.loader.Loaders;
import org.nutz.ioc.meta.IocValue;
import org.nutz.lang.Lang;
import org.nutz.lang.meta.Pair;

public class MapValue implements ValueProxy {

	private Class<? extends Map<String, Object>> type;

	private List<Pair<ValueProxy>> list;

	@SuppressWarnings("unchecked")
	public MapValue(IocMaking ing, Map<?, ?> map, Class<? extends Map<String, Object>> type) {
		this.type = (Class<? extends Map<String, Object>>) (null == type ? HashMap.class : type);
		list = new ArrayList<Pair<ValueProxy>>(map.size());
		for (Entry<?, ?> en : map.entrySet()) {
			String name = en.getKey().toString();
			IocValue iv = Loaders.object2value(en.getValue());
			list.add(new Pair<ValueProxy>(name, ing.makeValue(iv)));
		}
	}

	public Object get(IocMaking ing) {
		try {
			Map<String, Object> map = type.newInstance();
			for (Pair<ValueProxy> p : list)
				map.put(p.getName(), p.getValue().get(ing));
			return map;
		} catch (Exception e) {
			throw Lang.wrapThrow(e);
		}
	}

}
