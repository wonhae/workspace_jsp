package Z;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ZTest {
	
	public void me8() {
		File f1 = new File("C:","no.txt");
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			in = new FileInputStream(f1);
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			while(true) {
				String msg = br.readLine();
				if(msg == null) break;
				System.out.print(msg);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(br != null) br.close();
				if(isr !=null) isr.close();
				if(in != null) in.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			f1.renameTo(new File("C:" , "nonono.txt"));
		}
	}
	
	public void me7() {
		File f1 = new File("C:" + File.separator + "cha.gif");
		File f2 = new File("c:", "copiedcha.gif");
		InputStream in = null;
		BufferedInputStream bis = null;
		
		OutputStream out = null;
		BufferedOutputStream bos = null;
		
		try {
			in = new FileInputStream(f1);
			bis = new BufferedInputStream(in);
			
			out = new FileOutputStream(f2);
			bos = new BufferedOutputStream(out);
			int what = -1;
			while(true) {
				what = in.read();
				if(what == -1) break;
				out.write(what);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(bis != null) bis.close();
				if(in != null) in.close();
				if(bos != null) bos.close();
				if(out != null) out.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public void me6() {
		File f1 = new File("C:" + File.separator + "cha.gif");
		File f2 = new File("c:", "copiedcha.gif");
		InputStream in = null;
		OutputStream out = null;
		byte[] byteArr = new byte[1024];
		try {
			in = new FileInputStream(f1);
			out = new FileOutputStream(f2);
			while(true) {
				 in.read(byteArr);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) in.close();
				if(out != null) out.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void me5() {
		File f1 = new File("c:" + File.separator + "cha.gif");
		File f2 = new File("c:", "copiedcha.gif");
		InputStream in = null;
		OutputStream out = null;
		int what = -1;
		
		try {
			in = new FileInputStream(f1);
			out = new FileOutputStream(f2);
			while(true) {
				what = in.read();
				if(what == -1) break;
				out.write(what);
			}
			System.out.println("파일복사종료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) in.close();
				if(out != null) out.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void me4() {
		File f1 = new File("C:" + File.separator + "cha.gif");
		File f2 = new File("C:", "cha.gif");
		InputStream in = null;
		OutputStream out = null;
		byte[] byteArr = new byte[512];
		
		try {
			in = new FileInputStream(f1);
			out = new FileOutputStream(f2);
			while(true) {
				int intRead = in.read(byteArr);
				if(intRead == -1) break;
				out.write(byteArr, 0, intRead);
			}
			System.out.println("파일복사완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) in.close();
				if(out != null) out.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void me3() {
		File f1 = new File("C:" + File.separator + "mol.jpg");
		File f2 = new File("C:","copymol.jpg");
		InputStream in = null;
		OutputStream out = null;
		int what = -1;
		try {
			in = new FileInputStream(f1);
			out = new FileOutputStream(f2);
			while(true) {
				what = in.read();
				if(what == -1) {
					break;
				}
				out.write(what);
			}
			System.out.println("파일복사 종료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) in.close();
				if(out != null) out.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	public void me2() {
		File f1 = new File("C:" + File.separator + "mol.jpg");
		File f2 = new File("C:","copy_mol.jpg" );
		InputStream in = null;
		OutputStream out = null;
		byte[] byteArr = new byte[512];
		try {
			in = new FileInputStream(f1);
			out = new FileOutputStream(f2);
			
			while(true) {
				int leng =  in.read(byteArr);
				if(leng == -1) {
					break;
				}
				out.write(byteArr, 0, leng);
			}
			System.out.println("파일복사완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(in !=null) in.close();
				if(out != null) out.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	public void me1() {
		//파일 설정 클래스 이용하여 가져올 파일과, 복사할 파일 미리 설정해두기 
		File f1 = new File("C:" + File.separator + "cha.gif"); 
		File f2 = new File("C:", "copy_cha.gif");
		
		//스트림 2개를 만드는데 둘다 추상클래스라 바로 못만든다. 스트림은 반드시 닫아주기! finally 쓰기 위해서 따로 빼서 변수선언 해준다. 
		InputStream in = null;
		OutputStream out = null;
		//byte로 받아올 것 같지만 int로 하나씩 받는다
		int what = -1;
		
		
		try {
			//상하수도관 만듦
			in = new FileInputStream(f1);
			out = new FileOutputStream(f2);
			//수도꼭지 만들고 물 틀어야지~~ 
			while(true) {
				what =  in.read();
				
				if(what == -1) {
					break;
				}
				out.write(what);
			}
			System.out.println("파일복사 종료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) in.close();
				if(out != null) out.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
