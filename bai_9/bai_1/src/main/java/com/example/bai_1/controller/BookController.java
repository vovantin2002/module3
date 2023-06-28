package com.example.bai_1.controller;

import com.example.bai_1.model.Book;
import com.example.bai_1.model.Oder;
import com.example.bai_1.service.IBookService;
import com.example.bai_1.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Random;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IOrderService orderService;

    @GetMapping("")
    public String display(Model model) {
        model.addAttribute("books", bookService.display());
        return "list";
    }

    @GetMapping("/pay_book/{id}")
    public String showFormBorrow(@PathVariable int id, Model model) {
        if (id == 0) {
            model.addAttribute("id", "khong tim thay id.");
        }
        model.addAttribute("id", id);
        return "tra";
    }

    @GetMapping("/borrow_book/{id}")
    public String borrow(@PathVariable int id, RedirectAttributes redirectAttributes) {
        Book book = bookService.detail(id);
        if (book == null) {
            redirectAttributes.addFlashAttribute("msg", "khong tim thay id.");
        } else {
            Random random = new Random();
            String codeRandom = String.valueOf(random.nextInt(90000) + 10000);
            Oder oder = new Oder(codeRandom, book);
            orderService.create(oder);
            bookService.edit(book);
            redirectAttributes.addFlashAttribute("msg", "ma so muon sach cua ban la: " + codeRandom);
        }
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        Book book = bookService.detail(id);
        if (book == null) {
            model.addAttribute("msg", "khong tim thay id.");
        } else {
            model.addAttribute("books", book);
        }
        return "detail";
    }

    @PostMapping("/pay")
    public String payBook(@RequestParam int id, String code, Model model) {
        Oder oder = orderService.findById(code);
        if (oder != null) {
            orderService.delete(oder);
            Book book = bookService.detail(id);
            book.setQuantity(book.getQuantity() + 1);
            bookService.pay(book);
            model.addAttribute("msg", "tra sach thanh cong");
        } else {
            model.addAttribute("msg", "khong tim thay ma sach");
        }
        return "redirect:/";
    }
}
