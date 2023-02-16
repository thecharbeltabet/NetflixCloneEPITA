// Used to store all the API endpoints

//This is the java base url 
const API_URL = 'http://localhost:8080/api';

// This is the node base url
const RATING_URL = 'http://localhost:4000/api';


// Specific requests
const requests = {
    // Java
    API_URL: 'http://localhost:8080/api',

    // Node
    RATING_URL: 'http://localhost:4000/api',

    // Trending movies from java
    fetchTrending: `${API_URL}/movies/trending`,

    // Top Rated movies from java
    fetchTopRated: `${API_URL}/movies/top-rated`,

    // Action movies from java
    fetchActionMovies: `${API_URL}/movies/action`,

    // Comedy movies from java
    fetchComedyMovies: `${API_URL}/movies/comedy`,

    // Horror movies from java
    fetchHorrorMovies: `${API_URL}/movies/horror`,

    // Romance movies from java
    fetchRomanceMovies: `${API_URL}/movies/romance`,

    // Mystery movies from java
    fetchDocumentaries: `${API_URL}/movies/documentary`,

    // Top 10 viewed movies from java
    fetchTop10Viewed: `${API_URL}/movies/top10`,

    // Rating for a specific movie from node
    fetchRatings: `${RATING_URL}/ratings/movieId/`,
}

export default requests;