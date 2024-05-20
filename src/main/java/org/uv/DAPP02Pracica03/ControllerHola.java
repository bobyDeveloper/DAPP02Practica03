package org.uv.DAPP02Pracica03;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class ControllerHola {

    @GetMapping(path = "/hola")
    public String msg() {
        return "Hola Mundo";
    }
}
