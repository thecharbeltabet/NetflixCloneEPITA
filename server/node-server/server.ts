require('dotenv').config();
const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');


const mongoURL = process.env.DB_URL;
console.log(mongoURL)


const routes = require('./Routes/ratingRoute');

mongoose.connect(mongoURL, {
useNewUrlParser: true,
useUnifiedTopology: true,
});

const database = mongoose.connection;

database.on('error', (error: Error) => {
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

app.listen(process.env.PORT, () => {
    
console.log(`Server Started at ${4000}`);
});



