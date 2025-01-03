package jp.tyabata.sample.apisamplegraalvm;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SampleController {


    @GetMapping("/v1/test")
    public ResponseEntity<String> getTest() {

        log.info("sample!!!");

        return ResponseEntity.ok("Hello World");
    }
}
