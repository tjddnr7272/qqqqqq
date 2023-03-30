package ezen.springmvc.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/notices")
    public String getNotices(@RequestParam(value = "page", defaultValue = "0") int page,
                             @RequestParam(value = "size", defaultValue = "10") int size,
                             Model model) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdDate");
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Notice> noticePage = noticeService.findAll(pageRequest);
        model.addAttribute("noticePage", noticePage);
        return "basic/notices";
    }
}
