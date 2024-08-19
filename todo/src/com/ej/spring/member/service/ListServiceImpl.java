package com.ej.spring.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ej.spring.list.dao.ListDAO;
import com.ej.spring.list.vo.ListVO;

@Service("listService")
@Transactional(propagation=Propagation.REQUIRED)
public class ListServiceImpl implements ListService{
	@Autowired
	private ListDAO listDAO;

	@Override
	public List lists(ListVO listVO) throws DataAccessException {
		List<ListVO> listsList = null;
		listsList = listDAO.selectAllList(listVO);
		return listsList;
	}

	@Override
	public int addList(ListVO listVO) throws DataAccessException {
		int result = 0;
		result = listDAO.insertList(listVO);
		return result;
	}

	@Override
	public ListVO modList(String tno) throws DataAccessException {
		ListVO listVO = new ListVO();
		listVO = listDAO.selectlistBytno(tno);
		return listVO;
	}

	@Override
	public int modifyList(ListVO listVO) throws DataAccessException {
		int result = 0;
		result = listDAO.updateList(listVO);
		return result;
	}

	@Override
	public int removeList(String tno) throws DataAccessException {
		int result = 0;
		result = listDAO.deleteMember(tno);
		return result;
	}



}
