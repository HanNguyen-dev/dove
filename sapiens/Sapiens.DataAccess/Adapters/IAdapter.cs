using Sapiens.DataAccess.Entities;

namespace Sapiens.DataAccess.Adapters;

public interface IAdapter
{
    public Task<AccountDataModel> GetAccountAsync(string accountId, string name);

    public void CreateAccountAsync(AccountDataModel account);
}
