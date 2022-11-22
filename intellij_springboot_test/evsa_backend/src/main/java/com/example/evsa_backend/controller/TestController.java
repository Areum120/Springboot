package com.example.evsa_backend.controller;
import com.example.evsa_backend.dto.Info;
import com.example.evsa_backend.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController//@ResponseBody를 지원하는 컨트롤러라는 의미로, return 시킨 ResponseEntity를 ResponseBody에 담아 반환한다
@RequestMapping("/test")//받은 request에서 contextPath 이후에 시작되는 path에 대해 해당 컨트롤러로 mapping을 시킨다. localhost:8080/test로 시작하는 요청에 대ㅐ 컨트롤러로 맵핑시킴

public class TestController {
    private final TestService testService;//service 인스턴스 생성, @service와 동시에 Bean으로 등록되어 Constructor에서 Parameter로 받아 사용함

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/get")//get방식으로 호출된 리퀘스트에 대해 mapping함
    ResponseEntity<?> getHelloWorld(@RequestParam(required = false) String name){//@RequestParam: query string을 mapping함, required 옵션으로 필수값 체크 ex) http://localhost:8080/test/get/name=kim)
        return new ResponseEntity<>(testService.myName(name), HttpStatus.OK);
    }

    @PostMapping("/post/{age}")
    ResponseEntity<?> postHelloWorld(@PathVariable("age") Integer age){//@PathVariable: 해당 path 값을 mapping한다. (ex) http://localhost:8080/test/post/50)
        return new ResponseEntity<>(testService.myAge(age), HttpStatus.OK);
    }

    @PutMapping("/put")
    ResponseEntity<?> putHelloWorld(@RequestBody Info info){//@RequestBody: body에 담긴 객체를 mapping
        return new ResponseEntity<>(testService.myInfo(info), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    ResponseEntity<?> deleteHelloWorld(@RequestHeader String role, @RequestBody Info info){//@RequestHeader: 헤더 중 파라미터 명과 이름이 같은 header 값을 가져온다.
        return new ResponseEntity<>(testService.myInfoWithRole(role, info), HttpStatus.OK);
    }

}
