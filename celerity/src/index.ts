import express, { Request, Response } from 'express';
import { accountRouter } from './routers/account.router';

let app = express();

app.use("/accounts", accountRouter);

app.listen(3000, () => {
  console.log('Listen on port 3000');
});