import './LoginPage.scss'

import React, { useEffect, useState } from "react";
import { Link, useNavigate } from 'react-router-dom';

import FormInput from '../../formInput/formInput';

import useAppStateContext from '../../hooks/hook';

import { loginInputs } from '../../data/inputs';
import { loginFormValidation } from '../../utils/formsValidations';

import { login } from '../../services/accounts';

const initialState = {
    username: '',
    password: '',
};

function Login() {

    useEffect(() => {
        setBackgroundColor('/images/login-background.jpg');
    }
        , []);

    const setBackgroundColor = (image) => {
        document.body.style.backgroundImage = `url(${image})`;
        document.body.style.backgroundSize = 'cover';
        document.body.style.backgroundPosition = 'center';
    }

    const [formValues, setFormValues] = useState(initialState);
    const [formErrors, setFormErrors] = useState({});
    const { dispatch } = useAppStateContext();

    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();

        const noErrors = Object.values(formErrors).every((err) => err === '');
        if (noErrors) {
            // calling the backend api 'login' to login the user
            login(formValues, dispatch, navigate);
            document.body.style.backgroundImage = 'none';
            document.body.style.backgroundColor = '#111';
            document.body.style.filter = "blur(0px)";
        }
    };

    const onInputChange = (e) => {
        let { name, value } = e.target;
        setFormValues({ ...formValues, [name]: value });
        loginFormValidation(setFormErrors, name, value);
    };

    return (
        <div className='Auth-form-container'>
            <div>
                <img
                    src='/images/logo.JPG'
                    alt='My Logo'
                    height={100}
                    width={150}
                />
            </div>
            <form className='Auth-form' onSubmit={handleSubmit}>
                {loginInputs.map((input) => (
                    <FormInput
                        key={input.id}
                        {...input}
                        value={formValues[input.name]}
                        errorMessage={formErrors[input.name] && formErrors[input.name]}
                        onChange={onInputChange}
                    />
                ))}

                <button type='submit' className='loginButton'>
                    Sign in
                </button>

                <div className='noPassword'>
                    <span>No account?</span>
                    <Link to='/register/user' className='SMS_Signup'>
                        Sign up
                    </Link>
                </div>
            </form>
        </div>
    )
}

export default Login