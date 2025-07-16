package MediaSoft_5.Services;

import MediaSoft_5.Entity.Visitor;
import MediaSoft_5.Repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitorService {
    private final VisitorRepository repo;

    public void save(Visitor v) { repo.save(v); }
    public void remove(Visitor v) { repo.remove(v); }
    public List<Visitor> findAll() { return repo.findAll(); }
}
