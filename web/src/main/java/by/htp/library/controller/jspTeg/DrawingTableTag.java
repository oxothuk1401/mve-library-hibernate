package by.htp.library.controller.jspTeg;

import by.htp.library.service.CountAllUsers;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class DrawingTableTag extends TagSupport {
    private static final long serialVersionUID = 1L;
    private JspSet set;
    private int amount = 3;
    private int amountPages = CountAllUsers.countAllUsers() / amount;

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
            out.write("<table width=\"800\" border=\"1\"align=\"center\">");
            for (int i = 0; i < size; i++) {
                out.write("<tr><td width=\"220\" align=\"center\">");
                out.write(set.getElement());
                out.write("</td></tr>");
            }
            out.write("</table>");
//            out.write("<a href = \"Controller?command=back_position\">&laquo;</a>");
            for (int i = 0; i < amountPages; i++) {
                int page = i + 1;
                int position = i*amount;
                    out.write("<a href = \"Controller?command=show-users1&position=" + position + "&amount=" + amount + "\">" + page + "</a>"   );
                    out.write("  ");
            }
//            out.write("<a href = \"Controller?command=add_position\">&raquo;</a>");
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }
}
