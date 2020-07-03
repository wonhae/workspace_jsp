package com.google;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;

public class Test {
	
	//
	public void me4() {
		File f1 = new File("C:" + File.separator + "no.txt");
		
		InputStream in = null;
		InputStreamReader isr = null;  //byte stream, 문자 stream 연결해줌
		BufferedReader br = null;
		
		try {
			in = new FileInputStream(f1);
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			
			while(true) {
				String msg = br.readLine();
				if(msg == null) break;
				System.out.println(msg);				
			}
			
			System.out.println("파일복사");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
				if(isr != null) isr.close();
				if(in != null) in.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			f1.renameTo(new File("C:","nono.txt"));  //위치중요 스트림 제거 하고나서 파일이름 바꿀 수 있다. 
		}
	}
	
	//문자스트림 사용할 때 주의사항 // 출력을 먼저하고 읽어오는 것을 할 때 잘 안나온다. //이전까지는 먼저 읽어오고나서 출력. // 이번엔 출력을 먼저하고 읽어온 것. bytestream 에서는 가능하다. 
	//**문자 스트림(~er)에서 출력 작업 후에는  flush 를 호출해야한다. 스트림의 찌꺼기..를 비워주는것! (.close 안에  flush 메소드도 들어가있다! ) //각각 다른 메서드 만들면 flush 할필요 없지만 안전하게 
	public void me3() {
		Writer out = null;
		BufferedWriter bw = null;
		
		Reader in = null;
		BufferedReader br = null;
		
		try { //외부에 먼저 쓰기 
			out = new FileWriter("C:" + File.separator + "no.txt");  //출력할때 없으면 자동으로 만들어준다!!! 입력시 없으면 filenotfoundexception 
			bw = new BufferedWriter(out);
			
			bw.write("hello");
			bw.write(System.getProperty("line.separator"));	//bw.newLine();
			bw.write("world");
			bw.write(System.getProperty("line.separator"));
			bw.write("good");
			bw.write(System.getProperty("line.separator"));
			bw.flush();
			
			in = new FileReader("C:" + File.separator + "no.txt");//여기서 읽어와서 console 창에 sysout 할 것
			br = new BufferedReader(in);
			
			while(true) {
				String msg = br.readLine();
				if(msg == null) break;
				System.out.println(msg);//ln 때문에 자동 줄바꿈됨!! 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) bw.close();
				if(out != null) out.close();
				if(br != null) bw.close();
				if(in != null) in.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	//잘쓰는 코드  BufferedReader:한줄씩 잘 읽어온다 줄바꿈 표시가 있을때까지)노드 스트림인데 문자스트림이다.다른 노드스트림과 같이 사용되는경우가 대다수
	//줄바꿈이 안되어있다. 줄바꿈기호는 누락시켜버림. 
	public void me2() { 
		File f1 = new File("C:", "test112.txt");
		File f2 = new File("C:", "copytest113.txt");
		
		Reader in = null;
		BufferedReader br = null;  //짝꿍: printwriter 와 같이 사용
		
		Writer out = null;
		BufferedWriter bw = null; //이건 잘 안쓴다. 안중요		
		
		try {
			in = new FileReader(f1);
			br = new BufferedReader(in);
			
			out = new FileWriter(f2);
			bw = new BufferedWriter(out);
			
			String msg = "";
			
			while(true) {
				msg = br.readLine();
				if(msg == null) break;
				bw.write(msg);
				//bw.newLine();  //줄바꿈 넣어주기~~~ 
				bw.write(System.getProperty("line.separator"));//라인구분자 
			}			
			System.out.println("파일복사 완료 ");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close(); //둘다 노드 스트림이라 닫는 순서는 상관없긴함
				if(in != null) in.close();
				if(bw != null) bw.close();
				if(out != null) out.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void me1() { //문자 스트림 학습 //잘 안쓰는 코드이다. 
		File f1 = new File("C:" + File.separator + "test112.txt");
		File f2 = new File("C:","copytest112.txt");
		
		Reader in = null;
		Writer out = null;
		
		try {
			in = new FileReader(f1);
			out = new FileWriter(f2); //2개있다. 1개짜리는 덮어쓰는 것
			
			char[] arr = new char[64];
			int leng = -1;  //몇개를 읽어왔는지 아는  int 만들어주기 
			
			while(true) {
				leng = in.read(arr, 0, arr.length);  //arr.length 몇개까지 저장이 되느냐!!!! leng = in.read(arr); 이것도 동일하다 
				if(leng == -1) break; 
				out.write(arr, 0, leng);//arr에 있는거 0부터 leng 개 만큼 넣어준다. 
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
}
