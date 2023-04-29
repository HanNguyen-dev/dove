using Amazon.DynamoDBv2;
using Amazon.DynamoDBv2.DataModel;
using Sapiens.DataAccess.Entities;

namespace Sapiens.DataAccess.Adapters;

public class DynamoDbAdapter : IAdapter {

    private static AmazonDynamoDBClient _client;
    private static DynamoDBContext _context;

    public DynamoDbAdapter()
    {
        _client = new AmazonDynamoDBClient();
        _context = new DynamoDBContext(_client);
    }

    public Task<AccountDataModel> GetAccountAsync(string accountId, string name)
    {
        return _context.LoadAsync<AccountDataModel>(accountId, name);
    }

    public void CreateAccountAsync(AccountDataModel account)
    {
        _context.SaveAsync<AccountDataModel>(account);
    }
}