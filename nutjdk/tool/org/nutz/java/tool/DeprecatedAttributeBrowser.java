package org.nutz.java.tool;

import org.nutz.java.bytecode.cp.CP;

public class DeprecatedAttributeBrowser implements AttributeBrowser {

	@Override
	public void load(int[] bytes, CP cp) {
		System.out.println("It is mark as Deprecated");
	}

}
