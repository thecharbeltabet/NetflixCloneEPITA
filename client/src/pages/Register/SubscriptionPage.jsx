import React, { useEffect } from "react";
import { useNavigate, useLocation } from 'react-router-dom';

import { addRole } from '../../services/accounts';

import useAppStateContext from '../../hooks/hook';

function SubscriptionPage() {

    const location = useLocation();
    const username = location.state.username;

    useEffect(() => {
        setBackgroundColor('/images/login-background.jpg');
    }
        , []);

    const setBackgroundColor = (image) => {
        document.body.style.backgroundImage = `url(${image})`;
        document.body.style.backgroundSize = 'cover';
        document.body.style.backgroundPosition = 'center';
    }

    const navigate = useNavigate();
    const { dispatch } = useAppStateContext();

    const handleBasic = async (e) => {
        e.preventDefault();
        addRole('Basic User', navigate, username, dispatch);
    }

    const handlePremium = async (e) => {
        e.preventDefault();
        addRole('Premium User', navigate, username, dispatch);
    }

    const handleUltimate = async (e) => {
        e.preventDefault();
        addRole('Ultimate User', navigate, username, dispatch);
    }

    return (
        <div className='Auth-form-container'>
            <div>
                <img
                    src={'/images/logo.JPG'}
                    alt='My Logo'
                    height={100}
                    width={150}
                />
            </div>
            <form className='Auth-form'>
                <button onClick={handleBasic} type='submit' className='loginButton'>
                    Poor - 9$
                </button>
                <button onClick={handlePremium} type='submit' className='loginButton'>
                    Middle Class - 10$
                </button>
                <button onClick={handleUltimate} type='submit' className='loginButton'>
                    Rich - 20$
                </button>
            </form>
        </div>
    )
}

export default SubscriptionPage;