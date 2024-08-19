package com.ej.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ej.spring.list.vo.ListVO;

public interface ListService {
	public List<ListVO> lists(ListVO listVO) throws DataAccessException;	//전체조회
	public int addList(ListVO listVO) throws DataAccessException;			//목록추가
	public ListVO modList(String tno) throws DataAccessException;			//목록수정폼
	public int modifyList(ListVO listVO) throws DataAccessException;		//수정완료
	public int removeList(String tno) throws DataAccessException;			//목록삭제
	


		
}
