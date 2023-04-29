using Sapiens.Domain.Models;

namespace Sapiens.Domain.Interfaces;

public interface IRepository {
    public Task<AccountDetails> GetAccount(string accountId, string name);

    public void CreateAccount(AccountDetails account);
}