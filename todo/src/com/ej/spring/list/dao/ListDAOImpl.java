package com.ej.spring.list.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ej.spring.list.vo.ListVO;

@Repository("listDAO")
public class ListDAOImpl implements ListDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ListVO> selectAllList(ListVO listVO) throws DataAccessException {
		List<ListVO> todoList = null;
		todoList = sqlSession.selectList("mapper.list.selectAllList", listVO);
		return todoList;
	}

	@Override
	public ListVO selectlistBytno(String tno) throws DataAccessException {
		ListVO listVO= new ListVO();
		System.out.println(listVO.getTno());
		listVO = (ListVO) sqlSession.selectOne("mapper.list.selectlistBytno", tno);
		return listVO;
	}

	@Override
	public int insertList(ListVO listVO) throws DataAccessException {
		System.out.println(listVO.getTitle());
		int result = sqlSession.insert("mapper.list.insertList", listVO);
		return result;
	}

	@Override
	public int updateList(ListVO listVO) throws DataAccessException {
		System.out.println(listVO);
		int result = sqlSession.update("mapper.list.updateList", listVO);
		return result;
	}

	@Override
	public int deleteMember(String tno) throws DataAccessException {
		int result = sqlSession.delete("mapper.list.deleteList", tno);
		return result;
	}	
	
}
