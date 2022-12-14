package org.example.controller;

import org.example.dto.Guestbook;
import org.example.service.GuestbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping(path = "/guestbooks")
public class GuestbookApiController {
    @Autowired
    GuestbookService guestbookService;

    @GetMapping
    public Map<String, Object> list(@RequestParam(name="start",required = false,defaultValue = "0") int start){
        List<Guestbook> list = guestbookService.getGuestbooks(start);
        int count = guestbookService.getCount();
        int pageCount = count / GuestbookService.LIMIT;
        if(count % GuestbookService.LIMIT > 0)
            pageCount++;

        List<Integer> pageStartList = new ArrayList<>();
        for(int i = 0; i < pageCount; i++) {
            pageStartList.add(i * GuestbookService.LIMIT);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("count", count);
        map.put("pageStartList", pageStartList);

        return map;
    }

    @PostMapping
    public Guestbook write(@RequestBody Guestbook guestbook,
                           HttpServletRequest request) {
        String clientIp = request.getRemoteAddr();
        // id가 입력된 guestbook이 반환된다.
        Guestbook resultGuestbook = guestbookService.addGuestbook(guestbook, clientIp);
        return resultGuestbook;
    }

    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable(name="id") Long id,
                                      HttpServletRequest request) {
        String clientIp = request.getRemoteAddr();

        int deleteCount = guestbookService.deleteGuestbook(id, clientIp);
        return Collections.singletonMap("success", deleteCount > 0 ? "true" : "false");
    }
}
