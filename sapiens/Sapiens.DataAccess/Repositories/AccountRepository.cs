using Sapiens.DataAccess.Adapters;
using Sapiens.DataAccess.Mappers;
using Sapiens.Domain.Interfaces;
using Sapiens.Domain.Models;

namespace Sapiens.DataAccess.Repositories;

public class AccountRepository : IRepository
{
    IAdapter _adapter;

    public AccountRepository(IAdapter adapter)
    {
        _adapter = adapter;
    }

    public async Task<AccountDetails> GetAccount(string accountId, string name)
    {
        var account = await _adapter.GetAccountAsync(accountId, name);
        return Mapper.mapAccount(account);
    }

    public void CreateAccount(AccountDetails accountDetails)
    {
        _adapter.CreateAccountAsync(Mapper.mapAccount(accountDetails));
    }
}