package net.sunfarms.z.wiki.view;

import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.doc.DocRender;
import org.nutz.doc.html.HtmlDocRender;
import org.nutz.doc.meta.ZDoc;
import org.nutz.mvc.View;

public class ZDocView implements View {
	
	DocRender<StringBuilder> render = new HtmlDocRender();

	@Override
	public void render(HttpServletRequest req, HttpServletResponse resp,
			Object obj) throws Throwable {
		if (obj instanceof ZDoc ){
			StringBuilder sb = render.render((ZDoc)obj);
			Writer out = resp.getWriter();
			out.write(sb.toString());
			out.flush();
		}
	}

}
