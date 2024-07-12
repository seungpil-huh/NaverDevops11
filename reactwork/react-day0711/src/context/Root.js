import React, { useState } from 'react';
import { UserContext } from './UserContext';
import { ThemeContext } from './ThemeContext';
import Page from './Page';

const Root = () => {
    const [isDark,setIsDark]=useState(false);
    return (
        <UserContext.Provider value={'제주마씸'}>
            <ThemeContext.Provider value={{isDark,setIsDark}}>
                <Page/>
            </ThemeContext.Provider>
        </UserContext.Provider>
    );
};

export default Root;