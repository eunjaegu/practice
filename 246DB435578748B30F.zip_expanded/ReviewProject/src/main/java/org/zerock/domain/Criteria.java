package org.zerock.domain;
/**
 * 
 * 페이징 기준 VO 클래스
 *
 * @author 허우진 
 * @since  2016. 7. 07.
 * @version 1.0
 *
 * <pre>
 *
 * 수정일           			수정자               	수정내용
 * -------------  --------    ---------------------------
 * 2016. 7. 07.     허우진     		최초 생성
 *   
 * </pre>
 *
 */
public class Criteria {
	
	private Integer page;
	private Integer perPageNum;
	
	//	- 생성자
	//		page와 perPageNum을 default로 각각 1, 10으로 정해준다.
	public Criteria() {
	
		this.page = 1;
		this.perPageNum = 10;
	}

	// getter & setter
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		// page를 1보다 작은 수로 입력되면 1로 고정.
		this.page = (page < 1) ? 1 :  page; 
	}

	public Integer getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(Integer perPageNum) {
		// perPageNum을 10 미만 또는 100이상일 경우 10으로 고정.		
		this.perPageNum = (perPageNum <10 || perPageNum >=100) ? 10 : perPageNum;
		
	}
	
	// for MyBatis
	public int getPageStart(){

		return (this.page-1) * 10 ;
	}
	
}// class
