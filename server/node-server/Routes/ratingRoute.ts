import express from 'Express';
import RatingModel from '../Models/rating';

const router = express.Router();



// post a rating
router.post('/postRating', async (req: express.Request, res: express.Response) => {
  const { rating, commentTitle, commentContent, userId, movieId } = req.body;
  const newRating = new RatingModel({
    rating,
    commentTitle,
    commentContent,
    userId,
    movieId
  });
  try {
    const savedRating = await newRating.save();
    res.status(200).json(savedRating);
  } catch (error) {
    res.status(400).json({ message: Error });
  }
});

// get a rating by movieId
router.get('/ratings/movieId/:movieId', async (req: express.Request , res: express.Response) => {
  const { movieId } = req.params;
  try {
    const ratings = await RatingModel.find({ movieId });
    res.send(ratings);
  } catch (err) {
    res.send(err);
  }
});

// get all ratings
router.get('/ratings', async (req: express.Request, res: express.Response) => {
  try {
    const ratings = await RatingModel.find();
    res.send(ratings);
  } catch (err) {
    res.send(err);
  }
});

module.exports = router ;
