package oneToOne.mapper;

import javax.annotation.Generated;
import oneToOne.dto.RequestOneToOne;
import oneToOne.dto.ResponseOneToOne;
import oneToOne.model.OneToOneMeetEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-14T09:48:15+0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class OneToOneMeetToEntityMapperImpl extends OneToOneMeetToEntityMapper {

    @Override
    public ResponseOneToOne toDto(OneToOneMeetEntity oneToOneMeetEntity) {
        if ( oneToOneMeetEntity == null ) {
            return null;
        }

        ResponseOneToOne responseOneToOne = new ResponseOneToOne();

        responseOneToOne.setCreatorId( oneToOneMeetEntity.getCreatorId() );
        responseOneToOne.setOwnerId( oneToOneMeetEntity.getOwnerId() );
        responseOneToOne.setId( oneToOneMeetEntity.getId() );
        responseOneToOne.setDateTime( oneToOneMeetEntity.getDateTime() );
        responseOneToOne.setComment( oneToOneMeetEntity.getComment() );
        responseOneToOne.setStatus( oneToOneMeetEntity.getStatus() );

        return responseOneToOne;
    }

    @Override
    public OneToOneMeetEntity toEntity(RequestOneToOne requestOneToOne) {
        if ( requestOneToOne == null ) {
            return null;
        }

        OneToOneMeetEntity oneToOneMeetEntity = new OneToOneMeetEntity();

        oneToOneMeetEntity.setCreatorId( requestOneToOne.getCreatorId() );
        oneToOneMeetEntity.setOwnerId( requestOneToOne.getOwnerId() );
        oneToOneMeetEntity.setId( requestOneToOne.getId() );
        oneToOneMeetEntity.setDateTime( requestOneToOne.getDateTime() );
        oneToOneMeetEntity.setComment( requestOneToOne.getComment() );
        oneToOneMeetEntity.setStatus( requestOneToOne.getStatus() );

        return oneToOneMeetEntity;
    }
}
