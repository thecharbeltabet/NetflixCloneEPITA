import React from 'react'
import './Banner.scss'
import { HelpOutline, PlayArrow } from "@mui/icons-material";

import axios from 'axios'
import requests from '../../config/Requests';
import { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'

import MovieDetail from '../CustomModals/MovieDetail';

// Banner component
function Banner() {
    const [movie, setMovie] = useState([])
    const [popup, setPopup] = useState(false)

    // Fetching data from API
    useEffect(() => {
        async function fetchData() {
            const request = await axios.get(requests.fetchTrending)
            setMovie(request.data[Math.floor(Math.random() * request.data.length)])
        }
        fetchData()
    }, [])

    // Handling popup
    function handleClickPopup() {
        popup ? setPopup(false) : setPopup(true)
    }

    // Truncate description
    function truncate(str, n) {
        return str?.length > n ? str.substr(0, n - 1) + '...' : str;
    }

    // Banner style
    const bannerStyle = {
        backgroundSize: 'cover',
        backgroundPosition: 'center center',
        backgroundImage: `url(
            "https://image.tmdb.org/t/p/original/${movie.backdropURL}"
        )`,
    };

    return (
        <header className='banner' style={bannerStyle}>
            <div className='banner__content'>
                <h1 className='banner__title'>
                    {movie?.title}
                </h1>
                <p className='banner__description'>
                    {truncate(movie?.description, 190)}
                </p>
                <div className='banner__buttons'>
                    <Link to={`/video/${movie?.id}`}>
                        <button className='banner__button banner__button--play'>
                            <PlayArrow /> Play
                        </button>
                    </Link>
                    <button className='banner__button' onClick={handleClickPopup}>
                        <HelpOutline /> More Info
                    </button>
                </div>
            </div>
            <MovieDetail
                movie={movie}
                backgroundSize='cover'
                backgroundPosition='center center'
                backgroundImage={`url(
                    "https://image.tmdb.org/t/p/original/${movie.backdropURL}"
                )`}
                handleClickPopup={handleClickPopup}
                popup={popup}
            />
        </header>
    )
}

export default Banner