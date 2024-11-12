package com.assign.entrance.web;

import com.assign.entrance.service.IdentityCardAreaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;

import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {IdentityCardAreaController.class, IdentityCardAreaService.class})
@ActiveProfiles({"uat"})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class IdentityCardAreaControllerTest {
    @Autowired
    private IdentityCardAreaController identityCardAreaController;

    @MockBean
    private IdentityCardAreaService identityCardAreaService;

    /**
     * Method under test:
     * {@link IdentityCardAreaController#selectIdentityCardArea()}
     */
    @Test
    void testSelectIdentityCardArea() throws Exception {
        // Arrange
        when(identityCardAreaService.selectIdentityCardArea()).thenReturn(new HashMap<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/identity/card/area/group");
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(identityCardAreaController).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":200,\"data\":{},\"message\":\"SUCCESS\",\"status\":\"OK\"}"));
    }


}
