import axios from 'axios';

// This is the base URL for the node microservice
const baseUrl = 'http://localhost:4000/api';

// This is the function that gets all ratings
export const getAllRatings = async () => {
    return await axios.get(`${baseUrl}/ratings`);
}

// This is the function that gets all ratings for a specific movie
export const getRatings = async (id) => {
    return await axios.get(`${baseUrl}/ratings/movieId/${id}`);
}


// This is the function that posts a rating created by the user
export const postRating = async (formValues, id) => {
    const rating = formValues.rating;
    const commentTitle = formValues.ratingTitle;
    const commentContent = formValues.ratingContent;
    const userId = formValues.userId;
    const movieId = id;

    return await axios.post(`${baseUrl}/postRating`, { rating, commentTitle, commentContent, userId, movieId });
}
