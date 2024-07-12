import React from 'react';

const FiveRowItem = ({mycar}) => {
    const storage = "https://kr.object.ncloudstorage.com/bitcamp-bucket-91/mycar/";
    
    return (
        <>
            <tr>
                <td style={{width:'200px'}} align='center' rowSpan={5}>
                    <img alt='' style={{width:'180px',height:'180px'}}
                    src={`${storage}${mycar.carphoto}`}/>
                </td>
                <td>자동차명: {mycar.carname}</td>
            </tr>
            <tr>
                <td>가 격: {mycar.carprice}만원</td>
            </tr>
            <tr>
                <td style={{backgroundColor:mycar.carcolor}}>
                    색 상: {mycar.carcolor}
                </td>
            </tr>
            <tr>
                <td>
                    구입일: {mycar.carguip}
                </td>
            </tr>
            <tr>
                <td style={{fontSize:'13px'}}>
                    등록일: {mycar.writeday}
                </td>
            </tr>
        </>
    );
};

export default FiveRowItem;