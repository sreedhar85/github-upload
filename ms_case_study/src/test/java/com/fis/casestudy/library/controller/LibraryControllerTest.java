package com.fis.casestudy.library.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fis.casestudy.library.controller.LibraryController;
import com.fis.casestudy.library.service.LibraryService;

@ExtendWith(MockitoExtension.class)
public class LibraryControllerTest
{
    @Mock
    LibraryService    libService;

    @InjectMocks
    LibraryController libController;

    @Autowired
    private MockMvc   mockMvc;

    @BeforeEach
    public void setup()
    {
        mockMvc = MockMvcBuilders.standaloneSetup(libController).build();
    }

    @Test
    void getAllBooksShouldReturnStatusIsOk() throws Exception
    {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/library/books").accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void getSubsciptionByNameShouldReturnStatusIsOk() throws Exception
    {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
            .get("/library/subscriptions/naveen")
            .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(libService, Mockito.times(1)).getAllSubscriptions(Mockito.eq("naveen"));
    }

}
