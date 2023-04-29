using Microsoft.AspNetCore.Mvc;
using Sapiens.Domain.Interfaces;
using Sapiens.Domain.Models;

namespace Sapiens.Api.Controllers;

[ApiController]
[Route("api/[controller]")]
public class AccountsController : ControllerBase
{

    private readonly ILogger<AccountsController> _logger;
    private readonly IRepository _repository;

    public AccountsController(ILogger<AccountsController> logger, IRepository repository)
    {
        _logger = logger;
        _repository = repository;
    }

    [HttpPost(Name = "PostAccount")]
    public AccountDetails Post()
    {
        return new AccountDetails
        {
            AccountId = "1239083",
            Name = "Han",
            Email = "11231@mga.com",
        };
    }

    [HttpGet("{accountId}/{name}")]
    public Task<AccountDetails> GetAccountDetails(string accountId, string name)
    {
        return _repository.GetAccount(accountId, name);
    }

}
