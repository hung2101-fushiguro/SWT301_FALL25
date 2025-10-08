import hungth.example.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testing account registration functionality from a CSV file")
class AccountServiceTest {

    private AccountService accountService;

    @BeforeEach
    void setUp() {
        accountService = new AccountService();
    }

    @DisplayName("Verify registration scenarios from the test-data.csv file")
    @ParameterizedTest(name = "Test case #{index}: user={0}, pass={1}, email={2} -> expected={3}")
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void testRegisterAccount_FromCsvFile(String username, String password, String email, boolean expected) {
        // Convert an empty string from the CSV (representing null) to an actual null object
        if ("".equals(username)) {
            username = null;
        }

        // 1. Act: Execute the method under test
        boolean actual = accountService.registerAccount(username, password, email);

        // 2. Assert: Compare the actual result with the expected result from the CSV file
        assertEquals(expected, actual);
    }
}
