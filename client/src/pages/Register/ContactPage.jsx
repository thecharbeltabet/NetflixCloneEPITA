import React, { useEffect, useState } from "react";
import { useNavigate, useLocation } from 'react-router-dom';

import { addContact } from '../../services/accounts';

import FormInput from '../../formInput/formInput';

import { contactInputs } from '../../data/inputs';
import { contactFormValidation } from '../../utils/formsValidations';

const initialState = {
    email: '',
    firstName: '',
    lastName: '',
    phoneNumber: '',
};

function ContactPage() {

    const location = useLocation();
    const username = location.state.username;

    useEffect(() => {
        setBackgroundColor('/images/login-background.jpg');
    }
        , [username]);

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
            addContact(formValues, navigate, username);
        }
    };

    const onInputChange = (e) => {
        let { name, value } = e.target;
        setFormValues({ ...formValues, [name]: value });
        contactFormValidation(setFormErrors, name, value);
    };

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
            <form className='Auth-form' onSubmit={handleSubmit}>
                {contactInputs.map((input) => (
                    <FormInput
                        key={input.id}
                        {...input}
                        value={formValues[input.name]}
                        errorMessage={formErrors[input.name] && formErrors[input.name]}
                        onChange={onInputChange}
                    />
                ))}

                <button type='submit' className='loginButton'>
                    Next
                </button>

            </form>
        </div>
    )

}

export default ContactPage;