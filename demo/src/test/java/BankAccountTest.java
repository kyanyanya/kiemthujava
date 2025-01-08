import com.example.models.BankAccount;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount(1000); // Số dư khởi tạo
    }

    @Test
    public void testInitialBalanceIsCorrect() {
        assertEquals(1000, account.getBalance(), "Initial balance should be 1000.");
    }

    @Test
    public void testDepositWithPositiveAmount() {
        account.deposit(500);
        assertEquals(1500, account.getBalance(), "Balance after depositing 500 should be 1500.");
    }

    @Test
    public void testDepositWithZeroAmountThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(0);
        });
        assertEquals("Deposit amount must be positive.", exception.getMessage());
    }

    @Test
    public void testDepositWithNegativeAmountThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-100);
        });
        assertEquals("Deposit amount must be positive.", exception.getMessage());
    }

    @Test
    public void testWithdrawWithSufficientBalance() {
        account.withdraw(200);
        assertEquals(800, account.getBalance(), "Balance after withdrawing 200 should be 800.");
    }

    @Test
    public void testWithdrawExactBalance() {
        account.withdraw(1000);
        assertEquals(0, account.getBalance(), "Balance after withdrawing exact balance should be 0.");
    }

    @Test
    public void testWithdrawWithInsufficientBalanceThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(1500);
        });
        assertEquals("Insufficient balance.", exception.getMessage());
    }

    @Test
    public void testWithdrawWithNegativeAmountThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-200);
        });
        assertEquals("Withdraw amount must be positive.", exception.getMessage());
    }

    @Test
    public void testInitialBalanceCannotBeNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount(-500);
        });
        assertEquals("Initial balance cannot be negative.", exception.getMessage());
    }

    @Test
    public void testAccountBalanceAfterMultipleOperations() {
        account.deposit(500);
        account.withdraw(300);
        assertEquals(1200, account.getBalance(), "Balance after depositing 500 and withdrawing 300 should be 1200.");
    }

    @Test
    public void testEdgeCaseWithZeroInitialBalance() {
        BankAccount zeroBalanceAccount = new BankAccount(0);
        assertEquals(0, zeroBalanceAccount.getBalance(), "Balance for account initialized with 0 should be 0.");
    }

    @Test
    public void testEdgeCaseWithMaxDoubleBalance() {
        BankAccount maxBalanceAccount = new BankAccount(Double.MAX_VALUE);
        assertEquals(Double.MAX_VALUE, maxBalanceAccount.getBalance(), "Initial balance should be Double.MAX_VALUE.");
    }
}
