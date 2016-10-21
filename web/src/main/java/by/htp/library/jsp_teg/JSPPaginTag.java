package by.htp.library.jsp_teg;

import by.htp.library.command.impl.Login;
import by.htp.library.jsp_bean.JSPUserBean;
import org.apache.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by oxothuk1401 on 21.10.2016.
 */
public class JSPPaginTag extends TagSupport {
    private static Logger log = Logger.getLogger(Login.class.getName());
    private JSPUserBean jspUserBean;

    public JSPUserBean getJspUserBean() {
        return jspUserBean;
    }

    public void setJspUserBean(JSPUserBean jspUserBean) {
        this.jspUserBean = jspUserBean;
    }

    public int doStartTag() throws JspException {
        int position = jspUserBean.getPosition();
        log.info("JSPPaginTag jspUserBean.getPosition = " + position);
        int amount = jspUserBean.getAmount();
        int amountPages = jspUserBean.getCountAllUsers() / amount;
        try {
            JspWriter out = pageContext.getOut();
            out.write("<table border=\"0\" align=\"center\">");
            out.write("<tr>");
            out.write("<td align=\"center\">");
//            out.write("<a href = \"Controller?command=back_position\">&laquo;</a>");
            for (int i = 0; i <= amountPages; i++) {
                int page = i + 1;
                position = i * amount;
                out.write("<a href = \"Controller?command=show-users&position=" + position + "&amount=" + amount + "\">" + page + "</a>");
                out.write("  ");
            }
            out.write("</td>");
            out.write("</tr>");
            out.write("</table");
//            out.write("<a href = \"Controller?command=add_position\">&raquo;</a>");
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }
}
