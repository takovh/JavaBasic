package cn.zhang.server.demo01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * ��װ��Ӧ��Ϣ
 * @author tako_
 *
 */
public class Response {
	public static String BLANK = " ";
	public static String CRLF = "\r\n";
	private BufferedWriter bw;//��
	private StringBuilder headInfo;//�洢ͷ��Ϣ
	private StringBuilder content;//����
	private int len;//���ĳ���
	
	public Response(){
		headInfo = new StringBuilder();
		content = new StringBuilder();
		len = 0;
	}
	public Response(OutputStream os){
		this();
		bw = new BufferedWriter(new OutputStreamWriter(os));
	}
	public Response(Socket client){
		this();
		try {
			bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			headInfo = null;
		}
	}
	/**
	 * ������Ӧͷ
	 */
	private void creatHeadInfo(int code) {
		//1.HTTPЭ��汾��״̬���롢����
		headInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
		switch(code) {
			case 200: headInfo.append("OK"); break;
			case 404: headInfo.append("NOT FOUND"); break;
			case 505: headInfo.append("SERVER ERROR"); break;
		}
		headInfo.append(CRLF);
		//2.��Ӧͷ��Respons Head��
		headInfo.append("Server:tencent Server/0.0.1").append(CRLF);
		headInfo.append(new Date()).append(CRLF);//"Data:Mon,7Jan2019 13:18:00 GMT"
		headInfo.append("Content-type:text/html;charset=GBK").append(CRLF);
		headInfo.append("Content-length:").append(len).append(CRLF);//���ĳ��ȣ��ֽڳ���
		//3.����֮ǰ
		headInfo.append(CRLF);
	}
	/**
	 * ��������
	 */
	public Response print(String info) {
		content.append(info);
		len+=info.getBytes().length;
		return this;
	}
	public Response println(String info) {
		content.append(info).append(CRLF);
		len+=(info+CRLF).getBytes().length;
		return this;
	}
	/**
	 * ���͵��ͻ���
	 * @throws IOException 
	 */
	void pushToClient(int code) throws IOException {
		if(null==headInfo) code = 500;
		creatHeadInfo(code);
		//ͷ��Ϣ+�ָ���
		bw.append(headInfo.toString());
		//����
		bw.append(content.toString());
		bw.flush();
	}
	public void close() {
		CloseUtil.closeIO(bw);
	}
}
