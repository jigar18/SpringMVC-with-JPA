//package com.training.jpacode.controller;
//
//import com.training.jpacode.domain.Student;
//import com.training.jpacode.service.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
//@Controller
//public class StudentController {
//    @Autowired
//    private StudentService studentService;
//
//    @RequestMapping("/")
//    public String indexPage(Model model) {
//        List<Student> student = studentService.findAllStudents();
//        model.addAttribute("student", student);
//        return "index";
//    }
//
//    @RequestMapping("new")
//    public String newPage(Model model) {
//        Student student = new Student();
//        model.addAttribute("student", student);
//        return "new_student";
//    }
//
//    @RequestMapping("edit/{id}")
//    public ModelAndView editPage(@PathVariable int id) {
//        ModelAndView modelAndView = new ModelAndView("edit_student");
//        Student student = studentService.getStudentById(id);
//        modelAndView.addObject("student", student);
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public String save(@ModelAttribute("student")Student student) {
//        studentService.saveStudent(student);
//        return "redirect:/";
//    }
//
//    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
//    public String cancel() {
//        return "redirect:/";
//    }
//
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    public String delete(@PathVariable(name = "id") int id) {
//        studentService.deleteStudent(id);
//        return "redirect:/";
//    }
//}
