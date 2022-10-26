package egovframework.example.sample.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.sample.service.MyService;
import egovframework.example.sample.vo.BoardVO;
import egovframework.example.sample.vo.CommentVO;
import egovframework.example.sample.vo.Criteria;
import egovframework.example.sample.vo.PagingVO;

@Service("myService")
public class MyServiceImpl implements MyService {

	@Resource(name = "myMapper")
	private MyMapper myMapper;

	@Override
	public List<BoardVO> selectBoardList(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return myMapper.selectBoardList(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		// TODO Auto-generated method stub
		return myMapper.getTotal(cri);
	}

	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		myMapper.insertBoard(boardVO);

	}

	@Override
	public List<BoardVO> selectDetail(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return myMapper.selectDetail(boardVO);
	}

	@Override
	public int deleteBoard(int id) {
		// TODO Auto-generated method stub
		return myMapper.deleteBoard(id);
	}

	@Override
	public void updateBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		myMapper.updateBoard(boardVO);
	}

	@Override
	public void reInsertBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		myMapper.reInsertBoard(boardVO);
	}

	@Override
	public void updateBoardId() throws Exception {
		// TODO Auto-generated method stub
		myMapper.updateBoardId();
	}

	@Override
	public void updateReWrite(BoardVO boardVO) {
		// TODO Auto-generated method stub
		myMapper.updateReWrite(boardVO);
	}

	@Override
	public boolean selectLevel(BoardVO boardVO) {
		return myMapper.selectLevel(boardVO);
	}

	@Override
	public void updateReWriteTrue(BoardVO boardVO) {
		// TODO Auto-generated method stub
		myMapper.updateReWriteTrue(boardVO);
	}

	@Override
	public void updateReWriteFalse(BoardVO boardVO) {
		// TODO Auto-generated method stub
		myMapper.updateReWriteFalse(boardVO);
	}

	@Override
	public List<CommentVO> selectComment(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return myMapper.selectComment(boardVO);
	}

	@Override
	public void insertComment(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		myMapper.insertComment(map);
	}

	

}
