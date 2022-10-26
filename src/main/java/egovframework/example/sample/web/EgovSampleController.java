package egovframework.example.sample.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.example.sample.service.MyService;
import egovframework.example.sample.vo.BoardVO;
import egovframework.example.sample.vo.CommentVO;
import egovframework.example.sample.vo.Criteria;
import egovframework.example.sample.vo.PagingVO;

@Controller
public class EgovSampleController {

	@Resource(name = "myService")
	protected MyService myService;

	/* 게시물 조회 */
	@RequestMapping(value = "/board.do")
	public String board(BoardVO vo, Criteria cri, ModelMap model) throws Exception {

		int total = myService.getTotal(cri);

		model.addAttribute("search", cri);
		model.addAttribute("resultList", myService.selectBoardList(cri));
		model.addAttribute("pageMaker", new PagingVO(cri, total));
		return "sample/board";
	}

	/* 상세페이지 조회 */
	@RequestMapping(value = "/detail.do")
	public String detail(BoardVO boardVO, ModelMap model) throws Exception {

		model.addAttribute("result", myService.selectDetail(boardVO));
		model.addAttribute("comment", myService.selectComment(boardVO));
		return "sample/detail";
	}
	
	/* 댓글 작성 */
	@RequestMapping(value = "/detail.do", method = RequestMethod.POST)
	public String insertComment(CommentVO commentVO, @RequestParam("id")int id) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("writer", commentVO.getWriter());
		map.put("content", commentVO.getContent());
		map.put("id", id);
		
		myService.insertComment(map);
	
		return "redirect:/detail.do?id="+id;
	}

	/* 게시물 작성 페이지 이동 */
	@RequestMapping(value = "/writeBoard.do")
	public String writeBoard() throws Exception {

		return "sample/writeBoard";
	}

	/* 게시물 작성 */
	@RequestMapping(value = "/writeBoard.do", method = RequestMethod.POST)
	public String write(BoardVO boardVO) throws Exception {

		myService.insertBoard(boardVO);
		myService.updateBoardId();
		return "redirect:/board.do";
	}

	/* 게시물 삭제 */
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String delete(@RequestParam("id") int id) throws Exception {
		
		myService.deleteBoard(id);
		return "redirect:/board.do";
	}

	/* 게시물 수정 페이지 이동 */
	@RequestMapping(value = "/updateBoard.do")
	public String updateBoard(BoardVO boardVO, ModelMap model) throws Exception {
		model.addAttribute("result", myService.selectDetail(boardVO));

		return "sample/updateBoard";
	}

	/* 게시물 수정 */
	@RequestMapping(value = "/updateBoard.do", method = RequestMethod.POST)
	public String update(BoardVO boardVO) throws Exception {

		myService.updateBoard(boardVO);
		return "redirect:/board.do";
	}
	
	/* 답글 게시물 작성 페이지 이동 */
	@RequestMapping(value = "/reWriteBoard.do")
	public String reWriteBoard(BoardVO boardVO) throws Exception {

		return "sample/reWriteBoard";
	}
	
	/* 답글 게시물 작성 */
	@RequestMapping(value = "/reWriteBoard.do", method = RequestMethod.POST)
	public String reWrite(BoardVO boardVO) throws Exception {

		myService.insertBoard(boardVO);
		if(boardVO.getLevel() ==0) {
			myService.updateReWrite(boardVO);
		}else {
			boolean levelTest = myService.selectLevel(boardVO);
			if(levelTest == true) {
				myService.updateReWriteTrue(boardVO);
			}else {
				myService.updateReWriteFalse(boardVO);
			}
		}

		return "redirect:/board.do";
	}

}
