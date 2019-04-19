package service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BoardDAO;
import db_p.BoardDTO;
import di.MvcAction;
import di.MvcFoward;

public class Detail implements MvcAction {

	@Override
	public MvcFoward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		BoardDTO dto = new BoardDTO();
		dto.setBid(Integer.parseInt(request.getParameter("bid")));
		
		BoardDAO dao  =new BoardDAO();
		dao.addCount(dto);
		
		request.setAttribute("dto",dao.detail(dto));
		//요청 할때 넘길 자료를 set 해주는게 setAttribute
		dao.close();
		
		
		System.out.println("디테일 서비스 진입");
			
		return null;
	}

}
