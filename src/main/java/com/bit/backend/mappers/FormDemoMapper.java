package com.bit.backend.mappers;

import com.bit.backend.dtos.FormDemoDto;
import com.bit.backend.entities.FormDemoEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

//Map data between DTO and Entity
@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface FormDemoMapper {

    //Map Entity to DTO (Take Entity as input and output DTO using the function toFormDemoDTO)
    FormDemoDto toFormDemoDto(FormDemoEntity FormDemoEntity);
    //Map DTO to Entity (Take DTO as input and output Entity using the function toFormDemoEntity)
    FormDemoEntity toFormDemoEntity(FormDemoDto FormDemoDto);

    List<FormDemoDto> toFormDemoDtoList(List<FormDemoEntity> formDemoEntityList);
}
