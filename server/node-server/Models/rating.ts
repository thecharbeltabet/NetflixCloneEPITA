const mongoose = require('mongoose');

const RatingModel = new mongoose.Schema({
rating: {
type: Number,
},
commentTitle: {
type: String,
},
commentContent: {
type: String,
},
userId: {
type: String,
},
movieId: {
type: String,
}
});

export default mongoose.model('Rating', RatingModel);