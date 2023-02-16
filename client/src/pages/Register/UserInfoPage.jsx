import React, { useEffect, useState } from "react";
import { Link, useNavigate } from 'react-router-dom';

import { register } from '../../services/accounts';

import FormInput from '../../formInput/formInput';

import { registerInputs } from '../../data/inputs';
import { registerFormValidation } from '../../utils/formsValidations';

const initialState = {
    username: '',
    password: '',
};

function AddressPage() {

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
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();

        const noErrors = Object.values(formErrors).every((err) => err === '');
        if (noErrors) {
            // calling the backend register function, then navigating to ContactPage
            register(formValues, navigate);
        }
    }

    const onInputChange = (e) => {
        let { name, value } = e.target;
        setFormValues({ ...formValues, [name]: value });
        registerFormValidation(setFormErrors, name, value);
    };

    return (
        <div className='Auth-form-container'>
            <div>
                <img
                    src={'/images/logo.png'}
                    alt='Netflix Logo'
                    height={70}
                    width={200}
                />
            </div>
            <form className='Auth-form' onSubmit={handleSubmit}>
                {registerInputs.map((input) => (
                    <FormInput
                        key={input.id}
                        {...input}
                        value={formValues[input.name]}
                        errorMessage={formErrors[input.name] && formErrors[input.name]}
                        onChange={onInputChange}
                    />
                ))}

                <button type='submit' className='loginButton'>
                    Sign Up
                </button>

                <div className='noPassword'>
                    <span>Already have an account?</span>
                    <Link to='/login' className='SMS_Signup'>
                        Sign In
                    </Link>
                </div>
            </form>
        </div>
    )
}

export default AddressPage;