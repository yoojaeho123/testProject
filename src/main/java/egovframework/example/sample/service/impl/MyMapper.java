package egovframework.example.sample.service.impl;

import java.util.List;
import java.util.Map;

import egovframework.example.sample.vo.BoardVO;
import egovframework.example.sample.vo.CommentVO;
import egovframework.example.sample.vo.Criteria;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("myMapper")
public interface MyMapper {

	List<BoardVO> selectBoardList(Criteria cri) throws Exception;
	
	int getTotal(Criteria cri);
	
	void insertBoard(BoardVO boardVO) throws Exception;
	
	List<BoardVO> selectDetail(BoardVO boardVO)throws Exception;
	
	int deleteBoard(int id);
	
	void updateBoard(BoardVO boardVO);
	
	void reInsertBoard(BoardVO boardVO)throws Exception;
	
	void updateBoardId()throws Exception;
	
	void updateReWrite(BoardVO boardVO);
	
	boolean selectLevel(BoardVO boardVO);
	
	void updateReWriteTrue(BoardVO boardVO);
	
	void updateReWriteFalse(BoardVO boardVO);
	
	List<CommentVO>selectComment(BoardVO boardVO);
	
	void insertComment(Map<String, Object> map) throws Exception;
}
