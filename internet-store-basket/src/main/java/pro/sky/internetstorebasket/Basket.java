package pro.sky.internetstorebasket;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Component
@SessionScope
public class Basket {

    private final Set<Integer> items = new HashSet<>();

    public void addItems(List<Integer> ids) {
        items.addAll(ids);
    }

    public Collection<Integer> getItems() {
        return Collections.unmodifiableSet(items);
    }

}

