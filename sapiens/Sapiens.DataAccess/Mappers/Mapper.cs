using Sapiens.DataAccess.Entities;
using Sapiens.Domain.Models;

namespace Sapiens.DataAccess.Mappers;

public class Mapper {

    public static AccountDetails mapAccount(AccountDataModel account)
    {
        return new AccountDetails
        {
            AccountId = account.AccountId,
            Name = account.Name,
            Email = account.Email,
        };
    }

    public static AccountDataModel mapAccount(AccountDetails account)
    {
        return new AccountDataModel
        {
            AccountId = account.AccountId,
            Name = account.Name,
            Email = account.Email,
        };
    }

}