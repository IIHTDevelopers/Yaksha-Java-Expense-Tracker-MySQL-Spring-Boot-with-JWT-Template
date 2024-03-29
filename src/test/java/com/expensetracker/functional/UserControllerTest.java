package com.expensetracker.functional;

import static com.expensetracker.utils.TestUtils.businessTestFile;
import static com.expensetracker.utils.TestUtils.currentTest;
import static com.expensetracker.utils.TestUtils.testReport;
import static com.expensetracker.utils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.expensetracker.controller.UserController;
import com.expensetracker.entity.User;
import com.expensetracker.service.impl.JwtService;
import com.expensetracker.service.impl.UserInfoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserInfoService userInfoService;

	@MockBean
	private JwtService jwtService;

	@InjectMocks
	private UserController userController;

	@Autowired
	private AuthenticationManager authenticationManager;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testAddNewUserWithMockAuthentication() throws Exception {
		try {
			User user = new User();
			user.setName("abc");
			user.setEmail("abc@abc.com");
			user.setPassword("abc");
			user.setRoles("ROLE_USER");
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken("abc", "abc"));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			when(userInfoService.addUser(user)).thenReturn("User Added Successfully");
			MvcResult result = mockMvc
					.perform(MockMvcRequestBuilders.post("/api/auth/addNewUser").content(asJsonString(user))
							.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
			int actualStatus = result.getResponse().getStatus();
			yakshaAssert(currentTest(), actualStatus == 200, businessTestFile);
		} catch (Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}

	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}