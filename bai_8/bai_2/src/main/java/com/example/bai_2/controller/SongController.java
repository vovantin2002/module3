package com.example.bai_2.controller;

import com.example.bai_2.model.Song;
import com.example.bai_2.dto.SongDto;
import com.example.bai_2.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
            SongDto songDto=new SongDto();
            BeanUtils.copyProperties(songService.showFormEdit(id),songDto);
            model.addAttribute("song", songDto);
            return "edit";
        } else {
            model.addAttribute("msg", "Không tìm thấy id này");
            return "/list";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (songService.delete(id)){
            redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        }else {
            redirectAttributes.addAttribute("msg", "Không tìm thấy id này");
        }
        return "redirect:/";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult,Model model, RedirectAttributes redirectAttributes) {
        new SongDto().validate(songDto,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("song",songDto);
            return "edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        this.songService.update(song);
        redirectAttributes.addFlashAttribute("msg", "Sửa thành công");
        return "redirect:/";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("song", songDto);
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.create(song);
        return "redirect:/";
    }
}
