package com.naver;

public class CommandAction {
	
	private boolean isRedirect;  //포워딩 방법에 대해서. 포워딩(어떤방식,어디로)
	private String where;
	
	
	public CommandAction() {
		// TODO Auto-generated constructor stub
	}

	public CommandAction(boolean isRedirect, String where) {
		super();
		this.isRedirect = isRedirect;
		this.where = where;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}
	
	
	
	
}
