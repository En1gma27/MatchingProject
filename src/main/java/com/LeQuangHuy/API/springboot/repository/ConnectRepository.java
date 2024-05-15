import com.LeQuangHuy.API.springboot.model.Connect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ConnectRepository extends JpaRepository<Connect, Long> {

    List<Connect> findByUserId (Long userId);
    List<Connect> findByType(String type);
    List<Connect> findByUserIdAndType(Long userId, String type);


}
