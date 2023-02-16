import React from "react";
import './NavBar.scss'
import { useState } from "react";

// State Context
import useAppStateContext from '../../hooks/hook';

import { MenuOutlined, LogoutOutlined } from "@mui/icons-material";


function Navbar() {

    const { dispatch } = useAppStateContext();

    const [navBlack, setNavBlack] = useState(false);

    const [toggleMenu, setToggleMenu] = useState(false);

    const transitionNav = () => {
        window.scrollY > 100 ? setNavBlack(true) : setNavBlack(false);
    }

    const handleToggleMenu = () => {
        toggleMenu ? setToggleMenu(false) : setToggleMenu(true);
    }

    useState(() => {
        document.addEventListener('scroll', transitionNav);
    });

    const handleLogout = () => {
        dispatch({ type: 'Logout' });
    };

    const logoClick = () => {
        window.scrollTo(0, 0);
    }

    return (
        <div className={`navbar ${navBlack || toggleMenu ? "navbar--black" : "navbar--transparent"} ${toggleMenu && "show"}`}>
            <button onClick={handleToggleMenu} className="navbar__burger">
                <MenuOutlined />
            </button>
            <img onClick={logoClick} className="navbar__logo" src="../images/logo.png" alt="Netflix logo" />
            <img   className = "navbar__logo2" src="../images/Logo.JPG" alt="Charbel logo" />
            <div  className="navbar__actions">
                <button  onClick={handleLogout} className="logout__button" >
                    <LogoutOutlined />
                </button>
            </div>
        </div>
    )
}

export default Navbar;