import React, { useEffect } from 'react'
import Footer from '../../components/footer/footer';
import Navbar from '../../components/navbar/Navbar';
import Banner from '../../components/banner/Banner';
import Row from '../../components/row/Row';
import requests from '../../configuration/config';

function Home() {

    useEffect(() => {
        setBackgroundColor('/images/home-background.jpg');
    }

        , []);

    const setBackgroundColor = (image) => {
        document.body.style.backgroundImage = 'none';
        document.body.style.backgroundSize = 'cover';
        document.body.style.backgroundPosition = 'center';
    }

    return (
        <div className="App">

            <Navbar />

            <Banner />

            <Row
                title="Most Viewed"
                fetchUrl={requests.fetchTop10Viewed}
            />

            <Row
                title="Trending Now"
                fetchUrl={requests.fetchTrending}
                isLargeRow={true}
            />

            <Row
                title="Action Movies"
                fetchUrl={requests.fetchActionMovies}
            />
            <Row
                title="Comedy Movies"
                fetchUrl={requests.fetchComedyMovies}
            />
            
            <Row
                title="Romance Movies"
                fetchUrl={requests.fetchRomanceMovies}
            />
            <Row
                title="Horror Movies"
                fetchUrl={requests.fetchHorrorMovies}
            />
            <Row
                title="Documentaries"
                fetchUrl={requests.fetchDocumentaries}
            />

            <Footer />
        </div>
    )
}

export default Home