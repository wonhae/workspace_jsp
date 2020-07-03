package Z;

public class MainEx {
	public static void main(String[] args) {
		ZTest xT = new ZTest();
		long start =  System.currentTimeMillis();
		xT.me1();
		long end =  System.currentTimeMillis();
		System.out.println(end-start);
		System.out.println("::::::::::::::::");
		start =  System.currentTimeMillis();
		xT.me2();
		end =  System.currentTimeMillis();
		System.out.println(end-start);
		
		ZTest zt = new ZTest();
		long st = System.currentTimeMillis();
		zt.me3();
		long en = System.currentTimeMillis();
		System.out.println(en-st);
	}
}
