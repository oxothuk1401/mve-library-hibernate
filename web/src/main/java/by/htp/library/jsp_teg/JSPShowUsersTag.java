package by.htp.library.jsp_teg;

import by.htp.library.entity.User;
import by.htp.library.jsp_bean.JSPUserBean;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by oxothuk1401 on 21.10.2016.
 */
public class JSPShowUsersTag extends TagSupport {
    private static final long serialVersionUID = 6980012309609439962L;

    private JSPUserBean jspUserBean;

    public JSPUserBean getJspUserBean() {
        return jspUserBean;
    }

    public void setJspUserBean(JSPUserBean jspUserBean) {
        this.jspUserBean = jspUserBean;
    }

    public int doStartTag() throws JspException {
        int size = new Integer(jspUserBean.getSize());

        try {
            JspWriter out = pageContext.getOut();
            out.write("<table width=\"450\" border=\"1\" align=\"center\">");

            for (int i = 0; i < size; i++) {
                User user = jspUserBean.getElement(i);
                out.write("<tr><td width=\"60\" align=\"center\">");
                out.write(Integer.toString(user.getId()));
                out.write("</td><td width=\"250\" align=\"center\">");
                out.write(user.getLogin());
                out.write("</td><td width=\"70\" align=\"center\">");
                out.write(user.getRole());
                out.write("</td><td width=\"70\" align=\"center\">");
                out.write(user.getBlacklist());
                out.write("</td></tr>");
            }
            out.write("</table>");
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }
}
