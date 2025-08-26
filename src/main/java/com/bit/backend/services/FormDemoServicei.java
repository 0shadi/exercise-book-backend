package com.bit.backend.services;

import com.bit.backend.dtos.FormDemoDto;

import java.util.List;

//Interface
public interface FormDemoServicei {
    FormDemoDto addFormDemoEntity(FormDemoDto formDemoDto);

    List<FormDemoDto> getData();

    FormDemoDto updateForm(long id, FormDemoDto formDemoDto);

    FormDemoDto deleteFormDemo(long id);
}
