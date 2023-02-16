import React from 'react'
import { useParams } from 'react-router-dom'

import './Video.scss'

function Video() {

    let { id } = useParams()
    console.log(id);

    return (
        <div className='video'>
            <iframe
                title='video'
                src={`https://www.youtube.com/watch?v=vrlqnPJVbeo&t=1s&ab_channel=EPITA`}
                frameBorder='0'
                allow='accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture'
                allowFullScreen
            ></iframe>
        </div>

    )
}

export default Video