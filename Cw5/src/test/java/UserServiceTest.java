import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

    class UserServiceTest {

        @Test
        void shouldSendWelcomeEmail() {
            final var mockEmailService = mock(EmailService.class);
            final var userService = new UserService(null, mockEmailService);
            userService.sendWelcomeEmail("test@email.co");
            final var expectedEmail = new EmailBody("Welcome", "Welcome to the portal", "test@email.co");
            verify(mockEmailService).send(expectedEmail);
        }
        @Test
        void shouldSendRegisteredPhoneNumberIfUserAccountExists() throws NotFoundException {
            final var mockEmailService = mock(EmailService.class);
            final var stubUserRepository = mock(UserRepository.class);
            when(stubUserRepository.findByEmail("existing@user.com"))
                    .thenReturn(new User("1122334455", "existing@user.com", "Existing User"));
            final var userService = new UserService(stubUserRepository, mockEmailService);
            userService.sendRegisteredPhoneNumber("existing@user.com");
            final var expected = new EmailBody("Account Details",
                    "Here is your Registered Phone Number: \n" + "1122334455",
                    "existing@user.com");
            verify(mockEmailService).send(expected);
        }

        @Test
        void sendAccountNotFoundEmailForUnregisteredUsersWhenTryingToGetRegisteredPhoneNumber() throws NotFoundException {
            final var mockEmailService = mock(EmailService.class);
            final var stubUserRepository = mock(UserRepository.class);
            when(stubUserRepository.findByEmail("other@user.com")).thenThrow(new NotFoundException());

            final var userService = new UserService(stubUserRepository, mockEmailService);
            userService.sendRegisteredPhoneNumber("other@user.com");
            final var expected = new EmailBody("Account Not Found",
                    "We do not have a registered account matching your email address",
                    "other@user.com");
            verify(mockEmailService).send(expected);
        }

    }