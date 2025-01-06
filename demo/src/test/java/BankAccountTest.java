import com.example.models.BankAccount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void testInitialBalance() {
        BankAccount account = new BankAccount(1000);
        assertEquals(1000, account.getBalance(), "Initial balance should be 1000.");
    }

    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount(1000);
        account.deposit(500);
        assertEquals(1500, account.getBalance(), "Balance after deposit should be 1500.");
    }

    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount(1000);
        account.withdraw(300);
        assertEquals(700, account.getBalance(), "Balance after withdrawal should be 700.");
    }

    @Test
    public void testWithdrawInsufficientBalance() {
        BankAccount account = new BankAccount(1000);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(1500);
        });
        assertEquals("Insufficient balance.", exception.getMessage());
    }

    @Test
    public void testNegativeDeposit() {
        BankAccount account = new BankAccount(1000);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-500);
        });
        assertEquals("Deposit amount must be positive.", exception.getMessage());
    }

    @Test
    public void testNegativeInitialBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount(-100);
        });
        assertEquals("Initial balance cannot be negative.", exception.getMessage());
    }
}
