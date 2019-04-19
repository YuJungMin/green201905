package di;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MvcAction {
	MvcFoward execute(HttpServletRequest request, HttpServletResponse response);
}
