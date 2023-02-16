// This file contains all the form validation functions for the forms in the app

// This function is used to validate the form fields in the contact form
export const contactFormValidation = (setFormErrors, name, value) => {
    setFormErrors((prev) => {
      const errorStateObj = { ...prev, [name]: '' };
  
      switch (name) {
        case 'email':
          if (!value.includes('@')) {
            errorStateObj['email'] = 'Email is invalid';
          }
          break;
  
        default:
          break;
      }
  
      return errorStateObj;
    });
  };
  

  // This function is used to validate the form fields in the address form
  export const addressFormValidation = (setFormErrors, name, value) => {
    setFormErrors((prev) => {
      const errorStateObj = { ...prev, [name]: '' };
  
      switch (name) {
        case 'number':
          if (value.length < 1) {
            errorStateObj['number'] = 'Street number is required';
          }
          break;
  
        default:
          break;
      }
  
      return errorStateObj;
    });
  };
  
  // This function is used to validate the form fields in the register form
  export const registerFormValidation = (setFormErrors, name, value) => {
    setFormErrors((prev) => {
      const errorStateObj = { ...prev, [name]: '' };
  
      switch (name) {
        case 'password':
          if (value.length < 6) {
            errorStateObj['password'] = 'Password must be at least 6 characters';
          }
          break;
  
        case 'username':
          if (value.length < 8) {
            errorStateObj['username'] = 'Username must be at least 8 characters';
          }
          break;
  
        default:
          break;
      }
  
      return errorStateObj;
    });
  };
  

  // This function is used to validate the form fields in the rating form
  export const ratingFormValidation = (setFormErrors, name, value) => {
    setFormErrors((prev) => {
      const errorStateObj = { ...prev, [name]: '' };
  
      switch (name) {
        case 'rating':
          if (value < 1 || value > 10) {
            errorStateObj['rating'] = 'Rating must be between 1 and 10';
          }
          break;
  
        default:
          break;
      }
  
      return errorStateObj;
    });
  }
  
  // This function is used to validate the form fields in the login form
  export const loginFormValidation = (setFormErrors, name, value) => {
    setFormErrors((prev) => {
      const stateObj = { ...prev, [name]: '' };
  
      switch (name) {
  
        default:
          break;
      }
  
      return stateObj;
    });
  };
  