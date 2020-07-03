package kr.co.domain;

import java.util.List;

public class pageTO {
	//각각의 변수가 무엇을 의미하는지 정리하기! 
	
	private int curPage = 1;  //몇번부터 몇번까지 찍을 지 기준은 현재페이지!! 
	private int perPage = 10; //최대 몇개의 게시글 보이는지
	private int pageLine = 10; // 1페이지에 보여줄 수 있는 페이지수 (밑에 몇깨 찍히는지)
	
	private int amount;  //게시글의 총 갯수 
	private int totalPage;  //총 몇 페이지가 필요한지... //종속변수: amount 나누기 perPage
	
	private int startNum;  //rownum 1번부터  //종속변수: curPage  몇 페이지에 해당하는 rownum을 넘겨준다. 
	private int endNum;  //rownum 10번까지
	
	private int beginPageNum; // 1페이지부터 / 무엇에 의해 결정? 현재페이지curPage 에 의한 종속변수
	private int stopPageNum;  //10페이지까지
	
	private List<BoardDTO> list;  //최대 perpage 갯수만큼 들어갈 수 있는 list 필요 
	
	public pageTO() { //curPage 가 1일경우 
		changeVarVal();
	}

	
	//curPage가 사용되는 생성자.... 
	public pageTO(int curPage) {
		super();
		this.curPage = curPage;
		changeVarVal();
	}


	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
		changeVarVal();
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
		changeVarVal();
	}

	public int getPageLine() {
		return pageLine;
	}

	public void setPageLine(int pageLine) {
		this.pageLine = pageLine;
		changeVarVal();
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
		changeVarVal();
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNUm() {
		return endNum;
	}

	public void setEndNUm(int endNum) {
		this.endNum = endNum;
	}

	public int getBeginPageNum() {
		return beginPageNum;
	}

	public void setBeginPageNum(int beginPageNum) {
		this.beginPageNum = beginPageNum;
	}

	public int getStopPageNum() {
		return stopPageNum;
	}

	public void setStopPageNum(int stopPageNum) {
		this.stopPageNum = stopPageNum;
	}

	public List<BoardDTO> getList() {
		return list;
	}

	public void setList(List<BoardDTO> list) {
		this.list = list;
	}
	
	//종속변수들의 벨류값 바꿔주는메서드
	private void changeVarVal() {
		//이 식으로 해도됨  totalPage = (amount -1)/perPage + 1;
		totalPage = amount/perPage;  //amount 가 0으로 끝나는경우
		if(amount % perPage != 0) {
			totalPage = totalPage + 1;
		}
		
		
		startNum = (curPage -1) * perPage + 1;
		
		// 이렇게 해도됨 endNum = startNum + perPage -1
		endNum = curPage * perPage;  
		if(endNum > amount) {
			endNum = amount;
			// 총 게시글의 수가 27
			// endNum = 30;  -->27
		} 
		
		
		beginPageNum = ((curPage -1) / pageLine) * pageLine + 1;  // 나누기는 몫만 나온다!!
		
		stopPageNum = beginPageNum + ( pageLine -1 );
		if(stopPageNum > totalPage) {
			stopPageNum = totalPage;
		}
		// stoppavenum = 110;, totalpage = 108일경우.. // 101~108까지찍기 
		
		
		
	}
	
	
}
