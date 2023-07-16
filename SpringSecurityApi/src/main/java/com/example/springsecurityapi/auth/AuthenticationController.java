package com.example.springsecurityapi.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final AuthenticationRequestValidator authenticationRequestValidator;

    @InitBinder("authenticationRequest")
    protected void initAuthenticationRequestBinder(WebDataBinder binder) {
        binder.addValidators(authenticationRequestValidator);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @Valid @RequestBody RegisterRequest request,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(new AuthenticationResponse(errors));
        }
        try{
            return ResponseEntity.ok(service.register(request));
        }catch(IllegalArgumentException e){
            List<String> errors = new ArrayList<>();
            errors.add(e.getMessage());
            return ResponseEntity.badRequest().body(new AuthenticationResponse(errors));
        }
    }

@PostMapping("/login")
public ResponseEntity<AuthenticationResponse> login(
        @Valid @RequestBody AuthenticationRequest request,
        BindingResult bindingResult
) {
    if (bindingResult.hasErrors()) {
        List<String> errors = bindingResult.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(new AuthenticationResponse(errors));
    }

    try {
        return ResponseEntity.ok(service.authenticate(request));
    } catch (IllegalArgumentException e) {
        List<String> errors = new ArrayList<>();
        errors.add(e.getMessage());
        return ResponseEntity.badRequest().body(new AuthenticationResponse(errors));
    }
}
}

