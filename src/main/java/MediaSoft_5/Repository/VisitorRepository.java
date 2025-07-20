package MediaSoft_5.Repository;

import MediaSoft_5.Entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface VisitorRepository extends JpaRepository<Visitor, Long> {
}
