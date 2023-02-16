import { createContext, useReducer } from 'react';
import AppStateReducer from './reducers';

// This is the initial state of the app
const INITIAL_STATE = {


  isAuthenticated: false,
  user: null,
};

// This is the context that will be used to access the state

export const AppStateContext = createContext(INITIAL_STATE);

export const AppStateProvider = ({ children }) => {
  const [state, dispatch] = useReducer(AppStateReducer, INITIAL_STATE);

  return (
    <AppStateContext.Provider value={{ appState: state, dispatch }}>
      {children}
    </AppStateContext.Provider>
  );
};
