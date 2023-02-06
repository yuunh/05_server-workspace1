package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PizzaServlet
 */
@WebServlet("/confirmPizza.do")
public class PizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("이거 잘 되남..");
		// 1) 전달값 중에 한글이 있을 경우 인코딩 처리 (post 방식일 때만)
		// request.setCharacterEncoding("UTF-8");
		
		// 2) 요청 시 전달값 뽑기 및 데이터 가공처리 (파싱 같은거) => 변수 및 객체 기록
		// request.getParameter("키값") : "벨류값" (String)
		// request.getParameterValues("키값") : ["벨류값", "벨류값", ....] {String[])
		// => 만일 키 값이 존재하지 않을 경우 null 반환
		
		// 과제 : 요청시 전달값들 다 뽑아서 변수에 기록해놓기 (변수명 임의로) + 콘솔출력
		
		String userName = request.getParameter("userName"); // "이윤화"
		String phone = request.getParameter("phone"); // int로 받으면 폰번호 맨앞 0을 못 읽음 String로 해야됨 => 01079996044
		String address = request.getParameter("address"); // "서울시"
		String message = request.getParameter("message"); // "빨리줘요" | ""
		
		String pizza = request.getParameter("pizza"); // "치즈피자" | "불고기피자" .... | null 값이 들어갈 확률 없음
		String[] topping = request.getParameterValues("topping"); // ["고구마무스", "치즈바이트", ..] | null
		String[] side = request.getParameterValues("side"); // ["핫소스", "피클", ..] | null
		String payment = request.getParameter("payment"); // "card" | "cash"
		
		// 3) 요청처러 (db에 sql문 실행하러 > Service > Dao)
		
		int price = 0; // 나중에 총액을 저장할 변수
		
		switch (pizza) {
		case "콤비네이션피자": price += 5000; break;
		case "치즈피자": price += 6000; break;
		case "포테이토피자":
		case "고구마피자": price += 7000; break;
		case "불고기피자": price += 8000; break;
		}
		
		if (topping != null) { // 토핑이 null이 아닐 때만 돌리기
			for (int i = 0; i < topping.length; i++) {
				switch (topping[i]) {
				case "고구마무스":
				case "콘크림무스": price += 1500; break;
				case "파인애플토핑":
				case "치즈토핑": price += 2000; break;
				case "치즈바이트":
				case "치즈크러스트": price += 3000; break;
				}
			}
		}
		
		if (side != null) { // 사이드가 null이 아닐 때만 돌리기
			for (int i = 0; i < side.length; i++) {
				switch (side[i]) {
				case "콜라":
				case "사이다": price += 2000; break;
				case "핫소스":
				case "갈릭소스": price += 300; break;
				case "피클":
				case "파마산치즈가루": price += 500; break;
				}
			}
		}
		
		// 4) 요청 처리 후 사용자가 보게 될 응답페이지(결제페이지) 만들기
		//	  응답페이지(jsp)를 선택해서 포워딩
		// 	  단, 응답페이지에서 필요한 데이터가 있다면 담아서 포워딩 할 것!
		// 	  > request의 attribute 영역에 담기
		
		request.setAttribute("userName", userName);
		request.setAttribute("phone", phone);
		request.setAttribute("address", address);
		request.setAttribute("message", message);
		request.setAttribute("pizza", pizza);
		request.setAttribute("topping", topping);
		request.setAttribute("side", side);
		request.setAttribute("payment", payment);
		request.setAttribute("price", price);
		
		// 응답할 뷰(jsp) 선택
		RequestDispatcher view = request.getRequestDispatcher("views/pizza/pizzaPayment.jsp");
		
		// 선택된 뷰가 사용자에게 보여지도록 포워딩
		view.forward(request, response);
		
		System.out.println("이윤화");
		System.out.println("이름 : " + userName);
		System.out.println("전화번호 : " + phone);
		System.out.println("주소 : " + address);

		if (message.equals("")) {
			System.out.println("요청사항 : 없음");
		} else {
			System.out.println("요청사항 : " + message);
		}
		
		System.out.println("피자 : " + pizza);
		
		System.out.print("토핑 : ");
		if (topping == null) {
			System.out.println("X");
		} else {
			System.out.println(String.join(", ", topping));
		}
		
		System.out.print("사이드 : ");
		if (side == null) {
			System.out.println("X");
		} else {
			System.out.println(String.join(", ", side));
		}

		System.out.println("결제방식 : " + payment);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
