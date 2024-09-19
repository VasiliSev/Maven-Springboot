package service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Service
public class BasketService {

    private final Basket basket;

    public BasketService(Basket basket) {
        this.basket = basket;
    }

    public void add(List<Integer> ids) {
        basket.addItems(ids);
    }

    public Collection<Integer> get() {
        return basket.getItems();
    }

    @Component
    @SessionScope
    public static class Basket {

        private final Set<Integer> items = new HashSet<>();

        public void addItems(List<Integer> ids) {
            items.addAll(ids);
        }

        public Collection<Integer> getItems() {
            return Collections.unmodifiableSet(items);
        }

    }
}
