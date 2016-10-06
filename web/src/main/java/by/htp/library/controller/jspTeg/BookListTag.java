package by.htp.library.controller.jspTeg;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class BookListTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	private JspSet set;

	public JspSet getSet() {
		return set;
	}

	public void setSet(JspSet set) {
		this.set = set;
	}

	@Override
	public int doStartTag() throws JspException {
		int size = new Integer(set.getSize());
		try {
			JspWriter out = pageContext.getOut();
			out.write("<table width=\"420\" border=\"1\"align=\"center\">");
			for (int i = 0; i < size; i++) {
				out.write("<tr><td width=\"220\" align=\"left\">");
				out.write(set.getElement());
				out.write("</td></tr>");
				out.write("<br>");
			}
			out.write("</table>");
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}
}
