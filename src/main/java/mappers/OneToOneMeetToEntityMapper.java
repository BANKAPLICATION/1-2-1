package mappers;

import com.rm.toolkit.onetoone.dtos.OneToOneEdit;
import com.rm.toolkit.onetoone.dtos.RequestOneToOne;
import com.rm.toolkit.onetoone.dtos.ResponseOneToOne;
import com.rm.toolkit.onetoone.dtos.UserInfo;
import com.rm.toolkit.onetoone.model.NotificationEntity;
import com.rm.toolkit.onetoone.model.OneToOneMeetEntity;
import com.rm.toolkit.onetoone.services.UserService;
import com.rm.toolkit.onetoone.services.exceptions.OneToOneException;
import lombok.extern.java.Log;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
@Log
public abstract class OneToOneMeetToEntityMapper {
    @Autowired
    private UserService userService;

    @Mapping(source = "oneToOneMeetEntity.creatorId", target = "creatorId")
    @Mapping(source = "oneToOneMeetEntity.ownerId", target = "ownerId")
    @Mapping(source = "oneToOneMeetEntity.id", target = "id")
    public abstract ResponseOneToOne toDto(
            OneToOneMeetEntity oneToOneMeetEntity);

    @Mapping(source = "requestOneToOne.creatorId", target = "creatorId")
    @Mapping(source = "requestOneToOne.ownerId", target = "ownerId")
    public abstract OneToOneMeetEntity toEntity(
            RequestOneToOne requestOneToOne);

    @AfterMapping
    public OneToOneMeetEntity addOneToOneToNotifications(
            @MappingTarget OneToOneMeetEntity oneToOneMeetEntity) {
        if (oneToOneMeetEntity.getNotifications() == null || oneToOneMeetEntity.getNotifications().isEmpty()) {
            return oneToOneMeetEntity;
        }

        for (NotificationEntity notification : oneToOneMeetEntity.getNotifications()) {
            notification.setOneToOneMeetEntity(oneToOneMeetEntity);
        }
        return oneToOneMeetEntity;
    }

    @AfterMapping
    public void addNamesToOneToOne(@MappingTarget ResponseOneToOne responseOneToOne) {

        UserInfo creator = userService.getUser(responseOneToOne.getCreatorId());
        UserInfo owner = findSubordinateInfo(creator, responseOneToOne.getOwnerId());

        responseOneToOne.setCreatorName(creator.getName());
        responseOneToOne.setCreatorSurname(creator.getSurname());
        responseOneToOne.setCreatorEmail(creator.getEmail());

        responseOneToOne.setOwnerName(owner.getName());
        responseOneToOne.setOwnerSurname(owner.getSurname());
        responseOneToOne.setOwnerEmail(owner.getEmail());
    }

    private UserInfo findSubordinateInfo(UserInfo rm, Long ownerId) {
        if (!rm.getRole().getName().matches("ROLE_RD|ROLE_RM|ROLE_SRM|ROLE_ARM")) {
            throw new OneToOneException("The user with " + rm.getRole().getName() + " role can't plan one-to-one meeting.");
        }
        return rm.getSubordinates()
                .stream()
                .filter(sub -> sub.getId().equals(ownerId))
                .findFirst()
                .orElseThrow(() -> new OneToOneException("Not in subordinates, if not creator"));
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "dateTime", ignore = true),
            @Mapping(target = "creatorId", ignore = true),
            @Mapping(target = "ownerId", ignore = true),
            @Mapping(target = "status", ignore = true)
    })
    public abstract OneToOneMeetEntity updateOneToOne(
            @MappingTarget OneToOneMeetEntity oneToOneMeetEntity, OneToOneEdit oneToOneEdit);
}
