package com.zeal.contant;


public enum ScoreEnum {

	AGE(0,"0"),
	AGE_19(1,"1"),
	AGE_20(1,"1"),
	AGE_21(1,"1")
	;

	private int code;

	private String msg;

	ScoreEnum(int code,String msg){
		this.code = code;
		this.msg = msg;
	}


	public int getCode(){
		return code;
	}

	public String getMsg(){
		return msg;
	}
}
