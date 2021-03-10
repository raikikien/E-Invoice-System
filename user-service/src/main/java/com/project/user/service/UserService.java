package com.project.user.service;

import com.project.user.ValueObject.Invoice;
import com.project.user.ValueObject.ResponseTemplateVO;
import com.project.user.entity.User;
import com.project.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithInvoice(Long userId) {
        log.info("Inside getUserWithInvoice of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Invoice invoice =
                restTemplate.getForObject("http://localhost:9091/invoices/" + user.getId()
                        , Invoice.class);
        vo.setUser(user);
        vo.setInvoice(invoice);

        return vo;
    }
}
