import React from 'react';
import { Navigate, Outlet } from 'react-router-dom';
import useAppStateContext from '../hooks/hook';


//Private Route
export const PrivateRoute = () => {
  const { appState } = useAppStateContext();

  return appState?.isAuthenticated && appState?.user ? (
    <Outlet />
  ) : (
    <Navigate to='/login' />
  );
};

// Public Route
export const PublicRoute = () => {
  const { appState } = useAppStateContext();
  return !appState?.isAuthenticated && !appState?.user ? (
    <Outlet />
  ) : (
    <Navigate to='/' />
  );
};
