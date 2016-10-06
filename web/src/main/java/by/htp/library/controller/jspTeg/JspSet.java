package by.htp.library.controller.jspTeg;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class JspSet {
	private Iterator it;
	private TreeSet set;

	public JspSet(TreeSet set) {
		this.set = set;
	}

	public JspSet() {
	}

	public String getSize() {
		it = set.iterator();
		return Integer.toString(set.size());
	}

	public String getElement() {
		return it.next().toString();
	}

}
