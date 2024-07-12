import React from 'react';
import './MyStyle.css';
import { DeleteForeverOutlined } from '@mui/icons-material';
import { Button } from '@mui/material';

const SixChild2App = ({row,idx,onDelete}) => {
    return (
        <tr style={{backgroundColor:row.color}}>
            <td>{row.cname}</td>
            <td align='center'>
                <img alt='' src={require(`../mycar/${row.cphoto}`)}
                className='small'/>
            </td>
            <td align='right'>{row.cprice}만원</td>
            <td align='center'>
                <Button size="small" color="error" variant="contained"
                startIcon={<DeleteForeverOutlined/>}
                onClick={()=>onDelete(idx)}>삭제</Button>
            </td>
        </tr>
    );
};

export default SixChild2App;