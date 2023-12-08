package com.pepsico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-08T12:58:27.435673+05:30[Asia/Calcutta]")
@RestController
@RequestMapping("${openapi.mobiMenuAutomation.base-path:}")
public class V1ApiController implements V1Api {

    private final V1ApiDelegate delegate;

    public V1ApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) V1ApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new V1ApiDelegate() {});
    }

    @Override
    public V1ApiDelegate getDelegate() {
        return delegate;
    }

}
