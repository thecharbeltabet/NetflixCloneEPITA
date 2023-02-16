// This file contains the reducer for the app state
const AppStateReducer = (state, action) => {
    
    switch (action.type) {
        // This is the case for when the user logs in
      case 'Login': {
        // Add the user to local storage
        localStorage.setItem(
          'Profile',
          JSON.stringify({ ...action.payload, isAuthenticated: true })
        );
  
        return {
          ...state,
          isAuthenticated: true,
          user: action.payload,
        };
      }
      // This is the case for when the user logs out
      case 'Logout': {
        window.localStorage.removeItem('Profile');
        return {
          isAuthenticated: false,
          user: null,
        };
      }
  
      default:
        return state;
    }
  };
  
  export default AppStateReducer;
  