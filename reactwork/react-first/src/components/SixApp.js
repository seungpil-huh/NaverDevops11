import React, { useState } from 'react';
import img1 from '../12.jpg';
import img2 from '../17.jpg';
import img3 from '../18.jpg';
import img4 from '../19.jpg';

const SixApp = () => {
    const [show,setShow]=useState(false);
    const [width,setWidth]=useState(200);
    const [msg,setMsg]=useState('리액트 문제 다풀면 복습 100% 보장');
    const [photo,setPhoto]=useState(img1);
    const [border,setBorder]=useState('inset');
 
    return (
        <div>
            <b style={{fontFamily:'Single Day',fontSize:'3em',color:'deeppink'}}>
                    오늘의 문제</b>
            <hr/>
            <div className='input-group'>
                <label><input type={'checkbox'} 
                onClick={(e)=>setShow(e.target.checked)}/> 사진 숨김</label>

                <button type='button' className='btn btn-outline-danger'
                style={{marginLeft:'60px'}} onClick={(e)=>setWidth(width-10)}>점점작게</button>
                <button type='button' className='btn btn-outline-danger'
                style={{marginLeft:'10px'}} onClick={(e)=>setWidth(width+10)}>점점크게</button>                
            </div>
            <br/>
            <input type={'text'} className='form-control' style={{width:'400px'}}
                placeholder='메세지를 입력하세요'
                defaultValue={msg}
                onChange={(e)=>setMsg(e.target.value)}/>
            <br/><br/>
            <div style={{float:'left'}}>             

                <select className='form-select' style={{width:'200px'}}
                    onChange={(e)=>setPhoto(e.target.value)}>
                    <option value={img1}>박보영</option>
                    <option value={img2}>신민아</option>
                    <option value={img3}>신세경</option>
                    <option value={img4}>수지</option>                    
                </select>
                <br/><br/>
                <select className='form-select' style={{width:'200px'}}
                    onChange={
                        (e)=>{
                            setBorder(e.target.value);
                        }
                    }>
                    <option>solid</option>
                    <option selected>inset</option>
                    <option>double</option>
                    <option>groove</option> 
                    <option>dotted</option> 
                    <option>dashed</option>                    
                </select>
            </div>
            {
                !show &&                
                <img alt="" src={photo}
                style={{border:`10px ${border} pink`,width:`${width}px`,marginLeft:'20px'}}/>
            }

             <h1 style={{clear:'both',width:'500px',marginTop:'10px'}}
             className='alert alert-info'>{msg}</h1>        
        </div>
       
    )
};

export default SixApp;
