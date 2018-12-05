package com.example.demo.controller;

import com.example.demo.bean.ImageForm;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ncavallo on 5/20/2015.
 */
@Controller
public class QrCodeController {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private UserService userService;
    private final Integer id = 1;
    private final Integer price = 2893;

    @RequestMapping(value = "/qrcode/create", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createCode(@RequestBody ImageForm imageForm, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("imageForm", imageForm);

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("status", "OK");
        model.put("location", "/qrcode/view");
        return model;
    }

    @RequestMapping(value = "/qrcode/view", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public void viewCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        ImageForm form = (ImageForm) session.getAttribute("imageForm");
        if (form == null) {
            throw new CodeNotFoundException();
        }

        QRCode.from(objectMapper.writeValueAsString(form)).to(ImageType.JPG).withSize(256, 256).writeTo(response.getOutputStream());
    }

    @RequestMapping(value = "/qrcode/payment",method = RequestMethod.GET)
    public @ResponseBody String paymentuser(){
        userService.updateuser(id,price);
        return "Succesfully";


    }
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Code not found")
    public static class CodeNotFoundException extends RuntimeException {}

}
