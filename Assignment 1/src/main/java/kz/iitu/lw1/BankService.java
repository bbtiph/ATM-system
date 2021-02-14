package kz.iitu.lw1;

public interface BankService {
    public void CheckBalance(Account account);
    public void WithDraw(Account account);
    public void TopUp(Account account);
}
