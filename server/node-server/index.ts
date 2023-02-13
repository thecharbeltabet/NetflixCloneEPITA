import * as dotenv from 'dotenv';
import * as express from 'express';
import * as mongoose from 'mongoose';
import * as cors from 'cors';

dotenv.config();

const mongoURL = process.env.DB_URL;
const routes = require('./Routes/ratingRoute');

mongoose.connect(mongoURL, {
useNewUrlParser: true,
useUnifiedTopology: true,
});

const database = mongoose.connection;

database.on('error', (error) => {
console.log(error);
});

database.once('connected', () => {
console.log('Database Connected');
});

const app = express();

app.use(cors({
credentials: true,
origin: 'http://localhost:3000',
}));

app.use(express.json());
app.use('/api', routes);

app.listen(4000, () => {
console.log(`Server Started at ${4000}`);
});



