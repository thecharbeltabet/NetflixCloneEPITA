import axios from 'axios';

//This is the base url for the java microservice
const baseUrl = 'http://localhost:8080/api';

//This is the function that adds a view to a movie by id
export const addViewCount = async (movieId) => {
  await axios
    .post(`${baseUrl}/addView?id=${movieId}`)
    .then((response) => {
      if (response.status === 200) {
        console.log("Success!");
      } else {
        console.log("Error");
      }
    })
    .catch((error) => {
      console.error('Sign up form: There was an error!', error);
    });
}