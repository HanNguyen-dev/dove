using Amazon.DynamoDBv2.DataModel;

namespace Sapiens.DataAccess.Entities;

[DynamoDBTable("account")]
public class AccountDataModel
{
    [DynamoDBHashKey("accountId")]
    public string AccountId { get; set; }

    [DynamoDBProperty("name")]
    public string Name { get; set; }

    [DynamoDBProperty("email")]

    public string Email { get; set; }
}
