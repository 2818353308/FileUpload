import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.core.ApplicationPart;
import org.junit.Test;

@WebServlet("/upload")
@MultipartConfig(location="D://")
public class UploadServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String path = this.getServletContext().getRealPath("/");
		Part p = request.getPart("upload");
		System.out.println(p);
		if(true){
			ApplicationPart ap = (ApplicationPart)p;
			String fname1 = ap.getSubmittedFileName();
			
			int path_idx = fname1.lastIndexOf("\\")+1;
			String fname2 = fname1.substring(path_idx, fname1.length());
			System.out.println("�ļ���fname1==="+fname1);
			System.out.println("�ļ���fname2==="+fname2);
			p.write("path/"+fname2);
			out.write("�ļ��ϴ��ɹ�");
			
		}else{
			out.write("��ѡ��ͼƬ!");
		}
		
		System.out.println("�ύFile�ļ�");
		
	}
	
	@Test
	public void test01(){
		
	}
}
