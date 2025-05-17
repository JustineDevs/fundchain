package com.fundchain.controller;

import com.fundchain.entity.Project;
import com.fundchain.service.ProjectService;
import com.fundchain.service.EthereumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private EthereumService ethereumService;

    @GetMapping
    public String explore(Model model, @RequestParam(defaultValue = "") String search) {
        model.addAttribute("projects", projectService.searchProjects(search));
        return "explore";
    }

    @PostMapping("/create")
    public String createProject(@ModelAttribute Project project,
                              @RequestParam("image") MultipartFile image,
                              Authentication authentication) {
        projectService.createProject(project, image, authentication.getName());
        return "redirect:/dashboard";
    }

    @PostMapping("/{id}/fund")
    public String fundProject(@PathVariable Long id,
                            @RequestParam BigDecimal amount,
                            @RequestParam String privateKey) throws Exception {
        projectService.fundProject(id, amount, privateKey);
        return "redirect:/projects/" + id;
    }

    @GetMapping("/{id}")
    public String viewProject(@PathVariable Long id, Model model) {
        model.addAttribute("project", projectService.getProject(id));
        model.addAttribute("balance", ethereumService.getBalance(projectService.getProject(id).getEthereumAddress()));
        return "projects";
    }
}