package com.naver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test {
	
	public void me4() { //try 기사복사 
		File f1 = new File("C:" + File.separator + "test112.txt");
		File f2 = new File("C:","copytest112.txt");
		
		InputStream in = null;
		BufferedInputStream bis = null;
		
		OutputStream out = null;
		BufferedOutputStream bos = null;
		int what = -1;	
		
		try {
			in = new FileInputStream(f1);
			bis = new BufferedInputStream(in);
			
			out = new FileOutputStream(f2);
			bos =  new BufferedOutputStream(out);
			
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
				if(bis != null) bis.close();
				if(in != null) in.close();
				if(bos != null) bos.close();
				if(out != null) out.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	//buffered - in[out]putstream / 배열 이용한 것과 속도 비슷할 것~~ 
	public void me3() {
		File f1 = new File("C:"+ File.separator + "show.jpg");
		File f2 = new File("C:", "copyshow.jpg");
		
		InputStream in = null;
		BufferedInputStream bis = null;  //BIS ctenter
		
		OutputStream out = null;
		BufferedOutputStream bos = null;
		
		try { 
			//각각의 객체 만든다 = 화살표만 만든다
			in = new FileInputStream(f1);
			bis = new BufferedInputStream(in); //체이닝~ input 쪽 그림 완성됨
			
			out = new FileOutputStream(f2);
			bos = new BufferedOutputStream(out);
			
			//통로에 읽어와보기 / 수돗물. 파이프가 다 스트림 / 가장 가까이 있는 스트림을 이용할 것 ! 수도꼭지 열기 
			int what = -1;
			while(true) {
				what = bis.read();
				if(what == -1) break;
				bos.write(what);
			}
			System.out.println("파일복사 종료");	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { //삭제순서 유의  filterstream -> nodestream
				if(bos != null) bos.close();
				if(out != null) out.close();
				if(bis != null) bis.close();
				if(in != null) in.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	//배열 이용해서 작업 . 속도 엄청 빨라짐~~  암기할 것
	public void me2() { 
		File f1 = new File("C:"+File.separator+"test.jpg");  
		File f2 = new File("C:", "copytest.jpg"); 
		
		InputStream in = null;
		OutputStream out = null;
		byte[] arr = new byte[512];
		
		try {
			in = new FileInputStream(f1);
			out = new FileOutputStream(f2);
			
			while(true) {//읽어와서 arr 배열에 넣을 수 있을 수 있을때 까지 넣기
				int leng = in.read(arr);//read는 읽어온 갯수를 반환, leng은 읽어온 것만 받음(그림)
				if(leng == -1) {
					break;
				}
				out.write(arr, 0, leng);
			}
			System.out.println("파일 복사 완료");
			
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
	
	
	
	//byte stream 구현~ 암기할 것  ////복사되면 또 복사 안되남
	public void me1() {
		File f1 = new File("C:"+File.separator+"test.jpg");   //1byte 씩 읽어와서 
		File f2 = new File("C:", "copytest.jpg"); //여기에 넣어줄 것 ! 
		//파일복사~
		
		InputStream in = null;
		OutputStream out = null;
		int what = -1; //흘러가는애 byte stream구현한다고 해서 byte라 쓰지 않는다.int형에 넣어서 보낸다!! 
		
		try {  //화살표(스트림) 만들어줘야
			in = new FileInputStream(f1); //직접 경로 적어도 되고 파일 객체 넣어도되고
			out = new FileOutputStream(f2);
			//수도관 연결해도 물이 흐리지 않는다. 수도꼭지~~~ 
			
			while(true) { //test.jpg 에서 데이터 계속 읽어볼 것~~~~~
				what =  in.read(); //계속 받다보면 더 읽어올게 없으면 -1을 넘겨줌 / 프로그램은 합리적. 
				if(what == -1) {
					break;
				}
				out.write(what);
			}
			System.out.println("파일복사 종료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { //스트림은 받으시 닫아줘야한다! 닫는 순서는 상관없드아 
				if(in != null) in.close();
				if(out != null) out.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
}
