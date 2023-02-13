import express from 'express';
import RatingModel from '../Models/rating';

const router = express.Router();

// post a rating
router.post('/post', async (req, res) => {
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
    res.status(400).json({ message: error.message });
  }
});

// get a rating by movieId
router.get('/ratings/movieId/:movieId', async (req, res) => {
  const { movieId } = req.params;
  try {
    const ratings = await RatingModel.find({ movieId });
    res.send(ratings);
  } catch (err) {
    res.send(err);
  }
});

// get all ratings
router.get('/ratings', async (req, res) => {
  try {
    const ratings = await RatingModel.find();
    res.send(ratings);
  } catch (err) {
    res.send(err);
  }
});

export default router;
