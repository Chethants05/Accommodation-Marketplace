package com.dcl.accommodate.Controller;

import com.dcl.accommodate.DTO.Wrapper.ApiAck;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class BaseController {

    @GetMapping("/health")
    public ResponseEntity<ApiAck> health(){
        return ResponseEntity.ok(
                new ApiAck(
                        true,
                        "Accomadation marketplace is up and running"
                ));
    }
}
