package MediaSoft_5.Repository;

import MediaSoft_5.Entity.Visitor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class VisitorRepository {
    private final List<Visitor> data = new ArrayList<>();

    public void save(Visitor v) {
        data.add(v);
    }
    public void remove(Visitor v){
        data.remove(v);
    }

    public List<Visitor> findAll() {
        return List.copyOf(data);
    }
}
