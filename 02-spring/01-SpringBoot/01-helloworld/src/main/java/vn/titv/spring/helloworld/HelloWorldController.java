package vn.titv.spring.helloworld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Value("${khoahoc.name}")
    String KhoaHocName;

    @Value("${khoahoc.duration}")
    String KhoaHocDuration;

    @Value("${khoahoc.notes}")
    String KhoaHocNotes;

    @GetMapping("/")
    public String index(){
        return "Hello World!";
    }

    @GetMapping("/khoahoc")
    public String index2(){
        return "Hello, chào mừng bạn đến với khóa học " + KhoaHocName + "<br/>"
                + "Thời lượng của khóa học này là " + KhoaHocDuration + "<br/>"
                + KhoaHocNotes;
    }
}
