package com.iu.start.bankBook;


public class BankBookDTO {

	private Long booknum;
	private String bookname;
	private Double bookrate;
	private Integer booksale;
	
	public BankBookDTO() {
		
	}
	

	public Long getBooknum() {
		return booknum;
	}



	public void setBooknum(long booknum) {
		this.booknum = booknum;
	}



	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public Double getBookrate() {
		return bookrate;
	}
	public void setBookrate(double bookrate) {
		this.bookrate = bookrate;
	}
	public Integer getBooksale() {
		return booksale;
	}
	public void setBooksale(int booksale) {
		this.booksale = booksale;
	}
}