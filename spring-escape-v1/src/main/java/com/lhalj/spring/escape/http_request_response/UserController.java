package com.lhalj.spring.escape.http_request_response;

import org.springframework.web.bind.annotation.*;

/**
 * 描述:
 * Request 的 getInputStream() 和 getReader()都只能使用一次
 * 读取完数据后 指针不会重置 会留在最后 所以只能使用一次
 * request 的 getInputStream() getReader() getPatameter()方法互斥
 * 也就是使用了其中一个 再使用另外两个 是获取不到数据的
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/qinyi")
    public User qinyi(@RequestBody(required = false) User user){

        if(null != user){
            return user;
        }

        return new User(-1L,"qingyi",19);
    }
}
