package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class WebController {
    private final List<Integer> numbers = List.of(10, 5, 3, 12, 6, 7, 5, 3);

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Integer sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        model.addAttribute("numbers", Collections.singletonList(sum));
        return "result";
    }

    @GetMapping("/max")
    public String findMax(Model model) {
        Integer maxValue = numbers.stream()
                .max(Integer::compareTo)
                .orElse(null);
        model.addAttribute("numbers", Collections.singletonList(maxValue));
        return "result";
    }

    @GetMapping("/min")
    public String findMin(Model model) {
        Integer minValue = numbers.stream()
                .min(Integer::compareTo)
                .orElse(null);
        model.addAttribute("numbers", Collections.singletonList(minValue));
        return "result";
    }

    @GetMapping("/sum")
    public String calculateSum(Model model) {
        Integer sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        model.addAttribute("numbers", Collections.singletonList(sum));
        return "result";
    }

    @GetMapping("/distinct")
    public String findDistinct(Model model) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        model.addAttribute("numbers", distinctNumbers);
        return "result";
    }

    @GetMapping("/first-five")
    public String getFirstFive(Model model) {
        List<Integer> firstFive = numbers.stream()
                .limit(5)
                .collect(Collectors.toList());
        model.addAttribute("numbers", firstFive);
        return "result";
    }

    @GetMapping("/third-to-fifth")
    public String getThirdToFifth(Model model) {
        List<Integer> thirdToFifth = numbers.stream()
                .skip(2)
                .limit(3)
                .collect(Collectors.toList());
        model.addAttribute("numbers", thirdToFifth);
        return "result";
    }

    @GetMapping("/first-greater-than-5")
    public String getFirstGreaterThan5(Model model) {
        Optional<Integer> firstGreaterThan5 = numbers.stream()
                .filter(n -> n > 5)
                .findFirst();
        List<Integer> result = firstGreaterThan5.map(Collections::singletonList)
                .orElse(Collections.emptyList());
        model.addAttribute("numbers", result);
        return "result";
    }
}