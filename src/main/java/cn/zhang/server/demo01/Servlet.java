package cn.zhang.server.demo01;

public class Servlet {
	public void service(Request req, Response rep) {
		rep.println("<html><head><title>HTTP��Ӧʾ��</title></head><body>");
		rep.println("��ӭ��").println(req.getParameter("uname")).println("�����ˣ�");
		rep.println("</body></html>");
	}
}
