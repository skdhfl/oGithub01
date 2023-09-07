package och01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add3
 */
@WebServlet("/Add3") // @(annotation)는 address 주소를 가리킴
public class Add3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add3() { // 생성자
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("이미 up한 파일 수정...");
		
		System.out.println("doGet 여기 왔네");
		// parameter 받기
		int    num = Integer.parseInt(request.getParameter("num")); // num을 text로 받기 때문에 파싱해줘야 함
		String loc = request.getParameter("loc"); // 변수 이름은 다르게 해줘도 상관 없음
		System.out.println("num->"+num);
		System.out.println("loc->"+loc);
		// 목표 : 1부터 누적값 전달
		int sum = 0;
		for(int i = 1; i <= num; i++) {
			sum += i;
		}
		System.out.println("sum->"+sum);
		
		// Encoding 적용
		// request.setCharacterEncoding("utf-8");
		// get방식일 때는 request에 대한 인코딩은 없어도 되지만, response에 대한 인코딩은 필수
		response.setContentType("text/html;charset=utf-8"); // 지정해주지 않으면 한글이 깨져서 나타남
		// 공식 --> response는 사용자 Browser에 보여주는 객체
		PrintWriter out = response.getWriter();
		out.println("<html><body>"); // 콘솔이 아니라 브라우저에 보여주는 out객체
		out.printf("<h1>1부터 %d까지 합계</h1>",num);
		out.printf("<h4>LOC--> %s</h4>",loc);
		out.println(sum);
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost 여기 왔네");
		// 시기 --> request parameter 받기 전 Encoding 적용(파라미터를 받기 전에 인코딩해주지 않으면 한글이 깨짐)
		request.setCharacterEncoding("utf-8");
		// parameter 받기
		int    num = Integer.parseInt(request.getParameter("num")); // num을 text로 받기 때문에 파싱해줘야 함
		String loc = request.getParameter("loc"); // 변수 이름은 다르게 해줘도 상관 없음
		System.out.println("num->"+num);
		System.out.println("loc->"+loc);
		// 목표 : 1부터 누적값 전달
		int sum = 0;
		for(int i = 1; i <= num; i++) {
			sum += i;
		}
		System.out.println("sum->"+sum);
		
		// Encoding 적용 --> response도 마찬가지로 객체를 쓰기 직전에 인코딩 해줘야 함
		response.setContentType("text/html;charset=utf-8");
		// 공식 --> response는 사용자 Browser에 보여주는 객체
		PrintWriter out = response.getWriter();
		out.println("<html><body>"); // 콘솔이 아니라 브라우저에 보여주는 out객체
		out.printf("<h1>1부터 %d까지 Post 합계</h1>",num);
		out.printf("<h4>LOC--> %s</h4>",loc);
		out.println(sum);
		out.println("</body></html>");
		out.close();
	}

}
