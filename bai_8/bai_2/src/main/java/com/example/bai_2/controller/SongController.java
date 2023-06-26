package com.example.bai_2.controller;

import com.example.bai_2.model.Song;
import com.example.bai_2.model.dto.SongDto;
import com.example.bai_2.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String display(Model model) {
        model.addAttribute("songs", songService.display());
        return "list";
    }
    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable int id, Model model) {
        if (this.songService.showFormEdit(id) != null) {
            model.addAttribute("appSong", songService.showFormEdit(id));
            return "edit";
        } else {
            model.addAttribute("msg", "Không tìm thấy id này");
            return "/list";
        }
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        songService.delete(id);
        redirectAttributes.addFlashAttribute("msg","Xóa thành công");
        return "edit";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }
    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        this.songService.update(song);
        redirectAttributes.addFlashAttribute("msg", "Sửa thành công");
        return "redirect:/";
    }
    @PostMapping("/create")
    public String create(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        this.songService.create(song);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/";
    }
}
