package egovframework.example.sample.vo;

public class Criteria {
	private int pageNum; //페이지번호
	private int amount; //한 페이지에 보여질 개수
	private String keyWord; //검색어
	private String searchType; //검색타입
	
	public Criteria() {
		
		this(1, 10); 
	}
	

	// 기본 생성자 설정
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	public String getKeyWord() {
		return keyWord;
	}


	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}


	public String getSearchType() {
		return searchType;
	}


	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}


	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	
}
