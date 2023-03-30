package ezen.springmvc.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    public Page<Notice> findAll(Pageable pageable) {
        return noticeRepository.findAll(pageable);
    }
}
