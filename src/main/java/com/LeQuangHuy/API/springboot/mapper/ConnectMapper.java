
import com.LeQuangHuy.API.springboot.model.Connect;
import com.LeQuangHuy.API.springboot.dto.ConnectDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ConnectMapper {

    @Mapping(source = "user.id", target = "userId")
    ConnectDTO connectToDTO (Connect connect);
    Connect toEntity(ConnectDTO connectDTO);
}
