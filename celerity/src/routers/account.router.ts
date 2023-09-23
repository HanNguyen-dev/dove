import express, { Request, Response } from 'express';
import { ddbDocClient } from '../services/DynamoDbSevice';
import { GetCommand, PutCommand } from '@aws-sdk/lib-dynamodb';
import { json } from 'body-parser';

const router = express.Router();

router.use(json());

router.get("/:accountId/name/:name", (req: Request, resp: Response) => {
  const { accountId, name } = req.params;
  req.cookies.user


    if (accountId && name) {
      const params = {
        TableName: "account",
        Key: {
          "accountId": accountId,
          "name": name,
        },
      };

      ddbDocClient.send(new GetCommand(params))
                  .then(result => {
                    if (result.Item) {
                      resp.json(result.Item)
                    } else {
                      throw "not found"
                    }
                  })
                  .catch(err => {
                    resp.status(404)
                        .send("Your requested resource doesn't exist");
                  });
    } else {
      resp.status(400)
          .send("Please try again");
    }
});
// router.use(urlencoded({ extended: true }));

router.post("/", (req: Request, resp: Response) => {
  const { accountId, name, email } = req.body;

  if (accountId && name && email) {
    const params = {
      TableName: "account",
      Item: {
        "accountId": accountId,
        "name": name,
        "email": email,
      },
    };

    console.log(params);

    ddbDocClient.send(new PutCommand(params))
                .then(result => {
                  console.log(result);
                  resp.send("Your request has been completed");
                })
                .catch(err => {
                  resp.status(500)
                      .send("Your requested resource doesn't exist");
                });
  } else {
    resp.status(400)
        .send("Please try again");
  }
  // resp.send("hello");
});

export const accountRouter = router;
