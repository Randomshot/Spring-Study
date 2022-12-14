package org.example.service.impl;

import org.example.dao.GuestbookDao;
import org.example.dao.LogDao;
import org.example.dto.Guestbook;
import org.example.dto.Log;
import org.example.service.GuestbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class GuestbookServiceImpl implements GuestbookService {
    @Autowired
    GuestbookDao guestbookDao;

    @Autowired
    LogDao logDao;

    @Override
    @Transactional
    public List<Guestbook> getGuestbooks(Integer start) {
        List<Guestbook> list = guestbookDao.selectAll(start, GuestbookService.LIMIT);
        return list;
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteGuestbook(Long id, String ip) {
        int deleteCount = guestbookDao.deleteById(id);
        Log log = new Log();
        log.setIp(ip);
        log.setMethod("delete");
        log.setRegdate(new Date());
        logDao.insert(log);
        return deleteCount;
    }

    @Override
    @Transactional(readOnly = false)
    public Guestbook addGuestbook(Guestbook guestbook, String ip) {
        guestbook.setRegdate(new Date());
        Long id = guestbookDao.insert(guestbook);
        guestbook.setId(id);

//		if(1 == 1)
//			throw new RuntimeException("test exception");
//
        Log log = new Log();
        log.setIp(ip);
        log.setMethod("insert");
        log.setRegdate(new Date());
        logDao.insert(log);

        return guestbook;
    }

    @Override
    public int getCount() {
        return guestbookDao.selectCount();
    }
}
