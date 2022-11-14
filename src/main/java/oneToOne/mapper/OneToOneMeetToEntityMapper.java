package oneToOne.mapper;

import lombok.extern.java.Log;
import oneToOne.dto.RequestOneToOne;
import oneToOne.dto.ResponseOneToOne;
import oneToOne.model.OneToOneMeetEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
@Log
public abstract class OneToOneMeetToEntityMapper {
    @Mapping(source = "oneToOneMeetEntity.creatorId", target = "creatorId")
    @Mapping(source = "oneToOneMeetEntity.ownerId", target = "ownerId")
    @Mapping(source = "oneToOneMeetEntity.id", target = "id")
    public abstract ResponseOneToOne toDto(
            OneToOneMeetEntity oneToOneMeetEntity);

    @Mapping(source = "requestOneToOne.creatorId", target = "creatorId")
    @Mapping(source = "requestOneToOne.ownerId", target = "ownerId")
    public abstract OneToOneMeetEntity toEntity(
            RequestOneToOne requestOneToOne);

}
