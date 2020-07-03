package kr.co.ca;

import java.io.File;

public class FileClassMainEx {

	public static void main(String[] args) {
		//try: c://new.txt -> c://BBB//new.txt    폴더만들고 옮기기
		File f4 = new File("C:"+File.separator + "BBB");
		if(!f4.exists()) {
			f4.mkdir();
		}
		File f5 = new File("C:", "new.txt");
		File f6 = new File(f4, "new.txt");  
		f5.renameTo(f6);  //파일이 이동~ 넘어간다
		//파일삭제는 f6.delete 하면됨 
		////이름과 경로 둘다 변경한꺼번에?
		
		
		//파일 이름바꾸기
		File f3 = new File("C:", "test119.txt");
		File newName = new File("C:","new.txt");
		f3.renameTo(newName);	
		
		//파일 삭제하기
		File f2 = new File("C:" + File.separator + "test119.txt");

		boolean isDel = f2.delete();
		if (isDel) { // 잘안되면 관리자 권한으로 실행해보세요~
			System.out.println("삭제성공");
		} else {
			System.out.println("삭제실패");
		}

		//폴더 생성 및 삭제
		File f1 = new File("C:" + File.separator + "AAA");

		if (!f1.exists()) {//실무에선 요로코롬 //가장 많이 사용하는걸 위로~ //f.c에서 select.bo를 맨위에 놓은 것도~
			System.out.println("AAA 폴더가 없쪙 그러니 폴더를 만들겠습니다");
			f1.mkdir();
		} else {
			System.out.println("AAA 폴더가 있넴 그러니 폴더를 삭제하겠습니다");
			f1.delete();
		}

		

	}
}
