package com.gdu.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.myapp.service.BbsService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequestMapping("/bbs")
@RequiredArgsConstructor
@Controller
public class BbsController {
  
  private final BbsService bbsService;
  
  @GetMapping("/list.do")
  public String list(HttpServletRequest request, Model model) {
    bbsService.loadBbsList(request, model);
    return "bbs/list";
  }
  
  @GetMapping("/write.page")
  public String writePage() {
    return "bbs/write";
  }
  
  @PostMapping("/register.do")
  public String register(HttpServletRequest request, RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute("insertBbsMessage", bbsService.registerBbs(request) == 1 ? "원글이 등록되었습니다." : "원글이 등록되지 않았습니다.");
    return "redirect:/bbs/list.do";
  }
  
  @PostMapping("/registerReply.do")
  public String registerReply(HttpServletRequest request, RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute("insertReplyMessage", bbsService.registerReply(request) == 1 ? "답글이 등록되었습니다." : "답글이 등록되지 않았습니다.");
    return "redirect:/bbs/list.do";
  }
  
  @GetMapping("/removeBbs.do")
  public String removeBbs(@RequestParam int bbsNo, RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute("removeMessage", bbsService.removeBbs(bbsNo) == 1 ? "삭제되었습니다." : "삭제되지 않았습니다.");
    return "redirect:/bbs/list.do";
  }
  
  @GetMapping("/search.do")
  public String search(HttpServletRequest request, Model model) {
    bbsService.loadBbsSearchList(request, model);
    return "bbs/list";
  }

}
