import './App.scss';
import React, { useEffect } from "react";
import Home from './pages/Home';
import Video from './components/Video/Video';
import LoginPage from './pages/Login/LoginPage';
import ContactPage from './pages/Register/ContactPage';
import AddressPage from './pages/Register/AddressPage';
import UserInfoPage from './pages/Register/UserInfoPage';
import SubscriptionPage from './pages/Register/SubscriptionPage';

import { ToastContainer } from 'react-toastify';

// state context
import useAppStateContext from './hooks/useAppStateContext';

// Routes
import { PrivateRoute, PublicRoute } from './Routes/Routes';

import { BrowserRouter, Route, Routes } from 'react-router-dom';

function App() {

  const { dispatch } = useAppStateContext();

  if (JSON.parse(localStorage.getItem('MockflixProfile')) === null) {
    window.localStorage.setItem(
      'MockflixProfile',
      JSON.stringify({ isAuthenticated: false })
    );
  }

  useEffect(() => {
    const userProfile = JSON.parse(
      window.localStorage.getItem('MockflixProfile')
    );

    if (userProfile !== null) {
      if (userProfile.isAuthenticated) {
        delete userProfile.isAuthenticated;
        dispatch({ type: 'Login', payload: userProfile });
      }
    }
  }, [dispatch]);


  return (
    <BrowserRouter>
      <div className="app" >
        <ToastContainer />
        <div className='appContainer'>
          <div className='routesWrapper'>
            <Routes>
              <Route element={<PrivateRoute />}>
                <Route exact path="/" element={<Home />} />
              </Route>

              <Route element={<PrivateRoute />}>
                <Route exact path="/video/:id" element={<Video />} />
              </Route>

              <Route element={<PublicRoute />}>
                <Route path='login' element={<LoginPage />} />
              </Route>


              <Route element={<PublicRoute />}>
                <Route path='register/user' element={<UserInfoPage />} />
              </Route>

              <Route element={<PublicRoute />}>
                <Route path='register/contact' element={<ContactPage />} />
              </Route>

              <Route element={<PublicRoute />}>
                <Route path='register/address' element={<AddressPage />} />
              </Route>

              <Route element={<PublicRoute />}>
                <Route path='register/role' element={<SubscriptionPage />} />
              </Route>

            </Routes>
          </div>
        </div>
      </div>
    </BrowserRouter>
  );
}

export default App;
