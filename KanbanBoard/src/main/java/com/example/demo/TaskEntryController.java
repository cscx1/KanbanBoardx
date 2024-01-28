package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TaskEntryController {

    @GetMapping("/tasks/entry/{column}")
    public String showTaskEntryForm(@PathVariable String column, Model model) {
        model.addAttribute("column", column.toUpperCase());
        return "task-entry"; // Return the name of the HTML template
    }
}
