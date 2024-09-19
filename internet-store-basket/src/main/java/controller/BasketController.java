package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.BasketService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/store/order")
public class BasketController {

    private final BasketService service;

    public BasketController(BasketService service) {
        this.service = service;
    }

    @RequestMapping("/add")
    public String add(@RequestParam List<Integer> ids) {
        service.add(ids);
        return "Товары добавлены в корзину";
    }

    @RequestMapping("/get")
    public Collection<Integer> get() {
        return service.get();
    }

}

