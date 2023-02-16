import React from 'react'
import './Footer.scss'
import { Github, Twitter, LinkedIn, YouTube } from '@mui/icons-material'

function Footer() {
    return (
        <footer className='footer'>
            <div className='footer__container'>
                <div className='footer__socials'>
                    <a href='https://github.com/thecharbeltabet' className='footer__social-link'>
                        <Github />
                    </a>
                    <a href='/#' className='footer__social-link'>
                        <Twitter />
                    </a>
                    <a href='https://www.linkedin.com/in/charbel-tabet/' className='footer__social-link'>
                        <LinkedIn />
                    </a>
                    <a href='https://www.youtube.com/@Netflix' className='footer__social-link'>
                        <YouTube />
                    </a>
                </div>
                <ul className='footer__links'>
                    <li className='footer__link'>
                        <a href='/'>
                            About Netflix Clone
                        </a>
                    </li>
                    <li className='footer__link'>
                        <a href='/'>
                            Contact Charbel
                        </a>
                    </li>
                    <li className='footer__link'>
                        <a href='/'>
                            Terms & Conditions
                        </a>
                    </li>
                    <li className='footer__link'>
                        <a href='/'>
                            Privacy Policy
                        </a>
                    </li>
                </ul>
                <div className='footer__copyright'>
                    <p>
                        Netflix Clone © 2023. By Charbel Y. Tabet.
                    </p>
                </div>
            </div>
        </footer>
    )
}

export default Footer