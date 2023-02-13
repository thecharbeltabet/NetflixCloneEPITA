import * as mongoose from 'mongoose';

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

export default mongoose.model<mongoose.Document>('Rating', RatingModel);