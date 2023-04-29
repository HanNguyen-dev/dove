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
    public string PostAccount([FromBody] AccountDetails request)
    {
        _repository.CreateAccount(request);
        return "Your request has been successfully processed.";
    }

    [HttpGet("{accountId}/{name}")]
    public async Task<ActionResult<AccountDetails>> GetAccountDetails(string accountId, string name)
    {
        try
        {
            _logger.LogInformation("Get Account");
            var account = await _repository.GetAccount(accountId, name);
            return Ok(account);
        }
        catch (Exception e)
        {
            _logger.LogError(e.StackTrace);
            return NotFound(e.Message);
        }

    }

}
