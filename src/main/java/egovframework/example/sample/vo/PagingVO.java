package egovframework.example.sample.vo;

public class PagingVO {

	private int startPage; //페이징 시작번호
	private int endPage; //페이징 마지막번호
	private boolean prev, next; //이전,다음 버튼 활성화 여부
	private int total; //게시물 총개수
	private Criteria cri; //
	
	public PagingVO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		//시작페이지, 마지막페이지 계산
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0))*10 ; 
		this.startPage = this.endPage -9; 
		
		int realEnd;
		
		if(total % cri.getAmount() == 0) {
			realEnd = (total / cri.getAmount());
		}else {
			realEnd = (total / cri.getAmount())+1;
		}
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		//이전, 다음 버튼 표출 여부 결정
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
	
	
	
	
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public boolean isNext() {
		return next;
	}
	public int getTotal() {
		return total;
	}
	public Criteria getCri() {
		return cri;
	}

	@Override
	public String toString() {
		return "PageVO [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", total=" + total + "]";
	}
	
	
}
