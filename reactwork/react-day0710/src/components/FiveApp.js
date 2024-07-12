import React from 'react';
import { Alert } from '@mui/material';
import FiveChildApp from './FiveChildApp';
import FiveChild2App from './FiveChild2App';

const FiveApp = () => {
    return (
        <div>
            <Alert>FiveApp - 부모,자식 컴포넌트의 통신 #1</Alert>
            <h5>FiveChildApp 컴포넌트 호출</h5>
            <FiveChildApp irum={'이영자'} age={23} addr={'서울시'}/>
            <FiveChildApp irum={'강호동'} age={41} addr={'제주도'}/>
            <FiveChildApp irum={'손흥민'} age={33} addr={'부산시'}/>

            <h5>FiveChild2App 컴포넌트 호출</h5>
            <FiveChild2App irum="이미자" photo={"mycar6.png"} msg="노랑이차"/>
            <FiveChild2App irum="강미자" photo={"mycar4.png"} msg="분홍이차"/>
        </div>
    );
};

export default FiveApp;
