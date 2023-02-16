import React from 'react'
import { useState, useEffect } from 'react'
import axios from 'axios'
import MovieDetail from '../movieDetail/MovieDetail';

import './Row.scss'

const movie00 = {
    title: '',
    poster_path: '',
    backdrop_path: "/698FjyzLdpgXmUSr63LaRwblTmx.jpg",
    overview: '',
    release_date: '',
    genre: '',
    id: 111,
    view_count: 0,
};

function Row({ title, fetchUrl, isLargeRow }) {

    const baseUrl = 'https://image.tmdb.org/t/p/original/';

    const [movies, setMovies] = useState([])
    const [popup, setPopup] = useState(false)

    const [modalMovie, setModalMovie] = useState(movie00)

    function handleModal(movie) {
        setModalMovie(movie)
    }

    function handleClickPopup() {
        popup ? setPopup(false) : setPopup(true)
    }

    function onClick(movie) {
        handleModal(movie)
        handleClickPopup()
    }

    useEffect(() => {
        async function fetchData() {
            const request = await axios.get(fetchUrl)
            setMovies(request.data)
        }
        fetchData()
    }, [fetchUrl])

    return (
        <div className='row'>
            <h2 className='row__title'>{title}</h2>
            <div className='row__images'>
                {movies.map(movie => (
                    <div>
                        <div key={movie.id}>
                            {isLargeRow ? (
                                <img
                                    className='row__image'
                                    key={movie.id}
                                    src={`${baseUrl}${movie.posterURL}`}
                                    alt={movie?.title || movie?.name || movie?.original_name}
                                    onClick={() => onClick(movie)}
                                />
                            ) : (
                                <img
                                    className='row__image'
                                    key={movie.id}
                                    src={`${baseUrl}${movie.posterURL}`}
                                    alt={movie?.title}
                                    onClick={() => onClick(movie)}
                                />
                            )}
                        </div>
                        {isLargeRow ? (
                            null
                        ) : <p className='row__title'>
                            {movie?.title}
                        </p>}
                    </div>))}
            </div>
            <MovieDetail
                movie={modalMovie}
                backgroundImage={`url( ${baseUrl}${modalMovie.backdropURL})`}
                handleClickPopup={handleClickPopup}
                popup={popup}
            />
        </div>
    )
}

export default Row