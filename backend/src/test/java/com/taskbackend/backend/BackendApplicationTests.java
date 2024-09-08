package com.taskbackend.backend;
import com.taskbackend.backend.dto.AddressDTO;
import com.taskbackend.backend.dto.SubmitRequest;
import com.taskbackend.backend.model.SubmitModel;
import com.taskbackend.backend.repository.SubmitRepository;
import com.taskbackend.backend.service.SubmitService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class SubmitServiceTest {
	@Mock
	private SubmitRepository submitRepository;
	@InjectMocks
	private SubmitService submitService;
	@Test
	void testIntakeSubmit() {
		SubmitRequest submitRequest = new SubmitRequest("John", "Doe", new AddressDTO("123 Main St", "Toronto", "M1G3T1"));
		SubmitModel submitModel = SubmitModel.builder()
				.firstName("John")
				.lastName("Doe")
				.addressLine("123 Main St")
				.city("Toronto")
				.postalCode("M1G3T1")
				.build();
		when(submitRepository.save(any(SubmitModel.class))).thenReturn(submitModel);
		submitService.intakeSubmit(submitRequest);
		verify(submitRepository).save(any(SubmitModel.class));
	}
	@Test
	void testIsValidPostalCode() {
		String validPostalCode = "M1G3T1";
		String invalidPostalCode = "X1X1X1";
		assertThat(submitService.isValidPostalCode(validPostalCode)).isTrue();
		assertThat(submitService.isValidPostalCode(invalidPostalCode)).isFalse();
	}
}
