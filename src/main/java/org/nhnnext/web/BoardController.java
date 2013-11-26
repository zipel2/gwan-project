package org.nhnnext.web;

import org.nhnnext.repository.BoardRepository;
import org.nhnnext.support.FileUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller	
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardRepository boardRepository;
	
	@RequestMapping("/board")
    public String list(Model model) {
		model.addAttribute("boards", boardRepository.findAll());
        return "list";
    } 
    @RequestMapping("/form")
    public String form() {
        return "form";    
    }
    
    @RequestMapping(value="", method=RequestMethod.POST)
    public String create(Board board, MultipartFile file) { 
//    	System.out.println("title : " + title + " contents : " + contents); 
//    	System.out.println(board);
    	FileUploader.upload(file);
    	
    	board.setFileName(file.getOriginalFilename());
    	
    	Board savedBoard = boardRepository.save(board);
    	return "redirect:/board/" + savedBoard.getId();
    }    
    @RequestMapping("/{id}")
    public String show(@PathVariable Long id, Model model) {
    	Board SavedBoard = boardRepository.findOne(id);
       	// TODO DB에서 id에 해당하는 Board 데이터를 조회해야 한다.
    	model.addAttribute(SavedBoard);
     	// TODO 조회한 Board 데이터를 Model에 저장해야 한다.
    return "show";
    }
    
}
