package com.ej.spring.list.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ej.spring.list.vo.ListVO;

public interface ListDAO {
	public List<ListVO> selectAllList(ListVO listVO) throws DataAccessException;	//목록전체+검색?
	public ListVO selectlistBytno(String tno) throws DataAccessException;//목록조회
	public int insertList (ListVO listVO) throws DataAccessException;	//목록등록
	public int updateList (ListVO listVO) throws DataAccessException;	//목록수정
	public int deleteMember(String tno) throws DataAccessException;		//목록제거

}
