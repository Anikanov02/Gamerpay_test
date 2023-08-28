package com.gamerpay.test.controller;

import com.gamerpay.test.domain.dto.MessageDto;
import com.gamerpay.test.domain.response.PostMessageResponse;
import com.gamerpay.test.domain.model.Message;
import com.gamerpay.test.service.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @PostMapping("post")
    public ResponseEntity<PostMessageResponse> postMessage(@RequestBody @Valid MessageDto content, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            final Message saved = messageService.saveMessage(content);
            final PostMessageResponse dto = PostMessageResponse.convert(saved);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            final PostMessageResponse dto = PostMessageResponse.convert(content);
            final String message = bindingResult.getFieldError("content").getDefaultMessage();
            dto.setMessage(message);
            return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        }
    }
}
