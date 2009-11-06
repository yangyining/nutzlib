package org.nutz.ioc.val;

import org.nutz.ioc.IocMaking;
import org.nutz.ioc.ObjectProxy;
import org.nutz.ioc.ValueProxy;
import org.nutz.ioc.meta.IocObject;

public class InnerValue implements ValueProxy {

	private IocObject iobj;

	public InnerValue(IocObject iobj) {
		this.iobj = iobj;
	}

	public Object get(IocMaking ing) {
		IocMaking innering = new IocMaking(ing.getIoc(), ing.getMirrors(), ing.getContext(), ing
				.getObjectMake(), null);
		ObjectProxy op = ing.getObjectMake().make(innering, iobj);
		return op.get(innering);
	}

}