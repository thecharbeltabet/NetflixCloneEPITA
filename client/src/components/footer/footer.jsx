import React from 'react'
import { Facebook, Twitter, Instagram, Youtube} from '@mui/icons-material'

const footer = () => {
    return (
        <footer className='footer'>
            <div className='footer__container'>
                <div className='footer__socials'>
                    <a href='/#' className='footer__social-link'>
                        <Facebook />
                    </a>
                    <a href='/#' className='footer__social-link'>
                        <Twitter />
                    </a>
                    <a href='/#' className='footer__social-link'>
                        <Instagram />
                    </a>
                    <a href='/#' className='footer__social-link'>
                        <YouTube />
                    </a>
                </div>
                <ul className='footer__links'>
                    <li className='footer__link'>
                        <a href='/'>
                            About
                        </a>
                    </li>
                    <li className='footer__link'>
                        <a href='/'>
                            Contact
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
                        NetflixClone © 2023. Charbel Tabet.
                    </p>
                </div>
            </div>
        </footer>
    )
}

export default footer